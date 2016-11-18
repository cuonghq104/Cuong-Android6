package com.example.cuong.simpledictionary.models;

/**
 * Created by Cuong on 11/18/2016.
 */
public class Word {

    private int id;

    private String originalWord;

    private String translateWord;

    private String dateCreated;

    private int isFavorite;

    public Word(int id, String originalWord, String translateWord, String dateCreated, int isFavorite) {
        this.id = id;
        this.originalWord = originalWord;
        this.translateWord = translateWord;
        this.dateCreated = dateCreated;
        this.isFavorite = isFavorite;
    }

    public Word(String translateWord, String originalWord, String dateCreated, int isFavorite) {
        this(-1, originalWord, translateWord, dateCreated , isFavorite);
    }

    /*************************Getter & Setter**********************************/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOriginalWord() {
        return originalWord;
    }

    public void setOriginalWord(String originalWord) {
        this.originalWord = originalWord;
    }

    public String getTranslateWord() {
        return translateWord;
    }

    public void setTranslateWord(String translateWord) {
        this.translateWord = translateWord;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public int getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(int isFavorite) {
        this.isFavorite = isFavorite;
    }

    @Override
    public String toString() {
        return String.format("%s", originalWord);
    }
}
