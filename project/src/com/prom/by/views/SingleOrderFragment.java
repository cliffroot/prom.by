package com.prom.by.views;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.TextView;

import com.prom.by.R;
import com.prom.by.adapters.ItemAdapter;
import com.prom.by.model.Order;

@EFragment(R.layout.fragment_single_order)
public class SingleOrderFragment extends Fragment {

	Order order;

	@ViewById(R.id.order_id)
	TextView orderId;

	@ViewById(R.id.order_address)
	TextView orderAddress;

	@ViewById(R.id.order_company)
	TextView orderCompany;

	@ViewById(R.id.order_date)
	TextView orderDate;

	@ViewById(R.id.order_email)
	TextView orderEmail;

	@ViewById(R.id.order_orderer)
	TextView orderOrderer;

	@ViewById(R.id.order_phone)
	TextView orderPrice;

	@ViewById(R.id.order_items)
	LinearLayoutList orderItems;

	@Bean
	ItemAdapter itemAdapter;

	public static SingleOrderFragment_ newInstance(Order order) {
		SingleOrderFragment_ orderFragment = new SingleOrderFragment_();
		Bundle bundle = new Bundle();
		bundle.putParcelable("order", order);
		orderFragment.setArguments(bundle);
		return orderFragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		order = getArguments().getParcelable("order");
	}

	@AfterViews 
	void populateFragment () {
		orderId.setText(order.getId().toString());
		orderAddress.setText(order.getAddress());
		orderCompany.setText(order.getCompany());
		orderDate.setText(order.getDate());
		orderEmail.setText(order.getEmail());
		orderOrderer.setText(order.getName());
		orderPrice.setText(order.getPrice().toString());

		itemAdapter.setItems(order.getItems());
		orderItems.setAdapter(itemAdapter);
		itemAdapter.notifyDataSetChanged();

	}
}
