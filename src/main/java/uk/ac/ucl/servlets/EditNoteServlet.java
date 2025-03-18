package uk.ac.ucl.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uk.ac.ucl.model.Note;
import uk.ac.ucl.model.NoteIndex;

import java.io.IOException;
import java.util.Arrays;

@WebServlet("/editNote")
public class EditNoteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String originalTitle = request.getParameter("originalTitle");  // To track the original note title
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String url = request.getParameter("url");
        String imagePath = request.getParameter("imagePath");
        String[] selectedCategories = request.getParameterValues("categories");

        // Find the note with the original title
        Note selectedNote = null;
        if (originalTitle != null) {
            for (Note note : NoteIndex.getInstance().getNotes()) {
                if (note.getTitle().equals(originalTitle)) {
                    selectedNote = note;
                    break;
                }
            }
        }

        if (selectedNote != null) {
            // Update the note's details
            selectedNote.setTitle(title);
            selectedNote.setContent(content);
            selectedNote.setUrl(url);
            selectedNote.setImagePath(imagePath);
            selectedNote.setCategories(Arrays.asList(selectedCategories));

            // Redirect to a page that displays the updated note or the notes list
            response.sendRedirect("viewNote.jsp?title=" + title);  // Assuming you have a page to view individual notes
        } else {
            // If the note wasn't found, redirect back to the notes list
            response.sendRedirect("indexNotes.jsp");
        }
    }
}
