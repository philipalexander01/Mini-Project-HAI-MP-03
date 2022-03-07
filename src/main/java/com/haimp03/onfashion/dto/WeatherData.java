package com.haimp03.onfashion.dto;

import java.util.ArrayList;


public class WeatherData {
    public String name;
    public ArrayList<WeatherDetail> weather;
    public TemperatureData main;
    

    public TemperatureData getMain() {
        return main;
    }


    public void setMain(TemperatureData main) {
        this.main = main;
    }


    public WeatherData() {
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public ArrayList<WeatherDetail> getWeather() {
        return weather;
    }


    public void setWeather(ArrayList<WeatherDetail> weather) {
        this.weather = weather;
    }


    public static class WeatherDetail{
        public String main;
        public String description;
        public String icon;
        
        public WeatherDetail(String main, String description, String icon) {
            this.main = main;
            this.description = description;
            this.icon = icon;
        }
        public WeatherDetail() {
        }
        public String getMain() {
            return main;
        }
        public void setMain(String main) {
            this.main = main;
        }
        public String getDescription() {
            return description;
        }
        public void setDescription(String description) {
            this.description = description;
        }
        public String getIcon() {
            return icon;
        }
        public void setIcon(String icon) {
            this.icon = icon;
        }
    
    }   

    public static class TemperatureData{
        private Double temp;

        
        public TemperatureData() {
        }

    
        
    /**
     * @return Double return the temp
     */
    public String getTemp() {
        return String.format("%.2f",(temp - 273.15)) ;
    }

    /**
     * @param temp the temp to set
     */
    public void setTemp(Double temp) {
        this.temp = temp;
    }
    }



}


