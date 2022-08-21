package com.example.flora;


import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONArray;
import org.json.JSONObject;


public class weather extends AppCompatActivity {

    private static HttpURLConnection connection;

    String condition;
    TextView weatherTemperature, weatherCondition;

    @Override

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_plants);

        String city = "Toronto";
        BufferedReader reader;
        String line;
        StringBuffer responseContent = new StringBuffer();

        // get the reference of TextView's
        weatherTemperature = (TextView) findViewById(R.id.temperature);
        weatherCondition = (TextView) findViewById(R.id.condition);

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
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        } finally {
            connection.disconnect();
        }

        try {
            String jsonData = responseContent.toString();
            //Converting jsonData string into JSON object
            JSONObject jsonobject = new JSONObject(jsonData);
            //Getting weather JSON array from the JSON object
            JSONArray jsonArrayWeather = jsonobject.getJSONArray("weather");
            //Getting main temperature data from JSON object and Extracting the current temperature from the data
            Double temperature = jsonobject.getJSONObject("main").getDouble("temp");
            //Creating an empty ArrayList of type Object
            ArrayList<Object> listData = new ArrayList<Object>();
            //Checking whether the JSON array has some value or not
            if (jsonArrayWeather != null) {
                //Iterating JSON array
                for (int i=0;i<jsonArrayWeather.length();i++){
                    //Adding each element of JSON array into ArrayList
                    listData.add(jsonArrayWeather.get(i));
                }
            }
            String data = listData.toString();
            int id = Integer.parseInt(data.substring(data.length()-5,data.length()-2));
            if (id < 600){
                condition = "rain";
            } else if (id >= 600 && id < 700){
                condition = "snow";
            } else {
                condition = "clear";
            }
            // set employee name and salary in TextView's
            weatherTemperature.setText("Temperature: "+ temperature);
            weatherCondition.setText("Condition: "+ condition);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

