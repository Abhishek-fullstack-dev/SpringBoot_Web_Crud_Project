<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List Employee</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f6f9;
            margin: 0;
            padding: 0;
        }

        .navbar {
            background: #333;
            padding: 10px 20px;
            box-shadow: 0 2px 6px rgba(0,0,0,0.2);
        }

        .navbar a {
            color: #ffffff;
            text-decoration: none;
            margin-right: 20px;
            font-weight: bold;
        }

        .navbar a:hover {
            text-decoration: underline;
        }

        h2 {
            text-align: center;
            margin-top: 25px;
            color: #333;
        }

        table {
            width: 90%;
            margin: 20px auto 40px;
            border-collapse: collapse;
            font-family: Arial, sans-serif;
            background: #ffffff;
            box-shadow: 0 0 12px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            overflow: hidden;
        }

        th {
            background: #4CAF50;
            color: white;
            padding: 12px;
            text-align: left;
            font-size: 16px;
        }

        td {
            padding: 10px 12px;
            font-size: 15px;
            border-bottom: 1px solid #ddd;
        }

        tr:hover {
            background-color: #f1f1f1;
        }

        a.action-btn {
            padding: 6px 12px;
            text-decoration: none;
            color: white;
            border-radius: 4px;
            font-size: 14px;
            font-weight: bold;
        }

        .delete-btn {
            background: #e74c3c;
        }

        .update-btn {
            background: #3498db;
        }

        .delete-btn:hover {
            background: #c0392b;
        }

        .update-btn:hover {
            background: #2980b9;
        }
    </style>
</head>
<body>

    <%@ include file="Menu.jsp" %>   <!-- ✅ navbar inside body -->

    <h2>List Employee</h2>

    <table>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Mobile</th>
            <th>Delete</th>
            <th>Update</th>
        </tr>

        <c:forEach var="emp" items="${employees}">
            <tr>
                <td>${emp.firstName}</td>
                <td>${emp.lastName}</td>
                <td>${emp.email}</td>
                <td>${emp.mobile}</td>
                <td>
                    <a href="deleteRegistration?id=${emp.id}" class="action-btn delete-btn">Delete</a>
                </td>
                <td>
                    <a href="showUpdateForm?id=${emp.id}" class="action-btn update-btn">Update</a>
                </td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
