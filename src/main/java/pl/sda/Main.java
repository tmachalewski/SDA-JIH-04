package pl.sda;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory sf =
                new Configuration().configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Actor.class)
                        .buildSessionFactory();

        try(Session s = sf.openSession()){
            Transaction tr = s.beginTransaction();
            Actor a1 = new Actor(5, "A1");
            s.save(a1);
            tr.commit();
            Actor a2 = s.find(Actor.class, 5);
            System.out.println(a2);
        }


    }
}
