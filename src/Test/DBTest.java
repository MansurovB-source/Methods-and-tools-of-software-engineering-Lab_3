package Test;

import Main.Point;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Collections;
import java.util.List;

public class DBTest {
    public static EntityManagerFactory entityManagerFactory;
    public static Point point_1;
    public static Point point_2;
    public static Point point_3;
    public static Point point_4;

    @BeforeClass
    public static void setUp() {
        entityManagerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        point_1 = new Point(-1.,1.5, 3, true );
        point_2 = new Point(1., 2., 3., false);
        point_3 = new Point(1., -2., 5., true);
        point_4 = new Point(-1., -4, 3, false);
    }
    @AfterClass
    public static void setDown() {
        entityManagerFactory.close();
    }

    @Test
    public void addToDB() {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(point_1);
            entityManager.persist(point_2);
            entityManager.persist(point_3);
            entityManager.persist(point_4);
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test: Error while adding to the database");
        }

    }

    @Test
    public void getPointsFromDB() {
        List<Point> points = null;
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            points = (List<Point>) entityManager.createQuery("From Point ").getResultList();
            Collections.reverse(points);
            entityManager.getTransaction().commit();
            entityManager.close();
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("Test: Error while getting from the database");
        }
        Assert.assertNotNull(points);
    }
}
