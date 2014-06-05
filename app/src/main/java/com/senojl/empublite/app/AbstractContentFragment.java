package com.senojl.empublite.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.File;

abstract public class AbstractContentFragment extends WebViewFragment {
    abstract String getPage();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View result=
                super.onCreateView(inflater, container, savedInstanceState);
        getWebView().getSettings().setJavaScriptEnabled(true);
        getWebView().getSettings().setSupportZoom(true);
        getWebView().getSettings().setBuiltInZoomControls(true);

        File file = new File(getPage());
        if(file.exists()) {
            Log.d("AbstractContentFragment", "The file " + getPage() + " exists");
        } else {
            Log.d("AbstractContentFragment", "The file " + getPage() + " does not exist");
        }

        getWebView().loadUrl(getPage());
        return(result);
    }
}