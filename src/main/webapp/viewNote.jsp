<%@ page import="uk.ac.ucl.model.NoteIndex, uk.ac.ucl.model.Note, java.util.List" %>
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
        .content-box {
            text-align: left;
            background-color: #f9f9f9;
            padding: 10px;
            border-radius: 5px;
            margin: 10px 0;
            white-space: pre-wrap;
            word-wrap: break-word;
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
        input[type="button"], button, input[type="submit"] {
            background-color: #d66;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            font-size: 1.1em;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        input[type="button"]:hover, button:hover, input[type="submit"]:hover {
            background-color: #a44;
        }
    </style>
</head>
<body>
    <div class="container">
        <% if (selectedNote != null) { %>
            <h2><%= selectedNote.getTitle() %></h2>
            <div class="content-box">
                <%= selectedNote.getContent() %>
            </div>

            <% if (selectedNote.getUrl() != null && !selectedNote.getUrl().isEmpty()) { %>
                <a href="<%= selectedNote.getUrl() %>" target="_blank">Open URL</a><br>
            <% } %>

            <% if (selectedNote.getImagePath() != null && !selectedNote.getImagePath().isEmpty()) { %>
                <br>
                <img src="<%= selectedNote.getImagePath() %>" width="100"><br>
            <% } %>

            <%
                List<String> categories = selectedNote.getCategories();
                if (categories != null && !categories.isEmpty()) {
                    String categoriesStr = String.join(", ", categories);
            %>
                <h4>Categories: <%= categoriesStr %></h4>
            <% } %>

            <form action="editNote.jsp" method="GET" style="display: inline;">
                <input type="hidden" name="title" value="<%= selectedNote.getTitle() %>">
                <input type="submit" value="Edit">
            </form>

            <form action="deleteNote" method="POST" style="display: inline;">
                <input type="hidden" name="originalTitle" value="<%= selectedNote.getTitle() %>">
                <input type="submit" value="Delete">
            </form>

        <% } else { %>
            <p>Note not found.</p>
        <% } %>

        <br><br>
        <input type="button" value="Back to Notes" onclick="window.location.href='indexNotes.jsp'">
    </div>
</body>
</html>
