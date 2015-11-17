package library;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

import library.Library.LibraryType;

class MusicAlbum extends Item
{
	// MusicAlbum specific variables
	String groupName;
	int tracks = 0;
	
	HashSet<String> memberSet = new HashSet<String>();
	
	MusicAlbum(String title, String groupName, int tracks, String... keywords){
		this.title = title;
		this.groupName = groupName;
		this.tracks = tracks;
		this.lType = LibraryType.Album;
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
			ArrayList<String> workingList = new ArrayList<String>();
			for (Iterator<String> iter = memberSet.iterator(); iter.hasNext();) {
				workingList.add(iter.next());
			}
			Collections.sort(workingList);
			
			String addString = "";
			for (Iterator<String> iter = workingList.iterator(); iter.hasNext();) {
				addString = iter.next();
				returnString += String.format("%s%s", addString, (iter.hasNext() ? ", " : ""));	
			}
		}
		
		return returnString;
	}
	
	public String toString() {
		String rs = String.format("-Music %s-\n", this.lType.toString());
		rs += String.format("%-10s%s\n", "band:", this.groupName);
		rs += String.format("%-10s%d\n", "# songs:", this.tracks);
		rs += String.format("%-10s", "members:");
		rs += returnMembers();
		rs += "\n";
		rs += String.format("%-10s%s\n", "title:", this.title);
		rs += String.format("%-10s", "keywords:");		
		rs += this.returnKeyWords();
		rs += "\n\n";
		return rs;
	}
}
