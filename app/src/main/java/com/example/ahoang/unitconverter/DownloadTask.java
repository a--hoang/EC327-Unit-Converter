package com.example.ahoang.unitconverter;

import android.os.AsyncTask;

/**
 * Created by ahoang on 4/26/15.
 */
public class DownloadTask extends AsyncTask<String, Long, String> {
    protected String doInBackground(String... urls) {
        try {
//            HttpRequest request =  HttpRequest.get(urls[0]);
//            File file = null;
//            if (request.ok()) {
//                file = File.createTempFile("download", ".tmp");
//                request.receive(file);
//                publishProgress(file.length());
//            }
//            return file;
//            String response = HttpRequest.get("http://numbersapi.com/random").body();
            //CATFACTS REPLACEMENT API/PARSING
            String response = HttpRequest.get("http://catfacts-api.appspot.com/api/facts").body();
            int i;
            for(i = 0; i < response.length(); i++){
                if(response.charAt(i) == ']'){
                    break;
                };
            }
            response = response.substring(12, i-1);
            for(int j = 0; j < response.length(); j++){
                if(response.charAt(j) == '\\'){
                    response = response.substring(0, j) + response.substring(j+1);
                }
            }
            byte[] b = response.getBytes("UTF-8");
            response = new String(b, "UTF-8");
            //prevent obscene statement from api
            if(response.contains("masturbate")){
                response = "Cats are cute.";
            }
            System.out.println(response);
            return response;
        } catch (Exception e) {
            System.out.println("Error: call did not work.");
            return null;
        }
    }
}
