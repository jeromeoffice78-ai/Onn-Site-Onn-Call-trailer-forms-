package com.onnsiteonncall.forms;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
public class MainActivity extends Activity {
 private WebView webView;
 private static final String APP_URL="https://jarvis-native-watch-bridge.floot.app";
 @Override public void onCreate(Bundle b){super.onCreate(b);webView=new WebView(this);setContentView(webView);WebSettings s=webView.getSettings();s.setJavaScriptEnabled(true);s.setDomStorageEnabled(true);webView.setWebViewClient(new WebViewClient());webView.setWebChromeClient(new WebChromeClient());webView.loadUrl(APP_URL);}
 @Override public void onBackPressed(){if(webView!=null&&webView.canGoBack())webView.goBack();else super.onBackPressed();}
}
