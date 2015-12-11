package dbhelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customers;

public class SearchQuery
{

	private Connection conn;
	private ResultSet results;

	public SearchQuery()
	{
		Properties props = new Properties();	//MWC
		InputStream instr = getClass().getResourceAsStream("dbConn.properties");
		try
		{
			props.load(instr);
		} catch (IOException ex)
		{
			Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
		}
		try
		{
			instr.close();
		} catch (IOException ex)
		{
			Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
		}

		String driver = props.getProperty("driver.name");					//gets the drivername to load
		String url = props.getProperty("server.name");					//gets server name
		String username = props.getProperty("user.name");					//gets username
		String passwd = props.getProperty("user.password");				//gets password
		try
		{
			Class.forName(driver);									//how we load the driver -> ojdb6.jar
		} catch (ClassNotFoundException ex)
		{
			Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
		}
		try
		{
			conn = DriverManager.getConnection(url, username, passwd);		//performing connection
		} catch (SQLException ex)
		{
			Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public void doSearch(String searchVal)
	{
		try
		{
			//String query = "Select * FROM topgear WHERE EpisodeDescription LIKE ?";
			String query = "SELECT * FROM CUSTOMERS where upper(LASTNAME || FIRSTNAME) LIKE ?";
			
		
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, "%" + searchVal.toUpperCase() + "%");
			this.results = ps.executeQuery();

		} catch (SQLException ex)
		{
			Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public String getHTMLTable()
	{
		String table = "";

		table += "<table class='Main'>";	//change this to id= or class =
			table += "<tr>";
				table += "<td class='Headers'>";
					table += "Customer ID";
				table += "</td>";

				table += "<td class='Headers'>";
					table += "First Name";
				table += "</td>";

				table += "<td class='Headers'>";
					table += "Last Name";
				table += "</td>";

				table += "<td class='Headers'>";
					table += "Address 1";
				table += "</td>";

				table += "<td class='Headers'>";
					table += "Address 2";
				table += "</td>";

				table += "<td class='Headers'>";
					table += "City";
				table += "</td>";

				table += "<td class='Headers'>";
					table += "State";
				table += "</td>";

				table += "<td class='Headers'>";
					table += "Zip";
				table += "</td>";
				
				table += "<td class='Headers'>";
					table += "Email Address";
				table += "</td>";
				
				table += "<td class='Headers'>";
					table += "Age";
				table += "</td>";

				table += "</td>";
			table += "</tr>";
		try
		{
			while (this.results.next())			//as long as next record, get info and put in model
			{
				Customers customer = new Customers();
				
				customer.setCustomerID(this.results.getInt("CUSTID"));
				customer.setCustFName(this.results.getString("FIRSTNAME"));
				customer.setCustLName(this.results.getString("LASTNAME"));
				customer.setCustAddr1(this.results.getString("ADDR1"));
				customer.setCustAddr2(this.results.getString("ADDR2"));
				customer.setCustCity(this.results.getString("CITY"));
				customer.setCustState(this.results.getString("STATE"));
				customer.setCustZip(this.results.getString("ZIP"));
				customer.setCustEmailAddr(this.results.getString("EMAILADDR"));
				customer.setCustAge(this.results.getInt("AGE"));
				
				table += "<tr class='Entry'>";
					table += "<td>";
						table += customer.getCustomerID();
					table += "</td>";

					table += "<td class='Centered'>";
						table += customer.getCustFName();
					table += "</td>";

					table += "<td class='Centered'>";
						table += customer.getCustLName();
					table += "</td>";

					table += "<td class='Centered'>";
						table += customer.getCustAddr1();
					table += "</td>";
					
					table += "<td>";
						table += customer.getCustAddr2();
					table += "</td>";

					table += "<td class='Centered'>";
						table += customer.getCustCity();
					table += "</td>";

					table += "<td class='Centered'>";
						table += customer.getCustState();
					table += "</td>";

					table += "<td class ='Centered'>";
						table += customer.getCustZip();
					table += "</td>";

					table += "<td class='Centered'>";
						table += customer.getCustEmailAddr();
					table += "</td>";
					
					table += "<td class='Centered'>";
						table += customer.getCustAge();
					table += "</td>";
					
					table += "<td>";
						table += "<a href=update?ID=" + String.valueOf(customer.getCustomerID()) + "> Update </a>" + "<a href=delete?ID=" + customer.getCustomerID() + "> Delete </a>";
						
					table += "</td>";
				table += "</tr>";
			}
		} catch (SQLException ex)
		{
			Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
		}

		table += "</table>";

		return table;
	}
}
