import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start with prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Declare int-type variable that will return with the result
        int numPoints = 0;
        // Start with prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Update numPoints by 1
            numPoints = numPoints + 1;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // numPoints is the answer
        return numPoints;
    }

    public double getAverageLength(Shape s) {
        // Start with avgLength = 0 
        double avgLength = 0.0;
        // Start with prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance/length from prevPt point to currPt 
            double currLength = prevPt.distance(currPt);
            // Update sumLengths by currLength
            avgLength = avgLength + currLength;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // Get the numPoints
        int numPoints = getNumPoints(s);
        // Divide the sum of all sides lengths by the number of sides
        avgLength = (avgLength/numPoints);
        // avgLength is the answer
        return avgLength;
    }

    public double getLargestSide(Shape s) {
        // Start with largestSide = 0
        double largestSide = 0.0;
        // Start with prevPt = the last point and prevDistance = 0
        Point prevPt = s.getLastPoint();
        double prevDistance = 0;
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDistance = prevPt.distance(currPt);
            // If the current distance found is bigger than the previous and the current largest Side
            if (currDistance > prevDistance && currDistance > largestSide) {
                // Set the largest side to the current side
                largestSide = currDistance;
            }
            // Update prevPt to be currPt
            prevPt = currPt;
            prevDistance = currDistance;
        }
        // largestSide is the answer
        return largestSide;
    }

    public double getLargestX(Shape s) {
        // Start with largestX = 0
        double largestX = 0.0;
        // Start with prevPt = the last point and get the last X
        Point prevPt = s.getLastPoint();
        double prevX = prevPt.getX();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find the X of the current point
            double currX = currPt.getX();
            // If current X is bigger than previous X, and bigger than the largest X currently, then
            if (currX > prevX && currX > largestX) {
                // Set the largest X to the current X
                largestX = currX;
            }
            // Update prevPt to be currPt, and prevX to currX
            prevPt = currPt;
            prevX = currX;
        }
        // largestX is the answer
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        return 0.0;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int numPoints = getNumPoints(s);
        double avgLength = getAverageLength(s);
        double largestSide = getLargestSide(s);
        double largestX = getLargestX(s);
        
        System.out.println("perimeter = " + length);
        System.out.println("numPoints = " + numPoints);
        System.out.println("avgLength = " + avgLength);
        System.out.println("largestSide = " + largestSide);
        System.out.println("largestX = " + largestX);
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
