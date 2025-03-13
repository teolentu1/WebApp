<%@ page import="uk.ac.ucl.model.NoteIndex, uk.ac.ucl.model.Note" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Your Notes</title>
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
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
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
        <h2>Your Notes</h2>
        <ul>
            <% for (Note note : NoteIndex.getInstance().getNotes()) { %>
            <li>
                <a href="viewNote.jsp?title=<%= java.net.URLEncoder.encode(note.getTitle(), "UTF-8") %>">
                    <%= note.getTitle() %>
                </a>
            </li>
            <% } %>
        </ul>

        <br>
        <input type="button" value="Back to Index" onclick="window.location.href='index.html'">
    </div>
</body>
</html>
