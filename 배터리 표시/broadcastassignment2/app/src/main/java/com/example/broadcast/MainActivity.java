package com.example.broadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView myText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myText = (TextView) findViewById(R.id.textView);

    }
    public void onResume() {
        super.onResume();

        IntentFilter filter = new IntentFilter();

        filter.addAction(Intent.ACTION_BATTERY_LOW);
        filter.addAction(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(receiver, filter);
    }
    @Override
    public void onPause() {
        // onPause 경우 현재 방송 수신을 unregisterReceiver를 사용해 해제
        super.onPause();
        unregisterReceiver(receiver);
    }
    BroadcastReceiver receiver = new BroadcastReceiver() {

        // onReceive는 방송이 수신되었을 때 어떻게 행동할 것인가를 정의하는 부분
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            Toast.makeText(context, action, Toast.LENGTH_LONG).show();

            myText.setText(action);

            // 두 가지 Action을 비교하여 같을 때 처리하는 작업 진행
            if(action.equals(Intent.ACTION_BATTERY_CHANGED)) {
                int maxvalue = intent.getIntExtra(BatteryManager.EXTRA_SCALE, 0);
                int value = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
                int level = value * 100 / maxvalue;

                // level은 'max value'가 최대로 충전된 양이고, 'value'는 현재의 양임임

               myText.setText(action + "\n 현재 배터리 레벨 : " + level);
            }
            else if (action.equals(Intent.ACTION_BATTERY_LOW)) {
                // 배터리 부족 메시지 띄움
                myText.setText(action +  "\n 배터리가 부족한 상황입니다.");
            }
        }
    };
}