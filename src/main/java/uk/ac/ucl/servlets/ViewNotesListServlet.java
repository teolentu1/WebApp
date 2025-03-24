package uk.ac.ucl.servlets;

import uk.ac.ucl.model.Note;
import uk.ac.ucl.model.NoteIndex;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@WebServlet("/viewNotes")
public class ViewNotesListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String category = request.getParameter("category");
        String sortBy = request.getParameter("sortBy");
        String sortOrder = request.getParameter("sortOrder");  // "asc" or "desc"

        List<Note> notes;

        NoteIndex noteIndex = NoteIndex.getInstance();

        if (category == null || category.isEmpty()) {
            notes = noteIndex.getNotes(); // Get all notes
        } else {
            Map<String, List<Note>> notesByCategory = noteIndex.getNotesByCategory();
            notes = notesByCategory.getOrDefault(category, Collections.emptyList());
        }

        if (sortBy != null) {
            switch (sortBy) {
                case "dateA":
                    // The notes are already stored in this order
                    break;
                case "dateM":
                    notes.sort(Comparator.comparing(Note::getDate));
                    break;
                case "alpha":
                    notes.sort(Comparator.comparing(Note::getTitle));
                    System.out.println("sorted");
                    break;
            }
            if ("desc".equals(sortOrder)) {
                Collections.reverse(notes);
            }
        }

        request.setAttribute("notes", notes);
        request.setAttribute("category", category);

        if (category != null) {
            request.getRequestDispatcher("indexNotesCategories.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("indexNotes.jsp").forward(request, response);
        }
    }
}
