package com.example.lab4;

public class NoteController {
    private Note note;

    public void addTextNote(
            String userName,
            String title,
            String content,
            String createdDate
    ) {

        User user = new User();
        user.setUserName(userName);

        TextNote textNote = new TextNote();

        textNote.setTitle(title);
        textNote.setContent(content);
        textNote.setCreatedData(createdDate);
        textNote.setUser(user);

        note = textNote;
    }

    public String showNote() {
        return note.getSummary();
    }
}
