
package com.example.bangladeshdivdisuppersing.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class District {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("version")
    @Expose
    private String version;
    @SerializedName("comment")
    @Expose
    private String comment;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("database")
    @Expose
    private String database;
    @SerializedName("data")
    @Expose
    private List<DistrictData> data = null;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public List<DistrictData> getData() {
        return data;
    }

    public void setData(List<DistrictData> data) {
        this.data = data;
    }

}
