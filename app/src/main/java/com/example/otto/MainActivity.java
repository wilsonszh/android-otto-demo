package com.example.otto;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.squareup.otto.Subscribe;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Otto send event (a string)
                OttoBus.post(editText.getText().toString());
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
    public void onValueAvailable(String value) {
        Toast.makeText(this, "Value received: " + value, Toast.LENGTH_SHORT).show();
    }

}
