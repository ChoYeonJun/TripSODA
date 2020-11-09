package com.example.tripsoda.Model;

import android.media.Image;
import android.widget.ImageView;

import java.util.ArrayList;

public class HomeItem {


    public String location;
    public String date;
    public int index;
    public int requiredTime;
    public ImageView locationImage;

    public HomeItem(){

    }

    public HomeItem(String location, String date, int index, int requiredTime, ImageView locationImage) {
        this.location = location;
        this.date = date;
        this.index = index;
        this.requiredTime = requiredTime;
        this.locationImage = locationImage;
    }
    public static ArrayList<HomeItem> createContactsList(int numContacts) {
        ArrayList<HomeItem> items = new ArrayList<HomeItem>();

        for (int i = 1; i <= numContacts; i++) {
            items.add(new HomeItem());
        }

        return items;
    }


}
