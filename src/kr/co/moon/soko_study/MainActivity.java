package kr.co.moon.soko_study;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class MainActivity extends Activity implements OnClickListener {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView btn0 = (ImageView) findViewById(R.id.btn0);
        btn0.setOnClickListener(this);
        ImageView btn1 = (ImageView) findViewById(R.id.btn1);
        btn1.setOnClickListener(this);
        ImageView btn2 = (ImageView) findViewById(R.id.btn2);
        btn2.setOnClickListener(this);
        ImageView btn3 = (ImageView) findViewById(R.id.btn3);
        btn3.setOnClickListener(this);

    }

    public void onClick(View v) {
        Intent intent;
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.btn0:
                intent = new Intent(this, Content.class);
                intent.putExtra("FLAG1", 1);
                intent.putExtra("FLAG2", 1);
                intent.putExtra("FLAG3", 1);
                startActivity(intent);
                break;
            case R.id.btn1:
                intent = new Intent(this, Select.class);
                intent.putExtra("FLAG1", 2);
                intent.putExtra("FLAG2", 1);
                startActivity(intent);
                break;
            case R.id.btn2:
                intent = new Intent(this, Select.class);
                intent.putExtra("FLAG1", 3);
                intent.putExtra("FLAG2", 4);
                startActivity(intent);
                break;
            case R.id.btn3:
                intent = new Intent(this, Select.class);
                intent.putExtra("FLAG1", 4);
                intent.putExtra("FLAG2", 5);
                startActivity(intent);
                break;
            case R.id.btn4:
                intent = new Intent(this, Select.class);
                intent.putExtra("FLAG1", 5);
                intent.putExtra("FLAG2", 1);
                startActivity(intent);
                break;
            case R.id.btn5:
                //web
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            System.exit(0);
            // TODO Auto-generated method stub

        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
