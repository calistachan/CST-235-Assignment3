package beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Order")
@ManagedBean
@SessionScoped
public class Order implements Serializable {
	
	String orderNumber = "";
	String productName = "";
	Float price = 0f;
	Integer quantity = 0;
	
	public Order(String orderNumber, String productName, Float price, Integer quantity) {
		this.orderNumber = orderNumber;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}
	
	public Order() {
		this.orderNumber = "";
		this.productName = "";
		this.price = null;
		this.quantity = null;
	}
	
	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
