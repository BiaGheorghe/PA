package repo;

import entity.AlbumsEntity;
import entity.ArtistsEntity;
import util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlbumRepository {
    PersistenceUtil persistenceUtil=PersistenceUtil.getInstance();
    EntityManagerFactory entityManagerFactory=persistenceUtil.getEntityManagerFactory();
    public void closeEntityManagerFactory(){
        persistenceUtil.closeEntityManagerFactory();
    }

    public void create(AlbumsEntity albumsEntity)throws SQLException {

        albumsEntity.setName(albumsEntity.getName());
        albumsEntity.setArtistId(albumsEntity.getArtistId());
        albumsEntity.setReleaseYear(albumsEntity.getReleaseYear());
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(albumsEntity);
        entityManager.getTransaction().commit();
        entityManager.close();


    }

    public List<AlbumsEntity> findById(int id){
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        List<AlbumsEntity> lista = new ArrayList<AlbumsEntity>();
        String query = "SELECT c from AlbumsEntity c WHERE c.id= :id";
        TypedQuery<AlbumsEntity> tq= entityManager.createQuery(query, AlbumsEntity.class);
        tq.setParameter("id",id);
        lista=tq.getResultList();
        entityManager.close();
        return lista;

    }

    public  List<AlbumsEntity> findByName(String name){
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        List<AlbumsEntity> lista = new ArrayList<AlbumsEntity>();
        String query = "SELECT c from AlbumsEntity c WHERE c.name= :name";
        TypedQuery<AlbumsEntity> tq= entityManager.createQuery(query, AlbumsEntity.class);
        tq.setParameter("name",name);
        lista=tq.getResultList();
        entityManager.close();
        return lista;

    }

        public  List<AlbumsEntity> findByArtist(int id){
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        List<AlbumsEntity> lista = new ArrayList<AlbumsEntity>();
        Query query=entityManager.createNamedQuery("findArtistsByName");
        query.setParameter("id",artistsEntity.getId());
        lista=query.getResultList();
        return lista;
    }
}
