package com.example.lab4;

import com.example.lab4.Model.Note;
import com.example.lab4.Model.TextNote;
import com.example.lab4.Model.User;
import com.google.gson.Gson;

public class NoteMapper {

    static Gson gson = new Gson();

    // OOP -> Entity
    public static NoteEntity toEntity(Note note) {
        String userName = (note.getUser() != null) ? note.getUser().getUserName() : "Unknown";
        if (note instanceof TextNote) {
            return new NoteEntity(note.getTitle(), userName, "text", null, ((TextNote) note).getContent(), note.getCreatedData());
        } /*else if (note instanceof ChecklistNote) {
            String jsonItems = gson.toJson(((ChecklistNote) note).getItems());
            return new NoteEntity(note.title, "checklist", jsonItems, null, note.createdDate);
        }*/
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
        } /*else if (entity.type.equals("checklist")) {
            List<String> items = gson.fromJson(entity.checklistItemsJson, new TypeToken<List<String>>(){}.getType());
            return new ChecklistNote(entity.title, entity.createdDate, items);
        }*/
        return null;
    }
}