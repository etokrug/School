package library;

import java.io.PrintStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class Library
{
	
	public enum LibraryType {
		Book,
		Album,
		Movie,
		All
	}
	
	public enum LookupType {
		// General Lookups
		Title (LibraryType.All),
		Keywords (LibraryType.All),
		// Book specific enums
		Author (LibraryType.Book),
		// Album specific enums
		Band (LibraryType.Album),
		Musician (LibraryType.Album),
		// Movie specific enums
		Director (LibraryType.Movie),
		Actor (LibraryType.Movie);
		
		LibraryType mainLType;
			
		LookupType(LibraryType lType) {
			this.mainLType = lType;
		}
	}
	
	private HashSet<Item> bookItems  = new HashSet<Item>();
	private HashSet<Item> albumItems  = new HashSet<Item>();
	private HashSet<Item> movieItems  = new HashSet<Item>();
	// I think of this like I would think of an index on a real DB,
	// there may be more overhead in creating and maintaining it but it'll
	// drastically reduce the search times
	private HashMap<HashSet<Item>, Integer> keywordItems  = new HashMap<HashSet<Item>, Integer>();

	// general methods
	
	// returns all of the items which have the specified keyword
	public Collection<Item> itemsForKeyword(String keyword)
	{
		Collection<Item> items;
		
		
		return null;
	}
	
	// print an item from this library to the output stream provided
	public void printItem(PrintStream out, Item item)
	{
	}
	
	// book-related methods
	
	// adds a book to the library
	public Item addBook(String title, String author, int nPages, String... keywords)
	{
		Item newBook = new Book(title, author, nPages, keywords);
		books().add(newBook);
		return newBook;
	}
	
	// removes a book from the library
	public boolean removeBook(String title)
	{
		return false;
	}
	
	// returns all of the books by the specified author
	public Collection<Item> booksByAuthor(String author)
	{
		return null;
	}
	
	// returns all of the books in the library
	public HashSet<Item> books()
	{
		return bookItems;
	}
	
	// music-related methods
	
	// adds a music album to the library
	public Item addMusicAlbum(String title, String band, int nSongs, String... keywords)
	{
		return null;
	}

	// adds the specified band members to a music album
	public void addBandMembers(Item album, String... members)
	{
	}
	
	// removes a music album from the library
	public boolean removeMusicAlbum(String title)
	{
		return false;
	}

	// returns all of the music albums by the specified band
	public Collection<Item> musicByBand(String band)
	{
		return null;
	}
	
	// returns all of the music albums by the specified musician
	public Collection<Item> musicByMusician(String musician)
	{
		return null;
	}
	
	// returns all of the music albums in the library
	public Collection<Item> musicAlbums()
	{
		return null;
	}
	
	// movie-related methods
	
	// adds a movie to the library
	public Item addMovie(String title, String director, int nScenes, String... keywords)
	{
		return null;
	}

	// adds the specified actors to a movie
	public void addCast(Item movie, String... members)
	{
	}

	// removes a movie from the library
	public boolean removeMovie(String title)
	{
		return false;
	}
	
	// returns all of the movies by the specified director
	public Collection<Item> moviesByDirector(String director)
	{
		return null;
	}
	
	// returns all of the movies by the specified actor
	public Collection<Item> moviesByActor(String actor)
	{
		return null;
	}
	
	// returns all of the movies in the library
	public Collection<Item> movies()
	{
		return null;
	}	
}
