package uk.ac.ucl.model;

import java.io.Serializable;

public class Note implements Serializable {
    private String title;
    private String content;
    private String url;
    private String imagePath;

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
        StringBuilder builder = new StringBuilder();
        builder.append("Note Details:\n");
        builder.append("  Title: ").append(title).append("\n");
        builder.append("  Content: ").append(content).append("\n");

        if (url != null && !url.isEmpty()) {
            builder.append("  URL: ").append(url).append("\n");
        }

        if (imagePath != null && !imagePath.isEmpty()) {
            builder.append("  Image Path: ").append(imagePath).append("\n");
        }

        return builder.toString();
    }
}
