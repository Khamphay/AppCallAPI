package com.mycompany.appcallapi.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import com.mycompany.appcallapi.model.GetAllCases;

import org.json.*;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

public class MemberController implements Initializable {

    private JSONArray values;
    private GetAllCases obj = new GetAllCases();
    // private XYChart.Series series;

    @FXML
    private LineChart<String, Number> chart;

    private void loadData() {
       try {
           values=obj.findAllCuontry();
           var series = new XYChart.Series();
            
<<<<<<< HEAD
           series.setName("ຂໍ້ມູນຂອງບັນດາປະເທດທີ່ມີຜູ້ຕິດເຊື້ອ Covid 19 ທົ່ວໂລກ");
=======
           series.setName("The Countries Have People Infective Covid 19 Of The World");
>>>>>>> 22c144cc6ec5a9d5a03570e3fc0629787ebad7bc
           for (int i = 0; i < values.length(); i++) {
               series.getData().add(new XYChart.Data(((JSONObject) values.get(i)).optString("country")
                       .toString(), Double.parseDouble(((JSONObject) values.get(i)).optString("cases").toString())));
           }
           chart.setCreateSymbols(false);
           chart.getData().add(series);

       } catch (Exception e) {
           System.err.println("Error: "+e.getMessage());
       }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        loadData();
    }
    
}
