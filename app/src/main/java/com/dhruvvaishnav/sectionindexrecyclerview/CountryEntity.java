package com.dhruvvaishnav.sectionindexrecyclerview;


/**
 * Created by dhruv.vaishnav on 23-05-2016.
 */

public class CountryEntity {

    private String countryName;
    private String countryCode;

    public CountryEntity(String line) {
        this.countryName = line.split(",")[0];
        this.countryCode = "+" + line.split(",")[2];
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
