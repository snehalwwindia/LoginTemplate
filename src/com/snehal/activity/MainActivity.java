package com.snehal.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Button btn3 = (Button) findViewById(R.id.btn3);
        Button btn4 = (Button) findViewById(R.id.btn4);
        Button btn5 = (Button) findViewById(R.id.btn5);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        
        Intent i = new Intent(this,DemoActivity.class);
		i.putExtra("ID", R.layout.template2);
		startActivity(i);
    }

	@Override
	public void onClick(View v) {
		int id = R.layout.main;
		
		if(R.id.btn1 == v.getId())
			id = R.layout.template1;
		else if(R.id.btn2 == v.getId())
			id = R.layout.template2;
		else if(R.id.btn3 == v.getId())
			id = R.layout.template3;
		else if(R.id.btn4 == v.getId())
			id = R.layout.template4;
		else if(R.id.btn5 == v.getId())
			id = R.layout.template5;
		
		Intent i = new Intent(this,DemoActivity.class);
		i.putExtra("ID", id);
		startActivity(i);
	}    
}
