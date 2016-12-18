package com.kd.memo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.kd.memo.Service.MemoService;

public class MyDialog extends Activity {

    public static boolean active = false;
    public static Activity myDialog;

    EditText edt;
    Button btn;
    View top;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_my_dialog);

        edt = (EditText) findViewById(R.id.dialog_edt);
        btn = (Button) findViewById(R.id.dialog_btn);
        top = (View) findViewById(R.id.dialog_top);

        myDialog = MyDialog.this;

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String str = edt.getText().toString();
                if (str.length() > 0) {
//					ChatHeadService.showMsg(MyDialog.this, str);
                    Intent it = new Intent(MyDialog.this, MemoService.class);
                    it.putExtra(Utils.EXTRA_MSG, str);
                    startService(it);
                }
            }
        });


        top.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
            }
        });

    }


    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        active = true;
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        active = false;
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        active = false;
    }


}
