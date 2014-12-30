package hackgt.gatech.com.exchange_o_gram;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.Button;
import android.view.View;
import android.content.Intent;

public class MainActivity extends Activity {
    private Button mSearch;
    private Button mCompose;
    private Intent composeIntent;
    private String b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        composeIntent = new Intent();
        composeIntent.setClass(this, ComposeActivity.class);
        mCompose = (Button) this.findViewById(R.id.compose_button);
        mCompose.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(composeIntent);
            }
        });
        //b = getNum();
        //Intent sendPhone = new Intent();
        //sendPhone.setClass(this, Compose.class);
        //sendPhone.putExtra("phone_number",b);
        Intent postIntent = getIntent();
    }
//    public String getNum(){
//        TelephonyManager mTelephonyMgr;
//        mTelephonyMgr = (TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE);
//        return mTelephonyMgr.getLine1Number();
//    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        Intent intent = new Intent(this, MainActivity.class);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
