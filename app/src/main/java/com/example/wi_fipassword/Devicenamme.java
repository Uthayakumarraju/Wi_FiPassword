package com.example.wi_fipassword;

import android.os.Parcel;
import android.os.Parcelable;

class Devicenamme implements Parcelable {
    String devicename,devicebssid,capabilities,frequency,timestamp,venuname,level;
    protected Devicenamme(Parcel in) {
        in.writeString(devicename);
        in.writeString(devicebssid);
        in.writeString(capabilities);
        in.writeString(frequency);
        in.writeString(timestamp);
        in.writeString(level);

    }

    public static final Creator<Devicenamme> CREATOR = new Creator<Devicenamme>() {
        @Override
        public Devicenamme createFromParcel(Parcel in) {
            return new Devicenamme(in);
        }

        @Override
        public Devicenamme[] newArray(int size) {
            return new Devicenamme[size];
        }
    };

    public Devicenamme(String ssid, String bssid, String capabilities, int frequency, long timestamp, int level) {
        this.devicename=ssid;
        this.devicebssid=bssid;
        this.capabilities=capabilities;
        this.frequency=""+frequency;
        this.timestamp=""+timestamp;
        this.level=""+level;


    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(devicename);
        dest.writeString(devicebssid);
        dest.writeString(capabilities);
        dest.writeString(frequency);
        dest.writeString(timestamp);
        dest.writeString(level);

    }
}
