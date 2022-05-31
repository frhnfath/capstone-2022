package com.dicoding.githubuserbeta;

import android.os.Parcel;
import android.os.Parcelable;

public class Users implements Parcelable {
    private String username, avatar, htmlUrl;
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    String getHtmlUrl() { return htmlUrl; }
    void setHtmlUrl(String htmlUrl) { this.htmlUrl = htmlUrl; }
    String getAvatar() {
        return avatar;
    }
    void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    private Users(Parcel in) {
        username = in.readString();
        avatar = in.readString();
        htmlUrl = in.readString();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(username);
        parcel.writeString(avatar);
        parcel.writeString(htmlUrl);
    }

    public static final Creator<Users> CREATOR = new Creator<Users>() {
        @Override
        public Users createFromParcel(Parcel in) {
            return new Users(in);
        }

        @Override
        public Users[] newArray(int size) {
            return new Users[size];
        }
    };

    Users() {
    }

    @Override
    public int describeContents() { return 0; }
}
