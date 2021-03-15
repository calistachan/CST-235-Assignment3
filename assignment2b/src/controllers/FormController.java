package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Timer;
import javax.enterprise.inject.Default;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.User;
import business.MyTimerService;
import business.OrdersBusinessInterface;
import business.OrdersBusinessService;
import beans.Order;
import beans.Orders;

@ManagedBean(name = "formController", eager = true)
@ViewScoped
public class FormController {

	@ManagedProperty(value = "#{user}")
	public User user;
//	@ManagedProperty(value = "#{orders}")
//	public Orders orders;
//	
//	public Orders getOrders() {
//		return orders;
//	}
//
//	public void setOrders(Orders orders) {
//		this.orders = orders;
//	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public OrdersBusinessInterface getService() {
		return service;
	}
	
	
	@Inject
	@Default
	private OrdersBusinessInterface service;
	
	@EJB
	private MyTimerService timer;
	
	public String onSubmit(User user) {
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		//timer.createTimer(10000);
		try {
			getAllOrders();
			insertOrder();
			getAllOrders();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "TestResponse.xhtml";
	}
	
	public String onFlash(User user) {
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("user", user);
		return "TestResponse2.xhtml?faces-redirect=true";
	}
	
	private void getAllOrders() throws SQLException {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "postgres", "hello123");
			String query = "SELECT * FROM testapp.ORDERS";
			
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				int orderId = rs.getInt("ORDER_NUMBER");
				String  productName = rs.getString("PRODUCT_NAME");
				Float  price =  rs.getFloat("PRICE");
				System.out.println(orderId + " " + productName + " " + price);
			}
			
			rs.close();
			System.out.println("Success??");
		} catch (SQLException e) {
			System.out.println("Failure??");
			e.printStackTrace();
		} finally {
			conn.close();
		}
		
	}
	
	private void insertOrder() throws SQLException {
		String  query = "INSERT INTO  testapp.ORDERS(ORDER_NUMBER, PRODUCT_NAME, PRICE, QUANTITY) VALUES('001122334455', 'This was inserted new', 25.00, 100)";
		Connection conn  = null;
		try {
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "postgres", "hello123");
			Statement statement = conn.createStatement();
			statement.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Failure??");
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}
}
