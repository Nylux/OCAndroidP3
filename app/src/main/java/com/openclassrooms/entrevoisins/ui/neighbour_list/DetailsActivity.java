package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.EventLog;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.events.AddFavoriteEvent;
import com.openclassrooms.entrevoisins.events.RemoveFavoriteEvent;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailsActivity extends AppCompatActivity {

    // UI Elements Binding
    @BindView(R.id.details_imageview)
    ImageView details_imageview;
    @BindView(R.id.neighbour_name_textview)
    TextView neighbour_name_textview;
    @BindView(R.id.details_fab)
    FloatingActionButton fab;
    @BindView(R.id.location_textview)
    TextView location_textview;
    @BindView(R.id.phone_textview)
    TextView phone_textview;
    @BindView(R.id.social_textview)
    TextView social_textview;
    @BindView(R.id.aboutme_description)
    TextView aboutme_description;


    Neighbour neighbour;
    private NeighbourApiService mApiService;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        neighbour = (Neighbour) intent.getSerializableExtra("neighbour");

        mApiService = DI.getNeighbourApiService();

        Glide.with(this).load(neighbour.getAvatarUrl()).centerCrop().into(details_imageview);
        neighbour_name_textview.setText(neighbour.getName());
        location_textview.setText(neighbour.getAddress());
        phone_textview.setText((neighbour.getPhoneNumber()));
        social_textview.setText(neighbour.getSocial());
        aboutme_description.setText(neighbour.getAboutMe());


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (neighbour.isFavorite())
                {
                    EventBus.getDefault().post(new RemoveFavoriteEvent(neighbour));
                    fab.setImageResource(R.drawable.ic_star_border_white_24dp);
                }
                else
                {
                    EventBus.getDefault().post(new AddFavoriteEvent(neighbour));
                    fab.setImageResource(R.drawable.ic_star_yellow_24dp);
                }
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Subscribe
    public void onAddFavorite(AddFavoriteEvent event) {
        mApiService.addFavoriteNeighbour(event.neighbour);
        neighbour.setFavorite(!neighbour.isFavorite());
    }
}
