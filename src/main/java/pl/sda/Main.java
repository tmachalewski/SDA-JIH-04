package pl.sda;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        SessionFactory sf =
                new Configuration().configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Actor.class)
                        .buildSessionFactory();


        try(Session s = sf.openSession()){
            Transaction tr = s.beginTransaction();
//            Actor a1 = new Actor(5, "A1");
            Actor a1 = new Actor("A3");
//            Actor a2 = new Actor("A2");
            s.save(a1);
//            s.save(a2);
            tr.commit();
            tr.begin();
            a1.setName(a1.getName()+"+");
            Actor at = s.find(Actor.class, UUID.fromString("0851d881-6165-471c-a3a7-7d18e5cba015"));
            at.setName(at.getName()+"+");
            tr.commit();

            //System.out.println(a2);
        }


    }
}
