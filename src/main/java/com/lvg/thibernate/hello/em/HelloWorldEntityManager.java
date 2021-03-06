package com.lvg.thibernate.hello.em;

import com.lvg.thibernate.hello.Message;
import com.lvg.thibernate.utils.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by Victor on 21.08.2017.
 */
public class HelloWorldEntityManager {
    public static void main(String[] args) {
// Start EntityManagerFactory
        EntityManagerFactory emf =
                JPAUtil.getEntityManagerFactory();
// First unit of work
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Message message = new Message("Hello World");
        em.persist(message);
        tx.commit();
        em.close();
// Second unit of work
        EntityManager newEm = emf.createEntityManager();
        EntityTransaction newTx = newEm.getTransaction();
        newTx.begin();
        List messages = newEm
                .createQuery("select m from Message m order by m.text asc")
                        .getResultList();
        System.out.println( messages.size() + " message(s) found" );
        for (Object m : messages) {
            Message loadedMsg = (Message) m;
            System.out.println(loadedMsg.getText());
        }
        newTx.commit();
        newEm.close();
// Shutting down the application
        JPAUtil.shutdownEMF();
    }
}
