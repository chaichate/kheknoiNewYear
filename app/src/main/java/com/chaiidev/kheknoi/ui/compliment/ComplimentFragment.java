package com.chaiidev.kheknoi.ui.compliment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.chaiidev.kheknoi.DataBaseHelper;
import com.chaiidev.kheknoi.R;
import com.chaiidev.kheknoi.Visitor;
import com.chaiidev.kheknoi.ui.compliment.dummy.DummyContent;
import com.chaiidev.kheknoi.ui.compliment.dummy.DummyContent.DummyItem;
import com.chaiidev.kheknoi.ui.history.HistoryNewYearActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class ComplimentFragment extends Fragment {

    private  DataBaseHelper db ;
    private Context thiscontext;
    private ListView listviewVistor;
    private List<Visitor> listVistor ;
    private ArrayAdapter<Visitor> adapter ;


    //    // TODO: Customize parameter argument names
//    private static final String ARG_COLUMN_COUNT = "column-count";
//    // TODO: Customize parameters
//    private int mColumnCount = 1;
//    private OnListFragmentInteractionListener mListener;
//
//    /**
//     * Mandatory empty constructor for the fragment manager to instantiate the
//     * fragment (e.g. upon screen orientation changes).
//     */
//    public ComplimentFragment() {
//    }
//
//    // TODO: Customize parameter initialization
//    @SuppressWarnings("unused")
//    public static ComplimentFragment newInstance(int columnCount) {
//        ComplimentFragment fragment = new ComplimentFragment();
//        Bundle args = new Bundle();
//        args.putInt(ARG_COLUMN_COUNT, columnCount);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        if (getArguments() != null) {
//            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
//        }
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final FragmentActivity CurActivity = getActivity();
        thiscontext = container.getContext();

        db = new  DataBaseHelper(thiscontext);

        if( db == null)
            db = new DataBaseHelper(thiscontext);

        View root = inflater.inflate(R.layout.fragment_compliment, container, false);
        listviewVistor = (ListView) root.findViewById(R.id.todo_listView);


        TextView button = (TextView) root.findViewById(R.id.AddVistor);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent( CurActivity, CreateVistorActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                startActivity(intent);
            }
        });

        prepareData();

        return root;
    }


    public void prepareData(){
        listVistor = db.getAllVisitor();
        //adapter = new ArrayAdapter<Visitor>(thiscontext , android.R.layout.simple_spinner_item , android.R.id.text1 , listVistor );
        // Create the adapter to convert the array to views
        VisitorAdapter adapter = new VisitorAdapter(thiscontext, listVistor );

        listviewVistor.setAdapter(adapter);
    }


}
