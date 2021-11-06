package com.fullcycle.FCCatalogo.domain.entity;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

public class Video extends BaseEntity {
    private String title;
    private String description;
    private Integer yearLaunched;
    private Boolean opened;
    private String rating;
    private Float duration;


    public Video(){

    }

    public Video(UUID id, String title, String description, Integer yearLaunched, Boolean opened){
        super.setId(id);
        this.setTitle(title);
        this.setDescription(description);
        this.setYearLaunched(yearLaunched);
        this.setOpened(opened);
    }

    public Video( String title, String description, Integer yearLaunched, Boolean opened){
        super.generateUUID();
        this.setTitle(title);
        this.setDescription(description);
        this.setYearLaunched(yearLaunched);
        this.setOpened(opened);
    }

    public Video( String title, String description, Integer yearLaunched, Boolean opened, String rating, Float duration){
        super.generateUUID();
        this.setTitle(title);
        this.setDescription(description);
        this.setYearLaunched(yearLaunched);
        this.setOpened(opened);
        this.setRating(rating);
        this.setDuration(duration);
    }

    
    public Video( String title, String description, Integer yearLaunched, Float duration){
        super.generateUUID();
        this.setTitle(title);
        this.setDescription(description);
        this.setYearLaunched(yearLaunched);
        this.setDuration(duration);
    }
    

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        if(title == null) throw new IllegalArgumentException("title is marked non-null but is null");
        if(title.length() == 0) throw new IllegalArgumentException("title is marked non-blank but is blank");
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getYearLaunched() {
        return yearLaunched;
    }
    public void setYearLaunched(Integer yearLaunched) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        if(yearLaunched > currentYear){
            throw new IllegalArgumentException("yearLauched is greater than the current year")
        }
        this.yearLaunched = yearLaunched;
    }
    public String getRating() {
        return rating;
    }
    public void setRating(String rating) {
        this.rating = rating;
    }

    public Boolean isOpened() {
        return opened;
    }

    public void setOpened(Boolean opened) {
        this.opened = opened;
    }

    public Float getDuration() {
        return duration;
    }

    public void setDuration(Float duration) {
        DecimalFormat decimalFormar = new DecimalFormat("#.##");
        this.duration = Float.valueOf(decimalFormar.format(duration));

        this.duration = duration;
    }

    

    

}
