package com.example.pract17;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private static final String SHARED_PREFS = "sharedPrefs";
    private static final String TEXT_KEY = "textKey";

    EditText editText;
    TextView textView;
    Set<String> textSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.EditTextName);
        textView = findViewById(R.id.TVLoad);

        textSet = loadText();

        Button saveButton = findViewById(R.id.BtnSave);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                saveText(text);
                editText.setText("");
            }
        });

        Button loadButton = findViewById(R.id.BtnLoad);
        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = getStoredText();
                textView.setText(text);
            }
        });
    }

    private void saveText(String text) {
        textSet.add(text);
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putStringSet(TEXT_KEY, textSet);
        editor.apply();
    }

    private Set<String> loadText() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        return sharedPreferences.getStringSet(TEXT_KEY, new HashSet<String>());
    }

    private String getStoredText() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String text : textSet) {
            stringBuilder.append(text).append("\n");
        }
        return stringBuilder.toString().isEmpty() ? "Пусто" : stringBuilder.toString();
    }
}