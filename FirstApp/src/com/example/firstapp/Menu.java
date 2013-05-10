package com.example.firstapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity {

	String classes[] = {"MainActivity","TextPlay","Email","example3",
			"example4","example5","example6"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1, classes));
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		
		super.onListItemClick(l, v, position, id);
		String menuPos = classes[position];
		try {
			Class classOne = Class.forName("com.example.firstapp." + menuPos);
			Intent openMain = new Intent(Menu.this, classOne);
			startActivity(openMain);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}


	
}
