package com.example.resumebuilder;

public class Model {
    private String imageUrl;
    public Model(){

    }
    public Model(String imageUrl){
        this.imageUrl=imageUrl;
    }
    public String getImageUri(){
        return imageUrl;
    }
    public void setImageUri(String imageUrl){
        this.imageUrl=imageUrl;
    }
}
