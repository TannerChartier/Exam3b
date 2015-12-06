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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customers;

/**
 *
 * @author Tanner
 */
public class ReadRecord
{

	private Connection conn;
	private ResultSet results;
	private ResultSet results1;

	private Customers customer = new Customers();
	private String custID;

	public ReadRecord(String custID)
	{
		Properties props = new Properties();	//MWC
		InputStream instr = getClass().getResourceAsStream("dbConn.properties");
		try
		{
			props.load(instr);
		} catch (IOException ex)
		{
			Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
		}
		try
		{
			instr.close();
		} catch (IOException ex)
		{
			Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
		}

		String driver = props.getProperty("driver.name");					//gets the drivername to load
		String url = props.getProperty("server.name");					//gets server name
		String username = props.getProperty("user.name");					//gets username
		String passwd = props.getProperty("user.password");				//gets password

		this.custID = custID;

		try
		{
			Class.forName(driver);									//how we load the driver -> ojdb6.jar
		} catch (ClassNotFoundException ex)
		{
			Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
		}
		try
		{
			this.conn = DriverManager.getConnection(url, username, passwd);		//performing connection
		} catch (SQLException ex)
		{
			Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public void doRead()
	{

		try
		{
			//String query = "Select * from TOPGEAR WHERE EPISODEID = 24";
			//PreparedStatement ps1 = conn.prepareStatement(query);
			//this.results = ps1.executeQuery(query);

			String query1 = "Select * from CUSTOMERS WHERE CUSTID = " + custID;
			//***************************************//
			//There's something with this,when I have the ? up top, the popEpisode no longer works
			PreparedStatement ps1 = conn.prepareStatement(query1);
			//fill in the preparedstatement
			//ps1.setInt(1, Integer.parseInt(episodeID));

			this.results = ps1.executeQuery(query1);
			//episode.setEpisodeID(episodeID);
			this.results.next();
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

		} catch (SQLException ex)
		{
			Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public void popCustomer()
	{

	}

	public Customers getCustomer()
	{
		return this.customer;

	}
}
