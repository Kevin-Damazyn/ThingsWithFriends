package thingswithfriends.main;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
    
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.add_friends).setOnClickListener(
                new OnClickListener() {
            public void onClick(View v) {
                FriendListDialog fld = new FriendListDialog();
				fld.show(getFragmentManager(), "Friend List Channel");
            }
        });

        findViewById(R.id.new_game).setOnClickListener(
                new OnClickListener() {
            public void onClick(View v) {
                startGame(false);
            }
        });
        
        //TODO get the games from the stored games
        String[] games = {"Game1","Game2","Game3"};
        ArrayAdapter<String> valuesArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, games);
        ListView gameListView = (ListView) findViewById(R.id.listView1);
        gameListView.setAdapter(valuesArrayAdapter);
        
    }

	private void startGame(boolean startWithHuman) {
        /*Intent i = new Intent(this, GameActivity.class);
        i.putExtra(GameActivity.EXTRA_START_PLAYER,
                startWithHuman ? State.PLAYER1.getValue() : State.PLAYER2.getValue());
        startActivity(i);*/
    }
}