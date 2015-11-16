// Each book, music album, or movie will be an instance of a subclass of this class.
// Instances of this class should not be created. Specifying it as 'abstract' ensures
// that they cannot.

package library;

public abstract class Item
{
	String title;
	
	enum itemType {
		book,
		album,
		movie		
	}
	
	// abstract methods to be overridden will go here

}
