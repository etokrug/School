package library;

import java.util.HashSet;
import java.util.Iterator;

class MusicAlbum extends Item
{
	// MusicAlbum specific variables
	String groupName;
	int tracks = 0;
	String itemType = "Music Album";
	HashSet<String> memberSet = new HashSet<String>();
	
	MusicAlbum(String title, String groupName, int tracks, String... keywords){
		this.title = title;
		this.groupName = groupName;
		this.tracks = tracks;
		
		if (keywords.length > 0) {
			for (int i = 0; i < keywords.length; i++){
				this.kwords.add(keywords[i]);
			}
		}
	}

	public void AddMembers(String[] members) {
		// Thought about adding error handling in here but it
		// seemed redundant because if you pass nothing to the method it'll break anyway
		for (int i = 0; i < members.length; i++) {
			memberSet.add(members[i]);
		}
	}
	
	String returnMembers() {
		String returnString = "";
		if (!memberSet.isEmpty()) {
			String addString = "";
			for (Iterator<String> iter = this.kwords.iterator(); iter.hasNext();) {
				addString = iter.next();
				returnString += String.format("{0}{1}", addString, (iter.hasNext() ? ", " : ""));	
			}
		}
		
		return returnString;
	}
	
	public String toString() {
		String rs = String.format("\n-{0}-\n", this.itemType);
		rs += String.format("band:\t{0}\n", this.groupName);
		rs += String.format("# songs:\t{0}\n", this.tracks);
		rs += "members:\t";
		rs += returnMembers();
		rs += "\n";
		rs += String.format("title:\t{0}\n", this.title);
		rs += "keywords:\t";		
		rs += this.returnKeyWords();
		rs += "\n\n";
		return rs;
	}
}
