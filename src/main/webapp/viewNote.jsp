<%@ page import="uk.ac.ucl.model.NoteIndex, uk.ac.ucl.model.Note" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String noteTitle = request.getParameter("title");
    Note selectedNote = null;

    if (noteTitle != null) {
        for (Note note : NoteIndex.getInstance().getNotes()) {
            if (note.getTitle().equals(noteTitle)) {
                selectedNote = note;
                break;
            }
        }
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Note Details</title>
    <style>
        body {
            background-color: #fce0e0;
            font-family: Arial, sans-serif;
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            background-color: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            text-align: center;
            width: 100%;
            max-width: 600px;
        }
        h2 {
            margin-bottom: 20px;
            color: #333;
        }
        p {
            color: #666;
        }
        a {
            text-decoration: none;
            color: #d66;
            font-weight: bold;
            transition: color 0.3s;
        }
        a:hover {
            color: #a44;
        }
        input[type="button"] {
            background-color: #d66;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            font-size: 1.1em;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        input[type="button"]:hover {
            background-color: #a44;
        }
    </style>
</head>
<body>
    <div class="container">
        <% if (selectedNote != null) { %>
            <h2><%= selectedNote.getTitle() %></h2>
            <p><%= selectedNote.getContent() %></p>

            <% if (selectedNote.getUrl() != null && !selectedNote.getUrl().isEmpty()) { %>
                <a href="<%= selectedNote.getUrl() %>" target="_blank">Open URL</a><br>
            <% } %>

            <% if (selectedNote.getImagePath() != null && !selectedNote.getImagePath().isEmpty()) { %>
                <br>
                <img src="<%= selectedNote.getImagePath() %>" width="100"><br>
            <% } %>
        <% } else { %>
            <p>Note not found.</p>
        <% } %>

        <% if (selectedNote.getImagePath() != null && !selectedNote.getImagePath().isEmpty()) { %>
            <br>
            <img src="<%= request.getContextPath() + "/" + selectedNote.getImagePath() %>" width="100"><br>
        <% } %>

        <br>
        <input type="button" value="Back to Notes" onclick="window.location.href='indexNotes.jsp'">
    </div>
</body>
</html>
