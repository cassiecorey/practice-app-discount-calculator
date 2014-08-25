package com.example.discountcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		EditText discount = (EditText) findViewById(R.id.discount);

		discount.setOnKeyListener(new EditText.OnKeyListener() {
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if((event.getAction() == KeyEvent.ACTION_DOWN) &&
						(keyCode == KeyEvent.KEYCODE_ENTER)) {
					calculateSavings(v);
					return true;
				}
				return false;
			}
		});
	}



	public void calculateSavings(View view) {
		EditText mOriginal = (EditText) findViewById(R.id.original_price);
		EditText mDiscount = (EditText) findViewById(R.id.discount);

		if(!mOriginal.getText().toString().matches("") || !mOriginal.getText().toString().matches("")){
			double original = 0;
			int discount = 0;
			original = Double.parseDouble(mOriginal.getText().toString());
			discount = Integer.parseInt(mDiscount.getText().toString());
			calculate(original, discount);
		}
	}

	private void calculate(double original, int discount) {
		double result = original - (original* (double) discount/100.0);
		String resString = String.format("%.2f", result);
		String savString = String.format("%.2f", (original-result));
		
		TextView res = (TextView) findViewById(R.id.result);
		res.setText(resString);
		
		TextView sav = (TextView) findViewById(R.id.saved_amount);
		sav.setText(savString);
	}
}
