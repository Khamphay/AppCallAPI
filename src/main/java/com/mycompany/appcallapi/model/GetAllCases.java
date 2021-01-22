package com.mycompany.appcallapi.model;

import com.mycompany.appcallapi.DAOModel.CaseOfCovid19;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import org.json.JSONException;

public class GetAllCases {

    public ArrayList<CaseOfCovid19> findAllCases() throws JSONException, IOException, InterruptedException {

        ArrayList<CaseOfCovid19> allcase = new ArrayList<>();
        CaseOfCovid19 item;
        
        var client=HttpClient.newBuilder().build();
        var request=HttpRequest.newBuilder().GET().uri(URI.create(Covid19_API_Connector.getCallAPI("/all"))).build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        

        if (response.statusCode() == 200) {
            JSONObject object = new JSONObject(response.body());

            item = new CaseOfCovid19(object.get("updated").toString(),
                    object.get("cases").toString(),
                    object.get("todayCases").toString(),
                    object.get("deaths").toString(),
                    object.get("todayDeaths").toString(),
                    object.get("recovered").toString(),
                    object.get("todayRecovered").toString(),
                    object.get("active").toString(),
                    object.get("critical").toString(),
                    object.get("casesPerOneMillion").toString(),
                    object.get("deathsPerOneMillion").toString(),
                    object.get("tests").toString(),
                    object.get("testsPerOneMillion").toString(),
                    object.get("population").toString(),
                    object.get("oneCasePerPeople").toString(),
                    object.get("oneDeathPerPeople").toString(),
                    object.get("oneTestPerPeople").toString(),
                    object.get("activePerOneMillion").toString(),
                    object.get("recoveredPerOneMillion").toString(),
                    object.get("criticalPerOneMillion").toString(),
                    object.get("affectedCountries").toString());
            allcase.add(item);
        }
        return allcase;
    }
}
