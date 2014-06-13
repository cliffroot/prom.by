package com.prom.by.views;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.prom.by.R;
import com.prom.by.adapters.ItemAdapter;


public class LinearLayoutList extends LinearLayout {

	private Context context;

	public LinearLayoutList(Context context) {
		super(context);
		this.context = context;
		setOrientation(LinearLayout.VERTICAL);
	}

	public LinearLayoutList(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;
		setOrientation(LinearLayout.VERTICAL);
	}

	public void setAdapter (ItemAdapter adapter) {
		Double total = 0.0;
		LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		LinearLayout.LayoutParams dlp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 1);
		dlp.leftMargin = 18;
		dlp.rightMargin = 18;
		dlp.topMargin = 2;
		dlp.bottomMargin = 2;
		for (int i = 0; i < adapter.getCount(); i++) {
			View v = adapter.getView(i, null, this);
			this.addView(v, llp);

			if (i != adapter.getCount() - 1) {
				View divider = new View(context);
				divider.setBackgroundColor(getResources().getColor(android.R.color.darker_gray));
				this.addView(divider, dlp);
			}

			total += (adapter.getItem(i).getPrice()==null?0.d:adapter.getItem(i).getPrice()) * Double.parseDouble(adapter.getItem(i).getQuantity());
		}

		View v = ((Activity)context).getLayoutInflater().inflate(R.layout.view_item_list_total_cost, null);
		this.addView(v, llp);
		TextView totalCost = (TextView) v.findViewById(R.id.cost_tag);
		totalCost.setText("Всего: " + String.valueOf(total)); //TODO: move to constants;
	}

}
