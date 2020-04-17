import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChartController {
    String name = "";
    static Connection con
            = DataBase.getDBConnectio();
    ArtistController artistController = new ArtistController();

    public ChartController() throws SQLException {
    }

    List<Artists> lsAllArt = artistController.getArtists();

    public void create(Albums albums) throws SQLException {
        String query = "insert into charts(albums_id, " + "artists_id," + "albums_name," + "charts.rank) VALUES (?,?,?,?)";

        PreparedStatement ps
                = con.prepareStatement(query);
        int n;
        for (Artists a : lsAllArt) {
            if (a.getId() == albums.getArtist_id()) {
                ps.setInt(1, albums.getId());
                ps.setInt(2, albums.artist_id);
                ps.setString(3, albums.getName());
                ps.setInt(4, 2);
                n=ps.executeUpdate();
                System.out.println("-------------------------------"+n+"---------------------------");

                ps.clearParameters();


            }
        }


    }
}




