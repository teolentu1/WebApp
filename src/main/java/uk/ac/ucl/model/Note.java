package uk.ac.ucl.model;

import java.io.Serializable;
import java.util.List;

public class Note implements Serializable {
    private String title;
    private String content;
    private String url;
    private String imagePath;
    private List<String> categories;
    private static List<String> allCategories;

    public Note() {}

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Note(String title, String content, String url) {
        this.title = title;
        this.content = content;
        this.url = url;
    }

    public Note(String title, String content, String url, String imagePath) {
        this.title = title;
        this.content = content;
        this.url = url;
        this.imagePath = imagePath;
    }

    public Note(String title, String content, List<String> categories) {
        this.title = title;
        this.content = content;
    }

    public Note(String title, String content, String url, List<String> categories) {
        this.title = title;
        this.content = content;
        this.url = url;
    }

    public Note(String title, String content, String url, String imagePath, List<String> categories) {
        this.title = title;
        this.content = content;
        this.url = url;
        this.imagePath = imagePath;
    }

    // Getters and setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public String getImagePath() { return imagePath; }
    public void setImagePath(String imagePath) { this.imagePath = imagePath; }

    public List<String> getCategories() { return categories; }
    public void setCategories(List<String> categories) { this.categories = categories; }

    public static List<String> getAllCategories() { return allCategories; }
    public static void setAllCategories(List<String> allCategories) { Note.allCategories = allCategories; }

//    @Override
//    public String toString() {
//        StringBuilder builder = new StringBuilder();
//        builder.append("Note Details:\n");
//        builder.append("  Title: ").append(title).append("\n");
//        builder.append("  Content: ").append(content).append("\n");
//
//        if (url != null && !url.isEmpty()) {
//            builder.append("  URL: ").append(url).append("\n");
//        }
//
//        if (imagePath != null && !imagePath.isEmpty()) {
//            builder.append("  Image Path: ").append(imagePath).append("\n");
//        }
//
//        return builder.toString();
//    }
}
