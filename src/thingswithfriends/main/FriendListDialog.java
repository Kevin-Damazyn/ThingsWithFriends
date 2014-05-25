package thingswithfriends.main;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.DialogFragment;

public class FriendListDialog extends DialogFragment {

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		ArrayList<String> channelUsers = new ArrayList<String>(); // List of people in the channel

		// just to load the array with some names
		channelUsers.add("Charles35");
		channelUsers.add("Kevin157");
		channelUsers.add("mtabor150");
		channelUsers.add("PJ-WhatTheHey");

		final CharSequence[] channelPeople = channelUsers
				.toArray(new CharSequence[channelUsers.size()]);

		// end testing

		final ArrayList mSelectedItems = new ArrayList(); // List for people selected
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		// Set the dialog title
		builder.setTitle(R.string.channelPeopleList);
		// Specify the list array, the items to be selected by default (null for none),
		// and the listener through which to receive callbacks when items are selected
		builder.setMultiChoiceItems(channelPeople, null,
				new DialogInterface.OnMultiChoiceClickListener() {
					@SuppressWarnings("unchecked")
					@Override
					public void onClick(DialogInterface dialog, int which,
							boolean isChecked) {
						if (isChecked) {
							// If the user checked the item, add it to the
							// selected items
							mSelectedItems.add(which);
						} else if (mSelectedItems.contains(which)) {
							// Else, if the item is already in the array, remove
							// it
							mSelectedItems.remove(Integer.valueOf(which));
						}
					}
				})
				// Set the action buttons
				.setPositiveButton(R.string.ok,
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int id) {
								// User clicked OK, so save the mSelectedItems
								// results somewhere
								// or return them to the component that opened
								// the dialog
								// TODO the arraylist (mSelectedItems) to
								// serializable file

								// when everything is saved...dismiss the dialog
								dialog.dismiss();
							}
						})
				.setNegativeButton(R.string.cancel,
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int id) {
								dialog.cancel();
							}
						});

		return builder.create();

	}
}
