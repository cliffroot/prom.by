package com.prom.by;

import java.util.ArrayList;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.prom.by.adapters.OrderPagerAdapter;
import com.prom.by.helpers.BitmapLruCache;
import com.prom.by.model.Order;



@EActivity(R.layout.activity_order)
public class SingleOrderActivity extends FragmentActivity {

	@ViewById(R.id.pager)
	ViewPager pager;

	@Extra
	Bundle orders;

	@Extra("order_position")
	int orderPosition;

	OrderPagerAdapter pagerAdapter;

	public RequestQueue rQueue;
	public BitmapLruCache cache;

	@Override
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		rQueue = Volley.newRequestQueue(this);
		cache = new BitmapLruCache();
	}

	@AfterViews
	public void setAdapter() {
		ArrayList<Order> os = orders.getParcelableArrayList("orders");
		pagerAdapter = new OrderPagerAdapter(getSupportFragmentManager(), os);
		pager.setAdapter(pagerAdapter);

		pager.setCurrentItem(orderPosition);
	}

}
