package com.example.movieapp;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.VectorDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

import static android.app.DatePickerDialog.*;


public class MainActivity2 extends AppCompatActivity  {
    TextView textView_date,t_rating,t_duration,t_MainCast,ticketnum;
    String a;
ImageView imageView_up,imageView_down;
    Button button;
//Movie movie=new Movie(null);
    Spinner spinner,spinner_time;
    int count=0;
Bundle bundle = new Bundle();
Intent intent=new Intent();
    TextView booking_descr;
Movie movie=new Movie("Rampage","2.5","3:30");

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView_date = findViewById(R.id.datepickerview);
        t_rating=findViewById(R.id.Rating);
        t_duration=findViewById(R.id.time);
        t_MainCast=findViewById(R.id.cast);
        intent.putExtra("NAME_MOVIE","PPPPP");
        spinner=findViewById(R.id.spinner);
        spinner_time=findViewById(R.id.time_spinner);
      imageView_up=findViewById(R.id.up_btn);
      imageView_down=findViewById(R.id.down_btn);
      ticketnum=findViewById(R.id.ticket_num);
button=findViewById(R.id.book_btn);
getTextView_date();
getImageView_down();
getImageView_up();
getSpinner();
getSpinner_time();
getButton();
bundle.putInt("Count",count);
        booking_descr =(TextView) findViewById(R.id.booking_desc);
    }

    public TextView getTextView_date() {
       textView_date.setOnClickListener(new View.OnClickListener() {
          String time;
           @Override
           public void onClick(View v) {
DatePickerDialog datePickerDialog=new DatePickerDialog(MainActivity2.this);
datePickerDialog.show();
datePickerDialog.setOnDateSetListener(new OnDateSetListener() {
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        textView_date.setText(Integer.toString(dayOfMonth)+"/"+Integer.toString(month)+"/"+Integer.toString(year));
bundle.putInt("YEAR",year);
bundle.putInt("MONTH",month);
bundle.putInt("DAYOFMONTH",dayOfMonth);
bundle.putInt("DATE",dayOfMonth+month+year);
time= Integer.toString(dayOfMonth)+"/"+Integer.toString(month)+"/"+Integer.toString(year);
movie.setTime(time);
  //  movie.setTime(time);
    }
});

           }


       });

        return textView_date;
    }

    public Spinner getSpinner() {
        ArrayList<String> movie_array=new ArrayList<>();
        movie_array.add("Mission Impossible:Fallout");
        movie_array.add("Rampage");
        movie_array.add("Jurassic World: Fallen Kingdom");
        movie_array.add("Sky Scrapper");
        movie_array.add("The Meg");
        movie_array.add("Hotel Transylvania 3");
        movie_array.add("Peter Rabit");
        ArrayAdapter<String> movie_adpater=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,movie_array);

        spinner.setAdapter(movie_adpater);

spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        int iCurrentSelection = spinner.getSelectedItemPosition();
        Toast.makeText(MainActivity2.this,parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();

String name=parent.getItemAtPosition(position).toString();

        movie.setMovie(name);

        bundle.putString("NAME_MOVIE",movie.getMovie().toString());
        // intent.putExtras(bundle);
        //intent.putExtra("NAME_MOVIE",movie.getMovie().toString());
        Toast.makeText(MainActivity2.this,"This is after Toast 1: "+intent.getStringExtra("NAME_MOVIE"), Toast.LENGTH_SHORT).show();

        switch (position){
               case 0:
                t_rating.setText("Ratings:"+"7.5");
                t_duration.setText("60 mins");
                t_MainCast.setText("Main Cast:"+"Chris wolmer");

                break;

            case 1:
                t_rating.setText("Ratings:"+"5.5");
                t_duration.setText("35 mins");
                t_MainCast.setText("Main Cast:"+"Maria christ");

                break;

            case 3:
                t_rating.setText("Ratings:"+"1.5");
                t_duration.setText("20 mins");
                t_MainCast.setText("Main Cast:"+"Chris wolmer");
                break;

            case 4:
                t_rating.setText("Ratings:"+"6.5");
                t_duration.setText("60 mins");
                t_MainCast.setText("Main Cast:"+"Chris wolmer");
                break;

            case 5:
                t_rating.setText("Ratings:"+"3.5");
                t_duration.setText("90 mins");
                t_MainCast.setText("Main Cast:"+"Chris wolmer");
                break;

            case 6:
                t_rating.setText("Ratings:"+"8.5");
                t_duration.setText("120 mins");
                t_MainCast.setText("Main Cast:"+"Chris wolmer");
                break;

            case 7:
                t_rating.setText("Ratings:"+"9.5");
                t_duration.setText("110 mins");
                t_MainCast.setText("Main Cast:"+"Chris wolmer");
break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
});
        return spinner;
    }

    public Spinner getSpinner_time() {
        ArrayList<String> time_array=new ArrayList<>();

        time_array.add("10:30 am");
        time_array.add("11:00 am");
        time_array.add("1:30 am");
        time_array.add("7:00 am");
        time_array.add("9:00 am");
        ArrayAdapter<String> adapter_time=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,time_array);
spinner_time.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

movie.setTime(parent.getItemAtPosition(position).toString());
bundle.putString("TIME",Integer.toString(position));

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
});
        spinner_time.setAdapter(adapter_time);

        return spinner_time;
    }

    public ImageView getImageView_down() {
        imageView_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
      if(count>=0){
       count--;
                ticketnum.setText(Integer.toString(count));}
            }
        });

        return imageView_down;
    }

    public ImageView getImageView_up() {
        imageView_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count>=0){
                    count++;
                    ticketnum.setText(Integer.toString(count));}
            }

        });
                return imageView_up;
    }


    public Button getButton() {
     button.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
//movie.setMovie("Rampage");



Intent intent =new Intent();
intent.putExtras(bundle);
//intent=getIntent();
//intent=

//startActivityForResult(intent,0);

             setResult(RESULT_OK,intent);
             finish();
         }
     });
        return button;
    }
}
