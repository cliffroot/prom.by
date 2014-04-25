package com.prom.by.views;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import android.content.Context;
import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.prom.by.R;
import com.prom.by.model.Order;

@EViewGroup(R.layout.view_order)
public class OrderView extends LinearLayout {

	@ViewById(R.id.order_name)
	TextView orderName;

	@ViewById(R.id.order_id)
	TextView orderId;

	@ViewById(R.id.order_price)
	TextView orderPrice;

	@ViewById(R.id.order_time)
	TextView orderTime;

	@ViewById(R.id.order_items)
	TextView orderItems;

	public OrderView(Context context) {
		super(context);
	}


	public void bind (Order order) {
		orderName.setText(order.getName());
		if (!order.getState().equalsIgnoreCase("accepted")) { //TODO: move string to constants
			orderId.setText(order.getState() + " | " + "№" + order.getId().toString()); 
			paintTextViews(Color.GRAY);
		} else { 
			orderId.setText("№" + order.getId().toString());
			paintTextViews(Color.BLACK);
		}
		orderPrice.setText(order.getItemsTotalPrice().toString()); 
		orderTime.setText(order.getDate());
		orderItems.setText(" - " + order.getAllItems());
	}

	private void paintTextViews (int color) {
		orderName.setTextColor(color);
		orderId.setTextColor(color);
		orderPrice.setTextColor(color);
		orderTime.setTextColor(color);
		orderItems.setTextColor(color);
	}

}
