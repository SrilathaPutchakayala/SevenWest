package com.sevenwest.model.program;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.sevenwest.util.DateUtil;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * Created by srilatha on 7/07/2017.
 */

public class Program {

    @SerializedName("title")
    @Expose
    String programName;

    @SerializedName("id")
    @Expose
    int programId;

    @SerializedName("synopsis")
    @Expose
    String synopsis;

    @SerializedName("start_time")
    @Expose
    String start_time;

    @SerializedName("end_time")
    @Expose
    String end_time;

    @SerializedName("imageUrl")
    @Expose
    String imageUrl;

    @SerializedName("programs")
    @Expose
    List<Program> programsList;

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public int getProgramId() {
        return programId;
    }

    public void setProgramId(int programId) {
        this.programId = programId;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<Program> getProgramsList() {

        if(programsList != null && programsList.size()>1){
            Collections.sort(programsList, new Comparator<Program>() {
                public int compare(Program o1, Program o2) {
                    return (DateUtil.parseStringDateToStringDate(o1.getStart_time(),"hh:mm a")).
                            compareTo((DateUtil.parseStringDateToStringDate(o2.getStart_time(),"hh:mm a")));
                }
            });

        }

        return programsList;
    }

    public void setProgramsList(List<Program> programsList) {
        this.programsList = programsList;
    }
}
