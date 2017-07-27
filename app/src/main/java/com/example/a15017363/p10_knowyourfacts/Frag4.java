package com.example.a15017363.p10_knowyourfacts;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class Frag4 extends Fragment {

    ImageView iv;

    public Frag4() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_4, container, false);
        iv = (ImageView) view.findViewById(R.id.ivFact);
        String imageUrl = "http://68.media.tumblr.com/81c7ae35cacb011b2ac3ef916f9a37d3/tumblr_otk8r7EUux1roqv59o1_500.png";
        Picasso.with(getContext()).load(imageUrl).into(iv);

        return view;

    }

}
