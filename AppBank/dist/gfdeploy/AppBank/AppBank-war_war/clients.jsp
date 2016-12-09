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
        <title>Клиент</title>
    </head>
        <%@page import="javax.naming.*, appBank.bean.*, appBank.entity.*" %>
        <%  
            ClientSessionBeanLocal ejbRef;
            Clients client;
            Set<Bids> bids;
            Set<ClientOffer> clientOffers;
            int id;
            try {
            InitialContext ic = new InitialContext();
            ejbRef = (ClientSessionBeanLocal)ic.lookup("java:global/AppBank/AppBank-ejb/ClientSessionBean!appBank.bean.ClientSessionBeanLocal");
            if (request.getParameter("clientId") == null) {
                out.println("Please enter your id.");
                return;
            } else {
                id = Integer.parseInt(request.getParameter("clientId"));
                client = ejbRef.getClientById(id);
                if (client == null) {
                    System.out.println("Нет такого клиента: ");
                    return;
                }
                bids = client.getBids();
                clientOffers = client.getClientOffer();
            }
            } catch (NamingException e) {
                System.out.println("Проблемы looking up : " + e);
                return;
            }
        %>
        
        <body onLoad="JavaScript:checkRefresh(<%=id%>);">
        <p>Здравствуйте, <%=client.getName()%>!</p>
        <ul id='tabs' class="tabss">
            <li><a href='#tab1'>Заявки.</a></li>
            <li><a href='#tab2'>Заявки на рестр.</a></li>
            <li><a href='#tab3'>Специальные предложения</a></li>
        </ul>
       <form action="actionClient.jsp">   
       <div id='tab1' class="tab_content">
            Сумма:  <input type="text" name="bidSum" value="">
            <input type="hidden" name="clientId" value=<%=Integer.toString(id)%>>
            <input type="submit" value="Новая заявка"/> 
                
            <input type="submit" name="acceptBidClient" value="Принять"/> 
            <input type="submit" name="rejectBidClient" value="Отклонить"/> 
            <h3>Заявки</h3>
            <table border="1" cellpadding="5">
            <tr>
                <th>Сумма</th>
                <th>Дата</th>
                <th>Ответ финансиста</th>
                <th>Процент</th>
                <th>Срок (мес)</th>
                <th>Ваш ответ</th>
                <th>Договор</th>
                <th>Остаток суммы по договору</th>
                <th>Погашен</th>
            </tr>
            <c:forEach items="<%= bids%>" var="bid">
                <tr>
                <td>${ bid.getSum() }</td>
                <td>${ bid.getDate() }</td>
                <td>${ bid.getResponseFinancier().getAnswer() }</td>
                <td>${ bid.getResponseFinancier().getPersent() }</td>
                <td>${ bid.getResponseFinancier().getTime() }</td>
                <td>${ bid.getResponseClient() }</td>
                <td>${ bid.getAgreement()==null ? "-" :"+"}</td>
                <td>${ bid.getAgreement().getResidualAmount()}</td>
                <td>${ bid.getAgreement().getExtinguished()}</td>
                <td align="center"> 
                <input type="checkbox" name="checkBid" value="${bid.getId()}"/>  
                </td>
                </tr>
            </c:forEach>
        </table> 
        </form> 
        <c:if test= "<%=request.getParameter("isCreatedBid") != null && !Boolean.parseBoolean(request.getParameter("isCreatedBid")) %>">
            <script>alert("Сумма заявки должна быть представлена в виде числового значения!");</script>
        </c:if>
        
        <c:if test= "<%=request.getParameter("isAcceptedBid")!= null && !Boolean.parseBoolean(request.getParameter("isAcceptedBid"))%>">
            <script>alert("У выбранной заявки ответ финансиста должен быть положительный  и договор не должен быть заключен!");</script>
        </c:if> 
        </div>
            
            
        <div id='tab2' class="tab_content" >
            <h3>Заявки на реструктуризацию</h3>
            <table border="1" cellpadding="5">
                <th>Дата</th>
                <th>Процент (старое)</th>
                <th>Срок(старое)</th>
                <th>Ответ финансиста</th>
                <th>Процент (новое)</th>
                <th>Срок (новое)</th>
            </tr>
            <c:forEach items="<%= bids%>" var="bid">
                <tr>
                    <td>${ bid.getRestrBids().getDate() }</td>
                    <td>${ bid.getResponseFinancier().getPersent() }</td>
                    <td>${ bid.getResponseFinancier().getTime() }</td>
                    <td>${ bid.getRestrBids().getResponseFinancier() }</td>
                    <td>${ bBid.getRestrBids().getTime() }</td>
                    <td>${ bid.getRestrBids().getPersent() }</td>
                </tr>
            </c:forEach>   
        </table>
        </div>
        
        <div id='tab3' class="tab_content">
            <form action="actionClient.jsp">   
       
            <input type="hidden" name="clientId" value=<%=Integer.toString(id)%>>
            <input type="submit" name="acceptSpecialOffer" value="Принять"/> 
            <input type="submit" name="rejectSpecialOffer" value="Отклонить"/> 
            <h3>Специальные предложения</h3>
            <table border="1" cellpadding="5">
            <tr>
                <th>Сумма</th>
                <th>Процент</th>
                <th>Время</th>
                <th>Ваш ответ</th>
                <th>Договор</th>
                <th>Остаток суммы по договору</th>
                <th>Погашен</th>
            </tr>
            <c:forEach items="<%=clientOffers%>" var="clientOffer">
                <tr>
                    <td>${ clientOffer.getSpecialoffer().getSum() }</td>
                    <td>${ clientOffer.getSpecialoffer().getPersent() }</td>
                    <td>${ clientOffer.getSpecialoffer().getTime() }</td>
                    <td>${ clientOffer.getResponseClient() }</td>
                    <td>${ clientOffer.getAgreement()==null ? "-" :"+"}</td>
                    <td>${ clientOffer.getAgreement().getResidualAmount()}</td>
                    <td>${ clientOffer.getAgreement().getExtinguished()}</td>
                    <td align="center"> 
                    <input type="checkbox" name="clientOfferId" value="${clientOffer.getId()}"/>  
                    </td>
                </tr>
                </tr>
            </c:forEach>
        </table>
        </form>
        <c:if test= "<%=request.getParameter("isSetResponseClientSpecOff")!= null &&
                      !Boolean.parseBoolean(request.getParameter("isSetResponseClientSpecOff"))%>">
            <script>alert("Ответ на специальное предложение не отправлен!");</script>
        </c:if>
        </div>
    </body>
   <p><a href="registr.jsp">Вернуться к странице входа в систему</a></p>
   
   
    <script>     
        function checkRefresh(id)
        {
            //setTimeout(function(){ window.location.href = 'clients.jsp?clientId='+id; }, 300);
        }  
    </script> 
</html>
