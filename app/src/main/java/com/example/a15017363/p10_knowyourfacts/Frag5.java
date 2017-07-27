package com.example.a15017363.p10_knowyourfacts;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.crazyhitty.chdev.ks.rssmanager.Channel;
import com.crazyhitty.chdev.ks.rssmanager.RSS;
import com.crazyhitty.chdev.ks.rssmanager.RssReader;

import java.util.ArrayList;
import java.util.List;

import static android.content.Intent.ACTION_VIEW;


/**
 * A simple {@link Fragment} subclass.
 */
public class Frag5 extends Fragment implements RssReader.RssCallback {

    private RssReader rssReader = new RssReader(this);
    private List<String> urls = new ArrayList<>();



    ListView lv;
    ArrayAdapter aa;
    ArrayList<String> al;



    public Frag5() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_5, container, false);

        lv = (ListView)view.findViewById(R.id.lvRSS);


        String[] urls = new String[] {"https://www.gov.sg/rss/factuallyrss"};
        rssReader.loadFeeds(urls);


        return view;
    }



    private void loadFeeds(String[] urls) {
        rssReader.loadFeeds(urls);
    }


    @Override
    public void rssFeedsLoaded(final List<RSS> rssList) {
        al = new ArrayList<>();
        aa = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, al);
        lv.setAdapter(aa);
        // Feeds loaded, do whatever you want to do with them.
        for(Channel.Item i : rssList.get(0).getChannel().getItems() ){
            al.add(i.getTitle());
            aa.notifyDataSetChanged();
        }

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemurl = rssList.get(0).getChannel().getItems().get(position).getLink();
                Intent intent = new Intent(ACTION_VIEW, Uri.parse(itemurl));
                startActivity(intent);
            }
        });




    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public void unableToReadRssFeeds(String errorMessage) {
        // Oops, library was unable to parse your feed url.
    }
}
