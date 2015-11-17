package library;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import com.sun.javafx.css.StyleCacheEntry.Key;

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
	
	// Book Information
	HashMap<String, Item> bookItemsByTitle = new HashMap<String, Item>();
	HashMap<String, HashSet<Item>> bookItemsByAuthor = new HashMap<String, HashSet<Item>>();
	
	// MusicAlbum Information
	HashMap<String, Item> musicItemsByTitle = new HashMap<String, Item>();
	HashMap<String, HashSet<Item>> musicItemsByMusician = new HashMap<String, HashSet<Item>>();
	HashMap<String, HashSet<Item>> musicItemsByBand = new HashMap<String, HashSet<Item>>();
	
	// Movie Information
	HashMap<String, Item> movieItemsByTitle = new HashMap<String, Item>();
	HashMap<String, HashSet<Item>> movieItemsByDirector = new HashMap<String, HashSet<Item>>();
	HashMap<String, HashSet<Item>> movieItemsByActor = new HashMap<String, HashSet<Item>>();

	// I think of this like I would think of an index on a real DB,
	// there may be more overhead in creating and maintaining it but it'll
	// drastically reduce the search times
	private HashMap<String, HashSet<Item>> keywordItems  = new HashMap<String, HashSet<Item>>();

	// general methods
	
	// Checks if there are any kwargs
	// If there are it takes them and adds the item
	// to an internal HashSet - creating the set if the keyword has not been found yet
	private void addKeyWordItem(String[] keywords, Item newItem) {
		int kLength = keywords.length;
		if (kLength > 0) {
			for (int i = 0; i < kLength; i++){
				if (keywordItems.containsKey(keywords[i])) {
					keywordItems.get(keywords[i]).add(newItem);
				}
				else {
					HashSet<Item> newHS = new HashSet<Item>();
					newHS.add(newItem);
					keywordItems.put(keywords[i], newHS);
				}
			}
		}
	}
	
	private void addToInternalHashSet(HashMap<String, HashSet<Item>> map, Item newItem, String key) {
		if (map.containsKey(key)) {
			map.get(key).add(newItem);
		}
		else {
			HashSet<Item> set = new HashSet<Item>();
			set.add(newItem);
			map.put(key, set);
		}
	}
	
	// returns all of the items which have the specified keyword
	public HashSet<Item> itemsForKeyword(String keyword)
	{
		return keywordItems.get(keyword.hashCode());
	}
	
	// print an item from this library to the output stream provided
	public void printItem(PrintStream out, Item item)
	{
		
	}
	
	// book-related methods
	
	// adds a book to the library
	public Item addBook(String title, String author, int nPages, String... keywords)
	{
		Item newItem = new Book(title, author, nPages, keywords);
		bookItemsByTitle.put(title, newItem);
		addToInternalHashSet(bookItemsByAuthor, newItem, author);
		addKeyWordItem(keywords, newItem);
		
		return newItem;
	}
	
	// removes a book from the library
	public boolean removeBook(String title)
	{
		boolean removeByTitle = false;
		boolean removeByAuthor = false;
		
		Book bookItem = Book.class.cast(bookItemsByTitle.get(title));
		removeByAuthor = bookItemsByAuthor.get(bookItem.author).remove(bookItem);
		if (bookItemsByTitle.remove(bookItem.title) != null) {
			removeByTitle = true;
		}

		if (removeByAuthor && removeByTitle) {
			return true;
		}
		else {
			return false;
		}
	}
	
	// returns all of the books by the specified author
	public HashSet<Item> booksByAuthor(String author)
	{
		return bookItemsByAuthor.get(author);
	}
	
	// returns all of the books in the library
	public HashSet<Item> books()
	{
		HashSet<Item> newHash = new HashSet<Item>();
		Iterator<Item> iter = bookItemsByTitle.values().iterator();
		while (iter.hasNext()) {
			newHash.add(iter.next());
		}
		return newHash;
	}
	
	// music-related methods
	
	// adds a music album to the library
	public Item addMusicAlbum(String title, String band, int nSongs, String... keywords)
	{
		Item newItem = new MusicAlbum(title, band, nSongs, keywords);
		musicItemsByTitle.put(title, newItem);
		addToInternalHashSet(musicItemsByBand, newItem, band);
		addKeyWordItem(keywords, newItem);
		
		return newItem;
	}

	// adds the specified band members to a music album
	public void addBandMembers(Item album, String... members)
	{
		if (album.lType == LibraryType.Album) {
			MusicAlbum workingAlbum = MusicAlbum.class.cast(album);
			workingAlbum.AddMembers(members);
			int memberLength  = members.length;
			for (int i = 0; i < memberLength; i++) {
				addToInternalHashSet(musicItemsByMusician, album, members[i]);
			}
		}
	}
	
	// removes a music album from the library
	public boolean removeMusicAlbum(String title)
	{
		boolean removeByTitle = false;
		boolean removeByMusician = false;
		boolean removeByBand = false;
		
		MusicAlbum musicItem = MusicAlbum.class.cast(musicItemsByTitle.get(title));
		removeByBand = musicItemsByBand.get(musicItem.groupName).remove(musicItem);

		for (Iterator<String> iter = musicItem.memberSet.iterator(); iter.hasNext();) {
			removeByMusician = musicItemsByMusician.get(iter.next()).remove(musicItem);
		}
		
		if (musicItemsByTitle.remove(title) != null) {
			removeByTitle = true;
		}
		
		if (removeByTitle && removeByMusician && removeByBand) {
			return true;
		}
		else {
			return false;
		} 
	}

	// returns all of the music albums by the specified band
	public HashSet<Item> musicByBand(String band)
	{
		return musicItemsByBand.get(band);
	}
	
	// returns all of the music albums by the specified musician
	public HashSet<Item> musicByMusician(String musician)
	{
		return musicItemsByMusician.get(musician);
	}
	
	// returns all of the music albums in the library
	public HashSet<Item> musicAlbums()
	{
		HashSet<Item> newHash = new HashSet<Item>();
		Iterator<Item> iter = musicItemsByTitle.values().iterator();
		while (iter.hasNext()) {
			newHash.add(iter.next());
		}
		return newHash;
	}
	
	// movie-related methods
	
	// adds a movie to the library
	public Item addMovie(String title, String director, int nScenes, String... keywords)
	{
		Item newItem = new Movie(title, director, nScenes, keywords);
		movieItemsByTitle.put(title, newItem);
		addToInternalHashSet(movieItemsByDirector, newItem, director);
		addKeyWordItem(keywords, newItem);
		
		return newItem;
	}

	// adds the specified actors to a movie
	public void addCast(Item movie, String... members)
	{
		if (movie.lType == LibraryType.Movie) {
			Movie workingMovie = Movie.class.cast(movie);
			workingMovie.AddCast(members);
			int memberLength  = members.length;
			for (int i = 0; i < memberLength; i++) {
				addToInternalHashSet(movieItemsByActor, movie, members[i]);
			}	
		}
	}

	// removes a movie from the library
	public boolean removeMovie(String title)
	{
		boolean removeByTitle = false;
		boolean removeByActor = false;
		boolean removeByDirector = false;
		
		Movie movieItem = Movie.class.cast(movieItemsByTitle.get(title));
		removeByDirector = movieItemsByDirector.get(movieItem.directorName).remove(movieItem);
		
		for (Iterator<String> iter = movieItem.castSet.iterator(); iter.hasNext();) {
			removeByActor = movieItemsByActor.get(iter.next()).remove(movieItem);
		}
		
		if (movieItemsByTitle.remove(title) != null) {
			removeByActor = true;
		}
		
		if (removeByTitle && removeByActor && removeByDirector) {
			return true;
		}
		else {
			return false;
		} 
	}
	
	// returns all of the movies by the specified director
	public HashSet<Item> moviesByDirector(String director)
	{
		return movieItemsByDirector.get(director);
	}
	
	// returns all of the movies by the specified actor
	public HashSet<Item> moviesByActor(String actor)
	{
		return movieItemsByActor.get(actor);
	}
	
	// returns all of the movies in the library
	public HashSet<Item> movies()
	{
		HashSet<Item> newHash = new HashSet<Item>();
		Iterator<Item> iter = movieItemsByTitle.values().iterator();
		while (iter.hasNext()) {
			newHash.add(iter.next());
		}
		return newHash;
	}	
}
