package com.example.flora;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class weather {

    private static HttpURLConnection connection;

    public static void main(String[] args) {
        String city = "Toronto";
        BufferedReader reader;
        String line;
        StringBuffer responseContent = new StringBuffer();

        try {

            URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=542ffd081e67f4512b705f89d2a611b2&units=metric");
            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int status = connection.getResponseCode();

            if (status > 299){
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while((line = reader.readLine()) != null){
                    responseContent.append(line);
                }
                reader.close();
            } else{
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while((line = reader.readLine()) != null){
                    responseContent.append(line);
                }
                reader.close();
            }
        } catch (IOException ignored) {
        } finally {
            connection.disconnect();
        }

        String jsonData = responseContent.toString();
        //Converting jsonData string into JSON object
        JSONObject jsonobject = new JSONObject(jsonData);
        //Getting weather JSON array from the JSON object
        JSONArray jsonArrayWeather = jsonobject.getJSONArray("weather");
        //Getting main temperature data from JSON object
        String Temp = jsonobject.get("main").toString();
        //Extracting the current temperature from the data
        Double temperature = Double.parseDouble(Temp.substring(9,Temp.indexOf(",")));
        //Creating an empty ArrayList of type Object
        ArrayList<Object> listdata = new ArrayList<Object>();
        //Checking whether the JSON array has some value or not
        if (jsonArrayWeather != null) {
            //Iterating JSON array
            for (int i=0;i<jsonArrayWeather.length();i++){
                //Adding each element of JSON array into ArrayList
                listdata.add(jsonArrayWeather.get(i));
            }
        }
        String data = listdata.toString();
        int id = Integer.parseInt(data.substring(data.length()-5,data.length()-2));
        if (id < 600){
            System.out.println("It's gonna rain, do not water plants.");
        } else if (id >= 600 && id < 700){
            System.out.println("It's gonna snow, put plants inside.");
        } else {
            System.out.println("Weather is good.");
        }
        /*if (temperature){

        } else if (){

        }*/
    }
}
