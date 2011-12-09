package com.concentricsky.android.test;

/*
# Copyright 2011 Concentric Sky, Inc. All Rights Reserved.
# http://www.concentricsky.com
# This code may not be used without permission.
 */
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class ScrubBarActivity extends Activity {
	public static final String LOG_TAG = "ScrubBar";
	
	@Override
	public void onCreate(Bundle b) {
		super.onCreate(b);
		
		WebView webView = new WebView(this);
		webView.getSettings().setJavaScriptEnabled(true);

		webView.setWebChromeClient(new WebChromeClient() {
			@Override public boolean onConsoleMessage(ConsoleMessage msg) {
				Log.d(LOG_TAG, msg.message());
				return false;
				
			}

		});
		
		setContentView(webView);
		
        webView.loadUrl("file:///android_asset/test.html");
	}
}
