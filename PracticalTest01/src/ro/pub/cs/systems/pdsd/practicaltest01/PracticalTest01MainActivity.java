package ro.pub.cs.systems.pdsd.practicaltest01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01MainActivity extends Activity {
	
	EditText e1;
	EditText e2;
	Button b1;
	Button b2;
	Button b;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_main);
		
		e1 = (EditText) findViewById(R.id.editText1);
		e2 = (EditText) findViewById(R.id.editText2);
		b1 = (Button) findViewById(R.id.button1);
		b2 = (Button) findViewById(R.id.button2);
		
		b1.setOnClickListener(new Button.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				e1.setText(Integer.toString(Integer.parseInt(e1.getText().toString()) + 1));
			}
		});
		
		b2.setOnClickListener(new Button.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				e2.setText(Integer.toString(Integer.parseInt(e2.getText().toString()) + 1));
			}
		});
		
		b = (Button) findViewById(R.id.press);
		
		b.setOnClickListener(new Button.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(PracticalTest01MainActivity.this, PracticalTest01SecondaryActivity.class);
				i.putExtra("abc", Integer.toString(Integer.parseInt(e1.getText().toString()) + Integer.parseInt(e2.getText().toString())));
				
				startActivityForResult(i, 2015);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test01_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	protected void onSaveInstanceState(Bundle b) {
		super.onSaveInstanceState(b);
		
		b.putString("e1", e1.getText().toString());
		b.putString("e2", e2.getText().toString());
	}
	
	@Override
	protected void onRestoreInstanceState(Bundle b) {
		super.onRestoreInstanceState(b);
		
		e1.setText(b.getString("e1"));
		e2.setText(b.getString("e2"));
	}
	
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		Toast.makeText(this, resultCode + "", Toast.LENGTH_LONG).show();
	}
}
