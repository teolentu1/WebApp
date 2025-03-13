package uk.ac.ucl.servlets;

import uk.ac.ucl.model.Note;
import uk.ac.ucl.model.NoteIndex;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;

@MultipartConfig(
        fileSizeThreshold = 1024 * 1024, // 1MB
        maxFileSize = 5 * 1024 * 1024, // 5MB per file
        maxRequestSize = 10 * 1024 * 1024 // 10MB total request
)
public class UploadNoteServlet extends HttpServlet {
    private static final String UPLOAD_DIR = "uploads"; // Folder to store images

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String url = request.getParameter("url");

        String imagePath = null;

        // Handle file upload
        Part filePart = request.getPart("image");
        if (filePart != null && filePart.getSize() > 0) {
            String fileName = System.currentTimeMillis() + "_" + filePart.getSubmittedFileName(); // Unique filename
            String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) uploadDir.mkdir(); // Create directory if needed

            String fileSavePath = uploadPath + File.separator + fileName;
            filePart.write(fileSavePath); // Save file

            imagePath = UPLOAD_DIR + "/" + fileName; // Store relative path
        }

        // Create and save the note
        Note newNote = new Note(title, content, url, imagePath);
        NoteIndex.getInstance().addNote(newNote);

        // Redirect back to index
        response.sendRedirect("indexNotes.jsp");
    }
}
