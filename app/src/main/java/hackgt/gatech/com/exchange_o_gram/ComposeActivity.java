package hackgt.gatech.com.exchange_o_gram;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import java.io.File;
import java.util.ArrayList;
import android.util.Log;
import android.view.MotionEvent;

import android.os.Environment;

public class ComposeActivity extends Activity {

    private Button mComposeButton;
    private static final int CAMERA_REQUEST = 1888;
    private ImageView imageV;
    private EditText myDes;
    private EditText myTitle;
    private EditText myPrice;
    private Button mPicButton;
    private Button mPostButton;
    private Bitmap photo;
    private ArrayList<Compose> allEntries = new ArrayList();
    private static final String TAG = ComposeActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose);
        Intent composeIntent = getIntent();
        mPicButton = (Button) this.findViewById(R.id.photobutton);
        imageV = (ImageView) this.findViewById(R.id.ObjectPicture);
        mPicButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);

                startActivityForResult(cameraIntent, 1);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });
        String inputText, InputTextt, InputTextp;
        myDes = (EditText) this.findViewById(R.id.description);
        inputText = myDes.getText().toString();
        myTitle = (EditText) this.findViewById(R.id.title);
        InputTextt = myTitle.getText().toString();
        myPrice = (EditText) this.findViewById(R.id.price);
        InputTextp = myPrice.getText().toString();
        //textView.setText(inputText);
        mPostButton = (Button) this.findViewById((R.id.generate));
        final Intent postIntent = new Intent();
        postIntent.setClass(this, MainActivity.class);
        mPostButton.setOnClickListener(new View.OnClickListener(){
            @Override
        public void onClick(View v) {
            allEntries.add(new Compose(myDes.toString(), myTitle.toString(), photo, myPrice.toString()));
            startActivity(postIntent);

        };
    });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
            photo = (Bitmap) data.getExtras().get("data");
            //photo = BitmapFactory.decodeStream(this.getContentResolver().openInputStream(imageFilePath), null);
            //slikaa.setImageBitmap(pic);
            //imageV.setImageBitmap(photo);
            //imageV = (ImageView) this.findViewById(R.id.ObjectPicture);
            imageV.setImageBitmap(photo);
        }
    }
        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.compose, menu);
        return true;
    }
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        Log.i(TAG, "onInterceptTouchEvent");
        int action = ev.getActionMasked();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                Log.i(TAG, "onInterceptTouchEvent.ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i(TAG, "onInterceptTouchEvent.ACTION_MOVE");
                break;
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                Log.i(TAG, "onInterceptTouchEvent.ACTION_UP");
                break;
        }
        return super.onTouchEvent(ev);
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
