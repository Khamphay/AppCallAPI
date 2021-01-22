package com.mycompany.appcallapi.Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.mycompany.appcallapi.DAOModel.CaseOfCovid19;
import com.mycompany.appcallapi.model.GetAllCases;

import org.json.JSONException;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class AccountController implements Initializable {

    private ArrayList<CaseOfCovid19> data;
    private GetAllCases get = new GetAllCases();;

    @FXML
    private Label totalCases, totalDeaths, totalRecovered;

    @FXML
    private Label todayCases, todayDeaths, todayRecovered;

    private void ShowData()  {
        try {
            data = get.findAllCases();
            if (data != null) {
                totalCases.setText(data.get(0).getCases());
                totalDeaths.setText( data.get(0).getDeaths());
                totalRecovered.setText( data.get(0).getRecovered());

                todayCases.setText( data.get(0).getTodayCases());
                todayDeaths.setText(data.get(0).getTodayDeaths());
                todayRecovered.setText(data.get(0).getTodayRecovered());

            } else {
                System.out.println("============> Data null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        ShowData();
    }
    
}
