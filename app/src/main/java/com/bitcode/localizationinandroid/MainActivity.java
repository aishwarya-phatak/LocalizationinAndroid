package com.bitcode.localizationinandroid;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtMessage;
    private EditText edtInfo;
    private Button btnSetData;
    Resources resources;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       txtMessage = findViewById(R.id.txtMessage);
       edtInfo = findViewById(R.id.edtInfo);
       btnSetData = findViewById(R.id.btnSetData);

       resources = getResources();
       Configuration configuration = resources.getConfiguration();


       btnSetData.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View view) {
               txtMessage.setText(edtInfo.getText().toString());
           }
       });

       if(savedInstanceState != null){

       }

       MyData myData = (MyData) getLastCustomNonConfigurationInstance();
       if(myData!=null){
           txtMessage.setText(myData.data + "updated");
       }


    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("code",101);
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Nullable
    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        MyData myData = new MyData();
        myData.data =txtMessage.getText().toString();
        return myData;
    }
}