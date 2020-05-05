package com.chaiidev.kheknoi.ui.show;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chaiidev.kheknoi.R;

public class ShowFragment extends Fragment {

    private ShowViewModel mViewModel;

    public static ShowFragment newInstance() {
        return new ShowFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        mViewModel = ViewModelProviders.of(this).get(ShowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_show, container, false);

        return root;

    }

//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        mViewModel = ViewModelProviders.of(this).get(ShowViewModel.class);
//        // TODO: Use the ViewModel
//    }

}
