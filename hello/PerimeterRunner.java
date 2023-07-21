import edu.duke.*;

/**
 * Write a description of PerimeterRunner here.
 * 
 * @bruna.bassani (your name) 
 * @12.10.2022 (a version number or a date)
 */

public class PerimeterRunner {
    public double getPerimeter (Shape s) {
        //Start with totalPerim = 0
        double totalPerim = 0;
        //Start with prevPt = the last point
        Point prevPt = s.getLastPoint();
        //For each point currPt in the shape,
        for(Point currPt: s.getPoints()) {
            //Find distance from prevPt to currPt, name it currDist
            double currDist = prevPt.distance(currPt);
            //Update totalPerim to be totalPerim + currDist
            totalPerim = totalPerim + currDist;
            //Update prevPt to be currPt
            prevPt = currPt;
        }
        //totalPerim is my answer
        return totalPerim;
    }
    
    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
    }
    
    public static void main (String[] args) {
        PerimeterRunner pr = new PerimeterRunner();
        pr.testPerimeter();
    }
}
