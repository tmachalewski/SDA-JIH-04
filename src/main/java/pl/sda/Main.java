package pl.sda;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        SessionFactory sf =
                new Configuration().configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Actor.class)
                        .addAnnotatedClass(Movie.class)
                        .addAnnotatedClass(Studio.class)
                        .buildSessionFactory();


//        try(Session s = sf.openSession()){
//            Transaction tr = s.beginTransaction();
////            Actor a1 = new Actor(5, "A1");
//            Actor a1 = new Actor("A3");
////            Actor a2 = new Actor("A2");
//            s.save(a1);
////            s.save(a2);
//            tr.commit();
//            tr.begin();
//            a1.setName(a1.getName()+"+");
//            Actor at = s.find(Actor.class, UUID.fromString("0851d881-6165-471c-a3a7-7d18e5cba015"));
//            at.setName(at.getName()+"+");
//            tr.commit();
//            //System.out.println(a2);
//        }

//        try(Session s = sf.openSession()){
//            Transaction tr = s.beginTransaction();
//            Movie m1 = Movie.builder().movieId(new MovieId(1,"ML1")).title("MT1").build();
//            Movie m2 = Movie.builder().movieId(new MovieId(2,"ML1")).title("MT2").build();
//            s.save(m1);
//            s.save(m2);
//            tr.commit();
//            tr = s.beginTransaction();
//            Movie m3 = Movie.builder().movieId(new MovieId(1,"ML1")).title("MT3").build();
//            s.save(m3);
//            tr.commit();
//        }
//        try(Session s = sf.openSession()){
//            Transaction tr = s.beginTransaction();
//            Movie m3 = Movie.builder().movieId(new MovieId(1,"ML2")).title("MT3").build();
//            s.save(m3);
//            Movie mt = s.find(Movie.class, new MovieId(1,"ML2"));
//            tr.commit();
//
//            var a =5;
//        }

//        try(Session s = sf.openSession()){
//            Transaction tr = s.beginTransaction();
//            Movie m3 = Movie.builder().movieId(new MovieId(1,"ML2")).title("MT3").build();
//            Studio s3 = Studio.builder().location("SL1").build();
//            s.save(m3);
//            s.save(s3);
//            tr.commit();
//            tr.begin();
//            m3.setStudio(s3);
//            s3.setMovie(m3);
//            s.update(m3);
//            s.update(s3);
//            tr.commit();
//            var a =5;
//        }

        try(Session s = sf.openSession()){
            Transaction tr = s.beginTransaction();
            Actor a1 = Actor.builder().name("AN1").movies(new ArrayList<>()).build();
            Actor a2 = Actor.builder().name("AN2").movies(new ArrayList<>()).build();

            Movie m1 = Movie.builder().movieId(new MovieId(1, "A")).title("MT1").actors(new ArrayList<>()).build();
            Movie m2 = Movie.builder().movieId(new MovieId(2, "A")).title("MT2").actors(new ArrayList<>()).build();

            s.save(m1);
            s.save(m2);
            s.save(a1);
            s.save(a2);

            m1.getActors().addAll(List.of(a1, a2));
            m2.getActors().addAll(List.of(a1, a2));
            a1.getMovies().addAll(List.of(m1, m2));
            a2.getMovies().addAll(List.of(m1, m2));

            s.update(m1);
            s.update(m2);
            s.update(a1);
            s.update(a2);

            tr.commit();
        }




    }
}
