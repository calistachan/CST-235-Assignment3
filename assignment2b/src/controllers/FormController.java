package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import beans.User;
import beans.Order;
import beans.Orders;

@ManagedBean(name = "formController", eager = true)
@ViewScoped
public class FormController {

	@ManagedProperty(value = "#{user}")
	public User user;
	@ManagedProperty(value = "#{orders}")
	public Orders orders;
	
	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String onSubmit(User user) {
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		return "TestResponse.xhtml";
	}
	
	public String onFlash(User user) {
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("user", user);
		return "TestResponse2.xhtml?faces-redirect=true";
	}
}
