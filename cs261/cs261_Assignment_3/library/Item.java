// Each book, music album, or movie will be an instance of a subclass of this class.
// Instances of this class should not be created. Specifying it as 'abstract' ensures
// that they cannot.

package library;

import java.util.HashSet;
import java.util.Iterator;
import library.Library.LibraryType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public abstract class Item
{
	String title;
	LibraryType lType;
	
	HashSet<String> kwords = new HashSet<String>();

	// Non-abstract method for all types
	public int hashCode() {
		return this.title.hashCode();
	}
	
	public String returnKeyWords() {
		String returnString = "";
		if (!this.kwords.isEmpty()) {
			ArrayList<String> workingList = new ArrayList<String>();
			for (Iterator<String> iter = kwords.iterator(); iter.hasNext();) {
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
	
	public abstract String toString();

	public static Comparator<Item> ItemTitleComparator = new Comparator<Item>() {
		public int compare(Item item1, Item item2) {
			String ItemTitle1 = item1.title.toUpperCase();
			String ItemTitle2 = item2.title.toUpperCase();
			
			return ItemTitle1.compareTo(ItemTitle2);
		}
	};
}
