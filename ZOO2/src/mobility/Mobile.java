package mobility;
import java.lang.Math;
import utilities.MessageUtility;
/**
 * 07 April 2022
 * @author BarMor
 * @see Ilocatable
 */
public abstract class Mobile implements Ilocatable{
	
	private Point location;
	private double totalDistance;
	/**
	 * 
	 * @param p
	 */
	public Mobile(Point p) 
	 {
		if(setLocation(p))
		{
			this.location=new Point(p);
		}
		this.totalDistance=0;
	 }
	/**
	 * 
	 * @param d1
	 */
	public void addTotalDistance(double d1) {this.totalDistance+=d1;}
	/**
	 * 
	 * @param p2
	 * @return distance
	 */
	public double calcDistance(Point p2)
     {
		return Math.sqrt(Math.pow(this.location.getx()-p2.getx(),2)+Math.pow(this.location.gety()-p2.gety(),2));
	}
	
	/**
	 * @return location
	 */
	public Point getLocation()
	{
		return this.location;
	}
	/**
	 * @param p
	 * @return true
	 */
	public boolean setLocation(Point p)
	{
		return true;
	}
	/**
	 * 
	 * @param d
	 * @return true or false
	 */
	public boolean setTotalDistance(double d)
	{
		if(d>0)
		{
			this.totalDistance=d;
			return true;
		}
		return false;
	}
	/**
	 * 
	 * @return total distance
	 */
	
	public double getTotalDistance()
	{
		return this.totalDistance;
	}

	
	

}