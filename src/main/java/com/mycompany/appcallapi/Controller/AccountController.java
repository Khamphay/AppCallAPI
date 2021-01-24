package com.mycompany.appcallapi.Controller;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.mycompany.appcallapi.PrimaryController;
import com.mycompany.appcallapi.DAOModel.CaseOfCovid19;
import com.mycompany.appcallapi.model.GetAllCases;
<<<<<<< HEAD

=======
>>>>>>> 22c144cc6ec5a9d5a03570e3fc0629787ebad7bc
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

public class AccountController implements Initializable {

<<<<<<< HEAD
    // private loadData obj = new loadData();
    private loadData refresh = new loadData();
=======
    Thread refresh = new Thread(new loadData(),"t1");
>>>>>>> 22c144cc6ec5a9d5a03570e3fc0629787ebad7bc

    private ArrayList<CaseOfCovid19> data, dataInLaos;
    private GetAllCases get = new GetAllCases();;
    private DecimalFormat format = new DecimalFormat("#,###");
    private DecimalFormat formatDB = new DecimalFormat("#,###.00");
<<<<<<< HEAD

    @FXML
    private Text totalCases, totalDeaths, totalRecovered, perSentOfAllPeople, DeathperInfective, 
            totalAtive, RecoverperInfective,
            AtiveperInfective;
=======
>>>>>>> 22c144cc6ec5a9d5a03570e3fc0629787ebad7bc

    @FXML
    private Text todayCases, todayDeaths, todayRecovered, todayCase_PerDay, todayDeaths_PerDay, todayRecovered_PerDay;

    @FXML
<<<<<<< HEAD
    private Text totalCaseInLoas, newCaseInLaos, totalRecoveredInLaos, totalDeathsInLaos;

=======
    private Label todayCases, todayDeaths, todayRecovered, todayCase_PerDay, todayDeaths_PerDay, todayRecovered_PerDay;

    @FXML
    private Label totalCaseInLoas, newCaseInLaos, totalRecoveredInLaos, totalDeathsInLaos;

>>>>>>> 22c144cc6ec5a9d5a03570e3fc0629787ebad7bc
    private void ShowData() {
        try {
            data = get.findAllCases();
            if (data != null) {
<<<<<<< HEAD
                totalCases.setText(format.format(Double.parseDouble(data.get(0).getCases())) + " ຄົນ");
                totalDeaths.setText(format.format(Double.parseDouble(data.get(0).getDeaths())) + " ຄົນ");
                totalRecovered.setText(format.format(Double.parseDouble(data.get(0).getRecovered())) + " ຄົນ");
                todayCases.setText(format.format(Double.parseDouble(data.get(0).getTodayCases())) + " ຄົນ");
                todayDeaths.setText(format.format(Double.parseDouble(data.get(0).getTodayDeaths())) + " ຄົນ");
                todayRecovered.setText(format.format(Double.parseDouble(data.get(0).getTodayRecovered())) + " ຄົນ");
                totalAtive.setText(format.format(Double.parseDouble(data.get(0).getActive())) + " ຄົນ");
=======
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
>>>>>>> 22c144cc6ec5a9d5a03570e3fc0629787ebad7bc

                todayCase_PerDay.setText("ອັດຕາການຕິດເຊື້ອ: "
                        + formatDB.format(Double.parseDouble(data.get(0).getTodayCases()) / 60) + " ຄົນ/1 ຊົ່ວໂມງ");
                todayDeaths_PerDay.setText("ອັດຕາການເສຍຊີວິດ: "
                        + formatDB.format(Double.parseDouble(data.get(0).getTodayDeaths()) / 60) + " ຄົນ/1 ຊົ່ວໂມງ");
                todayRecovered_PerDay.setText("ອັດຕາການປິ່ນປົວດີ: "
                        + format.format(Double.parseDouble(data.get(0).getTodayRecovered()) / 60) + " ຄົນ/1 ຊົ່ວໂມງ");
                perSentOfAllPeople.setText( "ກວມ: " + formatDB.format((Double.parseDouble(data.get(0).getCases()) / Double.parseDouble(
                        data.get(0).getPopulation())) * 100) + "% ຂອງຈຳນວນປະຊາກອນທັງໝົດ");
                DeathperInfective .setText("ກວມ: " + formatDB.format(( Double.parseDouble(data.get(0).getDeaths())/ Double
                        .parseDouble(data.get(0).getCases()) ) * 100) + "% ຂອງຈຳນວນຜູ້ຕິດເຊື້ອທັງໝົດ");
                RecoverperInfective.setText("ກວມ: " + formatDB.format(Double.parseDouble(data.get(0).getRecovered()) / (Double
                        .parseDouble(data.get(0).getCases())) * 100) + "% ຂອງຈຳນວນຜູ້ຕິດເຊື້ອທັງໝົດ");
                        AtiveperInfective.setText("ກວມ: "
                                + formatDB.format(Double.parseDouble(data.get(0).getActive())
                                        / (Double.parseDouble(data.get(0).getCases())) * 100)
                                + "% ຂອງຈຳນວນຜູ້ຕິດເຊື້ອທັງໝົດ");
                PrimaryController.networkStats = "ການເຊື່ອມ NovelCOVID API ຕໍ່ສຳເລັດແລ້ວ";
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
<<<<<<< HEAD
                totalCaseInLoas.setText(format.format(Double.parseDouble(dataInLaos.get(0).getCases())) + " ຄົນ");
                totalDeathsInLaos.setText(format.format(Double.parseDouble(dataInLaos.get(0).getDeaths())) + " ຄົນ");
                totalRecoveredInLaos
                        .setText(format.format(Double.parseDouble(dataInLaos.get(0).getRecovered())) + " ຄົນ");
                newCaseInLaos.setText(format.format(Double.parseDouble(dataInLaos.get(0).getTodayCases())) + " ຄົນ");
=======
                totalCaseInLoas.setText(format.format(Double.parseDouble(dataInLaos.get(0).getCases())));
                totalDeathsInLaos.setText(format.format(Double.parseDouble(dataInLaos.get(0).getDeaths())));
                totalRecoveredInLaos.setText(format.format(Double.parseDouble(dataInLaos.get(0).getRecovered())));
                newCaseInLaos.setText(format.format(Double.parseDouble(dataInLaos.get(0).getTodayCases())));
>>>>>>> 22c144cc6ec5a9d5a03570e3fc0629787ebad7bc
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ShowData();
        showCaseInLaos();
<<<<<<< HEAD
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
                    System.out.println("===>Refresh");
                    ShowData();
                    showCaseInLaos();
                } catch (InterruptedException e) {
                    System.err.println("Thread error: " + e.getMessage());
                }
            }
        }

    }
=======
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
>>>>>>> 22c144cc6ec5a9d5a03570e3fc0629787ebad7bc
}
