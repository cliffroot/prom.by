//
// DO NOT EDIT THIS FILE, IT HAS BEEN GENERATED USING AndroidAnnotations 3.0.1.
//


package com.prom.by.helpers;

import android.content.Context;

public final class DataProvider_
    extends DataProvider
{

    private Context context_;

    private DataProvider_(Context context) {
        context_ = context;
        init_();
    }

    public static DataProvider_ getInstance_(Context context) {
        return new DataProvider_(context);
    }

    private void init_() {
    }

    public void rebind(Context context) {
        context_ = context;
        init_();
    }

}
