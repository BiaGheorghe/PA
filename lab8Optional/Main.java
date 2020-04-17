import java.sql.Connection;
import  java.sql.*;
import java.util.List;

public class Main {
    public static void main(String [] args)throws SQLException{

        //inser artist
       ArtistController artistDao= new ArtistController();
       artistDao.create("Robert","Argentina");

        //insert album
        AlbumController albumDao=new AlbumController();
        albumDao.create("albumNr1",2,2009);


        //select artists
       List<Artists> listaArtisti= artistDao.findByName("Corina");
        System.out.println("artistii cu numele Corina");
        System.out.println("");


        for (Artists allArt : listaArtisti) {
           System.out.println(allArt);
       }

        System.out.println("");

        //select albums
        System.out.println("albumele cu artist-id=20 ");
        System.out.println("");

        List<Albums> listaAlbume= albumDao.findByArtist(34);
        for (Albums allAlb : listaAlbume){
            System.out.println(allAlb);
        }


        //delete album
        //albumDao.delete(1);

        //delete artist
        //artistDao.delete(1);

        //selesc all artists
        List<Artists> lsAllArt = artistDao.getArtists();
        System.out.println("");
        System.out.println("///////////////////////lista artisti////////////////");
        System.out.println("");
        for (Artists allArt : lsAllArt) {
            System.out.println(allArt);
        }
        System.out.println("");

        //selest all albums
        List<Albums> lsAllAlb = albumDao.getAlbums();
        System.out.println("///////////////////////lista albume////////////////");
        for (Albums allAlb : lsAllAlb) {
            System.out.println(allAlb);
        }
        System.out.println("");
        System.out.println("");
        ChartController chartController=new ChartController();
        for (Albums allAlb : listaAlbume){
            chartController.create(allAlb);
        }

        DataBase.conn.close();
        }




}

