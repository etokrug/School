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
				returnString += String.format("{0}{1}", addString, (iter.hasNext() ? ", " : ""));	
			}
		}
		
		return returnString;
	}
	
	public String toString() {
		String rs = String.format("\n-{0}-\n", this.lType.toString());
		rs += String.format("director:\t{0}\n", this.directorName);
		rs += String.format("# scenes:\t{0}\n", this.scenes);
		rs += "cast:\t";
		rs += returnCast();
		rs += "\n";
		rs += String.format("title:\t{0}\n", this.title);
		rs += "keywords:\t";		
		rs += this.returnKeyWords();
		rs += "\n\n";
		return rs;
	}
}
