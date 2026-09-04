package com.example.lab4.Controller;

import android.content.Context;
import android.util.Log;

import com.example.lab4.AppDatabase;
import com.example.lab4.Model.Note;
import com.example.lab4.Model.TextNote;
import com.example.lab4.Model.User;
import com.example.lab4.NoteEntity;
import com.example.lab4.NoteMapper;

import java.util.Date;
import java.util.concurrent.Executors;

public class NoteController {
    private Note note;
    public void saveNote(String userName, String strOfTitle, String strOfContent, Date strOfDate, Context context ){
        TextNote textNote = new TextNote(strOfTitle,strOfContent,strOfDate);
        User user = new User();
        user.setUserName(userName);
        textNote.setUser(user);

        note = textNote;
        //OOP -> entity
        NoteEntity entity = NoteMapper.toEntity(textNote);

//add data to db
        Executors.newSingleThreadExecutor().execute(() -> {
            try {
// save note to Database
                AppDatabase.getInstance(context).noteDao().insert(entity);

// alert if Insert successful
                Log.d("DatabaseAction", "Insert successful: Note saved to database.");

            } catch (Exception e) {
// alert if Error inserting
                Log.e("DatabaseAction", "Error inserting note: " + e.getMessage());
            }
        });

    }
    public String showNote() {
        return note.getSummary();
    }

}
