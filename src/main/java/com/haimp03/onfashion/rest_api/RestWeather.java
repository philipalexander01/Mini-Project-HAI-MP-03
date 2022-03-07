package com.haimp03.onfashion.rest_api;

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
        String url = "https://api.openweathermap.org/data/2.5/weather?q=jakarta&appid=b7ab51b9d061c03f3079e740b32b60f1";
        RestTemplate restTemplate = new RestTemplate();
        WeatherData weatherData = restTemplate.getForObject(url, WeatherData.class);
        return weatherData;
    }
}
