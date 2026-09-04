package com.example.lab4.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lab4.Controller.NoteController;
import com.example.lab4.R;

import java.util.Date;

public class AddNoteActivity extends AppCompatActivity {
    NoteController controller = new NoteController();
    EditText title;
    EditText content;
    EditText UserName;
    TextView textView;
    Button Enter,Back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_note);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Back = findViewById(R.id.button);
        title = findViewById(R.id.editTextText);
        content = findViewById(R.id.editTextText2);
        UserName = findViewById(R.id.editTextUser);
        textView = findViewById(R.id.textView);
        Enter = findViewById(R.id.button3);

        Back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                System.out.println("click");
                Intent clickBack = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(clickBack);
            }
        });
        Enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strOfTitle = title.getText().toString();
                String strOfContent = content.getText().toString();
                String strOfUser = UserName.getText().toString();
                Date date = new Date();

                controller.saveNote(
                        strOfUser,
                        strOfTitle,
                        strOfContent,
                        date,
                        AddNoteActivity.this
                );

                textView.setText(controller.showNote());
            }
        });
        }
    }