package com.dicoding.githubuser2;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    private String username, avatar, url;
    public String getUsername() { return username;}
    public void setUsername(String username) { this.username = username;}
    String getAvatar() {return avatar;}
    void setAvatar(String avatar) {this.avatar = avatar;}
    String getUrl() {return url;}
    void setUrl(String url) {this.url = url;}

    User() {
    }

    private User(Parcel in) {
        username = in.readString();
        avatar = in.readString();
        url = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(username);
        dest.writeString(avatar);
        dest.writeString(url);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
