package com.example.uxim_android_1114;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<ItemList> mArrayList;
    private CustomAdapter mAdapter;
    private int count = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 이름 가져와서 추가
        TextView nameView = (TextView) findViewById(R.id.my_name);
        String name = getIntent().getStringExtra("name");
        nameView.setText(name);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_main_list);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        mArrayList = new ArrayList<>();

        mAdapter = new CustomAdapter( mArrayList);
        mRecyclerView.setAdapter(mAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mRecyclerView.getContext(),
                mLinearLayoutManager.getOrientation());
        mRecyclerView.addItemDecoration(dividerItemDecoration);

        Button buttonInsert = (Button)findViewById(R.id.button_main_insert);
        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count++;

                AlertDialog.Builder ad = new AlertDialog.Builder(MainActivity.this);

                ad.setTitle("Title");       // 제목 설정
                ad.setMessage("Message");   // 내용 설정

                // EditText 삽입하기
                final EditText et = new EditText(MainActivity.this);
                ad.setView(et);

                // 확인 버튼 설정
                ad.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        // Text 값 받아서 로그 남기기
                        String value = et.getText().toString();
                        Log.d("Hello", value);


                        ItemList data = new ItemList(count+"",value);

                        //mArrayList.add(0, data); //RecyclerView의 첫 줄에 삽입
                        mArrayList.add(data); // RecyclerView의 마지막 줄에 삽입


                        dialog.dismiss();     //닫기
                        // Event
                    }
                });

                ad.show();

                mAdapter.notifyDataSetChanged();
            }
        });
    }
}