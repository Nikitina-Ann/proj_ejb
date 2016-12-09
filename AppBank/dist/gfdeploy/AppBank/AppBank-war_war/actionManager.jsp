<%-- 
    Document   : actionManager
    Created on : 04.12.2016, 21:55:38
    Author     : ann
--%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html
    <head>
        <title>actionManager</title>
    </head>
    <body>
        <%@page import="javax.naming.*, appBank.bean.*, appBank.entity.*" %>
        <%  
            ManagerSessionBeanLocal ejbRef;
            InitialContext ic = new InitialContext();
            ejbRef = (ManagerSessionBeanLocal)ic.lookup("java:global/AppBank/AppBank-ejb/ManagerSessionBean!appBank.bean.ManagerSessionBeanLocal");
            String managerId = request.getParameter("managerId");
            if(request.getParameter("setFinancierForBid") != null) {
                boolean isSetFinancierForBid = ejbRef.setFinancierForBid(request.getParameter("bidId"), request.getParameter("financierId"));
                response.sendRedirect("managers.jsp?managerId="+managerId+"&isSetFinancierForBid="+isSetFinancierForBid);
            }
            if(request.getParameter("enterAgreementBid") != null) {
                boolean isEnterAgreementBid = ejbRef.enterAgreementBid(request.getParameter("bidId"));
                response.sendRedirect("managers.jsp?managerId="+managerId+"&isEnterAgreementBid="+isEnterAgreementBid);
            }
            if(request.getParameter("sendSpecialOffer") != null) {
                boolean isSendSpecialOffer = ejbRef.sendSpecialOffer(request.getParameter("clientId"), request.getParameter("specialOfferId"));
                response.sendRedirect("managers.jsp?managerId="+managerId+"&isSendSpecialOffer="+isSendSpecialOffer);
            }
           if(request.getParameter("enterAgreementSpecOff") != null) {
                boolean isSendSpecialOffer = ejbRef.enterAgreementSpecOffer(request.getParameter("clientOfferId"));
                response.sendRedirect("managers.jsp?managerId="+managerId+"&isSendSpecialOffer="+isSendSpecialOffer);
            }
            
             
        %>
        
    </body>
</html>

