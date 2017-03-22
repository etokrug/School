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
		String rs = String.format("-%s-\n", this.lType.toString());
		rs += String.format("%-10s%-10s\n", "author:", this.author);
		rs += String.format("%-10s%d\n", "# pages:", this.nPages);
		rs += String.format("%-10s%-10s\n", "title:", this.title);
		rs += String.format("%-10s", "keywords:");		
		rs += this.returnKeyWords();
		rs += "\n\n";
		return rs;
	}
}
