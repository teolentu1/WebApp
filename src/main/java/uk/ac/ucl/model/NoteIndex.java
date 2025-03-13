package uk.ac.ucl.model;

import java.util.ArrayList;
import java.util.List;

public class NoteIndex {
    private static NoteIndex instance;  // Singleton instance
    private List<Note> notes;

    private NoteIndex() {
        notes = new ArrayList<>();
    }

    public static NoteIndex getInstance() {
        if (instance == null) {
            instance = new NoteIndex();
        }
        return instance;
    }

    public void addNote(Note note) {
        notes.add(note);
    }

    public List<Note> getNotes() {
        return notes;
    }

    public Note getNoteByTitle(String title) {
        return notes.stream().filter(n -> n.getTitle().equals(title)).findFirst().orElse(null);
    }
}