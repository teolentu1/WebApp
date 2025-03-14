package uk.ac.ucl.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NoteIndex {
    private static NoteIndex instance;  // Singleton instance
    private List<Note> notes;
    private Map<String, Category> categories;

    private NoteIndex() {
        // Load notes from the JSON file on startup
        Model model = null;
        try {
            model = ModelFactory.getModel();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        notes = model.readFile("data/notes.json");
    }

    public static NoteIndex getInstance() {
        if (instance == null) {
            instance = new NoteIndex();
        }
        return instance;
    }

    public void addNote(Note note) {
        notes.add(note); // Add the new note to the in-memory list
        // Save the updated notes list to the JSON file
        Model model = null;
        try {
            model = ModelFactory.getModel();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        model.writeToFile("data/notes.json", notes);
    }

    public List<Note> getNotes() {
        return notes;
    }

    public Note getNoteByTitle(String title) {
        return notes.stream().filter(n -> n.getTitle().equals(title)).findFirst().orElse(null);
    }

    public Map<String, Category> getCategories() { return categories; }

    public List<Note> getNotesByCategory(String categoryName) {
        return categories.containsKey(categoryName) ? categories.get(categoryName).getNotes() : new ArrayList<>();
    }

}