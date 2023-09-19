<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        .container{
            background-color: bisque;
            background-size: cover;
            position: absolute;
             top: 50%;
            left: 50%;
            transform: translate(-50%,-50%);
            height: 530px;
            width: 500px;
            }
            .container h1{
                font-size: 28px;
                text-align: center;
            }
            .container p{
                font-size: 15px;
                text-align: center;
            }
            .container h2{
                text-align: center;
            }
            
            
            
            .container #button input{
                font-size: 15px;
                text-align: center;
                border: 0;
                background-color: green;
                color: aliceblue;
                padding: 10px 14px;
                position: absolute;
                top: 90%;
                left: 39%;
            }
            .container #button input:hover{
                color: black;
            }
    </style>
</head>
<body>
    <div class="container">
        <h1>User Found successfully</h1>
        <form action="updateuser" method="post">
            <p>User Name : <%=request.getAttribute("uname") %></p>
            <p>User ID : <%=request.getAttribute("uid") %></p>
            <p>Password : *******</p>
            <p>Email : <%=request.getAttribute("uemail") %></p>
            <p>Age : <%=request.getAttribute("uage") %></p>

            <h2>Enter Details</h2>
            <div id="name">
                <p>User Name <input type="text" name="newname" placeholder="Enter user name"/></p>
            </div>
            <div id="id">
                <p>User ID <input type="text" name="newid" placeholder="Enter user id"/></p>
            </div>
            <div id="pass">
                <p>Password = You can not change password </p>
            </div>
            <div id="email">
                <p>Email <input type="text" name="newemail" placeholder="Enter email"/></p>
            </div>
            <div id="age">
                <p>Age <input type="text" name="newage" placeholder="Enter age"/></p>
            </div>
            <div id="button">
                <input type="submit" name="update" value="Updateuser"/>
            </div>
        </form>
    </div>
</body>
</html>