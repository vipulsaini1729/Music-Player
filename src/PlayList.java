import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

public class PlayList {

    private String title;

    private List<Song> songs;

    private ListIterator<Song> itr;

    private boolean wasNext=false;


    public PlayList(String title) {
        this.title = title;
        this.songs=new ArrayList<>();
        itr=songs.listIterator();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public String addSongFromAlbum(Album album,String songName){
        Optional<Song> songOpt=album.searchSong(songName);
        if(songOpt.isEmpty()) return "Song is not present in Album";
        Song addedSong=songOpt.get();
        this.songs.add(addedSong);
        itr=songs.listIterator();
        return "Song is added in the Playlist";
    }

    public String playNext(){
        if(wasNext){

        }
        if(!wasNext){
            wasNext=true;
            itr.next();
        }
        if(itr.hasNext()){
            wasNext=true;
            Song song= itr.next();
            return "Your next song is "+song.getName();
        }
        return "This is the last song of this Playlist";
    }
    public String playPrevious(){
        if(!wasNext){

        }
        if(wasNext){
            wasNext=false;
            itr.previous();
        }
        if(itr.hasPrevious()){
            wasNext=false;
            Song song= itr.previous();
            return "Your previous song is "+song.getName();
        }
        return "This is the First song of this Playlist";
    }
    public String playCurrent(){
        if(wasNext){
            wasNext=false;
            Song song= itr.previous();
            return "Your previous song is "+song.getName();
        }
        wasNext=true;
        return "This is the Current song of this Playlist "+itr.next().getName();
    }

    @Override
    public String toString() {
        return "PlayList{" +
                "title='" + title + '\'' +
                ", songs=" + songs +
                ", itr=" + itr +
                ", wasNext=" + wasNext +
                '}';
    }
}
