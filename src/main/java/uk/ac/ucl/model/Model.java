package uk.ac.ucl.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Model {
  private final ObjectMapper objectMapper = new ObjectMapper();
  private static final String FILE_PATH = "data/notes.json";

  // Read both notes and categories from the JSON file
  public Map<String, Object> readFile(String fileName) {
    File file = new File(fileName);
    Map<String, Object> data = new HashMap<>();

    try {
      if (file.exists()) {
        // Read file as Map<String, Object>
        data = objectMapper.readValue(file, new TypeReference<Map<String, Object>>() {});
      } else {
        // File does not exist, create default structure
        file.getParentFile().mkdirs();
        file.createNewFile();

        // Initialize empty lists
        data.put("notes", new ArrayList<Note>());
        data.put("allCategories", new ArrayList<String>());

        // Save empty structure to file
        writeToFile(fileName, data);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return data;
  }

  // Write both notes and categories to the JSON file
  public void writeToFile(String fileName, Map<String, Object> data) {
    try {
      objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(fileName), data);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
