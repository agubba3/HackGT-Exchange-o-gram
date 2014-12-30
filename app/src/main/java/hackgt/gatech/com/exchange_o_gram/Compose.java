package hackgt.gatech.com.exchange_o_gram;

/**
 * Created by Anirudh on 9/20/2014.
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.media.Image;
import android.telephony.TelephonyManager;
import android.content.Context;
import android.provider.Settings.Secure;
import android.content.Intent;
import android.os.Bundle;


public class Compose {
    private String myDescription;
    private String myTitle;
    private Bitmap myPic;
    private double myPrice;
    private String myPhone;

    public Compose(String d, String t, Bitmap p, String pr){
        myDescription = d;
        myTitle = t;
        myPic = p;
        myPrice = Integer.parseInt(pr);
    }
    public String getMyDescription() {
        return myDescription;
    }
    public void setMyDescription(String myDescription) {
        this.myDescription = myDescription;
    }
    public String getMyTitle() {
        return myTitle;
    }
    public void setMyTitle(String myTitle) {
        this.myTitle = myTitle;
    }
    public Bitmap getMyPic() {
        return myPic;
    }
    public void setMyPic(Bitmap myPic) {
        this.myPic = myPic;
    }
//    public String getMyPhone() {
//        Intent sendPhone = getIntent();
//        Bundle extras = getIntent().getExtras();
//        myPhone = extras.getString("phone_number");
//    }
}


