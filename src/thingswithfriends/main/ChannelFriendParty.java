package thingswithfriends.main;

import java.io.Serializable;
import java.util.ArrayList;

public class ChannelFriendParty implements Serializable {

	ArrayList<Friend> party;

	public Friend getFriend(int index) {
		return party.get(index);
	}

	public void addFriend(Friend friend) {
		party.add(friend);
	}

	public void removeFriend(Friend friend) {
		party.remove(friend);
	}

	public int size() {
		return party.size();
	}

	public ArrayList<Friend> getParty() {
		return party;
	}

	public boolean contains(int which) {
		if (party != null) {
			for (int i = 0; i < party.size(); i++) {
				if (party.get(i).equals(party.get(which))) {
					return true;
				}
			}
		}
		return false;
	}
}
