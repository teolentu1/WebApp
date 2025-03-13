<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
  <jsp:include page="/meta.jsp"/>
  <title>Patient Data App - Search Results</title>
  <style>
    body {
      background-color: #fce0e0; /* Lighter pink */
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
    ul {
      list-style-type: none;
      padding: 0;
      text-align: left;
    }
    li {
      margin: 8px 0;
      color: #555;
    }
    p {
      color: #777;
      font-size: 18px;
    }
  </style>
</head>
<body>
  <jsp:include page="/header.jsp"/>

  <div class="container">
    <h1>Search Result</h1>
    <%
      List<String> patients = (List<String>) request.getAttribute("result");
      if (patients != null && !patients.isEmpty()) {
    %>
    <ul>
      <%
        for (String patient : patients) {
      %>
      <li><%= patient %></li>
      <%
        }
      %>
    </ul>
    <%
      } else {
    %>
      <p>Nothing found</p>
    <%
      }
    %>
  </div>

  <jsp:include page="/footer.jsp"/>
</body>
</html>
