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
                                <td><select name="state">
		<option value="">Please choose a state...</option>
			<option value="AL">Alabama</option>
			<option value="AK">Alaska</option>
			<option value="AZ">Arizona</option>
			<option value="AR">Arkansas</option>
			<option value="CA">California</option>
			<option value="CO">Colorado</option>
			<option value="CT">Connecticut</option>
			<option value="DE">Delaware</option>
			<option value="DC">District of Columbia</option>
			<option value="FL">Florida</option>
			<option value="GA">Georgia</option>
			<option value="HI">Hawaii</option>
			<option value="ID">Idaho</option>
			<option value="IL">Illinois</option>
			<option value="IN">Indiana</option>
			<option value="IA">Iowa</option>
			<option value="KS">Kansas</option>
			<option value="KY">Kentucky</option>
			<option value="LA">Louisiana</option>
			<option value="ME">Maine</option>
			<option value="MD">Maryland</option>
			<option value="MA">Massachusetts</option>
			<option value="MI">Michigan</option>
			<option value="MN">Minnesota</option>
			<option value="MS">Mississippi</option>
			<option value="MO">Missouri</option>
			<option value="MT">Montana</option>
			<option value="NE">Nebraska</option>
			<option value="NV">Nevada</option>
			<option value="NH">New Hampshire</option>
			<option value="NJ">New Jersey</option>
			<option value="NM">New Mexico</option>
			<option value="NY">New York</option>
			<option value="NC">North Carolina</option>
			<option value="ND">North Dakota</option>
			<option value="OH">Ohio</option>
			<option value="OK">Oklahoma</option>
			<option value="OR">Oregon</option>
			<option value="PA">Pennsylvania</option>
			<option value="RI">Rhode Island</option>
			<option value="SC">South Carolina</option>
			<option value="SD">South Dakota</option>
			<option value="TN">Tennessee</option>
			<option value="TX">Texas</option>
			<option value="UT">Utah</option>
			<option value="VT">Vermont</option>
			<option value="VA">Virginia</option>
			<option value="WA">Washington</option>
			<option value="WV">West Virginia</option>
			<option value="WI">Wisconsin</option>
			<option value="WY">Wyoming</option>
</select></td>
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