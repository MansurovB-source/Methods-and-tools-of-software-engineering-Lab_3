package Main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Serializable;
import java.util.List;

public class Area implements Serializable {
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
    private Point point;

    public Area(double x, double y, double r) {
        point = new Point();
        point.setX(x);
        point.setY(y);
        point.setR(r);
        point.setStatus(point.isArea());
    }
    public Area(Point point) {
        this.point = point;
    }


    public void addToDB() {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(point);
            entityManager.getTransaction().commit();
            entityManager.close();
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error while adding to the database");
        }
    }

    public List<Point> getPointsFromDB() {
        List<Point> points = null;
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            points = (List<Point>)entityManager.createQuery("From Point ").getResultList();
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (Exception e) {
            System.out.println("Error while getting from the database");
            e.printStackTrace();
        }
        return points;
    }
}
