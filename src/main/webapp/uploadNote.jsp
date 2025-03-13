<%@ page import="java.io.*, java.nio.file.*, uk.ac.ucl.model.Note, uk.ac.ucl.model.NoteIndex" %>
<%
    String title = request.getParameter("title");
    String content = request.getParameter("content");
    String url = request.getParameter("url");
    String imagePath = "";

    // Retrieve the uploaded file
    Part filePart = request.getPart("image");
    if (filePart != null && filePart.getSize() > 0) {
        // Extract file name from the uploaded part
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

        // Get the directory for storing uploads
        String uploadDir = request.getServletContext().getRealPath("/") + "uploads" + File.separator;
        File uploadFolder = new File(uploadDir);

        // Create upload directory if it doesn't exist
        if (!uploadFolder.exists()) {
            uploadFolder.mkdirs();
        }

        // Create the full file path
        File file = new File(uploadDir + fileName);

        // Write the file to the server
        filePart.write(file.getAbsolutePath());

        // Set the relative path to store in the database
        imagePath = "uploads/" + fileName;
    }

    // Create and add the note
    Note newNote = new Note(title, content, url, imagePath);
    NoteIndex.getInstance().addNote(newNote);

    // Redirect to the index page
    response.sendRedirect("indexNotes.jsp");
%>
