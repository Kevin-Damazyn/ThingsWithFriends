package thingswithfriends.main;


import java.io.File;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.start_player).setOnClickListener(
                new OnClickListener() {
            public void onClick(View v) {
                startGame(true);
            }
        });

        findViewById(R.id.start_comp).setOnClickListener(
                new OnClickListener() {
            public void onClick(View v) {
                startGame(false);
            }
        });
        
        String[] values = {"a","b","c"};
        ArrayAdapter<String> valuesArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values);
        ListView games = (ListView) findViewById(R.id.listView1);
        games.setAdapter(valuesArrayAdapter);
        
    }

    private void startGame(boolean startWithHuman) {
        /*Intent i = new Intent(this, GameActivity.class);
        i.putExtra(GameActivity.EXTRA_START_PLAYER,
                startWithHuman ? State.PLAYER1.getValue() : State.PLAYER2.getValue());
        startActivity(i);*/
    }
    
    private boolean userProfileExists(){
    	File directory = getFilesDir();
    	File filesList[] = directory.listFiles();
    	int listSize = filesList.length;
    	for (int i = 0; i < listSize; i++){
    		//this will be the name of the file to hold the user info
    		if (filesList[i].getName().equals("userProfile")) {
    			System.out.println("There is a file with name 'userProfile' ");
    			UserProfile tempProf = new UserProfile();
    			tempProf = tempProf.loadProfile(this);
    			if (tempProf != null) {
    				System.out.println("a user has signed up = " + tempProf.hasSignedUp()); 
    			}
    			return true;
    		}
    	}
    	return false;
    }
    
    //creates an alert box to register for a profile
    public void registrationPrompt(){
    	//custom dialog
    	final Dialog dialog = new Dialog(this);
    	dialog.setContentView(R.layout.register);
    	dialog.setTitle("Register For Things With Friends");
    	// Need 3 texts (firstName, lastName, userName)
    	final EditText text1 = (EditText) dialog.findViewById(R.id.editText1);
    	final EditText text2 = (EditText) dialog.findViewById(R.id.editText2);
    	final EditText text3 = (EditText) dialog.findViewById(R.id.editText3);
    	Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
    	
    	//if button is clicked, close the custom dialog
    	dialogButton.setOnClickListener(new OnClickListener() {
    		//@Override
    		public void onClick(View v) {
    			String firstName = text1.getText().toString();
    			String lastName = text2.getText().toString();
    			String userName = text3.getText().toString();
    			if (firstName.length() == 0 | lastName.length() == 0 | userName.length() == 0) {
    				return;
    			}
    			else {
    				UserProfile newProfile = new UserProfile();
    				newProfile.setInitialProfile(firstName, lastName, userName);
    				//TODO add friends for testing purposes later
    				
    				newProfile.saveProfile(v.getContext());
    				UserProfile testProfile = new UserProfile();
    				testProfile = testProfile.loadProfile(v.getContext());
    				System.out.println("User's real name: " + testProfile.getWholeName());
    				System.out.println("Username: " + testProfile.getUserName());
    				
    				//TODO check below adapter
    				//from top of MainActivity class...
    				// ...need to put in...
    				//private MainPagerAdapter mAdapter;
    				
    				//setupMAdapter(); 
    				dialog.dismiss();
    			}
    		}
    	});
    	dialog.show();
    }
    
    
    
}