package library;

class Book extends Item
{
	// Book specific variables
	String author;
	int nPages = 0;
	String itemType = "Book";
	
	Book(String title, String author, int nPages, String... keywords){
		this.title = title;
		this.author = author;
		this.nPages = nPages;
		
		if (keywords.length > 0) {
			for (int i = 0; i < keywords.length; i++){
				this.kwords.add(keywords[i]);
			}
		}
	}

	public String toString() {
		String rs = String.format("\n-{0}-\n", this.itemType);
		rs += String.format("author:\t{0}\n", this.author);
		rs += String.format("# pages:\t{0}\n", this.nPages);
		rs += String.format("title:\t{0}\n", this.title);
		rs += "keywords:\t";		
		rs += this.returnKeyWords();
		rs += "\n\n";
		return rs;
	}
}
