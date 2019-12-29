
package com.example.bangladeshdivdisuppersing.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DistrictData implements Parcelable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("division_id")
    @Expose
    private String divisionId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("bn_name")
    @Expose
    private String bnName;
    @SerializedName("lat")
    @Expose
    private String lat;
    @SerializedName("lon")
    @Expose
    private String lon;
    @SerializedName("url")
    @Expose
    private String url;

    protected DistrictData(Parcel in) {
        id = in.readString();
        divisionId = in.readString();
        name = in.readString();
        bnName = in.readString();
        lat = in.readString();
        lon = in.readString();
        url = in.readString();
    }

    public static final Creator<DistrictData> CREATOR = new Creator<DistrictData>() {
        @Override
        public DistrictData createFromParcel(Parcel in) {
            return new DistrictData(in);
        }

        @Override
        public DistrictData[] newArray(int size) {
            return new DistrictData[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(String divisionId) {
        this.divisionId = divisionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBnName() {
        return bnName;
    }

    public void setBnName(String bnName) {
        this.bnName = bnName;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(divisionId);
        dest.writeString(name);
        dest.writeString(bnName);
        dest.writeString(lat);
        dest.writeString(lon);
        dest.writeString(url);
    }

    @Override
    public String toString() {
        return "DistrictData{" +
                "id='" + id + '\'' +
                ", divisionId='" + divisionId + '\'' +
                ", name='" + name + '\'' +
                ", bnName='" + bnName + '\'' +
                ", lat='" + lat + '\'' +
                ", lon='" + lon + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
