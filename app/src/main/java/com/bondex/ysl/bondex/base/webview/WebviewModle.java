package com.bondex.ysl.bondex.base.webview;

import android.app.Application;
import android.support.annotation.NonNull;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import me.goldze.mvvmhabit.base.BaseViewModel;

/**
 * date: 2018/12/18
 * Author: ysl
 * description:
 */
public class WebviewModle extends BaseViewModel {

    public WebviewModle(@NonNull Application application) {
        super(application);
    }

    public void setWebview(WebView webView) {


        webView.loadUrl("file:///android_asset/font/index.html");
        webView.setWebViewClient(new WebViewClient() {

            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                view.loadUrl(url);
                return true;
            }
        });


//支持App内部javascript交互

        webView.getSettings().setJavaScriptEnabled(true);

        webView.getSettings().setAllowUniversalAccessFromFileURLs(true);

//自适应屏幕

        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);

        webView.getSettings().setLoadWithOverviewMode(true);

//设置可以支持缩放

        webView.getSettings().setSupportZoom(true);

//扩大比例的缩放

        webView.getSettings().setUseWideViewPort(true);

//设置是否出现缩放工具

        webView.getSettings().setBuiltInZoomControls(true);

    }

}
