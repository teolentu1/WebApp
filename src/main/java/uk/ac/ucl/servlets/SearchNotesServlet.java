package uk.ac.ucl.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uk.ac.ucl.model.Note;
import uk.ac.ucl.model.NoteIndex;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/searchNotes")
public class SearchNotesServlet extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String searchString = request.getParameter("searchstring");

    if (searchString == null || searchString.trim().isEmpty()) {
      request.setAttribute("searchResults", List.of()); // Empty list if no input
    } else {
      NoteIndex noteIndex = NoteIndex.getInstance();
      List<Note> notes = noteIndex.getNotes();

      List<Note> filteredNotes = notes.stream()
              .filter(note -> note.getTitle().toLowerCase().contains(searchString.toLowerCase()) ||
                      note.getContent().toLowerCase().contains(searchString.toLowerCase()))
              .collect(Collectors.toList());

      request.setAttribute("searchResults", filteredNotes);
    }

    request.getRequestDispatcher("/searchResult.jsp").forward(request, response);
  }
}
