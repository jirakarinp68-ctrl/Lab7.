package com.example.lab4;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "notes")
public class NoteEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @NonNull
    public String title;

    public String userName;

    @NonNull
    public String type; // "text" หรือ "checklist"

    public String checklistItemsJson; // null ถ้าเป็น textnote
    public String content; // null ถ้าเป็น checklist

    public Date createdDate;

    public NoteEntity(@NonNull String title, String userName, @NonNull String type, String checklistItemsJson, String content, Date createdDate) {
        this.title = title;
        this.userName = userName;
        this.type = type;
        this.checklistItemsJson = checklistItemsJson;
        this.content = content;
        this.createdDate = createdDate;
    }
}

