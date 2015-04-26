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
            String response = HttpRequest.get("http://numbersapi.com/random").body();
            System.out.println(response);
            return response;
        } catch (Exception e) {
            System.out.println("Error: call did not work.");
            return null;
        }
    }

//    protected void onProgressUpdate(Long... progress) {
//        Log.d("MyApp", "Downloaded bytes: " + progress[0]);
//    }

//    protected void onPostExecute(File file) {
//        if (file != null)
//            Log.d("MyApp", "Downloaded file to: " + file.getAbsolutePath());
//        else
//            Log.d("MyApp", "Downloaded");
//    }
}
