package com.yrazlik.tabstacks;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

/**
 * Created by yrazlik on 26/03/16.
 */
public class AFragment extends Fragment{

    TextView text;
    Button buttonA, buttonB;
    ImageView image, image2, image3, image4, image5;
    String id;

    MyObject m;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("THETABSTACKAPP", "THETABSTACKAPP A onCreateView()");
        View v = inflater.inflate(R.layout.fragment_a, container, false);

        m = new MyObject();
        m.randomString = UUID.randomUUID().toString();
        Random generator = new Random();
        int i = generator.nextInt(1000) + 1;
        m.randomInt = i;
        m.child = new ChildObject();
        m.child.randomChildString = UUID.randomUUID().toString();
        m.child.randomChildInt = generator.nextInt(1000) + 1;
        m.child.childObjects = new ArrayList<>();

        ChildObject cc1 = new ChildObject();
        ChildObject cc2 = new ChildObject();
        cc1.randomChildString = UUID.randomUUID().toString();
        cc1.randomChildInt = generator.nextInt(1000) + 1;
        cc2.randomChildString = UUID.randomUUID().toString();
        cc2.randomChildInt = generator.nextInt(1000) + 1;
        m.child.childObjects.add(cc1);
        m.child.childObjects.add(cc2);

        m.childObjects = new ArrayList<>();
        ChildObject c1 = new ChildObject();
        ChildObject c2 = new ChildObject();
        c1.randomChildString = UUID.randomUUID().toString();
        c1.randomChildInt = generator.nextInt(1000) + 1;
        c2.randomChildString = UUID.randomUUID().toString();
        c2.randomChildInt = generator.nextInt(1000) + 1;
        m.childObjects.add(cc1);
        m.childObjects.add(cc2);



        text = (TextView) v.findViewById(R.id.text);
        buttonA = (Button) v.findViewById(R.id.buttonA);
        buttonB = (Button) v.findViewById(R.id.buttonB);
        image = (ImageView) v.findViewById(R.id.image);
        image2 = (ImageView) v.findViewById(R.id.image2);
        image3 = (ImageView) v.findViewById(R.id.image3);
        image4 = (ImageView) v.findViewById(R.id.image4);
        image5 = (ImageView) v.findViewById(R.id.image5);

        text.setText(id);

        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).replace("a");

            }
        });

        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).replace("b");
            }
        });


        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("THETABSTACKAPP", "THETABSTACKAPP A onAttach()");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        id = UUID.randomUUID().toString();
        Log.d("THETABSTACKAPP", "THETABSTACKAPP A onCreate()");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("THETABSTACKAPP", "THETABSTACKAPP A onActivityCreated()");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("THETABSTACKAPP", "THETABSTACKAPP A onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("THETABSTACKAPP", "THETABSTACKAPP A onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("THETABSTACKAPP", "THETABSTACKAPP A onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("THETABSTACKAPP", "THETABSTACKAPP A onStop()");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("THETABSTACKAPP", "THETABSTACKAPP A onDestroyView()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("THETABSTACKAPP", "THETABSTACKAPP A onDestroy()");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("THETABSTACKAPP", "THETABSTACKAPP A onDetach()");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
