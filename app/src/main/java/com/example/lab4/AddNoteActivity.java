package com.example.lab4;

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
                String strOfData = new Date().toString();
                String strOfUser = UserName.getText().toString();

                controller.addTextNote(
                        strOfUser,
                        strOfTitle,
                        strOfContent,
                        strOfData
                );

                textView.setText(controller.showNote());

                }
            });
        }
    }