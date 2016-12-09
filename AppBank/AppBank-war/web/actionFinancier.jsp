<%-- 
    Document   : actionFinancier
    Created on : 04.12.2016, 22:43:01
    Author     : ann
--%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html
    <body>
        <%@page import="javax.naming.*, appBank.bean.*, appBank.entity.*" %>
        <%  
            FinancierSessionBeanLocal ejbRef;
            InitialContext ic = new InitialContext();
            ejbRef = (FinancierSessionBeanLocal)ic.lookup("java:global/AppBank/AppBank-ejb/FinancierSessionBean!appBank.bean.FinancierSessionBeanLocal");
            String financierId = request.getParameter("financierId");
            if(request.getParameter("approve")!=null || request.getParameter("reject")!=null){
                Boolean answer = (request.getParameter("approve") != null) ? true : false;
                boolean isSetFinancierForBid = ejbRef.setResponseFinancier(request.getParameter("bidId"),financierId, 
                                                                answer, request.getParameter("time"), request.getParameter("persent"));
                response.sendRedirect("financiers.jsp?financierId="+financierId+"&isSetFinancierForBid="+ isSetFinancierForBid);
            }
            if(request.getParameter("createSpecialoffer")!=null){
                boolean isCreateSpecialoffer = ejbRef.createSpecialoffer(financierId, request.getParameter("summa"), 
                                                                            request.getParameter("time"), request.getParameter("persent"));
                response.sendRedirect("financiers.jsp?financierId="+financierId+"&isCreateSpecialoffer="+ isCreateSpecialoffer);
            }
            %>
    </body>
</html>

