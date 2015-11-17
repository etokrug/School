package library;

import java.util.HashSet;
import java.util.Iterator;

import library.Library.LibraryType;

class Movie extends Item
{
	// Movie specific variables
	String directorName;
	int scenes = 0;

	HashSet<String> castSet = new HashSet<String>();
	
	Movie(String title, String directorName, int scenes, String... keywords){
		this.title = title;
		this.directorName = directorName;
		this.scenes = scenes;
		this.lType = LibraryType.Movie;
		
		if (keywords.length > 0) {
			for (int i = 0; i < keywords.length; i++){
				this.kwords.add(keywords[i]);
			}
		}
	}

	public void AddCast(String[] cast) {
		// Thought about adding error handling in here but it
		// seemed redundant because if you pass nothing to the method it'll break anyway
		for (int i = 0; i < cast.length; i++) {
			castSet.add(cast[i]);
		}
	}
	
	String returnCast() {
		String returnString = "";
		if (!castSet.isEmpty()) {
			String addString = "";
			for (Iterator<String> iter = this.kwords.iterator(); iter.hasNext();) {
				addString = iter.next();
				returnString += String.format("%s%s", addString, (iter.hasNext() ? ", " : ""));	
			}
		}
		
		return returnString;
	}
	
	public String toString() {
		String rs = String.format("\n-%s-\n", this.lType.toString());
		rs += String.format("%-10s%s\n", "director:", this.directorName);
		rs += String.format("%-10s%s\n", "# scenes:", this.scenes);
		rs += String.format("%-10s", "cast:");
		rs += returnCast();
		rs += "\n";
		rs += String.format("%-10s%s\n", "title:", this.title);
		rs += String.format("%-10s", "keywords:");		
		rs += this.returnKeyWords();
		rs += "\n\n";
		return rs;
	}
}
