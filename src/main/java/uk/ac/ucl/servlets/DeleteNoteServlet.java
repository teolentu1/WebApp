package uk.ac.ucl.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uk.ac.ucl.model.Note;
import uk.ac.ucl.model.NoteIndex;

import java.io.IOException;

@WebServlet("/deleteNote")
public class DeleteNoteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String originalTitle = request.getParameter("originalTitle");

        // Find the note with the original title
        Note noteToDelete = null;
        if (originalTitle != null) {
            for (Note note : NoteIndex.getInstance().getNotes()) {
                if (note.getTitle().equals(originalTitle)) {
                    noteToDelete = note;
                    break;
                }
            }
        }
        NoteIndex.getInstance().deleteNote(noteToDelete);
        System.out.println("Note to delete: " + noteToDelete);
        response.sendRedirect("indexNotes.jsp");
    }
}
