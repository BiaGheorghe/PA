import java.util.List;
import java.sql.SQLException;

public interface AlbumControllerInterface {
    public int create(String name,int artist_id, int release_year)
            throws SQLException;
    public List<Albums> findByArtist(int artistId)
            throws SQLException;
    public void delete(int id)
            throws SQLException;
    public List<Albums> getAlbums()
            throws SQLException;


}
