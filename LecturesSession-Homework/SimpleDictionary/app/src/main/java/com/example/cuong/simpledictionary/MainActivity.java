package com.example.cuong.simpledictionary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SearchView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.cuong.simpledictionary.managers.DbHelper;
import com.example.cuong.simpledictionary.models.Word;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();
    public static final String POSITION = "position";

    private DbHelper dbHelper = DbHelper.instance;

    private SearchView svSearchWord;

    private ListView lvDictionary;

    private static ArrayAdapter<Word> wordArrayAdapter;

    ArrayList<Word>words;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /****************************************************/
        selectAllWord();
        insertNewWord();
        deleteWord();
        updateWord();
        selectAllWord();
        selectRandomWord();
        selectRandomWord();

        /*****************************************************/
        getReference();
        setupUI();
        addListener();
    }

    private void addListener() {
        svSearchWord.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                String text = svSearchWord.getQuery().toString();
                Log.d(TAG, String.format("Change : %s", text));

                words = dbHelper.suggestWord(text);
                resetListView();
                Log.d(TAG, String.format("SIZE : %d", words.size()));

//                wordArrayAdapter.notifyDataSetChanged();
//                lvDictionary.setAdapter(wordArrayAdapter);
                return true;
            }
        });

        lvDictionary.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailScreen.class);
                intent.putExtra(POSITION, position);
                startActivity(intent);
            }
        });


    }

    private void resetListView() {
        wordArrayAdapter = new ArrayAdapter<Word>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                words
        );
        lvDictionary.setAdapter(wordArrayAdapter);
    }

    private void setupUI() {
        words = new ArrayList<>();
        words = dbHelper.readAllWord();
        wordArrayAdapter = new ArrayAdapter<Word>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                words
        );
        lvDictionary.setAdapter(wordArrayAdapter);
    }

    private void getReference() {
        svSearchWord = (SearchView) findViewById(R.id.sv_word);
        lvDictionary = (ListView) findViewById(R.id.lv_dictionary);
    }

    private void selectRandomWord() {
        Log.d(TAG, String.format("RANDOM : %s", dbHelper.selectRandomWord().toString()));
    }

    private void updateWord() {
        ArrayList<Word>words = dbHelper.readAllWord();
        words.get(0).setOriginalWord("I'm fine, Thanks you");
        words.get(0).setTranslateWord("Bien, gracias");
        dbHelper.updateWord(words.get(0));
    }

    private void deleteWord() {
        ArrayList<Word>words = dbHelper.readAllWord();
        dbHelper.deleteWord(words.get(0));
    }


    private void insertNewWord() {
        Word word = new Word("Goodbye", "Adios", "2016-11-18", 1);
        dbHelper.insertNewWord(word);
    }

    private void selectAllWord() {
        ArrayList<Word> words = dbHelper.readAllWord();
//        for (Word word : words) {
//            Log.d(TAG, word.toString());
//        }
    }
}
