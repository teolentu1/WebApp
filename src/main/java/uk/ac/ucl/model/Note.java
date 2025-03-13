package uk.ac.ucl.model;

import java.io.Serializable;

public class Note implements Serializable {
    private String title;
    private String content;  // Can be plain text or other data
    private String url;
    private String imagePath;  // Path to an image file (if applicable)

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

    // Getters and setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public String getImagePath() { return imagePath; }
    public void setImagePath(String imagePath) { this.imagePath = imagePath; }

    @Override
    public String toString() {
        return "Note: " + title + "\nContent: " + content + (url != null ? "\nURL: " + url : "")
                + (imagePath != null ? "\nImage: " + imagePath : "");
    }
}
