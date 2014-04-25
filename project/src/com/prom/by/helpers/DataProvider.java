package com.prom.by.helpers;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import org.androidannotations.annotations.EBean;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import android.util.Log;

import com.prom.by.model.Orders;

@EBean
public class DataProvider extends DefaultHttpClient{

	static final String URL = "https://my.deal.by/cabinet/export_orders/xml/147966?hash_tag=e107c2eca71f4f9d68621043ca037005";

	public DataProvider () {
		super();
	}

	public Orders getOrders () {
		try {
			String xmlData = retrieve(URL);
			Serializer serializer = new Persister();       
			Reader reader = new StringReader(xmlData);
			Orders orders = serializer.read(Orders.class, reader, false);
			Log.d("Orders", orders.toString());
			return orders;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

	}

	private String retrieve(String url) {
		HttpGet getRequest = new HttpGet(url);
		try {
			HttpResponse getResponse = this.execute(getRequest);
			final int statusCode = getResponse.getStatusLine().getStatusCode();
			if (statusCode != HttpStatus.SC_OK) {
				return null;
			}
			HttpEntity getResponseEntity = getResponse.getEntity();
			if (getResponseEntity != null) {
				return EntityUtils.toString(getResponseEntity, HTTP.UTF_8);
			}
		} 
		catch (IOException e) {
			getRequest.abort();
			e.printStackTrace();
		}

		return null;
	}
}
