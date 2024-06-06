package org.training.spring.springtraining20240603.dao.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import org.training.spring.springtraining20240603.services.models.Customer;

public class CustomerJPARepository {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;


    public void insert(Customer customerParam){
        EntityManager entityManagerLoc = entityManagerFactory.createEntityManager();
        try {
            entityManagerLoc.getTransaction().begin();
            entityManagerLoc.persist(customerParam);
            entityManagerLoc.getTransaction().commit();
        } catch (Exception eParam) {
            entityManagerLoc.getTransaction().rollback();
            eParam.printStackTrace();
        } finally {
            if (entityManagerLoc != null){
                entityManagerLoc.close();
            }
        }
    }

    public void update(Customer customerParam){
        EntityManager entityManagerLoc = entityManagerFactory.createEntityManager();
        try {
            entityManagerLoc.getTransaction().begin();
            Customer mergeLoc = entityManagerLoc.merge(customerParam);
            mergeLoc.setName("deneme");
            customerParam.setName("test");
            entityManagerLoc.getTransaction().commit();
        } catch (Exception eParam) {
            entityManagerLoc.getTransaction().rollback();
            eParam.printStackTrace();
        } finally {
            if (entityManagerLoc != null){
                entityManagerLoc.close();
            }
        }
    }


}
