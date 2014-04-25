package com.prom.by.adapters;

import java.util.List;

import org.androidannotations.annotations.EBean;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.prom.by.model.Item;
import com.prom.by.views.ItemView;
import com.prom.by.views.ItemView_;

@EBean
public class ItemAdapter extends BaseAdapter{

	List<Item> items;

	Context context;


	public ItemAdapter (Context context) {
		this.context = context;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ItemView view = null;
		if (convertView == null) {
			try {
				view = ItemView_.build(context);
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		} 
		else {
			view = (ItemView) convertView;
		}
		view.bind(getItem(position));
		return view;
	}

	public void setItems (List<Item> items) {
		this.items 	  = items;
	}

	public List<Item> getItems () {
		return items;
	}

	@Override
	public int getCount() {
		return items== null? 0 : items.size();
	}

	@Override
	public Item getItem(int position) {
		return items.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}
}
