package uk.ac.ucl.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Model
{
  private final ObjectMapper objectMapper = new ObjectMapper();

  // all functions for interacting with the website
  public List<Note> getNotes()
  {
    return readFile("data/notes.json");
  }

  // This method illustrates how to read csv data from a file.
  // The data files are stored in the root directory of the project (the directory your project is in),
  // in the directory named data.
  public List<Note> readFile(String fileName) {
    List<Note> notes = new ArrayList<>();
    File file = new File(fileName);

    try {
      if (file.exists()) {
        // Read notes from the file
        notes = objectMapper.readValue(file, new TypeReference<List<Note>>() {});
      } else {
        // File doesn't exist: create an empty JSON file
        file.getParentFile().mkdirs(); // Ensure parent directories exist
        file.createNewFile();
        objectMapper.writeValue(file, notes); // Initialize with an empty list
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return notes;
  }

  public void writeToFile(String fileName, List<Note> notes) {
    try {
      objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(fileName), notes);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // This also returns dummy data. The real version should use the keyword parameter to search
  // the data and return a list of matching items.
  public List<String> searchFor(String keyword)
  {
    return List.of("Search keyword is: "+ keyword, "result1", "result2", "result3");
  }

  public void getNote() {

  }
}
