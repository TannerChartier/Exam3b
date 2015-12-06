/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Tanner
 */
public class Customers
{

	private int CustomerID;
	private String custFName;
	private String custLName;
	private String custAddr1;
	private String custAddr2;
	private String custCity;
	private String custState;
	private String custZip;
	private String custEmailAddr;
	private int custAge;

	public Customers()
	{
		this.CustomerID = 0;
		this.custFName = "";
		this.custLName = "";
		this.custAddr1 = "";
		this.custAddr2 = "";
		this.custCity = "";
		this.custState = "";
		this.custZip = "";
		this.custEmailAddr = "";
		this.custAge = 0;

	}

	public Customers(int CustomerID, String custFName, String custLName, String custAddr1, String custAddr2, String custCity, String custState, String custZip, String custEmailAddr, int custAge)
	{
		this.CustomerID = CustomerID;
		this.custFName = custFName;
		this.custLName = custLName;
		this.custAddr1 = custAddr1;
		this.custAddr2 = custAddr2;
		this.custCity = custCity;
		this.custState = custState;
		this.custZip = custZip;
		this.custEmailAddr = custEmailAddr;
		this.custAge = custAge;
	}

	public int getCustomerID()
	{
		return CustomerID;
	}

	public void setCustomerID(int CustomerID)
	{
		this.CustomerID = CustomerID;
	}

	public String getCustFName()
	{
		return custFName;
	}

	public void setCustFName(String custFName)
	{
		this.custFName = custFName;
	}

	public String getCustLName()
	{
		return custLName;
	}

	public void setCustLName(String custLName)
	{
		this.custLName = custLName;
	}

	public String getCustAddr1()
	{
		return custAddr1;
	}

	public void setCustAddr1(String custAddr1)
	{
		this.custAddr1 = custAddr1;
	}

	public String getCustAddr2()
	{
		return custAddr2;
	}

	public void setCustAddr2(String custAddr2)
	{
		this.custAddr2 = custAddr2;
	}

	public String getCustCity()
	{
		return custCity;
	}

	public void setCustCity(String custCity)
	{
		this.custCity = custCity;
	}

	public String getCustState()
	{
		return custState;
	}

	public void setCustState(String custState)
	{
		this.custState = custState;
	}

	public String getCustZip()
	{
		return custZip;
	}

	public void setCustZip(String custZip)
	{
		this.custZip = custZip;
	}

	public String getCustEmailAddr()
	{
		return custEmailAddr;
	}

	public void setCustEmailAddr(String custEmailAddr)
	{
		this.custEmailAddr = custEmailAddr;
	}

	public int getCustAge()
	{
		return custAge;
	}

	public void setCustAge(int custAge)
	{
		this.custAge = custAge;
	}

	@Override
	public String toString()
	{
		return "Customers{" + "CustomerID=" + CustomerID + ", custFName=" + custFName + ", custLName=" + custLName + ", custAddr1=" + custAddr1 + ", custAddr2=" + custAddr2 + ", custCity=" + custCity + ", custState=" + custState + ", custZip=" + custZip + ", custEmailAddr=" + custEmailAddr + ", custAge=" + custAge + '}';
	}

}
