package com.example.resumebuilder;

public class Exptemp {
    String Company,Details,Dur,Job;

    public Exptemp() {
    }

    public Exptemp(String company, String details, String dur, String job) {
        Company = company;
        Details = details;
        Dur = dur;
        Job = job;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String details) {
        Details = details;
    }

    public String getDur() {
        return Dur;
    }

    public void setDur(String dur) {
        Dur = dur;
    }

    public String getJob() {
        return Job;
    }

    public void setJob(String job) {
        Job = job;
    }
}
