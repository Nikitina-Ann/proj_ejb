<%-- 
    Document   : clients
    Created on : 27.10.2016, 20:21:04
    Author     : ann

                <!--<td><%="user.getId()%></td>-->

--%>
<%@ page import="appBank.Clients" %> 
<%@ page import="appBank.Bids" %> 
<%@ page import="java.util.*" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="windows-1251"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@page import="javax.naming.*, appBank.*" %>
        <%
            Clients client;
            List<Bids> bids;
            try {
            InitialContext ic = new InitialContext();
            AppBankBeanLocal ejbRef = (AppBankBeanLocal)ic.lookup("java:app/AppBank-ejb/AppBankBean!appBank.AppBankBeanLocal");

            if (request.getParameter("id") == null) {
                out.println("Please enter your id.");
                return;
            } else {
                int id = Integer.parseInt(request.getParameter("id"));
                //client = ejbRef.findName(id);
                bids = ejbRef.getBidsForClient(id);
            }
            } catch (NamingException e) {
                System.err.println("Problem looking up : " + e);
                return;
            }

        %>
        <p><a href="registr.jsp">Return</a></p>

        <!--<table border="1" cellpadding="5">
            <caption><h2>Заявки</h2></caption>
            <tr>
                <th>Сумма</th>
                <th>Дата</th>
            </tr>
            c:forEach items="%=bids%>" var="bid">
                <tr>
                <td>{bid.getSum()}</td>
                <td>{bid.getDate()}</td>
                </tr>
            /c:forEach>
            
            
        </table>-->
    </body>
</html>
