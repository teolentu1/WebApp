<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Add a New Note</title>
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
    label {
      display: block;
      margin: 10px 0;
      color: #333;
      font-size: 1.1em;
    }
    input[type="text"], textarea {
      width: 100%;
      padding: 10px;
      margin-bottom: 10px;
      border-radius: 5px;
      border: 1px solid #ccc;
      font-size: 1em;
      resize: none;
    }
    input[type="submit"] {
      background-color: #d66;
      color: white;
      padding: 10px 20px;
      border: none;
      border-radius: 5px;
      font-size: 1.1em;
      cursor: pointer;
      transition: background-color 0.3s ease;
    }
    input[type="submit"]:hover {
      background-color: #a44;
    }
    nav ul {
      list-style-type: none;
      padding: 0;
    }
    nav ul li {
      margin: 10px 0;
    }
    nav a {
      text-decoration: none;
      color: #d66;
      font-weight: bold;
      transition: color 0.3s;
    }
    nav a:hover {
      color: #a44;
    }
  </style>
</head>
<body>
  <div class="container">
    <h2>Add a New Note</h2>
    <form action="uploadNote.jsp" method="post" functype="multipart/form-data">
        <label for="title">Title:</label>
        <input type="text" id="title" name="title" required><br><br>

        <label for="content">Content:</label>
        <textarea id="content" name="content" required></textarea><br><br>

        <label for="url">URL (Optional):</label>
        <input type="text" id="url" name="url"><br><br>

        <label for="image">Image (Optional):</label>
        <input type="file" id="image" name="image"><br><br>

        <input type="submit" value="Upload Note">
    </form>

    <br>
    <nav>
      <ul>
        <li><a href="index.html">Cancel</a></li>
      </ul>
    </nav>
  </div>
</body>
</html>
