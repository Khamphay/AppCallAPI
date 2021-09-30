package com.mycompany.appcallapi.Controller;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.mycompany.appcallapi.PrimaryController;
import com.mycompany.appcallapi.DAOModel.CaseOfCovid19;
import com.mycompany.appcallapi.model.GetAllCases;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

public class AccountController implements Initializable {

    // private loadData obj = new loadData();
    private loadData refresh = new loadData();

    private ArrayList<CaseOfCovid19> data, dataInLaos;
    private GetAllCases get = new GetAllCases();;
    private DecimalFormat format = new DecimalFormat("#,###");
    private DecimalFormat formatDB = new DecimalFormat("#,###.00");

    @FXML
    private Text totalCases, totalDeaths, totalRecovered, perSentOfAllPeople, DeathperInfective, RecoverperRecovered,
            DeathperRecodovered, totalAtive, RecoverperInfective, AtiveperInfective;

    @FXML
    private Text todayCases, todayDeaths, todayRecovered, todayCase_PerDay, todayDeaths_PerDay, todayRecovered_PerDay;

    @FXML
    private Text totalCaseInLoas, newCaseInLaos, totalRecoveredInLaos, totalDeathsInLaos, ativeCaseLaos;

    private void ShowData() {
        try {
            data = get.findAllCases();
            if (data != null) {
                totalCases.setText(format.format(Double.parseDouble(data.get(0).getCases())) + " ຄົນ");
                totalDeaths.setText(format.format(Double.parseDouble(data.get(0).getDeaths())) + " ຄົນ");
                totalRecovered.setText(format.format(Double.parseDouble(data.get(0).getRecovered())) + " ຄົນ");
                todayCases.setText(format.format(Double.parseDouble(data.get(0).getTodayCases())) + " ຄົນ");
                todayDeaths.setText(format.format(Double.parseDouble(data.get(0).getTodayDeaths())) + " ຄົນ");
                todayRecovered.setText(format.format(Double.parseDouble(data.get(0).getTodayRecovered())) + " ຄົນ");
                totalAtive.setText(format.format(Double.parseDouble(data.get(0).getActive())) + " ຄົນ");

                todayCase_PerDay.setText("ອັດຕາການຕິດເຊື້ອ: "
                        + formatDB.format(Double.parseDouble(data.get(0).getTodayCases()) / 60) + " ຄົນ/1 ຊົ່ວໂມງ");
                todayDeaths_PerDay.setText("ອັດຕາການເສຍຊີວິດ: "
                        + formatDB.format(Double.parseDouble(data.get(0).getTodayDeaths()) / 60) + " ຄົນ/1 ຊົ່ວໂມງ");
                todayRecovered_PerDay.setText("ອັດຕາການປິ່ນປົວດີ: "
                        + format.format(Double.parseDouble(data.get(0).getTodayRecovered()) / 60) + " ຄົນ/1 ຊົ່ວໂມງ");

                // ! Persent Per Actived cases
                perSentOfAllPeople
                        .setText("ກວມ: "
                                + formatDB.format((Double.parseDouble(data.get(0).getCases())
                                        / Double.parseDouble(data.get(0).getPopulation())) * 100)
                                + "% ຂອງຈຳນວນປະຊາກອນທັງໝົດ");
                DeathperRecodovered.setText("ກວມ: "
                        + formatDB.format((Double.parseDouble(data.get(0).getDeaths())
                                / (Double.parseDouble(data.get(0).getRecovered())
                                        + Double.parseDouble(data.get(0).getDeaths())))
                                * 100)
                        + "% ຂອງຈຳນວນຜູ້ຕິດເຊື້ອ\nທີ່ຜ່ານການປິ່ນປົວແລ້ວ");
                RecoverperRecovered.setText("ກວມ: " + formatDB.format(Double.parseDouble(data.get(0).getRecovered())
                        / (Double.parseDouble(data.get(0).getRecovered()) + Double.parseDouble(data.get(0).getDeaths()))
                        * 100) + "% ຂອງຈຳນວນຜູ້ຕິດເຊື້ອ\nທີ່ຜ່ານການປິ່ນປົວແລ້ວ");
                // !Persent Per all cases
                DeathperInfective
                        .setText("ກວມ: "
                                + formatDB.format((Double.parseDouble(data.get(0).getDeaths())
                                        / Double.parseDouble(data.get(0).getCases())) * 100)
                                + "% ຂອງຈຳນວນຜູ້ຕິດເຊື້ອທັງໝົດ");
                RecoverperInfective
                        .setText("ກວມ: "
                                + formatDB.format(Double.parseDouble(data.get(0).getRecovered())
                                        / Double.parseDouble(data.get(0).getCases()) * 100)
                                + "% ຂອງຈຳນວນຜູ້ຕິດເຊື້ອທັງໝົດ");

                AtiveperInfective.setText("ກວມ: "
                                + formatDB.format(Double.parseDouble(data.get(0).getActive())
                                        / (Double.parseDouble(data.get(0).getCases())) * 100)
                                + "% ຂອງຈຳນວນຜູ້ຕິດເຊື້ອທັງໝົດ");

                PrimaryController.networkStats = "ການເຊື່ອມຕໍ່ NovelCOVID API ສຳເລັດແລ້ວ";
            } else {
                PrimaryController.networkStats = "ບໍ່ສາມາດເຊື່ອມຕໍ່ NovelCOVID API (ກະລຸນາກວດສອບເຊື່ອມຕໍ່ Network)";
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
                totalCaseInLoas.setText(format.format(Double.parseDouble(dataInLaos.get(0).getCases())) + " ຄົນ");
                totalDeathsInLaos.setText(format.format(Double.parseDouble(dataInLaos.get(0).getDeaths())) + " ຄົນ");
                totalRecoveredInLaos
                        .setText(format.format(Double.parseDouble(dataInLaos.get(0).getActive())) + " ຄົນ");
                ativeCaseLaos.setText(format.format(Double.parseDouble(dataInLaos.get(0).getRecovered())) + " ຄົນ");
                newCaseInLaos.setText(format.format(Double.parseDouble(dataInLaos.get(0).getTodayCases())) + " ຄົນ");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ShowData();
        showCaseInLaos();
        // refresh.stop();
        refresh.start();
    }

    // Todo: use Thrad for refresh data
    class loadData extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(100000);
                    // System.out.println("===>Refresh");
                    ShowData();
                    showCaseInLaos();
                } catch (InterruptedException e) {
                    System.err.println("Thread error: " + e.getMessage());
                }
            }
        }

    }
}
