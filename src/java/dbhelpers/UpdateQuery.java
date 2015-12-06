/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbhelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customers;

/**
 *
 * @author Tanner
 */
public class UpdateQuery
{
	private Connection conn;

	public UpdateQuery()
	{
		Properties props = new Properties();	//MWC
		InputStream instr = getClass().getResourceAsStream("dbConn.properties");
		try
		{
			props.load(instr);
		} catch (IOException ex)
		{
			Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
		}
		try
		{
			instr.close();
		} catch (IOException ex)
		{
			Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
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
			Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
		}
		try
		{
			conn = DriverManager.getConnection(url, username, passwd);		//performing connection
		} catch (SQLException ex)
		{
			Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void doUpdate(Customers customer)
	{
		try
		{
			String query = "UPDATE customers SET FIRSTNAME = ?, LASTNAME = ?, ADDR1 = ?, ADDR2 = ?, CITY = ?, STATE = ?, ZIP = ?, EMAILADDR =?, AGE = ? WHERE CUSTID = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, customer.getCustFName());
			ps.setString(2, customer.getCustLName());
			ps.setString(3, customer.getCustAddr1());
			ps.setString(4, customer.getCustAddr2());
			ps.setString(5, customer.getCustCity());
			ps.setString(6, customer.getCustState());
			ps.setString(7, customer.getCustZip());
			ps.setString(8, customer.getCustEmailAddr());
			ps.setString(9, String.valueOf(customer.getCustAge()));
			
			ps.setString(10, String.valueOf(customer.getCustomerID()));
			
			ps.executeUpdate();
		} catch (SQLException ex)
		{
			Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
