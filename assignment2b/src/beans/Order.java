package beans;

public class Order {
	
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
		this.orderNumber = "897";
		this.productName = "Product";
		this.price = 67f;
		this.quantity = 2;
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
