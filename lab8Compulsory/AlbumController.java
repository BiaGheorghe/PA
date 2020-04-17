import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlbumController implements AlbumControllerInterface {

    static Connection con
            = DataBase.getDBConnectio();
    //create
    public int create(String name, int artist_id, int release_year) throws SQLException{
        String query="insert into albums(name, "+"artist_id,"+"release_year) VALUES (?,?,?)";

        PreparedStatement ps
                = con.prepareStatement(query);
        ps.setString(1, name);
        ps.setInt(2, artist_id);
        ps.setInt(3,release_year);
        int n = ps.executeUpdate();
        return n;
    }
    //find by Artist
    public List<Albums> findByArtist(int artist_id)
            throws SQLException
    {
        String query = "select * from albums where artist_id= ?";
        PreparedStatement ps
                = con.prepareStatement(query);
        ps.setInt(1,artist_id);
        ResultSet rs = ps.executeQuery();
        List<Albums> ls = new ArrayList();

        while (rs.next()) {
            Albums album = new Albums();
            album.setId(rs.getInt("id"));
            album.setName(rs.getString("name"));
            album.setArtist_id(rs.getInt("artist_id"));
            album.setRelease_year(rs.getInt("release_year"));
            ls.add(album);
        }
        return ls;
    }
    //delete by id
    public void delete(int id)
            throws SQLException
    {
        String query
                = "delete from albums where id =?";
        PreparedStatement ps
                = con.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
    }
    // select all albums
    public List<Albums> getAlbums()
            throws SQLException
    {
        String query = "select * from albums";
        PreparedStatement ps
                = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Albums> ls = new ArrayList();

        while (rs.next()) {
            Albums album = new Albums();
            album.setId(rs.getInt("id"));
            album.setName(rs.getString("name"));
            album.setArtist_id(rs.getInt("artist_id"));
            album.setRelease_year(rs.getInt("release_year"));
            ls.add(album);
        }
        return ls;
    }
}
