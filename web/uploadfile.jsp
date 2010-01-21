<%-- 
    Document   : uploadfile
    Created on : 15 janv. 2010, 16:12:39
    Author     : vincentb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Test upload</h1>

        <form action="doUploadfile"
        enctype="multipart/form-data" method="post">
            <p>
                Name:<br>
                <input type="text" name="Name" size="30">
            </p>
            <p>
                Please specify a file, or a set of files:<br>
                <input type="file" name="datafile" size="40">
            </p>
            <div>
                <input type="submit" value="Send">
            </div>
        </form>
    </body>
</html>
