package Main;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Area area = new Area(5, 6, 7);
        area.addToDB();
        List<Point> points = area.getPointsFromDB();
        for(Point point : points) {
            System.out.println( point.getId() + " | " + point.getX() + " | " + point.getY() + " | " + point.getR() + " | ");
        }
    }
}
