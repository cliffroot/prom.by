package com.prom.by.helpers;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.prom.by.R;

public class DialogHelper {

	public static void showErrorDialog (Context context, int StringMessageResourse) {
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setMessage(StringMessageResourse).setTitle(R.string.error).setCancelable(false).setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int id) {
				dialog.dismiss();
			}
		});
		AlertDialog alert = builder.create();
		alert.show();
	}
}
