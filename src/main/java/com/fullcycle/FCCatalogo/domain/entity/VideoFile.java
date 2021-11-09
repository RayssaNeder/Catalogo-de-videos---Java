package com.fullcycle.FCCatalogo.domain.entity;

import java.text.DecimalFormat;

public class VideoFile extends BaseEntity {

    private String title;
    private Float duration;
    private String url;

    public VideoFile() {
    }

    public VideoFile(String title, Float duration, String url) {
        this.setTitle(title);
        this.setDuration(duration);
        this.setUrl(url);
    }

    public VideoFile(String title, Float duration) {
        this.setTitle(title);
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

    public Float getDuration() {
        DecimalFormat decimalFormar = new DecimalFormat("#.##");
        return Float.valueOf(decimalFormar.format(duration));
    }

    public void setDuration(Float duration) {
        DecimalFormat decimalFormar = new DecimalFormat("#.##");
        this.duration = Float.valueOf(decimalFormar.format(duration));
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    

    
    
}
