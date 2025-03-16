package uk.ac.ucl.model;

import java.io.IOException;
import java.util.*;

public class NoteIndex {
    private static NoteIndex instance;
    private List<Note> notes;
    private List<String> allCategories;

    private NoteIndex() {
        Model model;
        try {
            model = ModelFactory.getModel();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Load data from JSON
        Map<String, Object> data = model.readFile("data/notes.json");

        // Load notes
        notes = (List<Note>) data.getOrDefault("notes", new ArrayList<>());

        // Load categories
        allCategories = (List<String>) data.getOrDefault("allCategories", new ArrayList<>());
        Note.setAllCategories(allCategories);
    }

    public static NoteIndex getInstance() {
        if (instance == null) {
            instance = new NoteIndex();
        }
        return instance;
    }

    public void addNote(Note note) {
        notes.add(note);

        // Add new categories to allCategories list
        for (String category : note.getCategories()) {
            if (!allCategories.contains(category)) {
                allCategories.add(category);
            }
        }

        saveNotes();
    }

    public List<Note> getNotes() {
        return notes;
    }

    public List<String> getAllCategories() {
        return allCategories;
    }

    private void saveNotes() {
        Model model;
        try {
            model = ModelFactory.getModel();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Save notes and categories to JSON
        Map<String, Object> data = new HashMap<>();
        data.put("notes", notes);
        data.put("allCategories", allCategories);

        model.writeToFile("data/notes.json", data);
    }
}
