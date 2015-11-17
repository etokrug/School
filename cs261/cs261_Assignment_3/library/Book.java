package library;

import library.Library.LibraryType;

class Book extends Item
{
	// Book specific variables
	String author;
	int nPages = 0;

	
	Book(String title, String author, int nPages, String... keywords){
		this.title = title;
		this.author = author;
		this.nPages = nPages;
		this.lType = LibraryType.Book;
		
		if (keywords.length > 0) {
			for (int i = 0; i < keywords.length; i++){
				this.kwords.add(keywords[i]);
			}
		}
	}

	public String toString() {
		String rs = String.format("\n-{0}-\n", this.lType.toString());
		rs += String.format("author:\t{0}\n", this.author);
		rs += String.format("# pages:\t{0}\n", this.nPages);
		rs += String.format("title:\t{0}\n", this.title);
		rs += "keywords:\t";		
		rs += this.returnKeyWords();
		rs += "\n\n";
		return rs;
	}
}
