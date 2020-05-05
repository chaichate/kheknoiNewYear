package com.chaiidev.kheknoi.ui.history;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.PersistableBundle;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;

import com.chaiidev.kheknoi.R;
import com.chaiidev.kheknoi.ui.shop.ShopLayoutViewModel;

import static android.text.Html.FROM_HTML_MODE_LEGACY;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HistoryAFragment} factory method to
 * create an instance of this fragment.
 */
public class HistoryAFragment extends FragmentActivity {

//    public static HistoryAFragment newInstance() {
//        return new HistoryAFragment();
//    }

    public HistoryAFragment() {
        // Required empty public constructor
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_history_a);

//
//        WebView  webView = (WebView) findViewById(R.id.webview);
//        String text=  getString(R.string.history_01);
//        Spanned htmlData = Html.fromHtml(text, FROM_HTML_MODE_LEGACY);
//
//
//        webView.loadData("<html><body> " + htmlData + "</body></html>", "text/html", "UTF-8");


    }


}
