package com.example.six.tellme1or0;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;

public class MainActivity extends Activity {
    private double a;
    private TextView textView;
    private Button button;
    private Timer timer;
    private Handler handler;
    private AlertDialog alert;
    private KProgressHUD hud;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        timer = new Timer();
        //handler = new Handler();
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                showAlertDialog();
                hud = KProgressHUD.create(this)
                        .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                        .setLabel("Please wait")
                        .setCancellable(true);
                scheduleDismiss();
            }
        });
    }

    private void showAlertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("please wait");
        builder.setMessage("God is conimg");
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                a = Math.random();
                while (a == 0.5) {
                    a = Math.random();
                }
                if (a < 0.5) {
                    textView.setText("0");
                } else {
                    textView.setText("1");
                }
            }
        });
        alert = builder.create();
        alert.show();

       // timer.schedule(new CloseDialogTask(),4000);
    }

   /* private class CloseDialogTask extends TimerTask{
        @Override
        public void run(){
            alert,dismiss();
        }
              handler.sendEmptyMessage(0);
        }
    }*/
//    private class MyHandler extends Handler{
//        @Override
//        public void handlerMessage(Message msg){
//            alert.dismiss();
//        }
//    }
}
