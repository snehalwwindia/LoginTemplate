package com.snehal.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.snehal.utility.LoginUtils;

public class DemoActivity extends Activity implements OnClickListener{

	String TAG = "DemoActivity";
	MainApp appObj;
	EditText txtUserName,txtPass;
	Button btnLogin,btnRegister;
	CheckBox chkRembrPass = null, chkShowPass = null;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		int layout_id = getIntent().getExtras().getInt("ID");
		setContentView(layout_id);
		
		appObj = new MainApp(getApplicationContext());
		
		/***********************************************/
		txtUserName = (EditText)findViewById(R.id.txtUserName);
		txtPass = (EditText)findViewById(R.id.txtPass);
		btnLogin = (Button)findViewById(R.id.btnLogin);
		btnRegister = (Button)findViewById(R.id.btnRegister);
		btnLogin.setOnClickListener(this);
		btnRegister.setOnClickListener(this);
		
		/***********************************************/
		
		/** Optional choices**/
		if(findViewById(R.id.chkRemmbrPass)!=null){
			chkRembrPass = (CheckBox)findViewById(R.id.chkRemmbrPass);
			chkRembrPass.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
				
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					appObj.getSettings().setFlagSavePassword(isChecked);
				}
			});
			if(appObj.getSettings().getFlagSavePassword())
			{
				appObj.alert("You are already logged in!");
				txtUserName.setText(appObj.getSettings().getUserName());
				txtPass.setText(appObj.getSettings().getPassword());
				chkRembrPass.setChecked(true);
			}
		}
		if(findViewById(R.id.chkShowPass)!=null){
			chkShowPass = (CheckBox)findViewById(R.id.chkShowPass);
			LoginUtils.toggleShowPassword(chkShowPass, txtPass);
		}
	}

	@Override
	public void onClick(View v) {
		if(v.getId() == R.id.btnLogin){
			
			String valid_msg =LoginUtils.validateEmptyFields(txtUserName, txtPass); 
			
			if(LoginUtils.VALID_OK.equals(valid_msg)){
				appObj.alert("You are logged in!");
				Log.d(TAG, ""+txtUserName.getText().toString());
				Log.d(TAG, ""+txtPass.getText().toString());
				Log.d(TAG,""+appObj.getSettings().getFlagSavePassword());
						
				if(appObj.getSettings().getFlagSavePassword()){
					appObj.getSettings().setUserName(txtUserName.getText().toString());
					appObj.getSettings().setPassword(txtPass.getText().toString());
					appObj.getSettings().setLoginStatus(true);
				}
			}else{
				appObj.alert(valid_msg);
			}
		}else if(v.getId() == R.id.btnRegister){
			appObj.alert("Sign Up.");
		}
	}
	
}
