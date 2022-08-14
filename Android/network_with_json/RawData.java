package com.skt.network_with_json;

import android.os.Bundle;

public class RawData {

    String img;
    String subject;
    Double rating;

    public RawData(String img, String subject, Double rating){
        this.img = img;
        this.subject = subject;
        this.rating = rating;
    }

    public String getImg(){
        return img;
    }

    public String getSubject(){
        return subject;
    }

    public Double getRating(){
        return rating;
    }
}
