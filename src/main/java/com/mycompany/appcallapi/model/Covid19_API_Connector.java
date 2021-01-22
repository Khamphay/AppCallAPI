package com.mycompany.appcallapi.model;

public class Covid19_API_Connector {
    
   public static String getCallAPI(String urlpath) {
       try {
           var url = "https://corona.lmao.ninja/v2" + urlpath;
           return url;
       } catch (Exception e) {
           e.printStackTrace();
           return null;
       }
   }
}
