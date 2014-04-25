package com.prom.by.adapters;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.EBean.Scope;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;

import com.prom.by.model.Order;
import com.prom.by.views.OrderView;
import com.prom.by.views.OrderView_;

@EBean(scope = Scope.Singleton)
public class OrderAdapter extends BaseAdapter implements Filterable{

	List<Order> items;

	List<Order> allItems;

	Context context;

	public OrderAdapter (Context context) {
		this.context = context;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		OrderView view = null;
		if (convertView == null) {
			try {
				view = OrderView_.build(context);
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		} 
		else {
			view = (OrderView) convertView;
		}
		view.bind(getItem(position));
		return view;
	}

	public void setItems (List<Order> items) {
		allItems = items;
		this.items 	  = items;
	}

	public List<Order> getItems () {
		return items;
	}

	public List<Order> getAllItems () {
		return allItems;
	}

	@Override
	public int getCount() {
		return items== null? 0 : items.size();
	}

	@Override
	public Order getItem(int position) {
		return items.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public Filter getFilter() {
		Filter filter = new Filter() {

			@SuppressWarnings("unchecked")
			@Override
			protected void publishResults(CharSequence constraint, FilterResults results) {
				items = (List<Order>) results.values;
				notifyDataSetChanged();

			}

			@Override
			protected FilterResults performFiltering(CharSequence constraint) {
				FilterResults results = new FilterResults();
				ArrayList<Order> filtered = new ArrayList<Order>();
				Locale locale = new Locale("ru");
				String cons = constraint.toString().toLowerCase(locale);
				for (Order order: allItems) {
					if (order.getId().toString().startsWith(cons) || order.getName().toLowerCase(locale).contains(cons) || order.getPhone().contains(cons) || 
							order.itemSKUStartsWith(cons) || order.itemNameContains(cons)) {
						filtered.add(order);
					}
				}
				results.count = filtered.size();
				results.values = filtered;
				return results;
			}
		};
		return filter;
	}

}
