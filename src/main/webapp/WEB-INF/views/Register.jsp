<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register .....</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f6f9;
            margin: 0;
            padding: 0;
        }

        /* 🔹 Navbar style (same as List & Update pages) */
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

        .container {
            max-width: 500px;
            margin: 40px auto;
            background: #ffffff;
            padding: 25px 30px;
            border-radius: 8px;
            box-shadow: 0 0 12px rgba(0, 0, 0, 0.1);
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #333333;
        }

        .form-group {
            margin-bottom: 12px;
        }

        label {
            display: block;
            font-weight: bold;
            margin-bottom: 4px;
            color: #555555;
        }

        input[type="text"] {
            width: 100%;
            padding: 8px 10px;
            border: 1px solid #cccccc;
            border-radius: 4px;
            font-size: 14px;
            box-sizing: border-box;
        }

        input[type="text"]:focus {
            outline: none;
            border-color: #4CAF50;
            box-shadow: 0 0 4px rgba(76, 175, 80, 0.4);
        }

        .btn-submit {
            width: 100%;
            padding: 10px;
            margin-top: 10px;
            background: #4CAF50;
            border: none;
            color: #ffffff;
            font-size: 15px;
            font-weight: bold;
            border-radius: 4px;
            cursor: pointer;
        }

        .btn-submit:hover {
            background: #45a049;
        }

        .message {
            text-align: center;
            margin-top: 15px;
            color: green;
            font-weight: bold;
        }
    </style>
</head>
<body>

    <%@ include file="Menu.jsp" %>  <!-- ✅ navbar now styled -->

    <div class="container">
        <h2>Register here</h2>

        <form action="saveRegistration" method="post">

            <div class="form-group">
                <label>First Name</label>
                <input type="text" name="firstName" />
            </div>

            <div class="form-group">
                <label>Last Name</label>
                <input type="text" name="lastName" />
            </div>

            <div class="form-group">
                <label>Email Id</label>
                <input type="text" name="email" />
            </div>

            <div class="form-group">
                <label>Mobile</label>
                <input type="text" name="mobile" />
            </div>

            <div class="form-group">
                <label>City</label>
                <input type="text" name="city" />
            </div>

            <div class="form-group">
                <label>State</label>
                <input type="text" name="state" />
            </div>

            <div class="form-group">
                <label>PinCode</label>
                <input type="text" name="pinCode" />
            </div>

            <div class="form-group">
                <label>Address Line</label>
                <input type="text" name="addressLine" />
            </div>

            <button type="submit" class="btn-submit">Save</button>
        </form>

        <div class="message">${msg}</div>
    </div>

</body>
</html>
