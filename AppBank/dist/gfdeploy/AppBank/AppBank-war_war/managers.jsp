<%-- 
    Document   : managers
    Created on : 29.11.2016, 23:22:52
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
        <title>Менеджер</title>
    </head>
        <%@page import="javax.naming.*, appBank.bean.*, appBank.entity.*" %>
        <%  Managers manager;
            Set<Bids> bids;
            Set<RestrBids> restrBids;
            List<Financiers> financiers;
            List<Clients> clients;
            List<Specialoffers> specialoffers;
            List<ClientOffer> clientOffers;
            int id;
            try {
            InitialContext ic = new InitialContext();
            ManagerSessionBeanLocal ejbRef = (ManagerSessionBeanLocal)ic.lookup("java:global/AppBank/AppBank-ejb/ManagerSessionBean!appBank.bean.ManagerSessionBeanLocal");
            if (request.getParameter("managerId") == null) {
                out.println("Введите корректный id!");
                return;
            } else {
                id = Integer.parseInt(request.getParameter("managerId"));
                manager = ejbRef.getManagerById(id);
                if (manager == null){
                out.println("Введите корректный id!");
                return;
            }
                bids = manager.getBids();
                restrBids = ejbRef.getRestrBidsForManager(manager);
                financiers = ejbRef.getAllFinanciers();
                clients = ejbRef.getAllClients();
                specialoffers = ejbRef.getAllSpecialoffers();
                clientOffers = ejbRef.getAllClientOffers();
            }
            } catch (Exception e) {
                out.println("Введите корректный id!");
                return;
            }

        %>
       
        <body>
        <p>Здравствуйте, <%=manager.getName()%>!</p>
        <ul id='tabs' class="tabss">
            <li><a href='#tab1'>Заявки.</a></li>
            <li><a href='#tab3'>Специальные предложения</a></li>
            <li><a href='#tab4'>Принятые специальные предложения</a></li>
        </ul>
       <form action="actionManager.jsp"> 
       <div id='tab1' class="tab_content">
           <input type="submit" name ="enterAgreementBid" value="Заключить договор">
           <!--form id="select_financiers" action=""">-->
            <select name="financierId">
            <c:forEach items="<%=financiers%>" var="financier">
                <option value=${financier.getId()}>${financier.getName()}</option>
            </c:forEach>
            </select>
            <input type="hidden" name="managerId" value="<%=id%>">
            <input type="submit" name="setFinancierForBid" value="Отправить финансисту">
            <h3>Заявки</h3>
            <table border="1" cellpadding="5">
            <tr>
                <th>Дата</th>
                <th>Сумма</th>
                <th>Клиент</th>
                <th>Рейтинг</th>
                <th>Доход</th>
                <th>Ответ финансиста</th>
                <th>Ответ клиента</th>
                <th>Договор</th>
            </tr>
            <c:forEach items="<%= bids%>" var="bid">
                <tr>
                    <td>${ bid.getDate() }</td>
                    <td>${ bid.getSum() }</td>
                    <td>${ bid.getClient().getName() }</td>
                    <td>${ bid.getClient().getRating() }</td>
                    <td>${ bid.getClient().getRevenue() }</td>
                    <td>${ bid.getResponseFinancier().getAnswer() }</td>
                    <td>${ bid.getResponseClient()}</td>
                    <td>${ bid.getAgreement()==null ? "-" :"+"}</td>
                    <td align="center"> 
                        <input type="checkbox" name="bidId" value="${bid.getId()}"/>  
                    </td>
                </tr>
            </c:forEach>
        </table>
        </form>
        <c:if test= "<%=request.getParameter("isSetFinancierForBid")!= null && !Boolean.parseBoolean(request.getParameter("isSetFinancierForBid"))%>">
            <script>alert("Заявка финансисту не была отправлена!");</script>
        </c:if>
            
        <c:if test= "<%=request.getParameter("isEnterAgreementBid")!= null && !Boolean.parseBoolean(request.getParameter("isEnterAgreementBid"))%>">
            <script>alert("Договор не был заключен!");</script>
        </c:if>
        
        </div>
            
         <div id='tab3' class="tab_content">
         <form action="actionManager.jsp">
            <select name="clientId">
            <c:forEach items="<%=clients%>" var="client">
                <option value="${client.getId()}">${client.getName()}</option>
            </c:forEach>
            </select>
            <input type="hidden" name="managerId" value="<%=id%>">
            <input type="submit" name="sendSpecialOffer" value="Отправить клиенту">
            <h3>Специальные предложения</h3>
            <table border="1" cellpadding="5">
            <tr>
                <th>Сумма</th>
                <th>Процент</th>
                <th>Срок</th>
            </tr> 
            <c:forEach items="<%= specialoffers%>" var="specialoffer">
                <tr>
                    <td>${ specialoffer.getSum() }</td>
                    <td>${ specialoffer.getPersent() }</td>
                    <td>${ specialoffer.getTime() }</td>
                    <td align="center"> 
                        <input type="checkbox" name="specialOfferId" value="${specialoffer.getId()}"/>  
                    </td>
                </tr>
            </c:forEach>
        </table>
        </form>
        </div>
         
            
        <div id='tab4' class="tab_content">
         <form action="actionManager.jsp">
            <input type="hidden" name="managerId" value="<%=id%>">
            <input type="submit" name ="enterAgreementSpecOff" value="Заключить договор">
            <h3>Принятые специальные предложения</h3>
            <table border="1" cellpadding="5">
            <tr>
                <th>Сумма</th>
                <th>Процент</th>
                <th>Срок</th>
                <th>Ответ клиента</th>
                <th>Договор</th>
            </tr> 
            <c:forEach items="<%= clientOffers%>" var="clientOffer">
                <tr>
                    <td>${ clientOffer.getSpecialoffer().getSum() }</td>
                    <td>${ clientOffer.getSpecialoffer().getPersent() }</td>
                    <td>${ clientOffer.getSpecialoffer().getTime() }</td>
                    <td>${ clientOffer.getResponseClient() }</td>
                    <td>${ clientOffer.getAgreement() != null ? "+" : "-" }</td>
                    <td align="center"> 
                        <input type="checkbox" name="clientOfferId" value="${clientOffer.getId()}"/>  
                    </td>
                </tr>
            </c:forEach>
        </table>
        </form>
        <c:if test= "<%=request.getParameter("isSendSpecialOffer")!= null && !Boolean.parseBoolean(request.getParameter("isSendSpecialOffer"))%>">
            <script>alert("Специальное предложение клиенту не было отправлено!");</script>
        </c:if>  
        </div>
            
        <p><a href="index.html">Вернуться к странице входа в систему</a></p>
        
    </body>
</html>

