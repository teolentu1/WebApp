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

        // Load notes and convert raw maps to Note objects
        List<Map<String, Object>> rawNotes = (List<Map<String, Object>>) data.get("notes");
        notes = new ArrayList<>();
        if (rawNotes != null) {
            for (Map<String, Object> noteMap : rawNotes) {
                String title = (String) noteMap.get("title");
                String content = (String) noteMap.get("content");
                String url = (String) noteMap.get("url");
                String imagePath = (String) noteMap.get("imagePath");
                List<String> categories = (List<String>) noteMap.get("categories");
                notes.add(new Note(title, content, url, imagePath, categories));
            }
        }

        // Load categories
        allCategories = (List<String>) data.getOrDefault("allCategories", new ArrayList<>());
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

    public void deleteNote(Note note) {
        System.out.println("Deleting note: " + note.getTitle());
        System.out.println("Notes: " + note);
        notes.remove(note);
        saveNotes();
        System.out.println("New Notes: " + note);
    }

    public List<Note> getNotes() {
        return notes;
    }

    public Note findNote(String originalTitle) {
        Note selectedNote = null;
        if (originalTitle != null) {
            for (Note note : NoteIndex.getInstance().getNotes()) {
                if (note.getTitle().equals(originalTitle)) {
                    selectedNote = note;
                    break;
                }
            }
        }
        return selectedNote;
    }


    public Map<String, List<Note>> getNotesByCategory() {
        Map<String, List<Note>> categorizedNotes = new HashMap<>();

        for (Note note : notes) {
            for (String category : note.getCategories()) {
                categorizedNotes
                        .computeIfAbsent(category, k -> new ArrayList<>())
                        .add(note);
            }
        }
        return categorizedNotes;
    }

    public List<String> getAllCategories() {
        return allCategories;
    }

    public void saveNotes() {
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
