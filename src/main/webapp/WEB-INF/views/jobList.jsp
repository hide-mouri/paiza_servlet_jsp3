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

        <%
        ArrayList<HashMap<String,String>> rows = (ArrayList<HashMap<String,String>>)request.getAttribute("rows");
        %>

        <table>
        <%
        for (HashMap<String,String> columns : rows) {
        %>
            <tr>
                <td><%= columns.get("id") %></td>
                <td><%= columns.get("jobName") %></td>
                <td><%= columns.get("vitality") %></td>
                <td><%= columns.get("strength") %></td>
                <td><a href='jobprofile?id=<%= columns.get("id") %>'>表示</a></td>
            </tr>
        <% } %>
        </table>

    </body>
</html>
