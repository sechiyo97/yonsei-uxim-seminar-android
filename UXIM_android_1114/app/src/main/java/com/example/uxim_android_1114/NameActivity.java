package com.example.uxim_android_1114;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NameActivity extends Activity {
    /** Called when the activity is first created. */
    private EditText editText;
    private Button mInputDone;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        editText = (EditText)findViewById(R.id.edit_text);

        // 입력 완료 시 main으로
        mInputDone = (Button) findViewById(R.id.input_done);
        mInputDone.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){
                showMain();
            }
        });
    }

    public void showMain() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("name", editText.getText().toString());
        startActivity(intent);
        finish();
    }
}