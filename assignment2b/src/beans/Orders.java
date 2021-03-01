package beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Orders {
	
	List<Order> orders = new ArrayList<Order>();
	
	public Orders() {
		orders.add(new Order("1", "Grande Iced Caramel Macchiato", 5.45f, 1));
		orders.add(new Order("2", "Tall Flat White", 3.85f, 2));
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}
