<%@ page import="java.util.List, uk.ac.ucl.model.NoteIndex, uk.ac.ucl.model.Note" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Notes by Category</title>
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
        ul {
            list-style-type: none;
            padding: 0;
        }
        li {
            background-color: #f9f9f9;
            border-radius: 5px;
            padding: 10px;
            margin: 10px 0;
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
        button {
            background-color: #d66;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            font-size: 1.1em;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        button:hover {
            background-color: #a44;
        }
    </style>
</head>
<body>
    <div class="container">
        <%
            String category = request.getParameter("category");
            NoteIndex noteIndex = NoteIndex.getInstance();
            List<Note> notes = noteIndex.getNotesByCategory().get(category);
        %>

        <h2>Notes in "<%= category %>"</h2>

        <ul>
            <% if (notes != null && !notes.isEmpty()) {
                for (Note note : notes) { %>
                    <li>
                        <a href="viewNote.jsp?title=<%= java.net.URLEncoder.encode(note.getTitle(), "UTF-8") %>">
                            <%= note.getTitle() %>
                        </a>
                    </li>
            <% } } else { %>
                <li>No notes available in this category.</li>
            <% } %>
        </ul>

        <br>
        <button onclick="window.history.back();">Back</button>
    </div>
</body>
</html>
