package kr.co.moon.soko_study;

import java.util.ArrayList;

import kr.co.moon.soko_study.OnSwipeTouchListener;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
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
    ArrayList<Integer> contentImageIdList;
    Intent intent;
    public static ArrayList<Integer> mId;
    TextView playlist;
    String tempText;
    Button back;
    Button movie;
    ImageView menuBtn1, menuBtn2, menuBtn3, menuBtn4;
    ImageView menuBtns[] = {menuBtn1, menuBtn2, menuBtn3, menuBtn4};
    int[] menuBtnId = {R.id.menu_btn1, R.id.menu_btn2, R.id.menu_btn3, R.id.menu_btn4};


    ImageView content;

    int flag1;
    int flag2;
    int flag3;
    int nowIndex;
    int contentNum;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content);
        Intent intent = getIntent(); // 값을 받아온다.
        flag1 = intent.getIntExtra("FLAG1", 0);
        flag2 = intent.getIntExtra("FLAG2", 0);
        flag3 = intent.getIntExtra("FLAG3", 0);
        contentImageIdList = new ArrayList<Integer>();
        String contentPreWord;
        if (flag1 == 1) {
            contentNum = 3;
        } else if (flag1 == 2) {
            if (flag2 == 1) {
                contentNum = 24;
            }
            if (flag2 == 2) {
                contentNum = 9;

            }
            if (flag2 == 3) {

                contentNum = 9;
            }
        } else if (flag1 == 4) {
            contentNum = 9;

        }
        String tempStr = "content_" + flag1 + "_" + flag2 + "_";
        for (int i = 0; i < contentNum; i++) {
            int contentResIdList = getResources().getIdentifier(tempStr + (i + 1), "drawable", getPackageName());
            contentImageIdList.add(contentResIdList);
        }
        nowIndex = flag3 - 1;


        // header viewstub
        ViewStub headStub = (ViewStub) findViewById(R.id.header_container);
        String headID = "head_" + flag1;
        int resID = getResources().getIdentifier(headID, "layout", getPackageName());
        headStub.setLayoutResource(resID);
        View inflated = headStub.inflate();
        for (int i = 0; i < 4; i++) {
            menuBtns[i] = (ImageView) findViewById(menuBtnId[i]);
            menuBtns[i].setOnClickListener(this);
        }

        String contentID = "content";
        if (flag1 != 0)
            contentID += "_" + flag1;
        if (flag2 != 0)
            contentID += "_" + flag2;
        if (flag3 != 0)
            contentID += "_" + flag3;


        int contentResID = getResources().getIdentifier(contentID, "drawable", getPackageName());
        Log.d("ss", contentID);

        content = (ImageView) findViewById(R.id.content_image);
        content.setImageResource(contentResID);
        content.setOnTouchListener(new OnSwipeTouchListener(this) {
            public void onSwipeTop() {
            }

            public void onSwipeRight() {
                if (nowIndex != 0)
                    content.setImageResource(contentImageIdList.get(--nowIndex));
                Log.d("ss", "now index" + nowIndex);
            }

            public void onSwipeLeft() {
                if (nowIndex != contentNum - 1)
                    content.setImageResource(contentImageIdList.get(++nowIndex));
                Log.d("ss", "now index" + nowIndex);
            }

            public void onSwipeBottom() {
            }

            public void OnDown() {
                Intent intent = new Intent(Content.this, M1.class);
                intent.putExtra("PLAY", 1);
                startActivity(intent);
                Log.d("ss","down");
            }
        });


    }

    private void initHead() {
    }


    public void onClick(View v) {
        // TODO Auto-generated method stub
        if (flag1 == 1) {
            switch (v.getId()) {
                case R.id.menu_btn1:
                    content.setImageResource(R.drawable.content_1_1_1);

                    break;
                case R.id.menu_btn2:
                    content.setImageResource(R.drawable.content_1_1_2);
                    break;
                case R.id.menu_btn3:
                    finish();
                    break;
                case R.id.menu_btn4:
                    content.setImageResource(R.drawable.content_1_1_3);
                    break;

            }
        }


        if (flag1 == 2) {
            switch (v.getId()) {
                case R.id.menu_btn1:
                    intent = new Intent(this, Select.class);
                    intent.putExtra("FLAG1", 2);
                    intent.putExtra("FLAG2", 1);
                    startActivity(intent);
                    finish();
                    break;
                case R.id.menu_btn2:
                    intent = new Intent(this, Select.class);
                    intent.putExtra("FLAG1", 2);
                    intent.putExtra("FLAG2", 2);
                    startActivity(intent);
                    finish();
                    break;
                case R.id.menu_btn3:

                    finish();
                    break;
                case R.id.menu_btn4:
                    intent = new Intent(this, Select.class);
                    intent.putExtra("FLAG1", 2);
                    intent.putExtra("FLAG2", 3);
                    startActivity(intent);
                    finish();
                    break;

            }
        }

        if (flag1 == 3) {
            switch (v.getId()) {

                case R.id.menu_btn3:

                    finish();
                    break;


            }
        }

        if (flag1 == 4) {
            switch (v.getId()) {
                case R.id.menu_btn1:
                    intent = new Intent(this, Select.class);
                    intent.putExtra("FLAG1", 4);
                    intent.putExtra("FLAG2", 5);
                    startActivity(intent);
                    finish();
                    break;
                case R.id.menu_btn3:

                    finish();
                    break;


            }
        }
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
