package repo;

import entity.Clients;
import entity.Masters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MasterRep implements IRepo<Masters>{
    private static final Logger log= LogManager.getLogger(MasterRep.class);

    @PersistenceContext
    public EntityManager em = Persistence.createEntityManagerFactory("TST").createEntityManager();



    @Override
    public void insert(Masters master) throws SQLException {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(master);
            transaction.commit();
            log.info("Мастер добавлен: " + master);
        } catch (Exception e) {
            log.warn(e.getMessage());
            log.info("Ошибка при добавлении клиента: " + master);
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        EntityTransaction transaction = em.getTransaction();
        Masters delMasters = em.find(Masters.class, id);
        if (delMasters != null) {
            delMasters.setDelete(false);
            em.merge(delMasters);
            log.info("Мастер с id " + id + " был удален.");}
        else{
            log.info("Мастер с id " + id + "не найден");
        }

    }




    @Override
    public void update(Masters master) throws SQLException {
        EntityTransaction transaction = em.getTransaction();
        try {
            Masters updatedMaster = em.merge(master);
            log.info("Клиент обновлен: " + updatedMaster);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("Ошибка при обновлении клиента: " + master);
        }

    }

    @Override
    public List<Masters> getAll() throws SQLException {
        return em.createQuery("SELECT s FROM Masters s", Masters.class).getResultList();
    }

}
