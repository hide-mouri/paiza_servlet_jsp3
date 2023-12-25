<!-- ServletからArryaListでデータ渡し -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
        <title>Java - paiza</title>
        <style>body {padding: 30px;}</style>
    </head>
    <body>
        <h1><%= request.getAttribute("message") %></h1>
        <p>職業：<%= request.getAttribute("jobName") %></p>
        <p>体力：<%= request.getAttribute("vitality") %></p>
        <p>強さ：<%= request.getAttribute("strength") %></p>
        <p></p>
        <p><a href="joblist">戻る</a></p>
    </body>
</html>
