package com.snehal.utility;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

/**
 * LoginUtils class contains util methods like,<p>
 * validateEmptyFields(EditText txtUser, EditText txtPass)<p>
 * toggleShowPassword(CheckBox chkTogglePass, final EditText txtPass)<p>
 * getIMEI(Context c)<p>
 * getMD5(String value)<p>
 * getPhoneNumber(Context c)<p>
 * getDate(String format, Date date)<p>
 * @author Snehal
 *
 */
public class LoginUtils {

	static String TAG = "LoginUtils";
	public static String VALID_OK = "valid_ok";
	
	
	/**
	 * Validates Login <b>userName</b> and <b>password</b> fields for zero length.
	 * @param txtUser EditText
	 * @param txtPass EditText
	 * @return true if validated else false.
	 */
	public static String validateEmptyFields(EditText txtUser, EditText txtPass){
		
		if(null == txtUser || null == txtPass){
			throw new NullPointerException("NullPointer Exception in login validation.");
		}else if(0 == txtUser.getText().toString().trim().length()){
			Log.d(TAG, "Enter Username.");
			return "Enter Username.";
		}else if(0 == txtPass.getText().toString().trim().length()){
			Log.d(TAG, "Enter Password.");
			return "Enter Password.";
		}else{
			return VALID_OK;
		}
	}
	
	
	/**
	 * Show/Hide Password in EditText
	 * @param chkTogglePass CheckBox control to show/hide password
	 * @param txtPass EditText for password
	 */
	public static void toggleShowPassword(CheckBox chkTogglePass, final EditText txtPass){
		if(null != chkTogglePass && null != txtPass){
			chkTogglePass.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
					
					@Override
					public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
						if (!isChecked) {
							txtPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
						}else{
							txtPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
						}
					}
			});
		}else{
			throw new NullPointerException("NullPointer Exception in toggle Show Password.");
		}
	}
	
	/**
	 * Get device IMEI.
	 * @param c Context
	 * @return imei Type:String
	 */
	public static String getIMEI(Context c){
		TelephonyManager telephonyManager = (TelephonyManager)c.getSystemService(Context.TELEPHONY_SERVICE);
		Log.d(TAG,""+telephonyManager.getDeviceId());
		return telephonyManager.getDeviceId();
	}
	
	/**
	 * Returns <b>MD5</b> encode of given String.
	 * @param value  String for which MD5 to be generated
	 * @return <b>md5Value</b> Type:String
	 */
	public static String getMD5(String value) {
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			try {
				digest.update(value.getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			byte messageDigest[] = digest.digest();
			StringBuffer hexString = new StringBuffer();
			int length = messageDigest.length;
			for (int i = 0; i < length; i++) {
				hexString.append(Integer.toHexString(
						(messageDigest[i] & 0xFF) | 0x100).substring(1, 3));
			}
			return hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	/**
	 * Returns device sim number.
	 * @param c Context 
	 * @return <b>phone_number</b> Type:String
	 */
	public static String getPhoneNumber(Context c)
	{
		TelephonyManager tMgr=(TelephonyManager)c.getSystemService(Context.TELEPHONY_SERVICE);
		return tMgr.getLine1Number();
	}
	
	/**
	 * Returns <b>current date</b> with <b>'yyyy-MM-dd HH:mm:ss'</b> format
	 * @return <b>date</b> Type:String
	 */
	public static String getDate() {
		String format = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(new Date());
	}
	
	/**
	 * Returns <b>given date</b> with <b>'yyyy-MM-dd HH:mm:ss'</b> format
	 * @param date Type:Date
	 * @return <b>date</b> Type:string
	 */
	public static String getDate(Date date){
		String format = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
	
	/**
	 * Returns <b>given date</b> with <b>given format</b>
	 * @param format Type:String
	 * @param date Type:Date
	 * @return <b>date</b> Type:String
	 */
	public static String getDate(String format, Date date){
		//String format = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
	
}
