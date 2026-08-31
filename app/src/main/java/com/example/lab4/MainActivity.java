package com.example.lab4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {
    Button AddNoteActivity,Brow;
    ImageView logo;
    ProgressBar loadData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
       AddNoteActivity = findViewById(R.id.button2);
       Brow = findViewById(R.id.button7);
       logo = findViewById(R.id.imageView);
       logo.setImageResource(R.drawable.logo2);
       loadData = findViewById(R.id.progressBar);


       AddNoteActivity.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               System.out.println("click");
               Intent clickAdd = new Intent(getApplicationContext(), AddNoteActivity.class);
               startActivity(clickAdd);
           }
       });
        Brow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("click");
                //add
                loadData.setVisibility(View.VISIBLE);
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
                        loadData.setVisibility(View.GONE);
                        // go to BrowActivityPage//
                        Intent clickBrow = new Intent(getApplicationContext(), BrowNoteActivity.class);
                        startActivity(clickBrow);
                        finish();
                    });
                }).start();
            }
        });
    }
}