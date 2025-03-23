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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String title = request.getParameter("title");
        Note selectedNote = NoteIndex.getInstance().findNote(title);

        if (selectedNote != null) {
            request.setAttribute("selectedNote", selectedNote);
            request.getRequestDispatcher("editNote.jsp").forward(request, response);
        } else {
            response.sendRedirect("viewNotes");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String originalTitle = request.getParameter("originalTitle");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String url = request.getParameter("url");
        String imagePath = request.getParameter("imagePath");
        String[] selectedCategories = request.getParameterValues("categories");

        Note selectedNote = NoteIndex.getInstance().findNote(originalTitle);

        if (selectedNote != null) {
            selectedNote.setTitle(title);
            selectedNote.setContent(content);
            selectedNote.setUrl(url);
            selectedNote.setImagePath(imagePath);
            selectedNote.setCategories(Arrays.asList(selectedCategories));
            selectedNote.setDate();

            response.sendRedirect("viewNotes?title=" + title);  // Assuming you have a page to view individual notes
        } else {
            response.sendRedirect("viewNotes");
        }
    }
}
