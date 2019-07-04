//class to define a segment points
class Point 
{ 
    double x,y; 
      
    public Point(double x, double y)  
    { 
        this.x = x; 
        this.y = y; 
    } 
} 
  
class GenericIntersection 
{   
	//using bubble sort for sorting points
	static void sortPoints(Point points[], int n) 
    { 
        if (n == 1) 
            return; 
        
        for (int i=0; i<n-1; i++) 
            if (points[i].x > points[i+1].x) 
            { 
                double temp = points[i].x; 
                points[i].x = points[i+1].x; 
                points[i+1].x = temp; 
            } 
        sortPoints(points, n-1); //recursion
    }
	public static int orientation(Point A, Point B, Point C) 
    { 
        double val = (B.y - A.y) * (C.x - B.x) -(B.x - A.x) * (C.y - B.y); 
        // collinear
        if (val == 0) 
        	return 0;
        // clock or counterclock wise
        return (val > 0)? 1: 2;  
    } 
	//check segments are parallel or intersected
	static Point checkIntersection(Point A, Point B, Point C, Point D) 
    { 
        double d = (B.y - A.y)*(C.x - D.x) - (D.y - C.y)*(A.x - B.x); 
        double s1 = (A.y-B.y)/(A.x-B.x);
	double s2 = (C.y-D.y)/(C.x-D.x);
	if(s1 == s2){
		if (d == 0) // The lines are parallel
		{  
		    return new Point(Double.MAX_VALUE, Double.MAX_VALUE); 
		}
	    	return new Point(Double.MAX_VALUE, Double.MAX_VALUE);
	} 
        else
        { 
            double x = ((C.x - D.x)*((B.y - A.y)*(A.x) 
            		+ (A.x - B.x)*(A.y)) - (A.x - B.x)*((D.y - C.y)*(C.x)
            		+ (C.x - D.x)*(C.y)))/d; 
            double y = ((B.y - A.y)*((D.y - C.y)*(C.x)
            		+ (C.x - D.x)*(C.y)) - (D.y - C.y)*((B.y - A.y)*(A.x) + (A.x - B.x)*(A.y)))/d; 
            return new Point(x, y); 
        } 
    } 
      
    public static void main(String args[]) 
    { 
    	//random points
        Point points[] = new Point[7]; 
        points[0]=new Point(5, 6); 
        points[1]=new Point(7, 8); 
        points[2]=new Point(9, 10); 
        points[3]=new Point(11, 12); 
        points[4]=new Point(3, 0); 
        points[5]=new Point(0, 0); 
        points[6]=new Point(3, 3);
        
        //sort coordinates
        sortPoints(points,7);
        
        Point A = points[0]; 
        Point B = points[1]; 
        Point C = points[2]; 
        Point D = points[3];
        
        Point intersection = checkIntersection(A, B, C, D); 
       
        if (intersection.x == Double.MAX_VALUE && intersection.y == Double.MAX_VALUE) 
        { 
            System.out.println("The given lines are parallel."); 
        } 
       
        else
        { 
           System.out.println("The given lines are intersected"); 
           System.out.print("Intersected at point "); 
           System.out.println("(" + intersection.x + ", " + intersection.y + ")");
        } 
    } 
} 
