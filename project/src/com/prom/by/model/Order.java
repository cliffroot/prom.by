package com.prom.by.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import android.os.Parcel;
import android.os.Parcelable;



@Element(name = "order")
public class Order implements Parcelable{

	@Attribute (name = "id")
	Long id;

	@Attribute (name = "state")
	String state;

	@Element(name = "name")
	String name;

	@Element(name = "phone")
	String phone;

	@Element(name = "company", required = false)
	String company;

	@Element(name = "email", required = false)
	String email;

	@Element(name = "date")
	String date;

	@Element(name = "address")
	String address;

	@Element(name = "index", required = false) 
	String index;

	@Element(name = "payercomment", required = false)
	String payerComment;

	@Element(name = "salescomment", required = false)
	String salesComment;

	@Element(name = "paymentType")
	String paymentType;

	@Element(name = "deliveryType")
	String deliveryType;

	@Element(name = "deliveryCost", required = false)
	Double deliveryCost;

	@Element(name = "priceBYR")
	Double price;

	@ElementList(name = "items")
	List<Item> items;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}

	public Double getDeliveryCost() {
		return deliveryCost;
	}

	public void setDeliveryCost(Double deliveryCost) {
		this.deliveryCost = deliveryCost;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getPayerComment() {
		return payerComment;
	}

	public void setPayerComment(String payerComment) {
		this.payerComment = payerComment;
	}

	public String getSalesComment() {
		return salesComment;
	}

	public void setSalesComment(String salesComment) {
		this.salesComment = salesComment;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Double getItemsTotalPrice () {
		Double price = 0.0;
		for (Item item: items) {
			price += item.getPrice();
		}
		return price;
	}

	public String getAllItems () {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < items.size(); i++) {
			builder.append(items.get(i).getName());
			if (i != items.size() - 1) {
				builder.append("; ");
			}
		}
		return builder.toString();
	}

	public boolean itemSKUStartsWith (String prefix) {
		for (Item item: items) {
			if (item.getSku().toString().startsWith(prefix)) {
				return true;
			}
		}
		return false;
	}

	public boolean itemNameContains (String str) {
		Locale locale = new Locale ("ru");
		for (Item item: items) {
			if (item.getName().toLowerCase(locale).contains(str)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString () {
		StringBuilder builder = new StringBuilder();
		builder.append("{Name:");
		builder.append(name);
		builder.append(", Email : ");
		builder.append(email);
		builder.append(", Phone : ");
		builder.append(phone);
		for (Item item: items) {
			builder.append("Item: ");
			builder.append(item.toString());
		}
		builder.append("}\n");
		return builder.toString();
	}

	@Override
	public int describeContents() {
		return id.hashCode();
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		//have to write this way, as values can be null.
		dest.writeValue(id);
		dest.writeValue(state);
		dest.writeValue(name);
		dest.writeValue(phone);
		dest.writeValue(company);
		dest.writeValue(email);
		dest.writeValue(date);
		dest.writeValue(address);
		dest.writeValue(index);
		dest.writeValue(payerComment);
		dest.writeValue(salesComment);
		dest.writeValue(paymentType);
		dest.writeValue(deliveryType);
		dest.writeValue(deliveryCost);
		dest.writeValue(price);
		dest.writeList(items); 

	}

	public static final Parcelable.Creator<Order> CREATOR = new Parcelable.Creator<Order>() {

		@Override
		public Order createFromParcel(Parcel in) {
			return new Order(in);
		}

		@Override
		public Order[] newArray(int size) {
			return new Order[size];
		}
	};

	public Order () {

	}

	public Order (Parcel parcel) {
		id = (Long) parcel.readValue(Long.class.getClassLoader());
		state =(String) parcel.readValue(String.class.getClassLoader());
		name = (String)parcel.readValue(String.class.getClassLoader());
		phone =(String) parcel.readValue(String.class.getClassLoader());
		company =(String) parcel.readValue(String.class.getClassLoader());
		email = (String)parcel.readValue(String.class.getClassLoader());
		date = (String)parcel.readValue(String.class.getClassLoader());
		address = (String)parcel.readValue(String.class.getClassLoader());
		index = (String)parcel.readValue(String.class.getClassLoader());
		payerComment = (String)parcel.readValue(String.class.getClassLoader());
		salesComment = (String)parcel.readValue(String.class.getClassLoader());
		paymentType = (String)parcel.readValue(String.class.getClassLoader());
		deliveryType = (String)parcel.readValue(String.class.getClassLoader());
		deliveryCost = (Double)parcel.readValue(Double.class.getClassLoader());
		price = (Double) parcel.readValue(Double.class.getClassLoader());
		items = new ArrayList<Item>();
		parcel.readList(items, Item.class.getClassLoader());
	}

}
