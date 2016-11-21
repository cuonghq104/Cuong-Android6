package com.example.cuong.lap2;

import java.util.ArrayList;

/**
 * Created by Cuong on 11/20/2016.
 */
public class New {

    private int imageResID;

    private String content;

    private int timePosted;

    public New(int imageResID, String content, int timePosted) {
        this.imageResID = imageResID;
        this.content = content;
        this.timePosted = timePosted;
    }

    public int getImageResID() {
        return imageResID;
    }

    public void setImageResID(int imageResID) {
        this.imageResID = imageResID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getTimePosted() {
        return timePosted;
    }

    public void setTimePosted(int timePosted) {
        this.timePosted = timePosted;
    }

    private static ArrayList<New>news = new ArrayList<>();

    public static ArrayList<New> getNews() {
        if (news.size() == 0) {
            news.add(new New(R.drawable.item1, "He may act like he want a secretarty but most of the time they're looking for...", 10));
            news.add(new New(R.drawable.item2, "Peggy, just think about it. Deeply. Then forget it. And an idea will jump up in your face", 13));
            news.add(new New(R.drawable.item3, "Go home, take a paper bag and cut some eyeholes out of it. Put it over your head...", 16));
            news.add(new New(R.drawable.item4, "Get out of hear and move forward. This never happened. It will shock you how much", 19));
            news.add(new New(R.drawable.item5, "That poor girl. She doesn't know that loving you is the worst way to get to you", 10));
        }
        return news;
    }
}
