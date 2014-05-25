package thingswithfriends.main;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class SubmissionActivity extends Activity {
	
	Button sendButton = null;
	
	public void OnCreate(Bundle SavedInstanceState) {
		super.onCreate(SavedInstanceState);
		setContentView(R.layout.activity_submission);
		this.sendButton = (Button)this.findViewById(R.id.buttonSend);

	}
}