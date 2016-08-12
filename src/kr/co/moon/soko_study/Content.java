package kr.co.moon.soko_study;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Content extends Activity implements OnClickListener {

    Intent intent;
    public static ArrayList<Integer> mId;
    TextView playlist;
    String tempText;
    Button back;
    Button movie;
    ImageView menuBtn1, menuBtn2, menuBtn3, menuBtn4;
    ImageView menuBtns[] = {menuBtn1, menuBtn2, menuBtn3, menuBtn4};
    int[] menuBtnId = {R.id.menu_btn1, R.id.menu_btn2, R.id.menu_btn3, R.id.menu_btn4};
    ;

    ImageView content;

    String flag1;
    String flag2;
    String flag3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content);
        Intent intent = getIntent(); // 값을 받아온다.
        flag1 = intent.getStringExtra("FLAG1");
        flag2 = intent.getStringExtra("FLAG2");
        flag3 = intent.getStringExtra("FLAG3");

        // header viewstub
        ViewStub headStub = (ViewStub) findViewById(R.id.header_container);
        String headID = "head" + flag1;
        int resID = getResources().getIdentifier(headID, "layout", getPackageName());
        headStub.setLayoutResource(resID);
        View inflated = headStub.inflate();
        for (int i = 0; i < 4; i++) {
            menuBtns[i] = (ImageView) findViewById(menuBtnId[i]);
            menuBtns[i].setOnClickListener(this);
        }

        String contentID= "content" + flag1+flag2+flag3;
        int contentResID = getResources().getIdentifier(contentID, "drawable", getPackageName());
        Log.d("ss",contentID);

        content = (ImageView) findViewById(R.id.content_image);
        content.setImageResource(contentResID);


        intent = new Intent(this, M1.class);
        intent.putExtra("BOOL", 2);
    }

    private void initHead() {
    }

    public void onClick(View v) {
        // TODO Auto-generated method stub

        switch (v.getId()) {
            case R.id.menu_btn1:
                Toast.makeText(getApplicationContext(), "1", Toast.LENGTH_SHORT).show();
                break;
//            case R.id.imageButton17:
//                mId.add(17);
//                break;
//            case R.id.imageButton18:
//                mId.add(18);
//                break;
//
//            case R.id.btn_back:
//                mId.remove(mId.size() - 1);
//                break;
//            case R.id.btn_movie:
//                startActivity(new Intent(this, M2.class));
//                break;
        }
//        tempText = "";
//        for (int i = 0; i < mId.size(); i++) {
//            if (i == 0)
//                tempText += String.valueOf(mId.get(i));
//            else
//                tempText += String.valueOf("->" + mId.get(i));
//        }
//        playlist.setText(tempText);
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
//        mId.clear();
        tempText = "";
//        for (int i = 0; i < mId.size(); i++) {
//            if (i == 0)
//                tempText += String.valueOf(mId.get(i));
//            else
//                tempText += String.valueOf("->" + mId.get(i));
//        }
//        playlist.setText(tempText);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
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
