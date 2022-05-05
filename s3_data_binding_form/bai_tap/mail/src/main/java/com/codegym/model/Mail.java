package com.codegym.model;

public class Mail {
    String languages;
    String show;
    String spams;
    String signature;

    public Mail(String languages, String show, String spams, String signature) {
        this.languages = languages;
        this.show = show;
        this.spams = spams;
        this.signature = signature;
    }
    public Mail() {
    }
    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getShow() {
        return show;
    }

    public void setShow(String show) {
        this.show = show;
    }

    public String getSpams() {
        return spams;
    }

    public void setSpams(String spams) {
        this.spams = spams;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }


}
