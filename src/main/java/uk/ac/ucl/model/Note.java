package uk.ac.ucl.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Note implements Serializable {
    private String title;
    private String content;
    private String url = "";
    private String imagePath = "";
    private String date;
    private List<String> categories = new ArrayList<>();

    public Note() {}

    public Note(String title, String content, List<String> categories) {
        this.title = title;
        this.content = content;
        this.categories = categories;
        setDate();
    }

    public Note(String title, String content, String url, List<String> categories) {
        this.title = title;
        this.content = content;
        this.url = url;
        this.categories = categories;
        setDate();
    }

    public Note(String title, String content, String url, String imagePath, List<String> categories) {
        this.title = title;
        this.content = content;
        this.url = url;
        this.imagePath = imagePath;
        this.categories = categories;
        setDate();
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

    public String getDate() { return date; }
    public void setDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        this.date = dateFormat.format(new Date());
    }


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
