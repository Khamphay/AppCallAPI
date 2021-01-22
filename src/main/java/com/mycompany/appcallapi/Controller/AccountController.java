package com.mycompany.appcallapi.Controller;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.mycompany.appcallapi.DAOModel.CaseOfCovid19;
import com.mycompany.appcallapi.model.GetAllCases;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class AccountController implements Initializable {

    Thread refresh = new Thread(new loadData(),"t1");

    private ArrayList<CaseOfCovid19> data, dataInLaos;
    private GetAllCases get = new GetAllCases();;
    private DecimalFormat format = new DecimalFormat("#,###");
    private DecimalFormat formatDB = new DecimalFormat("#,###.00");

    @FXML
    private Label totalCases, totalDeaths, totalRecovered;

    @FXML
    private Label todayCases, todayDeaths, todayRecovered, todayCase_PerDay, todayDeaths_PerDay, todayRecovered_PerDay;

    @FXML
    private Label totalCaseInLoas, newCaseInLaos, totalRecoveredInLaos, totalDeathsInLaos;

    private void ShowData() {
        try {
            data = get.findAllCases();
            if (data != null) {
                totalCases.setText(format.format(Double.parseDouble(data.get(0).getCases())));
                totalDeaths.setText(format.format(Double.parseDouble(data.get(0).getDeaths())));
                totalRecovered.setText(format.format(Double.parseDouble(data.get(0).getRecovered())));
                todayCases.setText(format.format(Double.parseDouble(data.get(0).getTodayCases())));
                todayDeaths.setText(format.format(Double.parseDouble(data.get(0).getTodayDeaths())));
                todayRecovered.setText(format.format(Double.parseDouble(data.get(0).getTodayRecovered())));

                todayCase_PerDay.setText(
                        "Cases: " + formatDB.format(Double.parseDouble(data.get(0).getTodayCases()) / 60) + "/1 Hour");
                todayDeaths_PerDay.setText(
                        "Death: " + formatDB.format(Double.parseDouble(data.get(0).getTodayDeaths()) / 60) + "/1 Hour");
                todayRecovered_PerDay.setText("Recovered: "
                        + format.format(Double.parseDouble(data.get(0).getTodayRecovered()) / 60) + "/1 Hour");

            } else {
                System.out.println("============> Data null");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private void showCaseInLaos() {
        try {
            dataInLaos = get.findInLaos();
            if (dataInLaos != null) {
                totalCaseInLoas.setText(format.format(Double.parseDouble(dataInLaos.get(0).getCases())));
                totalDeathsInLaos.setText(format.format(Double.parseDouble(dataInLaos.get(0).getDeaths())));
                totalRecoveredInLaos.setText(format.format(Double.parseDouble(dataInLaos.get(0).getRecovered())));
                newCaseInLaos.setText(format.format(Double.parseDouble(dataInLaos.get(0).getTodayCases())));
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ShowData();
        showCaseInLaos();
    }

    // Todo: use Thrad for refresh data
    class loadData implements Runnable {
        @Override
        public void run() {
            try {
                ShowData();
                showCaseInLaos();
                Thread.sleep(50000);
            } catch (InterruptedException e) {
               System.err.println("Thread error: "+e.getMessage());
            }
        }
   }
}
