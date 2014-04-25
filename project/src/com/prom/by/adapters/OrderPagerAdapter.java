package com.prom.by.adapters;


import java.util.ArrayList;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.prom.by.model.Order;
import com.prom.by.views.SingleOrderFragment_;

public class OrderPagerAdapter extends FragmentPagerAdapter {

	ArrayList<Order> orders;

	public OrderPagerAdapter(FragmentManager fm, ArrayList<Order> orders) {
		super(fm);
		this.orders = orders;
	}

	@Override
	public Fragment getItem(int index) {
		return SingleOrderFragment_.newInstance(orders.get(index));
	}

	@Override
	public int getCount() {
		return orders.size();
	}
}