package com.prom.by;

import java.util.ArrayList;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;

import com.prom.by.adapters.OrderAdapter;
import com.prom.by.helpers.DataProvider;
import com.prom.by.helpers.DialogHelper;
import com.prom.by.model.Order;


@EActivity(R.layout.activity_order_list)
public class OrderListActivity extends Activity implements SearchView.OnQueryTextListener {

	@Bean 
	DataProvider dataProvider;

	@ViewById(R.id.orders)
	ListView ordersList;

	@ViewById(android.R.id.empty)
	TextView empty;

	@ViewById(R.id.progress)
	ProgressBar progressBar;

	@Bean
	OrderAdapter orderAdapter;

	@AfterInject
	void getOrders () {
		if (orderAdapter.getItems() == null) {
			fetchFromServer();
		}
	}

	@AfterViews
	void setAdapter () {
		ordersList.setAdapter(orderAdapter);
		ordersList.setEmptyView(empty);
	}

	@Background
	void fetchFromServer () {
		showProgress();
		if (dataProvider.getOrders() != null) { 
			orderAdapter.setItems(dataProvider.getOrders().getOrders());
			showOrders();
		} else {
			orderAdapter.setItems(new ArrayList<Order>()); // do it so that it won't try all the time when the device configuration changes;
			progressBar.setVisibility(View.INVISIBLE);
			empty.setVisibility(View.VISIBLE);
			showError();
		}

	}

	@UiThread
	void showError () {
		DialogHelper.showErrorDialog(this, R.string.cant_reach_server);
	}

	@UiThread
	void showProgress () {
		ordersList.setVisibility(View.INVISIBLE);
		empty.setVisibility(View.INVISIBLE);
		progressBar.setVisibility(View.VISIBLE);
	}

	@UiThread
	void showOrders () {
		orderAdapter.notifyDataSetChanged();
		ordersList.setVisibility(View.VISIBLE);
		progressBar.setVisibility(View.INVISIBLE);
	}

	@ItemClick
	void ordersItemClicked (int position) {
		Bundle bundle = new Bundle();
		ArrayList <Order> orders = new ArrayList<Order>();
		orders.addAll(orderAdapter.getItems());
		bundle.putParcelableArrayList("orders", orders);
		Intent i = new Intent(OrderListActivity.this, SingleOrderActivity_.class);
		i.putExtra("orders", bundle);
		i.putExtra("order_position", position);
		orderAdapter.setItems(orderAdapter.getAllItems());
		this.startActivity(i);
	}

	@Override
	public boolean onCreateOptionsMenu (Menu menu) {
		getMenuInflater().inflate( R.menu.order_list, menu );
		SearchView searchView = (SearchView) (menu.findItem(R.id.search).getActionView());
		searchView.setOnQueryTextListener(this);
		return super.onCreateOptionsMenu( menu );
	}

	@Override
	public boolean onQueryTextChange(String arg0) {
		Log.i("Query", "Text change");
		orderAdapter.getFilter().filter(arg0);
		return true;
	}

	@Override
	public boolean onQueryTextSubmit(String arg0) {
		orderAdapter.getFilter().filter(arg0);
		return true;
	}

}
