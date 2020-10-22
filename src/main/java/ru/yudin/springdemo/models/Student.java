package ru.yudin.springdemo.models;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Student {
    private String firstName;
    private String lastName;
    private String country;
    private Map<String, String> countryOptions;
    private String favoriteLanguage;
    private List<String> languageOptions;
    private ArrayList<String> operationSystems;
    private List<String> operationSystemsOptions;

    public Student() {
        setCountryOptions();
        setLanguageOptions();
        setOperationSystemsOptionsOptions();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Map<String, String> getCountryOptions() {
        return countryOptions;
    }

    public String getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }

    private void setCountryOptions() {
        countryOptions = new LinkedHashMap<>();
        countryOptions.put("RUS", "Russia");
        countryOptions.put("USA", "America");
        countryOptions.put("ITL", "Italy");
        countryOptions.put("IND", "India");
    }

    private void setLanguageOptions() {
        languageOptions = new ArrayList<>();
        languageOptions.add("1C");
        languageOptions.add("C");
        languageOptions.add("Java");
    }

    public List<String> getLanguageOptions() {
        return languageOptions;
    }

    private void setOperationSystemsOptionsOptions() {
        operationSystemsOptions = new ArrayList<>();
        operationSystemsOptions.add("Windows");
        operationSystemsOptions.add("Mac");
        operationSystemsOptions.add("Linux");
    }

    public List<String> getOperationSystemsOptions() {
        return operationSystemsOptions;
    }

    public ArrayList<String> getOperationSystems() {
        return operationSystems;
    }

    public void setOperationSystems(ArrayList<String> operationSystems) {
        this.operationSystems = operationSystems;
    }
}
