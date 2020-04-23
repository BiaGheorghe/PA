package repo;

import entity.ArtistsEntity;
import util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArtistRepository {
    PersistenceUtil persistenceUtil=PersistenceUtil.getInstance();
    EntityManagerFactory entityManagerFactory=persistenceUtil.getEntityManagerFactory();
    public void closeEntityManagerFactory(){
        persistenceUtil.closeEntityManagerFactory();
    }

    public void create(ArtistsEntity artistsEntity)throws SQLException {

        artistsEntity.setName(artistsEntity.getName());
        artistsEntity.setCountry(artistsEntity.getCountry());
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(artistsEntity);
        entityManager.getTransaction().commit();
        entityManager.close();



    }

    public  List<ArtistsEntity> findById(int id){
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        List<ArtistsEntity> lista = new ArrayList<ArtistsEntity>();
        String query = "SELECT c from ArtistsEntity c WHERE c.id= :id";
        TypedQuery<ArtistsEntity> tq= entityManager.createQuery(query, ArtistsEntity.class);
        tq.setParameter("id",id);
        lista=tq.getResultList();
        entityManager.close();
        return lista;
    }

    public  List<ArtistsEntity> findByName(String name){
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        List<ArtistsEntity> lista = new ArrayList<ArtistsEntity>();
        String query = "SELECT c from ArtistsEntity c WHERE c.name= :name";
        TypedQuery<ArtistsEntity> tq= entityManager.createQuery(query, ArtistsEntity.class);
        tq.setParameter("name",name);
        lista=tq.getResultList();
        entityManager.close();
        return lista;
    }



}

