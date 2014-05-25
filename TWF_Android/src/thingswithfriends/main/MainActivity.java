package thingswithfriends.main;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends Activity {

	ListView listView;
	Button gameButton;

	public void OnCreate(Bundle SavedInstanceState) {
		super.onCreate(SavedInstanceState);
		setContentView(R.layout.activity_main);
		this.gameButton = (Button)this.findViewById(R.id.button_newgame);

		// get listview object
		listView = (ListView) findViewById(R.id.gameList);

		// listview values
		// TODO get values of games from server.
		String[] values = new String[] { "Game1", "Game2", "Game3" };

		// Adapter for list
		ArrayAdapter<String> gameListAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, android.R.id.text1, values);

		// assign adapter to listview
		listView.setAdapter(gameListAdapter);

		// ListView item click listener (Choosing a game)
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// ListView clicked item index
				int itemPosition = position;

				// Listview clicked item value
				String itemValue = (String) listView
						.getItemAtPosition(itemPosition);

			}

		});

	}
}