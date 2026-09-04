package com.example.lab4.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lab4.AppDatabase;
import com.example.lab4.Model.Note;
import com.example.lab4.NoteEntity;
import com.example.lab4.NoteMapper;
import com.example.lab4.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

public class BrowNoteActivity extends AppCompatActivity {
    Button SearchButton;
    ProgressBar LoadProsess;
    EditText InputSearch;
    TextView ShowNote;

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
        ShowNote = findViewById(R.id.textView5);
        LoadProsess = findViewById(R.id.progressBar2);
        InputSearch = findViewById(R.id.editTextSearch);
        SearchButton = findViewById(R.id.button5);

        // load data from db
        Executors.newSingleThreadExecutor().execute(() -> {
            List<NoteEntity> entities = AppDatabase.getInstance(this).noteDao().getAll();
            List<Note> notes = new ArrayList<>();
            for (NoteEntity e : entities) {
                notes.add(NoteMapper.fromEntity(e));
            }

            // display on UI thread
            runOnUiThread(() -> {
                StringBuilder sb = new StringBuilder();
                for (Note n : notes) {
                    if (n != null) {
                        sb.append(n.getSummary()).append("\n");
                    }
                }
                ShowNote.setText(sb.toString());
            });
        });

        SearchButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    System.out.println("click");
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
                            Intent clickBrow = new Intent(getApplicationContext(), BrowNoteActivity.class);
                            startActivity(clickBrow);
                            finish();
                        });
                    }).start();
            }
        });
    }
}
