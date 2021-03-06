package com.chaiidev.kheknoi.ui.more;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chaiidev.kheknoi.R;

public class MoreFragment extends Fragment {

    private MoreViewModel moreViewModel;

    public static MoreFragment newInstance() {
        return new MoreFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        moreViewModel = ViewModelProviders.of(this).get(MoreViewModel.class);
        View root = inflater.inflate(R.layout.fragment_more, container, false);

        return root;

    }

//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        mViewModel = ViewModelProviders.of(this).get(MoreViewModel.class);
//        // TODO: Use the ViewModel
//    }

}
