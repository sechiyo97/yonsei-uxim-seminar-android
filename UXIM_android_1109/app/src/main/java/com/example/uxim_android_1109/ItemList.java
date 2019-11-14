package com.example.uxim_android_1109;

public class ItemList {

    private String id;
    private String English;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEnglish() {
        return English;
    }

    public void setEnglish(String english) {
        English = english;
    }

    public ItemList(String id, String english) {
        this.id = id;
        English = english;
    }
}