import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArtistController implements ArtisControllerInterface {

    static Connection con
            = DataBase.getDBConnectio();
    //create
    public int create(String name, String country) throws SQLException{
        String query="insert into artists(name, "+"country) VALUES (?,?)";

        PreparedStatement ps
                = con.prepareStatement(query);
        ps.setString(1, name);
        ps.setString(2, country);
        int n = ps.executeUpdate();
        return n;
    }
    //find by name
    public List<Artists> findByName(String name)
            throws SQLException
    {
        String query = "select * from artists where name= ?";
        PreparedStatement ps
                = con.prepareStatement(query);
        ps.setString(1,name);
        ResultSet rs = ps.executeQuery();
        List<Artists> ls = new ArrayList();

        while (rs.next()) {
            Artists artist = new Artists();
            artist.setId(rs.getInt("id"));
            artist.setName(rs.getString("name"));
            artist.setCountry(rs.getString("country"));
            ls.add(artist);
        }
        return ls;
    }
    //delete by id
    public void delete(int id)
            throws SQLException
    {
        String query
                = "delete from artists where id =?";
        PreparedStatement ps
                = con.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    //selest all artists
    public List<Artists> getArtists()
            throws SQLException
    {
        String query = "select * from artists";
        PreparedStatement ps
                = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Artists> ls = new ArrayList();

        while (rs.next()) {
            Artists emp = new Artists();
            emp.setId(rs.getInt("id"));
            emp.setName(rs.getString("name"));
            emp.setCountry(rs.getString("country"));
            ls.add(emp);
        }
        return ls;
    }
}
