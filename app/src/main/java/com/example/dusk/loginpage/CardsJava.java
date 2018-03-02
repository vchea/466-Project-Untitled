package com.example.dusk.loginpage;

/**
 * Created by Jared Fipps on 2/25/2018.
 */

public class CardsJava {
    private String mText1;
    private String mHour;
    private String mMinute;

    public CardsJava(String Text1, String hour, String minute)
    {
        mText1 = Text1;
        mHour = hour;
        mMinute = minute;
    }

    public String getTitleText () {
        return mText1;
    }
    public String getMHour () {
        return mHour;
    }
    public String getMMinute () {
        return mMinute;
    }
}
