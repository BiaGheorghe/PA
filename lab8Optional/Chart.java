public class Chart {
    int id;
    int artistId;
    int albumId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    @Override
    public String toString() {
        return "Chart{" +
                "id=" + id +
                ", artistId=" + artistId +
                ", albumId=" + albumId +
                '}';
    }
}
