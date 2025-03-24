<%@ page import="java.util.List, uk.ac.ucl.model.Note" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Search Results</title>
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
            width: 80%;
            max-width: 600px;
        }
        h1 {
            margin-bottom: 20px;
            color: #333;
        }
        .note-box {
            background-color: #f9f9f9;
            padding: 15px;
            border-radius: 5px;
            margin: 10px 0;
            text-align: left;
        }
        .note-title {
            font-weight: bold;
            color: #d66;
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
        <h1>Search Results</h1>
        <%
            List<Note> searchResults = (List<Note>) request.getAttribute("searchResults");
            if (searchResults == null || searchResults.isEmpty()) {
        %>
            <p>No notes found matching your search.</p>
        <% } else {
            for (Note note : searchResults) {
        %>
            <div class="note-box">
                <div class="note-title"><%= note.getTitle() %></div>
                <p><%= note.getContent() %></p>
            </div>
        <%
            }
        } %>
        <br>
        <button onclick="window.location.href='search.html'">Back to Search</button>
    </div>
</body>
</html>
