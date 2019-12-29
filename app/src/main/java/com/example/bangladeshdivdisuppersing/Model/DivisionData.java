
package com.example.bangladeshdivdisuppersing.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DivisionData implements Parcelable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("bn_name")
    @Expose
    private String bnName;
    @SerializedName("url")
    @Expose
    private String url;

    protected DivisionData(Parcel in) {
        id = in.readString();
        name = in.readString();
        bnName = in.readString();
        url = in.readString();
    }

    public static final Creator<DivisionData> CREATOR = new Creator<DivisionData>() {
        @Override
        public DivisionData createFromParcel(Parcel in) {
            return new DivisionData(in);
        }

        @Override
        public DivisionData[] newArray(int size) {
            return new DivisionData[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        dest.writeString(name);
        dest.writeString(bnName);
        dest.writeString(url);
    }

    @Override
    public String toString() {
        return "DivisionData{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", bnName='" + bnName + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
