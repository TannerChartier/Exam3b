<%-- 
    Document   : index
    Created on : Dec 6, 2015, 8:21:37 AM
    Author     : Tanner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Customers"%>
<% Customers customer = (Customers) request.getAttribute("customer");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tanner's Exam 3B</title>
        <link rel="stylesheet" type="text/css" href="css/exam3b.css" />
    </head>
    <body>
        <div class="wrap">  <!--div to hold all the other divs -->    

            <!--Header-->
            <%@include file="includes/header.jsp" %>
            <!--Menu-->
            <%@include file="includes/menu.jsp" %>      

            <div class="main">      <!--main div -->
                <h3> Add A New Customer</h3>
                <p>
                <div class="addWrapper">
                    <form class="add" name="updateForm" action="updateCustomer" method="get">
                        <table class="update">
                            <tr>
                                <td class="right">Episode ID:</td>
                                <td><input type="text" name="custID" value="<%=String.valueOf(customer.getCustomerID())%>" readonly/></td>
                            </tr>
                            
                            <tr>
                                <td class="right">First Name:</td>
                                <td><input type="text" name="fName" value ="<%=String.valueOf(customer.getCustFName())%>" pattern="^[A-Za-z-\s.]{1,50}$" title="You failed!"/></td>
                            </tr>

                            <tr>
                                <td class="right">Last Name:</td>
                                <td><input type="text" name="lName" value ="<%=String.valueOf(customer.getCustLName())%>" pattern="^[A-Za-z-\s.]{1,50}$" title="You failed!"/></td>
                            </tr>

                            <tr>
                                <td class="right">Address 1:</td>
                                <td><input type="text" name="addr1" value ="<%=String.valueOf(customer.getCustAddr1())%>" pattern="^[0-9A-Za-z\s.-]{1,50}$" title="You failed!"/></td>
                            </tr>

                            <tr>
                                <td class="right">Address 2:</td>
                                <td><input type="text" name="addr2" value ="<%=String.valueOf(customer.getCustAddr2())%>" pattern="^[0-9A-Za-z\s.-]{1,50}$" title="You failed!"/></td>
                            </tr>

                            <tr>
                                <td class="right">City:</td>
                                <td><input type="text" name="city" value ="<%=String.valueOf(customer.getCustCity())%>" pattern="^[A-Za-z-\s.]{1,50}$" title="You failed!"/></td>
                            </tr>

                            <tr>
                                <td class="right">State:</td>
                                <td><input type="text" name="state" value ="<%=String.valueOf(customer.getCustState())%>" /></td>
                            </tr>

                            <tr>
                                <td class="right">ZIP:</td>
                                <td><input type="text" name="zip" value ="<%=String.valueOf(customer.getCustZip())%>" pattern="^[0-9]{5}$" title="You failed!"/></td>
                            </tr>

                            <tr>
                                <td class="right">Email Address:</td>
                                <td><input type="email" name="emailAddr" value ="<%=String.valueOf(customer.getCustEmailAddr())%>" title="You failed!"/></td>
                            </tr>

                            <tr>
                                <td class="right">Age:</td>
                                <td><input type="text" name="age" value ="<%=String.valueOf(customer.getCustAge())%>" pattern="^[0-9]{1,3}$" title="You failed!"/></td>
                            </tr>

                            <tr>
                                <td><input type="submit" name="submit" value="Submit" /></td>
                                <td><input type="reset" name="clear" value="Clear" /></td>
                            </tr>

                        </table>
                    </form>
                    <br clear="all">
                </div>
                </p>


                <br clear="all">
            </div>                  <!--close main div -->

            <!--Footer-->
            <%@include file="includes/footer.jsp" %>

        </div>              <!--close the wrap div -->

    </body>
</html>