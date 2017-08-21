package com.lvg.thibernate.hello;

import com.lvg.thibernate.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


/**
 * Created by victor on 17.08.2017.
 */
public class HelloWorld {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Message message = new Message("Hello world");
        Long msgId = (Long)session.save(message);

        tx.commit();
        session.close();

       Session newSession = HibernateUtil.getSessionFactory().openSession();
        Transaction newTx = newSession.beginTransaction();

        List<Message> messages = newSession.createQuery("from Message m order by m.text asc").list();

        System.out.println(messages.size() + " message(s) found: ");

        for (Message msg : messages){
            System.out.println(msg.getText());
        }

        newTx.commit();
        newSession.close();


        //Third unit of work
        Session thirdSession = HibernateUtil.getSessionFactory().openSession();
        Transaction thirdTx = thirdSession.beginTransaction();

        message = (Message)thirdSession.get(Message.class, msgId);
        message.setText("Greeting Earthling");
        message.setNextMessage( new Message("Take me to your leader (please)") );

        messages = thirdSession.createQuery("from Message m").list();
        System.out.println(messages.size() + " message(s) found");
        for (Message m : messages){
            System.out.println(m.getText());
        }

        thirdTx.commit();
        thirdSession.close();

        HibernateUtil.shutdown();
    }
}
