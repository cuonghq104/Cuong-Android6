package com.example.cuong.simpledictionary.managers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.cuong.simpledictionary.models.Word;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.Dictionary;

/**
 * Created by Cuong on 11/18/2016.
 */
public class DbHelper extends SQLiteAssetHelper {

    private static final String DB_NAME = "dictionary.db";
    private static final int DB_VERSION = 1;
    private static final String DICTIONARY_TABLE_NAME = "tbl_dictionary";

    private static final String DICTIONARY_ID = "id";
    private static final String DICTIONARY_ORIGINAL_WORD = "original_word";
    private static final String DICTIONARY_TRANSLATE_WORD = "translate_word";
    private static final String DICTIONARY_IS_FAVORITE = "is_favorite";
    private static final String DICTIONARY_DATE_CREATED = "date_created";

    private static final String[] DICTIONARY_COLUMN = {
            DICTIONARY_ID,
            DICTIONARY_ORIGINAL_WORD,
            DICTIONARY_TRANSLATE_WORD,
            DICTIONARY_DATE_CREATED,
            DICTIONARY_IS_FAVORITE
    };
    /*******************CONSTRUCTOR & SINGLETON******************************/

    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public static DbHelper instance;

    public static DbHelper getInstance() {
        return instance;
    }

    public static void init(Context context) {
        instance = new DbHelper(context);
    }

    /****************** Word **********************************************/

    public ArrayList<Word> readAllWord() {
        ArrayList<Word> words = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(DICTIONARY_TABLE_NAME, DICTIONARY_COLUMN, null, null, null, null, null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex(DICTIONARY_ID));
            String originalWord = cursor.getString(cursor.getColumnIndex(DICTIONARY_ORIGINAL_WORD));
            String translateWord = cursor.getString(cursor.getColumnIndex(DICTIONARY_TRANSLATE_WORD));
            String dateCreated = cursor.getString(cursor.getColumnIndex(DICTIONARY_DATE_CREATED));
            int isFavorite = cursor.getInt(cursor.getColumnIndex(DICTIONARY_IS_FAVORITE));
            Word word = new Word(id, originalWord, translateWord, dateCreated, isFavorite);
            words.add(word);
        }
        db.close();;
        return  words;
    }

    public Word selectWord(int position) {
        SQLiteDatabase db = this.getReadableDatabase();
        Word word = null;

        Cursor cursor = db.query(DICTIONARY_TABLE_NAME, DICTIONARY_COLUMN, null, null, null, null, null);

        if (cursor.moveToPosition(position)) {
            int id = cursor.getInt(cursor.getColumnIndex(DICTIONARY_ID));
            String originalWord = cursor.getString(cursor.getColumnIndex(DICTIONARY_ORIGINAL_WORD));
            String translateWord = cursor.getString(cursor.getColumnIndex(DICTIONARY_TRANSLATE_WORD));
            String dateCreated = cursor.getString(cursor.getColumnIndex(DICTIONARY_DATE_CREATED));
            int isFavorite = cursor.getInt(cursor.getColumnIndex(DICTIONARY_IS_FAVORITE));
            word = new Word(id, originalWord, translateWord, dateCreated, isFavorite);

        }
        db.close();
        return word;
    }
    public void insertNewWord(Word word) {
        SQLiteDatabase db = this.getWritableDatabase();

        int id = (int) db.insert(DICTIONARY_TABLE_NAME, null, create(word));
        word.setId(id);

        db.close();
    }

    public void deleteWord(Word word) {
        SQLiteDatabase db = this.getWritableDatabase();

        String[] args = new String[] {String.format("%s", word.getId())};

        db.delete(DICTIONARY_TABLE_NAME, "id=?", new String[]{String.format("%s", args)});

        db.close();
    }


    public void updateWord(Word word) {
        SQLiteDatabase db = this.getWritableDatabase();

        String[] args = new String[] {String.format("%s", word.getId())};

        db.update(DICTIONARY_TABLE_NAME, create(word), "id=?", args);

        db.close();
    }

    public Word selectRandomWord() {
        SQLiteDatabase db = this.getReadableDatabase();
        Word word = null;
        String sql = "SELECT * FROM tbl_dictionary ORDER BY RANDOM() LIMIT 1";

        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex(DICTIONARY_ID));
            String originalWord = cursor.getString(cursor.getColumnIndex(DICTIONARY_ORIGINAL_WORD));
            String translateWord = cursor.getString(cursor.getColumnIndex(DICTIONARY_TRANSLATE_WORD));
            String dateCreated = cursor.getString(cursor.getColumnIndex(DICTIONARY_DATE_CREATED));
            int isFavorite = cursor.getInt(cursor.getColumnIndex(DICTIONARY_IS_FAVORITE));
            word = new Word(id, originalWord, translateWord, dateCreated, isFavorite);
        }
        db.close();
        return word;
    }

    public ArrayList<Word> suggestWord(String text) {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Word> words = new ArrayList<>();
        Cursor cursor = db.query(true, DICTIONARY_TABLE_NAME, DICTIONARY_COLUMN, DICTIONARY_ORIGINAL_WORD + " LIKE ?",
                new String[] {text + "%" }, null, null, null,
                null);

        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex(DICTIONARY_ID));
            String originalWord = cursor.getString(cursor.getColumnIndex(DICTIONARY_ORIGINAL_WORD));
            String translateWord = cursor.getString(cursor.getColumnIndex(DICTIONARY_TRANSLATE_WORD));
            String dateCreated = cursor.getString(cursor.getColumnIndex(DICTIONARY_DATE_CREATED));
            int isFavorite = cursor.getInt(cursor.getColumnIndex(DICTIONARY_IS_FAVORITE));
            Word word = new Word(id, originalWord, translateWord, dateCreated, isFavorite);
            words.add(word);
        }
        db.close();
        return words;
    }

    private ContentValues create(Word word) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DICTIONARY_ID, word.getId());
        contentValues.put(DICTIONARY_ORIGINAL_WORD, word.getOriginalWord());
        contentValues.put(DICTIONARY_TRANSLATE_WORD, word.getTranslateWord());
        contentValues.put(DICTIONARY_DATE_CREATED, word.getDateCreated());
        contentValues.put(DICTIONARY_IS_FAVORITE, word.getIsFavorite());

        return contentValues;
    }
}
