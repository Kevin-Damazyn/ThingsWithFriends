package thingswithfriends.main;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class AnswerActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_answer);

		TextView question = (TextView) findViewById(R.id.questionAnswer);
		question.setText("Things you don't say to a cop?");

		String[] values = { "1: Smells like bacon", "2: Oink Oink",
				"3: How was the policemans ball? Wait, I forgot police don't have balls" };
		ArrayAdapter<String> valuesArrayAdapter = new ArrayAdapter<String>(
				this, android.R.layout.simple_list_item_1, values);
		ListView games = (ListView) findViewById(R.id.answerView);
		games.setAdapter(valuesArrayAdapter);
		
		findViewById(R.id.buttonGuess).setOnClickListener(
				new OnClickListener() {
					public void onClick(View v) {

					}
				});

	}

}