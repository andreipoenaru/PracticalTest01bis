package ro.pub.cs.systems.pdsd.practicaltest01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01SecondaryActivity extends Activity {
	
	EditText e;
	Button ok, cancel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_secondary);
		
		e = (EditText) findViewById(R.id.editText3);
		ok = (Button) findViewById(R.id.buttonOk);
		cancel = (Button) findViewById(R.id.buttonCancel);
		
		Intent i = getIntent();
		
		if (i != null) {
			String s = i.getStringExtra("abc");
			e.setText("aici");
			
			if (s != null) {
				e.setText(s);
			}
		}
		
		ok.setOnClickListener(new Button.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				setResult(RESULT_OK, new Intent());
				finish();
			}
		});
		
		cancel.setOnClickListener(new Button.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				setResult(RESULT_CANCELED, new Intent());
				finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test01_secondary, menu);
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
}
