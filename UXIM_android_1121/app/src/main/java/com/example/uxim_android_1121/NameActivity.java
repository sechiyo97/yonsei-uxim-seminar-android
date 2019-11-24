package com.example.uxim_android_1121;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NameActivity extends Activity {
    /** Called when the activity is first created. */
    private EditText mEditText;
    private Button mInputDone;
    private SharedPreferences appData;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        mEditText = (EditText)findViewById(R.id.edit_text);
        // 설정값 객체 불러오기
        appData = getSharedPreferences("appData", MODE_PRIVATE);
        // 설정값 가져오기
        String name = appData.getString("NAME", "없음"); // 데이터 없는 경우 가져옴
        mEditText.setText(name);

        // 입력 완료 시 main으로
        mInputDone = (Button) findViewById(R.id.input_done);
        mInputDone.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){
                // 설정값 객체 불러오기
                appData = getSharedPreferences("appData", MODE_PRIVATE);
                // SharedPreferences 객체만으론 저장 불가능 Editor 사용
                SharedPreferences.Editor editor = appData.edit();
                // 에디터객체.put타입( 저장시킬 이름, 저장시킬 값 )
                // 저장시킬 이름이 이미 존재하면 덮어씌움
                editor.putString("NAME", mEditText.getText().toString()); // String 타입이므로 putString 사용
                editor.putBoolean("FIRST",false);
                // apply, commit 을 안하면 변경된 내용이 저장되지 않음
                editor.apply();
                showMain();
            }
        });
    }

    public void showMain() {
        Intent intent = new Intent(this, MainActivity.class);
        //intent.putExtra("name", editText.getText().toString());
        startActivity(intent);
        finish();
    }
}