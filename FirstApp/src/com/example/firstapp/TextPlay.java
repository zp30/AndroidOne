package com.example.firstapp;

import java.util.Random;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class TextPlay extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.text);
		
		Button chkCmd = (Button) findViewById(R.id.bResults);
		final ToggleButton passTog = (ToggleButton) findViewById(R.id.tbPassword);
		final EditText input = (EditText) findViewById(R.id.etCommands);
		final TextView display = (TextView) findViewById(R.id.tvResults);
		
		passTog.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(passTog.isChecked()){
					input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
				}else
				{
					input.setInputType(InputType.TYPE_CLASS_TEXT);
				}
				
			}
		});
		
		chkCmd.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String check = input.getText().toString();
				
				if(check.contentEquals("left")){
					display.setGravity(Gravity.LEFT);
				}else if(check.contentEquals("center")){
					display.setGravity(Gravity.CENTER);
				}else if(check.contentEquals("right")){
					display.setGravity(Gravity.RIGHT);
				}else if(check.contentEquals("blue")){
					display.setTextColor(Color.BLUE);
				}else if(check.contentEquals("crazy")){
					Random rand = new Random();
					display.setText("Suprise!!!!");
					display.setTextSize(rand.nextInt(75));
					display.setTextColor(Color.rgb(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
					switch(rand.nextInt(3)){
					case 0:
						display.setGravity(Gravity.LEFT);
						break;
					case 1:
						display.setGravity(Gravity.CENTER);
						break;
					case 2:
						display.setGravity(Gravity.RIGHT);
						break;
					}
				}else{
					display.setText("INVALID!!");
					display.setGravity(Gravity.CENTER);
					display.setTextColor(Color.BLACK);
				}
			}
		});
	}

	
}
