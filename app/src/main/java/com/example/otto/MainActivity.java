package com.example.otto;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.squareup.otto.Subscribe;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Otto send event (a string)
                OttoBus.post(new MsgToFrag(editText.getText().toString()));
            }
        });

        //for fragment
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayout, new SecondFragment());
        ft.commit();

    }

    @Override
    protected void onStart() {
        super.onStart();
        //In order to receive events, a class instance needs to register with the bus
        OttoBus.register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        //stop receiving events after app is not visible
        OttoBus.unregister(this);
    }

    //this method listen to event that is a String
    @Subscribe
    public void onValueAvailable(MsgToAct value) {
        textView.setText("Value Received:" + value.getMsg());
    }

}
