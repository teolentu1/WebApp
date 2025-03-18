package uk.ac.ucl.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uk.ac.ucl.model.NoteIndex;

import java.io.IOException;

@WebServlet("/addCategory")
public class AddCategoryServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String category = request.getParameter("category");

        if (category != null && !category.trim().isEmpty()) {
            NoteIndex noteIndex = NoteIndex.getInstance();
            if (!noteIndex.getAllCategories().contains(category)) {
                noteIndex.getAllCategories().add(category);
                noteIndex.saveNotes(); // Ensure the new category is saved
            }
        }

        // Redirect back to the category list page
        response.sendRedirect("indexCategories.jsp");

    }
}
