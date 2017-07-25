package sample;

import java.util.LinkedList;

/**
 * Created by Adonay on 3/30/2017.
 */
public class Clock {

    private int hours, minutes, day, year;
    private String month;
    private String[] monthsList = {"JAN","FEB", "MAR", "APR", "MAY","JUN", "JUL", "AUG","SEP","OCT", "NOV", "DEC"};
    private int monthCounter;

    public Clock (){
        year = 97;
        month = "SEP";
        day = 20;
        hours = 06;
        minutes = 57;
        monthCounter = 8;
    }

    public void updateClockObject(int yr, int mnth, int dy, int hr, int min){
        if(yr >= 0 && yr <= 99){
            year = yr;
        }else{
            year = 0;
        }

        if(mnth >= 0 && mnth <= 11){
            month = monthsList[mnth];
            monthCounter = mnth;
        }else{
            month = monthsList[0];
            monthCounter = 0;
        }

        if((monthCounter == 0 || monthCounter == 2 || monthCounter == 4 || monthCounter == 6 ||
                monthCounter == 7 || monthCounter == 9 || monthCounter == 11)
                && dy >= 1 && dy <= 31){
            day = dy;
        }else if ((monthCounter == 3 || monthCounter == 5 || monthCounter == 4 ||
                monthCounter == 8 || monthCounter == 10)
                && dy >= 1 && dy <= 30){
            day = dy;
        }else if (monthCounter == 1 && dy >= 1 && dy <= 28){
            day = dy;
        }else{
            day = 1;
        }

        if(hr >= 0 && hr <= 24){
            hours = hr;
        }else{
            hours = 0;
        }

        if(min >= 0 && min < 60){
            minutes = min;
        }else{
            minutes = 0;
        }

    }

    /*@Override
    public String toString(){
        String result;

        result = month +(" ") + String.format("%02d", day) +("-") + String.format("%02d", year)
                + ("\n") +  String.format("%02d", hours) + (":") + String.format("%02d", minutes);

        return result;
    }*/

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getDay() {
        return day;
    }

    public int getYear() {
        return year;
    }

    public int getMonthCounter() {
        return monthCounter;
    }

    public String getMonth(){
        return month;
    }
}
