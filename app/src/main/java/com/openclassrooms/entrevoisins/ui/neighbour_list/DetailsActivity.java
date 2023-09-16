package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.model.Neighbour;

import org.w3c.dom.Text;

import butterknife.BindView;

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


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        neighbour = (Neighbour) intent.getSerializableExtra("neighbour");

        Log.i("Entrevoisins", neighbour.getName()); // TODO: Remove debug log

        /*
        // details_imageview.setImageResource(neighbour.getAvatarUrl()); // TODO: Find a way to set the image ?
        neighbour_name_textview.setText(neighbour.getName());
        location_textview.setText(neighbour.getAddress());
        phone_textview.setText((neighbour.getPhoneNumber()));
        //social_textview.setText(neighbour.); // TODO: Extend Neighbour object to have a social field
        aboutme_description.setText(neighbour.getAboutMe());
        */
    }
}
