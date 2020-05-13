package Main;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "point", schema = "s270235")

public class Point implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) private int id;
    private double X;
    private double Y;
    private double R;
    private boolean status;

    public Point(double x, double y, double r, boolean status) {
        X = x;
        Y = y;
        R = r;
        this.status = status;
    }

    public Point(double x, double y, double r) {
        X = x;
        Y = y;
        R = r;
    }

    public Point() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getX() {
        return X;
    }

    public void setX(double x) {
        X = x;
    }

    public double getY() {
        return Y;
    }

    public void setY(double y) {
        Y = y;
    }

    public double getR() {
        return R;
    }

    public void setR(double r) {
        R = r;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isArea() {
        if (((getX() >= 0) && getY() <= 0) && (getY() >= (2 * getX() - getR()))) {
            return true;
        } else if ((getX() <= 0) && (getY() >= 0) && ((getX() * getX() + getY() * getY()) <= getR() * getR())) {
            return true;
        } else if ((getX() >= 0) && (getY() >= 0) && (getX() <= getR()) && (getY() <= getR() / 2)) {
            return true;
        } else {
            return false;
        }
    }

}
