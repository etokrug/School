// Each book, music album, or movie will be an instance of a subclass of this class.
// Instances of this class should not be created. Specifying it as 'abstract' ensures
// that they cannot.

package library;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public abstract class Item
{
	String title;
	String itemType;
	
	HashSet<String> kwords = new HashSet<String>();

	// Non-abstract method for all types
	public int hashCode() {
		String hashString = title + itemType;
		return hashString.hashCode();
	}
	
	public String returnKeyWords() {
		String returnString = "";
		if (!this.kwords.isEmpty()) {
			String addString = "";
			for (Iterator<String> iter = this.kwords.iterator(); iter.hasNext();) {
				addString = iter.next();
				returnString += String.format("{0}{1}", addString, (iter.hasNext() ? ", " : ""));	
			}
		}
		
		return returnString;
	}
	
	public abstract String toString();
}
