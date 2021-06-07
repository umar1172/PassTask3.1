package com.example.movieapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.movieapp.R.id.BOOKING;
import static com.example.movieapp.R.id.maskimage;

public class MainActivity extends AppCompatActivity {

    Button s_hero, b_action, b_animation;
    Intent intent_o;
    String movie_name, time, date;
    int REQUEST_CODE = 0;
    Bundle bundle = new Bundle();
    TextView booking_description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        s_hero = findViewById(R.id.s_hero);
        b_action = findViewById(R.id.action);
        b_animation = findViewById(R.id.animation);
        booking_description = findViewById(R.id.booking_desc);
//intent_o=getIntent();
        getS_hero();
        getB_action();
        getB_animation();
//        Bundle bundle = new Bundle();
//movie_name=bundle.getString("MOVIE NAME");
//booking_descr.setText(movie_name);

    }

    public Button getB_action() {
        b_action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                intent=new Intent(MainActivity.this,MainActivity2.class);
                try {
                    intent_o = new Intent(MainActivity.this, MainActivity2.class);

                    startActivityForResult(intent_o, 0);

                } catch (ActivityNotFoundException e) {
                    Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                }

            }
        });
        return b_action;
    }

    public Button getS_hero() {
        s_hero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    intent_o = new Intent(MainActivity.this, MainActivity2.class);

                    startActivityForResult(intent_o, 0);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                }

            }
        });
        return s_hero;
    }

    public Button getB_animation() {
        b_animation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //              intent=new Intent(MainActivity.this,MainActivity2.class);
                try {
                    intent_o = new Intent(MainActivity.this, MainActivity2.class);

                    startActivityForResult(intent_o, 0);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        return b_animation;
    }

/*    @Override
    public void startActivity(Intent intent) {
        setContentView(R.layout.booking);
        super.startActivity(intent);

intent=getIntent();

        //movie=intent.getParcelableExtra("MOVIE NAME");
    String moviename=intent.getParcelableExtra("NAME_MOVIE");
        booking_descr.setText(moviename);

    }*/

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    setContentView(R.layout.booking);
bundle=getIntent().getExtras();
                   Intent intent=getIntent();
                    bundle=intent.getExtras();
                    String xyz=intent.getExtras().toString();
                    booking_description =findViewById(R.id.booking_desc);
                    booking_description.setText("DATA : "+xyz);
                    System.out.println("Reach here");

//String abc=data.getStringExtra("NAME_MOVIE");
//                    Movie movie=new Movie("AAAA","DDDD","12,12113");

                }
        }
    }
}}