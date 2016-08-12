package kr.co.moon.soko_study;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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

public class Select extends Activity implements OnClickListener {

    Intent intent;
    public static ArrayList<Integer> mId;
    TextView playlist;
    String tempText;
    Button back;
    Button movie;


    ImageView menuBtn1, menuBtn2, menuBtn3, menuBtn4;
    ImageView menuBtns[] = {menuBtn1, menuBtn2, menuBtn3, menuBtn4};
    int[] menuBtnId={R.id.menu_btn1, R.id.menu_btn2, R.id.menu_btn3, R.id.menu_btn4};;
    ImageView selectBtn1,
            selectBtn2,
            selectBtn3,
            selectBtn4,
            selectBtn5,
            selectBtn6,
            selectBtn7,
            selectBtn8,
            selectBtn9,
            selectBtn10,
            selectBtn11,
            selectBtn12,
            selectBtn13,
            selectBtn14,
            selectBtn15,
            selectBtn16,
            selectBtn17,
            selectBtn18,
            selectBtn19,
            selectBtn20,
            selectBtn21,
            selectBtn22,
            selectBtn23,
            selectBtn24;
    ImageView selectBtns[] = {selectBtn1,
            selectBtn2,
            selectBtn3,
            selectBtn4,
            selectBtn5,
            selectBtn6,
            selectBtn7,
            selectBtn8,
            selectBtn9,
            selectBtn10,
            selectBtn11,
            selectBtn12,
            selectBtn13,
            selectBtn14,
            selectBtn15,
            selectBtn16,
            selectBtn17,
            selectBtn18,
            selectBtn19,
            selectBtn20,
            selectBtn21,
            selectBtn22,
            selectBtn23,
            selectBtn24};
    int[] selectBtnId = {R.id.btn1
            , R.id.btn2
            , R.id.btn3
            , R.id.btn4
            , R.id.btn5
            , R.id.btn6
            , R.id.btn7
            , R.id.btn8
            , R.id.btn9
            , R.id.btn10
            , R.id.btn11
            , R.id.btn12
            , R.id.btn13
            , R.id.btn14
            , R.id.btn15
            , R.id.btn16
            , R.id.btn17
            , R.id.btn18
            , R.id.btn19
            , R.id.btn20
            , R.id.btn21
            , R.id.btn22
            , R.id.btn23
            , R.id.btn24
    };
    int flag1;
    int flag2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select);
        Intent intent = getIntent(); // 값을 받아온다.
        flag1 = intent.getIntExtra("FLAG1",1);
        flag2 = intent.getIntExtra("FLAG2",1);

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

        // select viewstub
        ViewStub selectStub = (ViewStub) findViewById(R.id.select_container);
        String selectID = "select_" + flag2;
        int resID2 = getResources().getIdentifier(selectID, "layout", getPackageName());
        selectStub.setLayoutResource(resID2);
        View inflated2 = selectStub.inflate();

        switch (flag2) {
            case 1:
                for (int i = 0; i < 24; i++) {
                    selectBtns[i] = (ImageView) findViewById(selectBtnId[i]);
                    final int finalI = i+1;
                    selectBtns[i].setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            Intent intent = new Intent(Select.this, Content.class);
                            intent.putExtra("FLAG1", "_2");
                            intent.putExtra("FLAG2", "_1");
                            intent.putExtra("FLAG3", "_"+finalI);
                            startActivity(intent);
                        }
                    });
                }
                break;
            case 2:
                for (int i = 0; i < 9; i++) {
                    selectBtns[i] = (ImageView) findViewById(selectBtnId[i]);
                    selectBtns[i].setOnClickListener(this);
                }
                break;
            case 3:
                for (int i = 0; i < 9; i++) {
                    selectBtns[i] = (ImageView) findViewById(selectBtnId[i]);
                    selectBtns[i].setOnClickListener(this);
                }
                break;
            case 4:
                for (int i = 0; i < 24; i++) {
                    selectBtns[i] = (ImageView) findViewById(selectBtnId[i]);
                    selectBtns[i].setOnClickListener(this);
                }
                break;
            case 5:
                for (int i = 0; i < 9; i++) {
                    selectBtns[i] = (ImageView) findViewById(selectBtnId[i]);
                    selectBtns[i].setOnClickListener(this);
                }
                break;
        }


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
