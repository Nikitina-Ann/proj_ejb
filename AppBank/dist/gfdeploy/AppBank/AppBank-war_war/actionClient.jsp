<%-- 
    Document   : actionClient
    Created on : 04.12.2016, 19:35:09
    Author     : ann
--%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html
    <body>
        <%@page import="javax.naming.*, appBank.bean.*,appBank.entity.*" %>
        <%  
            ClientSessionBeanLocal ejbRef;
            Clients client;
            InitialContext ic = new InitialContext();
            ejbRef = (ClientSessionBeanLocal)ic.lookup("java:global/AppBank/AppBank-ejb/ClientSessionBean!appBank.bean.ClientSessionBeanLocal");
            int id = Integer.parseInt(request.getParameter("clientId"));
            client = ejbRef.getClientById(id);
            if(request.getParameter("bidSum") != null && request.getParameter("bidSum") !="") {
                boolean isCreatedBid = ejbRef.createBid(client, request.getParameter("bidSum"));
                response.sendRedirect("clients.jsp?clientId="+id+"&isCreatedBid="+isCreatedBid);
            }
            if((request.getParameter("acceptBidClient") != null && request.getParameter("acceptBidClient") !="")
                    || (request.getParameter("rejectBidClient") != null && request.getParameter("rejectBidClient") !="")) {
                boolean answer = (request.getParameter("acceptBidClient") != null) ? true : false;
                boolean isAcceptedBid =  ejbRef.setResponseClientBid(answer, request.getParameter("checkBid"));
                response.sendRedirect("clients.jsp?clientId="+id+"&isAcceptedBid="+isAcceptedBid);
            }
            if(request.getParameter("acceptSpecialOffer") != null || request.getParameter("rejectSpecialOffer") != null) {
                boolean answer = (request.getParameter("acceptSpecialOffer") != null) ? true : false;
                boolean isSetResponseClientSpecOff =  ejbRef.setResponseClientSpecOff(request.getParameter("clientOfferId"), answer);
                response.sendRedirect("clients.jsp?clientId="+id+"&isSetResponseClientSpecOff="+isSetResponseClientSpecOff);
            }
        %>
        
    </body>
</html>
