import java.util.Arrays;
//base class
public class Song extends Playlist{
	private String title;
	private String artist;
	private int [] time;
	
	//default constructor Song()
	public Song(String title, String artist, int[] time){
		super();
		this.title = title;
		this.artist = artist;
		//copy of to keep immutability
		this.time = Arrays.copyOf(time, time.length);
	}
	//public String getTitle() method
	public String getTitle() {
		return title;
	}
	//public String getArtist() method
	public String getArtist() {
		return artist;
	}
	//public int[] getTime() method
	//access private time to return using copyOf
	public int[] getTime() {
		return Arrays.copyOf(time,  time.length);
	}
	
	
}
