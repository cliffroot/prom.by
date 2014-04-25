package com.prom.by.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import android.os.Parcel;
import android.os.Parcelable;

@Element (name = "item")
public class Item implements Parcelable{

	@Attribute
	Long id;

	@Element (name = "name")
	String name;

	@Element (name = "quantity")
	String quantity;

	@Element (name = "currency")
	String currency;

	@Element (name = "image")
	String image;

	@Element (name = "url")
	String url;

	@Element (name = "price")
	Double price;

	@Element (name = "sku") 
	String sku;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	@Override
	public String toString () {
		StringBuilder builder = new StringBuilder ();
		builder.append("Item => ");
		builder.append(name);
		builder.append("; ");
		return builder.toString();
	}

	@Override
	public int describeContents() {
		return sku.hashCode();
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeValue(id);
		dest.writeValue(name);
		dest.writeValue(quantity);
		dest.writeValue(currency);
		dest.writeValue(image);
		dest.writeValue(url);
		dest.writeValue(price);
		dest.writeValue(sku);
	}

	public static final Parcelable.Creator<Item> CREATOR = new Parcelable.Creator<Item>() {

		@Override
		public Item createFromParcel(Parcel in) {
			return new Item(in);
		}

		@Override
		public Item[] newArray(int size) {
			return new Item[size];
		}
	};

	public Item () {

	}

	public Item (Parcel parcel) {
		id = (Long) parcel.readValue(Long.class.getClassLoader());
		name = (String) parcel.readValue(String.class.getClassLoader());
		quantity = (String) parcel.readValue(String.class.getClassLoader());
		currency = (String) parcel.readValue(String.class.getClassLoader());
		image = (String) parcel.readValue(String.class.getClassLoader());
		url = (String) parcel.readValue(String.class.getClassLoader());
		price = (Double) parcel.readValue(Double.class.getClassLoader());
		sku = (String) parcel.readValue(String.class.getClassLoader());
	}

}
