package com.ynov.springvacations;

import com.fasterxml.classmate.AnnotationConfiguration;
import com.ynov.springvacations.domain.Residence;
import com.ynov.springvacations.domain.Service;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


//public class HibernateUtils {
//    public static SessionFactory factory;
//    //to disallow creating objects by other classes.
//    private HibernateUtils() {
//    }
//    //maling the Hibernate SessionFactory object as singleton
//    public static synchronized SessionFactory getSessionFactory() {
//        if (factory == null) {
//            factory = new Configuration().configure("hibernate.cfg.xml").
//                    buildSessionFactory();
//        }
//        return factory;
//    }
//}