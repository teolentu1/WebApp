package uk.ac.ucl.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uk.ac.ucl.model.Note;
import uk.ac.ucl.model.NoteIndex;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Iterator;

@WebServlet("/deleteCategory")
public class DeleteCategoryServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String selectedCategory = request.getParameter("selectedCategory");

        if (selectedCategory != null && !selectedCategory.isEmpty()) {
            NoteIndex noteIndex = NoteIndex.getInstance();

            List<String> allCategories = noteIndex.getAllCategories();
            allCategories.remove(selectedCategory);


            List<Note> allNotes = noteIndex.getNotes();
            for (Note note : allNotes) {
                note.getCategories().remove(selectedCategory);
            }
            noteIndex.saveNotes();
        }

        response.sendRedirect("indexCategories.jsp");
    }
}
