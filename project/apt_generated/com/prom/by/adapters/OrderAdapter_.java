//
// DO NOT EDIT THIS FILE, IT HAS BEEN GENERATED USING AndroidAnnotations 3.0.1.
//


package com.prom.by.adapters;

import android.content.Context;
import org.androidannotations.api.view.OnViewChangedNotifier;

public final class OrderAdapter_
    extends OrderAdapter
{

    private Context context_;
    private static OrderAdapter_ instance_;

    private OrderAdapter_(Context context) {
        super(context);
        context_ = context;
    }

    public static OrderAdapter_ getInstance_(Context context) {
        if (instance_ == null) {
            OnViewChangedNotifier previousNotifier = OnViewChangedNotifier.replaceNotifier(null);
            instance_ = new OrderAdapter_(context.getApplicationContext());
            instance_.init_();
            OnViewChangedNotifier.replaceNotifier(previousNotifier);
        }
        return instance_;
    }

    private void init_() {
    }

}
