<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>adminprofile</title>
    <style>
        .container{
            background-color: bisque;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%,-50%);
            height: 500px;
            width: 600px;
            font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
        }
        h2{
            text-align: center;
            font-size: 40px;
        }
        #profile-info p{
            text-align: center;
            font-size: 27px;
            font-weight: 100;
        }
        .function #one{
            text-align: center;
            font-size: 25px;
            position: absolute;
            top: 70%;
            left: 23%;
        }
        .button input{
            text-align: center;
            font-size: 20px;
            background-color: green;
            color: aliceblue;
            border: 0;
            padding: 8px 15px;
        }
        .button #two{
            position: absolute;
            top: 83%;
            left: 23%;
        }
        .button #three{
            position: absolute;
            top: 83%;
            left: 42%;
        }
        .button #four{
            position: absolute;
            top: 83%;
            left: 60%;

        }
        .button input:hover{
        	color: black;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Admin Profile</h2>
        <form action="adminprofile" method="post">
        <div id="profile-info">
            <p><label>Welcome : <%=request.getAttribute("uname") %></label></p>
            <p><label>Admin Id : <%=request.getAttribute("uid") %></label></p>
            <p><label>Email : <%=request.getAttribute("uemail") %></label></p>
            <p><label>Age : <%=request.getAttribute("uage") %></label></p>
            <br>
        </div>
        <div class="function">
            <br>
            <input type="text" id="one" name="userid" placeholder="Enter User ID"/>
            <br>
            <div class="button">
                <input type="submit" id="two" name="action" value="Search"/>
                <input type="submit" id="three" name="action" value="Delete"/>
                <input type="submit" id="four" name="action" value="Update"/>
            </div>
        </div>
        </form>
    </div>
</body>
</html>