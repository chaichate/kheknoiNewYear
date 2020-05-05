package com.chaiidev.kheknoi.ui.compliment;
import com.chaiidev.kheknoi.DataBaseHelper;
import com.chaiidev.kheknoi.R;
import com.chaiidev.kheknoi.Visitor;
import com.chaiidev.kheknoi.ui.history.MarryActivity;

//import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateVistorActivity extends FragmentActivity {

    private DataBaseHelper db ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_vistor);

        db = new  DataBaseHelper(this);

        if( db == null)
            db = new DataBaseHelper(this);


        final EditText editText = (EditText) findViewById(R.id.edtName);
        final EditText messageText = (EditText) findViewById(R.id.message);
//        final thiscontext = this;

        Button button = (Button) findViewById(R.id.submit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Visitor visitor = new Visitor(editText.getText().toString(),messageText.getText().toString() );



                db.addVister(visitor);
                Toast.makeText( CreateVistorActivity.this ,"บันทึกข้อมูลสำเร็จ",Toast.LENGTH_LONG).show();

                int count  = db.getVisitorCount();
                final String TAG = "MyActivity";
                Log.i(TAG, String.valueOf(count));

                Intent intent = new Intent();
                setResult(RESULT_OK,intent);

                finish();


            }
        });




    }
}
