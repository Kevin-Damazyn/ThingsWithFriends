package thingswithfriends.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;


public class SubmissionActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_submission);

		findViewById(R.id.buttonSend).setOnClickListener(
				new OnClickListener() {
					public void onClick(View v) {
						submitAnswer();
					}
				});

	}
	
	private void submitAnswer() {
        Intent i = new Intent(this, AnswerActivity.class);
        startActivity(i);
    }
}