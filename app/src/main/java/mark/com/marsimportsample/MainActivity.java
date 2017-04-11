package mark.com.marsimportsample;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import mark.com.stnservice.MainServiceProxy;
import mark.com.stnservice.TextTaskWrapper;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.


    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath();
        final String logPath = SDCARD + "/marssample/log";
        textView = (TextView) findViewById(R.id.sample_text);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainServiceProxy.getInstance().send(new TextTaskWrapper("wasdafafa"));
            }
        });



        // Example of a call to a native method
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
//    public native String stringFromJNI();
}
