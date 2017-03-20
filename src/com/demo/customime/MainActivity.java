package com.demo.customime;

import android.app.Activity;
import android.inputmethodservice.KeyboardView;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.EditText;

/**
 * Android development: Custom keyboard
 * 
 * 参考：http://www.fampennings.nl/maarten/android/09keyboard/index.htm
 * 
 */
public class MainActivity extends Activity {
	private KeyboardBuilder builder;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		getWindow().setSoftInputMode(
				WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

		KeyboardView keyboardView = (KeyboardView) findViewById(R.id.keyboardview);
		builder = new KeyboardBuilder(this, keyboardView, R.xml.keys_layout);

		EditText editCustomIME = (EditText) findViewById(R.id.editCustomIME);
		builder.registerEditText(editCustomIME);
	}

	@Override
	public void onBackPressed() {
		if (builder != null && builder.isCustomKeyboardVisible()) {
			builder.hideCustomKeyboard();
		} else {
			this.finish();
		}
	}
}
