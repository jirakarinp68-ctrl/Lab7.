package com.example.lab4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BrowNoteActivity extends AppCompatActivity {
    Button SearchButton;
    ProgressBar LoadProsess;
    EditText InputSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_brow_note);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        SearchButton = findViewById(R.id.button5);
        LoadProsess = findViewById(R.id.progressBar2);
        InputSearch = findViewById(R.id.editTextSearch);
        SearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("clickSearch");
                //add
                LoadProsess.setVisibility(View.VISIBLE);
                //createThraed//
                new Thread(()->{
                    //Load DB from DB//
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e){
                        throw new RuntimeException(e);
                    }

                    runOnUiThread(()->{
                        //remove
                        LoadProsess.setVisibility(View.GONE);
                        // go to BrowActivityPage//
                        Intent clickSearch = new Intent(getApplicationContext(), ViewData.class);
                        startActivity(clickSearch);
                        finish();
                    });
                }).start();
            }
        });
    }
}