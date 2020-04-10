public class Albums {
    int id;
    String name;
    int artist_id;
    int release_year;
    public Albums(){}
    public Albums(String name, int artist_id, int release_year){
        this.name=name;
        this.artist_id=artist_id;
        this.release_year=release_year;
    }

    public int getId () {
        return id;
    }

    public void setId ( int id ) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public int getArtist_id () {
        return artist_id;
    }

    public void setArtist_id ( int artist_id ) {
        this.artist_id = artist_id;
    }

    public int getRelease_year () {
        return release_year;
    }

    public void setRelease_year ( int release_year ) {
        this.release_year = release_year;
    }

    @Override
    public String toString () {
        return "Albums{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", artist_id=" + artist_id +
                ", release_year=" + release_year +
                '}';
    }
}
