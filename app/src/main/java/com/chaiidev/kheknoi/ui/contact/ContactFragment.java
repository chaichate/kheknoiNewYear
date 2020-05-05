package com.chaiidev.kheknoi.ui.contact;

import androidx.lifecycle.ViewModelProviders;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.chaiidev.kheknoi.R;

public class ContactFragment extends Fragment {

    private ContactViewModel contactViewModel;

    public static ContactFragment newInstance() {
        return new ContactFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


//        return inflater.inflate(R.layout.fragment_contact, container, false);


        contactViewModel = ViewModelProviders.of(this).get(ContactViewModel.class);
        View root = inflater.inflate(R.layout.fragment_contact, container, false);

        TextView button = (TextView) root.findViewById(R.id.textPhone);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:0569255756"));
                startActivity(intent);

            }
        });



        final TextView textemail = (TextView) root.findViewById(R.id.textEmail);
        textemail.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                String mailto = "mailto:" + textemail.getText() +
                        "&subject=" + Uri.encode("") +
                        "&body=" + Uri.encode("");

                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse(mailto));

                try {
                    startActivity(emailIntent);
                } catch (ActivityNotFoundException e) {
                    //TODO: Handle case where no email app is available
                }

            }
        });



        final TextView textLine = (TextView) root.findViewById(R.id.textLineID);
        textLine.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Uri uri = Uri.parse("https://line.me/ti/p/@gmmgrammy");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });


        final TextView textFacebook = (TextView) root.findViewById(R.id.textFacebook);
        textFacebook.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Uri uri = Uri.parse("https://www.facebook.com/AtKheknoi");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);


            }
        });



        return root;
    }

//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        mViewModel = ViewModelProviders.of(this).get(ContactViewModel.class);
//        // TODO: Use the ViewModel
//    }


    public void onClick(View v) {




    }

}
