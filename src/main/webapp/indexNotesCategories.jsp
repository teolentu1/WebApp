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
        button, input[type="submit"] {
            background-color: #d66;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            font-size: 1.1em;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        button:hover, input[type="submit"]:hover{
            background-color: #a44;
        }

        button2 {
            background-color: none;
            padding: 10px 10px;
            border: none;
            border-radius: 5px;
            font-size: 1.1em;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
    </style>
</head>
<body>
    <div class="container">
        <% String category = (String) request.getAttribute("category"); %>
        <h2>Notes in "<%= category %>"</h2>

        <div style="margin-top: 10px;">
            <button2 id="sortButton" onclick="toggleSortOrder()" style="background: none; border: none; color: lightpink; font-size: 16px; cursor: pointer;">↑</button2>
            <strong>Sort by:</strong>
            <a href="viewNotes?category=<%= category %>&sortBy=dateA&sortOrder=<%= request.getParameter("sortOrder") != null ? request.getParameter("sortOrder") : "asc" %>"
               style="color: lightpink; text-decoration: none; padding: 0 5px;">Date Added</a>
            <a href="viewNotes?category=<%= category %>&sortBy=dateM&sortOrder=<%= request.getParameter("sortOrder") != null ? request.getParameter("sortOrder") : "asc" %>"
               style="color: lightpink; text-decoration: none; padding: 0 5px;">Date Modified</a>
            <a href="viewNotes?category=<%= category %>&sortBy=alpha&sortOrder=<%= request.getParameter("sortOrder") != null ? request.getParameter("sortOrder") : "asc" %>"
               style="color: lightpink; text-decoration: none; padding: 0 5px;">Alphabetically</a>
        </div>

        <ul>
            <%
                List<Note> notes = (List<Note>) request.getAttribute("notes");
                for (Note note : notes) {
            %>
                <li>
                    <a href="viewNote.jsp?title=<%= java.net.URLEncoder.encode(note.getTitle(), "UTF-8") %>">
                        <%= note.getTitle() %>
                    </a>
                </li>
            <% } %>
        </ul>

        <br>
        <button onclick="window.location.href='addNote.jsp'">Add New Note</button>
        <form action="deleteCategory" method="POST" style="display: inline;">
            <input type="hidden" name="selectedCategory" value="<%= category %>">
            <input type="submit" value="Delete Category">
        </form>
        <br>
        <button style="margin-top:5px" onclick="window.location.href='indexCategories.jsp'">Back</button>
    </div>

    <script>
        const urlParams = new URLSearchParams(window.location.search);
        let sortOrder = urlParams.get("sortOrder") || "asc";
        document.getElementById("sortButton").innerHTML = sortOrder === "asc" ? "↑" : "↓";

        function toggleSortOrder() {
            sortOrder = sortOrder === "asc" ? "desc" : "asc";
            document.getElementById("sortButton").innerHTML = sortOrder === "asc" ? "↑" : "↓";
            urlParams.set("sortOrder", sortOrder);
            window.location.search = urlParams.toString();
        }
    </script>

</body>
</html>