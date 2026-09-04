package com.example.lab4;

import com.example.lab4.Model.ChackListNote;
import com.example.lab4.Model.Note;
import com.example.lab4.Model.TextNote;
import com.example.lab4.Model.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.Date;
import java.util.List;

public class NoteMapper {

    static Gson gson = new Gson();

    // OOP -> Entity
    public static NoteEntity toEntity(Note note) {
        String userName = (note.getUser() != null) ? note.getUser().getUserName() : "Unknown";
        if (note instanceof TextNote) {
            return new NoteEntity(note.getTitle(), userName, "text", null, ((TextNote) note).getContent(), note.getCreatedData());
        } else if (note instanceof ChackListNote) {
            String jsonItems = gson.toJson(((ChackListNote) note).getItems());
            return new NoteEntity(note.getTitle(), userName, "checklist", jsonItems, null, note.getCreatedData());
        }
        return null;
    }

    // Entity -> OOP
    public static Note fromEntity(NoteEntity entity) {
        if (entity.type.equals("text")) {
            TextNote textNote = new TextNote(entity.title, entity.content, entity.createdDate);
            User user = new User();
            user.setUserName(entity.userName);
            textNote.setUser(user);
            return textNote;
        } else if (entity.type.equals("checklist")) {
            // Note: ChackListNote expects a single String item in this version, 
            // but the entity has checklistItemsJson. Adjusting to match ChackListNote.
            ChackListNote checklistNote = new ChackListNote();
            checklistNote.setTitle(entity.title);
            checklistNote.setCreatedData(entity.createdDate);
            checklistNote.item = entity.checklistItemsJson; // Using it as a string for now
            User user = new User();
            user.setUserName(entity.userName);
            checklistNote.setUser(user);
            return checklistNote;
        }
        return null;
    }
}