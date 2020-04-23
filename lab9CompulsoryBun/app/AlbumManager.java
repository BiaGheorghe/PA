package app;

import entity.AlbumsEntity;
import entity.ArtistsEntity;
import repo.AlbumRepository;
import repo.ArtistRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlbumManager {
    public static void main(String[] args) throws SQLException {
        ArtistsEntity artistsEntity=new ArtistsEntity();
        artistsEntity.setName("chiliiiii");
        artistsEntity.setCountry("manjarooooo");

        ArtistRepository artistRepository=new ArtistRepository();

        artistRepository.create(artistsEntity);

        List<ArtistsEntity>listaIdArtisti = new ArrayList<ArtistsEntity>();
        listaIdArtisti=artistRepository.findById(20);
        for(ArtistsEntity a: listaIdArtisti){
            System.out.println(a);
        }

        List<ArtistsEntity>listaNumeArtisti = new ArrayList<ArtistsEntity>();
        listaNumeArtisti=artistRepository.findByName("Miru2");
        for(ArtistsEntity a: listaNumeArtisti){
            System.out.println(a);
        }
        artistRepository.closeEntityManagerFactory();

        //////////////////

        AlbumsEntity albumsEntity=new AlbumsEntity();
        albumsEntity.setName("chili");
        albumsEntity.setArtistId(30);
        albumsEntity.setReleaseYear(1356);

        AlbumRepository albumRepository=new AlbumRepository();

        albumRepository.create(albumsEntity);

        List<AlbumsEntity>listaIdAlbume = new ArrayList<AlbumsEntity>();
        listaIdAlbume=albumRepository.findById(17);
        for(AlbumsEntity a: listaIdAlbume){
            System.out.println(a);
        }

        List<AlbumsEntity>listaNumeAlbume = new ArrayList<AlbumsEntity>();
        listaNumeAlbume=albumRepository.findByName("Corina");
        for(AlbumsEntity a: listaNumeAlbume){
            System.out.println(a);
        }

        List<AlbumsEntity>listaAlbumeDupaArtist =new ArrayList<AlbumsEntity>();
        listaAlbumeDupaArtist=albumRepository.findByArtist(20);
        for(AlbumsEntity a: listaAlbumeDupaArtist) {
            System.out.println(a);
        }

        albumRepository.closeEntityManagerFactory();







    }
}
