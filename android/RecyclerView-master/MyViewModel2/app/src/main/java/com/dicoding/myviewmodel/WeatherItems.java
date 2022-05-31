package com.dicoding.myviewmodel;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class WeatherItems extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {

    private int id;
    private String name;
    private String currentWeather;
    private String description;
    private String temperature;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        int.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrentWeather() {
        return currentWeather;
    }

    public void setCurrentWeather(String currentWeather) {
        this.currentWeather;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    @NonNull
    @Override
    public WeatherAdapter.WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherAdapter.WeatherViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
