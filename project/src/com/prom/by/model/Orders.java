package com.prom.by.model;

import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root
public class Orders {

	@ElementList(inline=true)
	List <Order> orders;

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString () {
		StringBuilder builder = new StringBuilder();
		for (Order order: orders) {
			builder.append("Order : ");
			builder.append(order.toString());
		}
		return builder.toString();
	}
}
