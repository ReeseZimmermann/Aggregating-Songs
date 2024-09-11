
public class Playlist {
	private static final int MIN_CAPACITY = 3;
	private Song[] songs;
	private int numSongs;
	
	
	//default constuctors 
	public Playlist() 
	{
		this(MIN_CAPACITY);
		this.numSongs = 0;
	}
	public Playlist(int capacity) 
	{
		//if over min capacity
		if(capacity < MIN_CAPACITY) {
			capacity = MIN_CAPACITY;
		}
		this.songs = new Song[capacity];
		this.numSongs = 0;
	}
	//methods
	public int getCapacity() 
	{
		return songs.length;
	}
	public int getNumSongs()
	{
		return numSongs;
	}
	public Song getSong(int index)
	{
		if(index < 0 || index >= numSongs) 
		{
			return null;
		}
		return songs[index];
	}
	
	public Song[] getSongs()
	{
		Song[] perfectArray = new Song[numSongs];
		System.arraycopy(songs, 0, perfectArray, 0, numSongs);
		return perfectArray;
	}
	
	public boolean addSong(Song song)
	{
		return addSong(numSongs, song);
	}
	
	//>= songs index & song
	public boolean addSong(int index, Song song)
	{
		if(index < 0 || index > numSongs || 
				numSongs == songs.length || song == null) {
			return false;
		}
		// if true, shift existing songs with >= index
		for(int i = numSongs; i > index; --i) {
			songs[i] = songs[i - 1];
		}
		songs[index] = song;
		numSongs++;
		return true;
	}
	
	
	public int addSongs(Playlist playlist)
	{
		if(playlist == null || playlist.numSongs == 0 || numSongs == songs.length) {
			return 0;
		}
		//add given songs in the playlist to end of array
		int addedSongs = 0;
		for( int i = 0; i < playlist.numSongs && numSongs < songs.length; i++) {
			songs[numSongs ++] = playlist.songs[i];
			numSongs++;
			addedSongs++;
		}
		return addedSongs;
	}
	
	public Song removeSong()
	{
		if(numSongs == 0) {
			return null;
		}
		Song removedSong = songs[--numSongs];
		songs[numSongs] = null;
		return removedSong;
	}
	
	public Song removeSong(int index)
	{
		if(index < 0 || index >= numSongs) {
			return null;
		}
		Song removedSong = songs[index];
		//shift songs
		for(int i = index; i < numSongs - 1; ++i) {
			songs[i] = songs[i + 1];
		}
		songs[--numSongs] = null;
		return removedSong;
	}
	
	
}	
