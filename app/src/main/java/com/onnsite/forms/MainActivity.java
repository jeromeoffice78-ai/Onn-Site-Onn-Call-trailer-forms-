package com.onnsite.forms;
import android.app.Activity;
import android.os.Bundle;
import android.print.PrintAttributes;
import android.print.PrintManager;
import android.content.Context;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebSettings;
public class MainActivity extends Activity {
 WebView web;
 @Override public void onCreate(Bundle b){super.onCreate(b);web=new WebView(this);web.setWebViewClient(new WebViewClient());WebSettings s=web.getSettings();s.setJavaScriptEnabled(true);s.setDomStorageEnabled(true);web.addJavascriptInterface(new Bridge(),"AndroidForms");setContentView(web);web.loadUrl("file:///android_asset/index.html");}
 public class Bridge {@JavascriptInterface public void printPage(){runOnUiThread(()->{PrintManager pm=(PrintManager)getSystemService(Context.PRINT_SERVICE);pm.print("Onn Service Form",web.createPrintDocumentAdapter("Onn Service Form"),new PrintAttributes.Builder().setMediaSize(PrintAttributes.MediaSize.NA_LETTER).build());});}}
 @Override public void onBackPressed(){if(web.canGoBack())web.goBack();else super.onBackPressed();}
}