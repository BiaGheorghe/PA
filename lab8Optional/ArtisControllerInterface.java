import java.util.List;
import java.sql.SQLException;

public interface ArtisControllerInterface {
    public int create(String name, String country)
        throws SQLException;
    public List<Artists> findByName(String nume)
            throws SQLException;
    public void delete(int id)
            throws SQLException;
    public List<Artists> getArtists()
            throws SQLException;

}
