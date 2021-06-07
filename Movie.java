package com.example.movieapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
String movie,ratings,time;

    public Movie(String movie, String ratings, String time) {
        this.movie = movie;
        this.ratings = ratings;
        this.time = time;
    }

    protected Movie(Parcel in) {
        movie = in.readString();
        ratings = in.readString();
        time = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public void setRatings(String ratings) {
        this.ratings = ratings;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public  String getMovie() {
        return movie;
    }

    public String getRatings() {
        return ratings;
    }

    public String getTime() {
        return time;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(movie);
        dest.writeString(ratings);
        dest.writeString(time);
    }
}
