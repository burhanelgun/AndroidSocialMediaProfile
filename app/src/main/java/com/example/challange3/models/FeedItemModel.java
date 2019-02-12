package com.example.challange3.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;

public class FeedItemModel{
    @SerializedName("Name")
    @Expose
    String userNameF;
    @SerializedName("FollowerCount")
    @Expose
    String numOfFollowers;
    @SerializedName("CreatedAt")
    @Expose
    String followDate;
    @SerializedName("photo")
    @Expose
    String drawable;
    ArrayList<Integer> timeArr;



    public FeedItemModel(String userNameF, String numOfFollowers, String followDate, String drawable){
        this.userNameF=userNameF;
        this.numOfFollowers=numOfFollowers;
        this.followDate=followDate;
        this.drawable=drawable;
    }


    public String getSubtractDate() {
        Calendar c = Calendar.getInstance();
        int currentYear = c.get(Calendar.YEAR);
        int currentMonth = c.get(Calendar.MONTH)+1;
        int currentDay = c.get(Calendar.DAY_OF_MONTH);
        int currentHour=c.get(Calendar.HOUR_OF_DAY);
        int currentMinute=c.get(Calendar.MINUTE);
        int currentSecond=c.get(Calendar.SECOND);

        this.timeArr=getFeedTime();


        int feedYear=timeArr.get(0);
        int feedMonth=timeArr.get(1);
        int feedDay=timeArr.get(2);
        int feedHour=timeArr.get(3);
        int feedMinute=timeArr.get(4);
        int feedSecond=timeArr.get(5);

        String subtractDate=new String();

        if(currentYear>feedYear){
            subtractDate = subtractDate+(currentYear-feedYear)+ " year";
        }
        else if(currentMonth>feedMonth){
            subtractDate=subtractDate+(currentMonth-feedMonth)+ " month";
        }
        else if(currentDay>feedDay){
            subtractDate=subtractDate+(currentDay-feedDay)+ " day";
        }
        else if(currentHour>feedHour){
            subtractDate=subtractDate+(currentHour-feedHour)+ " hour";
        }
        else if(currentMinute>feedMinute){
            subtractDate=subtractDate+(currentMinute-feedMinute)+ " minute";
        }
        else if(currentSecond>feedSecond){
            subtractDate=subtractDate+(currentSecond-feedSecond)+ " second";
        }

        return subtractDate;
    }

    public ArrayList<Integer> getFeedTime(){
        timeArr =new ArrayList<>();
        String[] separated = followDate.split("-");
        timeArr.add(Integer.parseInt(separated[0])); //feed year
        timeArr.add(Integer.parseInt(separated[1])); //feed month
        separated = separated[2].split(" ");
        timeArr.add(Integer.parseInt(separated[0])); //feed day
        separated = separated[1].split(":");
        timeArr.add(Integer.parseInt(separated[0])); //feed hour
        timeArr.add(Integer.parseInt(separated[1])); //feed minute
        timeArr.add(Integer.parseInt(separated[2])); //feed second
        return timeArr;
    }



    public String getDrawable() {
        return drawable;
    }

    public String getFollowDate() {
        return getSubtractDate();
    }

    public String getNumOfFollowers() {
        return numOfFollowers;
    }

    public String getUserNameF() {
        return userNameF;
    }

    public void setDrawable(String drawable) {
        this.drawable = drawable;
    }

    public void setFollowDate(String followDate) {
        this.followDate = followDate;
    }

    public void setNumOfFollowers(String numOfFollowers) {
        this.numOfFollowers = numOfFollowers;
    }

    public void setUserNameF(String userNameF) {
        this.userNameF = userNameF;
    }

    static class FeedByTimeComparator implements Comparator<FeedItemModel> {
        public int compare(FeedItemModel chair1, FeedItemModel chair2) {
            return Integer.parseInt(chair1.getSubtractDate().split(" ")[0]) - Integer.parseInt(chair2.getSubtractDate().split(" ")[0]);

        }

    }
    static class FeedByPopularityComparator implements Comparator<FeedItemModel> {
        public int compare(FeedItemModel chair1, FeedItemModel chair2) {
            return Integer.parseInt(chair2.getNumOfFollowers()) - Integer.parseInt(chair1.getNumOfFollowers());
        }
    }

}
