package com.yctc.myzxing;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.king.zxing.CameraScan;
import com.king.zxing.CaptureActivity;

/**
 *CaptureActivity
 *CaptureFragment
 */
public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_SCAN = 0X01;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_main);
        startActivityForResult(new Intent(this, CaptureActivity.class), REQUEST_CODE_SCAN);
    }

    private void showToast(String result) {
        TextView textView = findViewById(R.id.text);
        textView.setText(result);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null) {
            switch (requestCode) {
                case REQUEST_CODE_SCAN:
                    String result = CameraScan.parseScanResult(data);
                    showToast(result);
                    break;
            }
        }
    }
}