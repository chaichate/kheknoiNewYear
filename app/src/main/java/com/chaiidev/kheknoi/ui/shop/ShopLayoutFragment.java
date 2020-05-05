package com.chaiidev.kheknoi.ui.shop;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import com.chaiidev.kheknoi.R;
import com.chaiidev.kheknoi.ui.history.CeremonyActivity;
import com.chaiidev.kheknoi.ui.history.HistoryAFragment;
import com.chaiidev.kheknoi.ui.history.HistoryNewYearActivity;
import com.chaiidev.kheknoi.ui.history.MarryActivity;
//import com.example.bottomnavigation.ui.notifications.NotificationsViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShopLayoutFragment extends Fragment {

    public ShopLayoutFragment() {
        // Required empty public constructor
    }


//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_shop_layout, container, false);
//    }


    private ShopLayoutViewModel shopLayoutViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        shopLayoutViewModel =
                ViewModelProviders.of(this).get(ShopLayoutViewModel.class);
        View root = inflater.inflate(R.layout.fragment_shop_layout, container, false);

        final FragmentActivity CurActivity = getActivity();

        Button button1 = (Button) root.findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent( CurActivity, HistoryAFragment.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                startActivity(intent);

//                HistoryAFragment nextFrag = new HistoryAFragment();
//                getActivity().getSupportFragmentManager().beginTransaction()
////                        .replace(R.id.ShopFragmentLayout , nextFrag , "findThisFragment")
//                        .addToBackStack(null)
//                        .commit();

            }
        });


        Button button2 = (Button) root.findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent( CurActivity, HistoryNewYearActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                startActivity(intent);
            }
        });


        Button button3 = (Button) root.findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent( CurActivity, CeremonyActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                startActivity(intent);
            }
        });


        Button button4 = (Button) root.findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent( CurActivity, MarryActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                startActivity(intent);
            }
        });




        return root;



    }



}
