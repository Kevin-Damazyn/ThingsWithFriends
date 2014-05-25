package thingswithfriends.main;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.DialogFragment;

public class FriendListDialog extends DialogFragment {

	private ChannelFriendParty party = null;

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		ArrayList<Friend> channelUsers = new ArrayList<Friend>(); // List of
																	// people in
																	// the
																	// channel

		// just to load the array with some names
		Friend charles = new Friend("Charles35", "Charles");
		Friend kevin = new Friend("Kevin157", "Kevin");
		Friend mark = new Friend("mtabor150", "Mark");
		Friend pj = new Friend("PJ-WhatTheHey", "PJ");
		channelUsers.add(charles);
		channelUsers.add(kevin);
		channelUsers.add(mark);
		channelUsers.add(pj);

		ArrayList<String> realNames = new ArrayList();
		for (Friend f : channelUsers) {
			realNames.add(f.getRealName());
		}

		final CharSequence[] channelPeople = realNames
				.toArray(new CharSequence[channelUsers.size()]);
		// end testing

		party = new ChannelFriendParty(); // List of people selected
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		// Set the dialog title
		builder.setTitle(R.string.channelPeopleList);
		// Specify the list array, the items to be selected by default (null for
		// none),
		// and the listener through which to receive callbacks when items are
		// selected
		builder.setMultiChoiceItems(channelPeople, null,
				new DialogInterface.OnMultiChoiceClickListener() {
					@SuppressWarnings("unchecked")
					@Override
					public void onClick(DialogInterface dialog, int which,
							boolean isChecked) {
						if (isChecked) {
							// If the user checked the item, add it to the
							// selected items

							party.addFriend(party.getFriend(which));
						} else if (party.contains(which)) {
							// Else, if the item is already in the array, remove
							// it
							party.removeFriend(party.getFriend(which));
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
