package com.mycompany.myapp2;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.content.res.*;
import android.view.*;
import android.view.View.*;
import android.text.format.*;
import android.text.*;
import android.text.style.*;
import android.graphics.*;

public class MainActivity extends Activity 
{
	TextView mainTv;
	EditText mainEt;
	Button submitBtn, fontBtn, sizeBtn, colorBtn, undoBtn;
	Time t = new Time();
	int dateTextSize;
	int regTextSize;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		mainTv = (TextView) findViewById(R.id.mainTextView);
		mainEt = (EditText) findViewById(R.id.mainEditText);
		
		submitBtn = (Button) findViewById(R.id.submitBtn);
		fontBtn = (Button) findViewById(R.id.fontBtn);
		sizeBtn = (Button) findViewById(R.id.sizeBtn);
		colorBtn = (Button) findViewById(R.id.colorBtn);
		undoBtn = (Button) findViewById(R.id.undoBtn);
		
		t = new Time();
		regTextSize = Integer.parseInt(getResources().getString(R.dimen.chat_text_size));
		dateTextSize = Math.round(mainTv.getTextSize() * 0.6f);
    }
	
	public void onClick(View v) {
		switch(v.getId()) {
			case R.id.submitBtn:
				String username = getResources().getText(R.string.user_name).toString();
				String timestamp = "["+getTimeNow()+"]";
				String msg = mainEt.getText().toString();
				StringBuilder sb = new StringBuilder();
				sb.append(username).append(" ")
					.append(timestamp).append("\n")
					.append(msg).append("\n");
				SpannableString nameSS =  new SpannableString(username);
				nameSS.setSpan(new RelativeSizeSpan(1.25f), 0, username.length(), 0);
				nameSS.setSpan(new TypefaceSpan(Typeface.DEFAULT_BOLD.toString()), 0, username.length(), 0);
				SpannableString timeSS =  new SpannableString(timestamp);
				timeSS.setSpan(new RelativeSizeSpan(0.9f), 0, timestamp.length(), 0); // set size
				mainTv.append(TextUtils.concat(nameSS, " ", timeSS, "\n ", msg, "\n\n"));
				mainEt.setText("");
				break;
			case R.id.fontBtn:
				
				break;
			case R.id.sizeBtn:
				
				break;
			case R.id.colorBtn:
				
				break;
			case R.id.undoBtn:
				
				break;
				
		}
	}
	
	private String getTimeNow() {
		t.setToNow();
		String amPm = t.hour < 12 ? "a" : "p";
			
		String h = String.valueOf(t.hour);
		if(h.length() < 2) 
			h = "0" + h;
		String m = String.valueOf(t.minute);
		if(m.length() < 2)
			m = "0" + m;
		String s = String.valueOf(t.second);
		if(s.length() < 2)
			s = "0" + s;
		return h+":"+m+":"+s+amPm;
	}
}
