package thingswithfriends.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.start_player).setOnClickListener(
                new OnClickListener() {
            public void onClick(View v) {
                startGame();
            }
        });

        findViewById(R.id.start_comp).setOnClickListener(
                new OnClickListener() {
            public void onClick(View v) {
                startGame();
            }
        });
        
        String[] values = {"a","b","c"};
        ArrayAdapter<String> valuesArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values);
        ListView games = (ListView) findViewById(R.id.listView1);
        games.setAdapter(valuesArrayAdapter);
        
    }

    private void startGame() {
        Intent i = new Intent(this, SubmissionActivity.class);
        startActivity(i);
    }
}