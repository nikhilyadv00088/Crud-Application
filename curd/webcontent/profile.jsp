<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>profilepage</title>
    <style>
        .container{
            background-color: bisque;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%,-50%);
            height: 550px;
            width: 600px;
        }
        .container h2{
            text-align: center;
            font-size: 30px;
            font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
            font-weight: bold;
            position: absolute;
            top: auto;
            left: 45%;
        }
        .container #profile-picture img{
            resize: both;
            height: 220px;
            width: 220px;
            position: absolute;
            top: 20%;
            left: 35%;
        }
        .container #profile-info{
            text-align: left;
            font-size: 20px;
            font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
            font-weight: 800;
            position: absolute;
            top: 65%;
            left: 38%;
        }

    </style>

</head>
<body>
    <div class="container">
        <h2>Profile</h2>
    <div id="profile-picture"><img src="https://static.vecteezy.com/system/resources/previews/005/544/718/original/profile-icon-design-free-vector.jpg"></div>
    <div id="profile-info">
        <P><label>Welcome : </label><%=request.getAttribute("uname") %></P>
        <P><label>User ID : </label><%=request.getParameter("userid") %></P>
        <P><label>Email : </label><%=request.getAttribute("uemail") %></P>
        <P><label>Age : </label><%=request.getAttribute("uage") %></P>
    </div>
    </div>
</body>
</html>