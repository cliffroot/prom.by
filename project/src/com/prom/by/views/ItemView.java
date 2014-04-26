package com.prom.by.views;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.prom.by.R;
import com.prom.by.SingleOrderActivity_;
import com.prom.by.model.Item;

@EViewGroup(R.layout.view_item)
public class ItemView extends LinearLayout{

	@ViewById(R.id.item_photo)
	NetworkImageView photo;

	@ViewById(R.id.item_name)
	TextView itemName;

	@ViewById(R.id.item_cost)
	TextView itemCost;

	@ViewById(R.id.item_price)
	TextView itemPrice;

	Context context;

	public ItemView(Context context) {
		super(context);
		this.context = context;
	}


	public void bind (Item item) {
		ImageLoader mImageLoader = new ImageLoader(((SingleOrderActivity_) context).rQueue, ((SingleOrderActivity_) context).cache);
		photo.setImageUrl(item.getImage(), mImageLoader);

		itemName.setText(item.getName());
		itemPrice.setText(item.getPrice() + " | " + item.getQuantity() + " шт.");
		itemCost.setText(String.valueOf(item.getPrice() * Double.parseDouble(item.getQuantity()))); //FIXME: wow, such quantity, so string 
	}


}
