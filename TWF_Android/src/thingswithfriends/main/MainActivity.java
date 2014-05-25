package thingswithfriends.main;

import java.io.File;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

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

		// make sure a file called "userProfile has been created
		if (!userProfileExists()) {
			UserProfile templateProfile = new UserProfile();
			templateProfile.saveProfile(this);
			registrationPrompt();
		} else {
			UserProfile tempProf = new UserProfile();
			tempProf = tempProf.loadProfile(this);
			// if no user has signed up, then prompt with registration
			if (!tempProf.hasSignedUp()) {
				registrationPrompt();
			}
			// else {
			// setupMAdapter();
			// }
		}

		findViewById(R.id.new_game).setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				startGame();
			}
		});

		// TODO get the games from the stored games
		String[] games = { "Game1", "Game2", "Game3" };
		ArrayAdapter<String> valuesArrayAdapter = new ArrayAdapter<String>(
				this, android.R.layout.simple_list_item_1, games);
		ListView gameListView = (ListView) findViewById(R.id.listViewGames);
		gameListView.setAdapter(valuesArrayAdapter);

	}

	private void startGame() {
		Intent i = new Intent(this, SubmissionActivity.class);
		startActivity(i);
	}

	private boolean userProfileExists() {
		File directory = getFilesDir();
		File filesList[] = directory.listFiles();
		int listSize = filesList.length;
		for (int i = 0; i < listSize; i++) {
			// this will be the name of the file to hold the user info
			if (filesList[i].getName().equals("userProfile")) {
				System.out.println("There is a file with name 'userProfile' ");
				UserProfile tempProf = new UserProfile();
				tempProf = tempProf.loadProfile(this);
				if (tempProf != null) {
					System.out.println("a user has signed up = "
							+ tempProf.hasSignedUp());
				}
				return true;
			}
		}
		return false;
	}

	// creates an alert box to register for a profile
	public void registrationPrompt() {
		// custom dialog
		final Dialog dialog = new Dialog(this);
		dialog.setContentView(R.layout.register);
		dialog.setTitle("Register For Things With Friends");
		// Need 3 texts (firstName, lastName, userName)
		final EditText name = (EditText) dialog.findViewById(R.id.editTextName);
		final EditText userName = (EditText) dialog
				.findViewById(R.id.editTextUserName);
		Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);

		// if button is clicked, close the custom dialog
		dialogButton.setOnClickListener(new OnClickListener() {
			// @Override
			public void onClick(View v) {
				String inputName = name.getText().toString();
				String inputUserName = userName.getText().toString();
				if (inputName.length() == 0 | inputUserName.length() == 0) {
					return;
				} else {
					UserProfile newProfile = new UserProfile();
					newProfile.setInitialProfile(inputName, inputUserName);

					// TODO add friends for testing purposes later

					newProfile.saveProfile(v.getContext());
					UserProfile testProfile = new UserProfile();
					testProfile = testProfile.loadProfile(v.getContext());
					System.out.println("User's real name: "
							+ testProfile.getWholeName());
					System.out.println("Username: " + testProfile.getUserName());

					// TODO check below adapter
					// from top of MainActivity class...
					// ...need to put in...
					// private MainPagerAdapter mAdapter;

					// setupMAdapter();
					dialog.dismiss();
				}
			}
		});
		dialog.show();

	}

}