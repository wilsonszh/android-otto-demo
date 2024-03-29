package com.example.otto;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.squareup.otto.Subscribe;

/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {

    TextView textView;
    EditText editText;
    Button button;

    public SecondFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_second, container, false);
        textView = v.findViewById(R.id.textView);
        editText = v.findViewById(R.id.editText);
        button = v.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OttoBus.post(new MsgToAct(editText.getText().toString()));
            }
        });

        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        //In order to receive events, a class instance needs to register with the bus
        OttoBus.register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        //stop receiving events after app is not visible
        OttoBus.unregister(this);
    }

    //this method listen to event that is a String
    @Subscribe
    public void onValueReceived(MsgToFrag value) {
        textView.setText("Value Received:" + value.getMsg());
    }
}
