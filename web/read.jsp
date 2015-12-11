<%-- 
    Document   : index
    Created on : Dec 6, 2015, 8:21:37 AM
    Author     : Tanner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tanner's Exam 3B</title>
        <link rel="stylesheet" type="text/css" href="css/exam3b.css" />
    </head>

    <% String table = (String) request.getAttribute("table");%>

    <body>
        <div class="wrap">  <!--div to hold all the other divs -->    

            <!--Header-->
            <%@include file="includes/header.jsp" %>
            <!--Menu-->
            <%@include file="includes/menu.jsp" %>      
            <%@ include file="includes/searchbar.jsp" %>
            <div class="main">      <!--main div -->
                <h3>  </h3>
                <p>
                    <%=table%>
                </p>


                <br clear="all">
            </div>                  <!--close main div -->

            <!--Footer-->
            <%@include file="includes/footer.jsp" %>

        </div>              <!--close the wrap div -->

    </body>
</html>