package thingswithfriends.main;

import java.io.Serializable;

public class Friend implements Serializable {

	private String userName;
	private String realName;

	public Friend(String userName, String realName) {
		this.userName = userName;
		this.realName = realName;
	}

	public String getUserName() {
		return userName;
	}

	public String getRealName() {
		return realName;
	}
	
	public boolean equals(Friend friend) {
		if (this.getUserName().equals(friend.getUserName()) &&
				this.getRealName().equals(friend.getRealName())) {
			return true;
		}else {
			return false;
		}
	}
	
}
