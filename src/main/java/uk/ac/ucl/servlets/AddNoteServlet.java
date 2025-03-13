package uk.ac.ucl.servlets;

import uk.ac.ucl.model.Note;
import uk.ac.ucl.model.NoteIndex;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/addNote")
public class AddNoteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String url = request.getParameter("url");
        String imagePath = request.getParameter("imagePath");

        // Create and add note
        Note newNote = new Note(title, content, url, imagePath);
        NoteIndex.getInstance().addNote(newNote);

        // Redirect to the index page to show the updated notes list
        response.sendRedirect("indexNotes.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("addNote.jsp").forward(request, response);
    }
}

