<%-- 
    Document   : financier
    Created on : 25.11.2016, 22:12:41
    Author     : ann
--%>

<%-- 
    Document   : newjsp
    Created on : 22.11.2016, 12:38:25
    Author     : ann
--%>
<%@ page import="java.util.*" %> 
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html
    <head>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
        <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/multiTabs.css" />" />
        <script src="<c:url value="/resources/js/multiTabs.js" />"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Финансист</title>
    </head>
        <%@page import="javax.naming.*, appBank.bean.*, appBank.entity.*" %>
        <%  Financiers financier;
            Set<Bids> bids;
            Set<RestrBids> restrBids;
            Set<Specialoffers> specialoffers;
            int id;
            try {
            InitialContext ic = new InitialContext();
            FinancierSessionBeanLocal ejbRef = (FinancierSessionBeanLocal)ic.lookup("java:global/AppBank/AppBank-ejb/FinancierSessionBean!appBank.bean.FinancierSessionBeanLocal");
            if (request.getParameter("financierId") == null) {
                out.println("Введите корректный id!");
                return;
            } else {
                id = Integer.parseInt(request.getParameter("financierId"));
                financier = ejbRef.getFinancierById(id);
                if (financier == null){
                out.println("Введите корректный id!");
                return;
            }
                bids = financier.getBidsWithoutResponseFinancier();
                restrBids = financier.getRestrBids();
                specialoffers = financier.getSpecialoffers();
            }
            } catch (Exception e) {
                out.println("Введите корректный id!");
                return;
            }

        %>
        <body>
        <p>Здравствуйте, <%=financier.getName()%>!</p>
        <ul id='tabs' class="tabss">
            <li><a href='#tab1'>Заявки.</a></li>
            <li><a href='#tab3'>Специальные предложения</a></li>
        </ul>
       <div id='tab1' class="tab_content">
        <form action="actionFinancier.jsp">     
        <input type="hidden" name="financierId" value=<%=Integer.toString(id)%>>
        Процент:   <input type="input" name="persent"/>  
        Время (мес.):    <input type="input" name="time"/>  
       <input type="submit" name="approve" value="Одобрить"/>  
       <input type="submit" name="reject" value="Отклонить"/>  
            <h3>Заявки</h3>
            <table border="1" cellpadding="5">
            <tr>
                <th>Дата</th>
                <th>Сумма</th>
                <th>Клиент</th>
                <th>Рейтинг</th>
                <th>Доход</th>
            </tr>
            <c:forEach items="<%= bids%>" var="bid">
                <tr>
                    <td>${ bid.getDate() }</td>
                    <td>${ bid.getSum() }</td>
                    <td>${ bid.getClient().getName() }</td>
                    <td>${ bid.getClient().getRating() }</td>
                    <td>${ bid.getClient().getRevenue() }</td>
                    <td align="center"> 
                    <input type="checkbox" name="bidId" value="${bid.getId()}"/>  
                    </td>
                </tr>
            </c:forEach>
        </table>
       </form> 
        <c:if test= "<%=request.getParameter("isSetFinancierForBid")!= null && !Boolean.parseBoolean(request.getParameter("isSetFinancierForBid"))%>">
            <script>alert("Не все параметры были выбраны!");</script>
        </c:if>
        </div>
        
        <div id='tab3' class="tab_content">
        <form action="actionFinancier.jsp">     
        <input type="hidden" name="financierId" value=<%=Integer.toString(id)%>>
        Сумма (руб.):   <input type="input" name="summa"/>  
        Процент:   <input type="input" name="persent"/>  
        Время (мес.):    <input type="input" name="time"/>  
       <input type="submit" name="createSpecialoffer" value="Создать"/>  
            <h3>Специальные предложения</h3>
            <table border="1" cellpadding="5">
            <tr>
                <th>Сумма</th>
                <th>Процент</th>
                <th>Время (мес.)</th>
            </tr> 
            <c:forEach items="<%= specialoffers%>" var="specialoffer">
                <tr>
                    <td>${ specialoffer.getSum() }</td>
                    <td>${ specialoffer.getPersent() }</td>
                    <td>${ specialoffer.getTime() }</td>
                </tr>
            </c:forEach>
        </table>
       </form> 
        <c:if test= "<%=request.getParameter("isCreateSpecialoffer")!= null && !Boolean.parseBoolean(request.getParameter("isCreateSpecialoffer"))%>">
            <script>alert("Не все параметры были выбраны!");</script>
        </c:if>
        </div>
       
        <p><a href="index.html">Вернуться к странице входа в систему</a></p>
        
    </body>
</html>

