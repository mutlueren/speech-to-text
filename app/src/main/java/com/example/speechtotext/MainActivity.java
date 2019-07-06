package com.example.speechtotext;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startEvent(View view){
        //Intent farklı sınıflar arasındaki aktiviteleri birbirleri ile ilişkilendirir
        Intent intent = new Intent(this, StartEvent.class);
        startActivity(intent);
        finish();

    }

}
