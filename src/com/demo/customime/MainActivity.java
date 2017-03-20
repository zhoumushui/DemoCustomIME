package com.demo.customime;

import java.util.Random;

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

		initialKeyboard();
	}

	@Override
	public void onBackPressed() {
		if (builder != null && builder.isCustomKeyboardVisible()) {
			builder.hideCustomKeyboard();
		} else {
			this.finish();
		}
	}

	private void initialKeyboard() {
		KeyboardView keyboardView = (KeyboardView) findViewById(R.id.keyboardview);
		int keyboardLayout = getResources().getIdentifier(
				"keys_layout_" + new Random().nextInt(3), "xml",
				getPackageName());
		builder = new KeyboardBuilder(this, keyboardView, keyboardLayout);

		EditText editCustomIME = (EditText) findViewById(R.id.editCustomIME);
		builder.registerEditText(editCustomIME);

	}
}
