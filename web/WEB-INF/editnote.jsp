<%-- 
    Document   : editnote
    Created on : Feb 5, 2023, 9:04:28 PM
    Author     : pusit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Note</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>Edit Note</h2>
        <form method="post" action="note">
            <label for="title">Title: </label><input type="text" name="title" value="${note.title}"><br>
            <label for="content">Contents: </label><textarea rows="5" cols="20" name="content">${note.content}</textarea><br>
            <input type="submit" value="Save">
        </form>
    </body>
</html>
