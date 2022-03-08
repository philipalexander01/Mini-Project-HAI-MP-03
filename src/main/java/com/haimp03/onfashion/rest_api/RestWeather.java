package com.haimp03.onfashion.rest_api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import com.haimp03.onfashion.dto.LocationData;
import com.haimp03.onfashion.dto.WeatherData;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("api/current_weather")
public class RestWeather {
    
    @GetMapping
    public WeatherData getCurrentWeather(){
        String city = getLocation();
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=b7ab51b9d061c03f3079e740b32b60f1";
        RestTemplate restTemplate = new RestTemplate();
        WeatherData weatherData = restTemplate.getForObject(url, WeatherData.class);
        return weatherData;
    }

    private String getLocation() {
        String ip = "";

        try {
            URL whatismyip = new URL("http://checkip.amazonaws.com");
            BufferedReader in = new BufferedReader(new InputStreamReader(whatismyip.openStream()));
            ip = in.readLine();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        String url = "http://ip-api.com/json/" + ip + "?fields=city";
        RestTemplate restTemplate = new RestTemplate();
        LocationData locationData = restTemplate.getForObject(url, LocationData.class);

        return locationData.city;
    }
}
