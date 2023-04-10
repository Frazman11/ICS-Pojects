package DysonFrazer_lab7;
/**
 * Class declaration with declaration of double Coordinates X and Y
 */
public class Point {
    public double X, Y;

    /**
     * No argument constructor for Point, that initializes the Coordinates X and Y to 0
     */
    public Point() {
        this(0, 0);
    }

    /**
     * Two argument constuctor for Point, for initializing coordinates to those provided as arguments
     * @param X
     * @param Y
     */
    public Point(double X, double Y) {
        this.X = X;
        this.Y = Y;
    }

    /**
     * 
     * method that takes a Point as parameter and finds the distance squared from that point to this point. 
     * @param that
     * @return distanceSquared
     */
    double distSquared(Point that) {
        double dx = that.X - this.X;
        double dy = that.Y - this.Y;

        return (dx * dx + dy * dy);
    }
    /**
     * 
     * method that takes Y and X coordinates as parameters and finds the distance squared from that location.
     * @param double X, Y
     * @return distanceSquared
     */
    double distSquared(double X, double Y) {
        double dx = X - this.X;
        double dy = Y - this.Y;

        return (dx * dx + dy * dy);
    }

    /**
     * Method that takes X and Y coordinates as parameters and returns the distance to that location, as a double. Calls 
     * distSquared and then takes the square root.
     * @param X
     * @param Y
     * @return
     */
    public double distanceFrom(double X, double Y) {
        return Math.sqrt(distSquared(X, Y));
    }
    /**
     * Overload for distanceFrom that takes a point as parameter and returns the distance to that point. Calls 
     * distSquared and then takes the square root.
     * @param that
     * @return
     */
    public double distanceFrom(Point that) {
        return Math.sqrt(distSquared(that));
    }

    /**
     * Manual Override of default Object toString Method, to output a specific format of "Point: [2.0, 3.5]"
     * @return "Point [X, Y]""
     */
    @Override
    public String toString() {
        return "Point: [" + X + ", " + Y + "]";
    }
}