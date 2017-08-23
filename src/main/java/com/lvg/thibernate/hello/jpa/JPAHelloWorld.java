package com.lvg.thibernate.hello.jpa;

import com.lvg.thibernate.hello.Message;
import com.lvg.thibernate.utils.DatabaseProduct;
import com.lvg.thibernate.utils.TransactionManagerSetup;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.UserTransaction;
import java.util.List;

/**
 * Created by Victor on 23.08.2017.
 */
public class JPAHelloWorld {


    public static void main(String[] args)throws Exception{

        EntityManagerFactory emf = null;
        TransactionManagerSetup tms = null;
        try {
             tms = new TransactionManagerSetup(DatabaseProduct.HSQLDB);
             emf = Persistence.createEntityManagerFactory("helloworld");
            System.out.println("--------CONNECTION ESTABLISHED-----------");
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }

        UserTransaction tx = tms.getUserTransaction();
        tx.begin();

        EntityManager em = emf.createEntityManager();
        Message message = new Message("Hello world!");
        em.persist(message);

        tx.commit();
        em.close();

        tx.begin();
        EntityManager em2 = emf.createEntityManager();
        List messages = em2.createQuery("select m from Message m").getResultList();

        System.out.println(messages.size() + " message(s) found");
        for (Object o : messages){
            Message m = (Message)o;
            System.out.println(m.getText());
        }

        tx.commit();
        em2.close();

        tms.stop();
        emf.close();

    }
}
