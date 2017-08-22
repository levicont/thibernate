package com.lvg.thibernate.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Victor on 22.08.2017.
 */
public class JPAUtil {
    private static EntityManagerFactory emf = createEntityManagerFactory();

    private static EntityManagerFactory createEntityManagerFactory() {
        try{

            Map properties = new HashMap();
            properties.put("hibernate.hbm2ddl.auto", "create-drop");
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("helloworld", properties);
            return emf;
        }catch (Throwable ex){
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static EntityManagerFactory getEntityManagerFactory(){
        return emf;
    }

    public static void shutdownEMF(){
        try{
            emf.close();
        }catch (Exception ex){
            System.out.println("EntityManagerFactory closed with message "+ ex.getMessage());
        }
    }
}
