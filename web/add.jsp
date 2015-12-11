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
        <script type="text/javascript">
            function validate()
            {
            var alphaPattern = "^[A-Za-z-\\s.]{1,50}$";
                    var addrPattern = "^[0-9A-Za-z\\s.-]{1,50}$";
                    var agePattern = "^[0-9]++$";
                    var zipPattern = "^[0-9]{5}$";
                    var emailPattern = "^[[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}]{1,50}$";
                    
                    var valid = false;
                    var x = document.forms["addForm"]["fName"].value;
                    
                   var custFName = document.getElementsByID("fName");
                   var custLName = document.getElementsByID("lName");
                   var  custAddr1 = document.getElementsByID("addr1");
                   var  custAddr2 = document.getElementsByID("addr2");
                   var  custCity = document.getElementsByID("city");
                   var  custZip = document.getElementsByID("zip");
                   var  custEmail = document.getElementsByID("emailaddr");
                   var  custAge = document.getElementsByID("age");
                   
                   if(x.match(alphaPattern))
                   {
                       valid = true;
                   }
                   return valid;
            }
        </script>
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
                    <form class="add" name="addForm" action="addCustomer" method="get" onsubmit="return validate();">
                        <table class="add">
                            <tr>
                                <td class="right">First Name:</td>
                                <td><input type="text" name="fName" value ="Tanner" id="fName" pattern="^[A-Za-z-\s.]{1,50}$" title="You failed!"/></td>
                            </tr>

                            <tr>
                                <td class="right">Last Name:</td>
                                <td><input type="text" name="lName" value ="Chartier" id="lName" pattern="^[A-Za-z-\s.]{1,50}$" title="You failed!"/></td>
                            </tr>

                            <tr>
                                <td class="right">Address 1:</td>
                                <td><input type="text" name="addr1" value ="1234 Fake St" id="addr1" pattern="^[0-9A-Za-z\s.-]{1,50}$" title="You failed!"/></td>
                            </tr>

                            <tr>
                                <td class="right">Address 2:</td>
                                <td><input type="text" name="addr2" value ="Apt H" id="addr2" pattern="^[0-9A-Za-z\s.-]{1,50}$" title="You failed!"/></td>
                            </tr>

                            <tr>
                                <td class="right">City:</td>
                                <td><input type="text" name="city" value ="Iowa City" id="city" pattern="^[A-Za-z-\s.]{1,50}$" title="You failed!"/></td>
                            </tr>

                            <tr>
                                <td class="right">State:</td>
                                <td><input type="text" name="state" value ="IA" id="state"/></td>
                            </tr>

                            <tr>
                                <td class="right">ZIP:</td>
                                <td><input type="text" name="zip" value ="52246" id="zip" pattern="^[0-9]{5}$" title="You failed!"/></td>
                            </tr>

                            <tr>
                                <td class="right">Email Address:</td>
                                <td><input type="email" name="emailAddr" value ="Tanner.Chartiergmail.com" id="emailAddr" title="You failed!"/></td>
                            </tr>

                            <tr>
                                <td class="right">Age:</td>
                                <td><input type="text" name="age" value ="27@" id="age" pattern="^[0-9]{1,3}$" title="You failed!"/></td>
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