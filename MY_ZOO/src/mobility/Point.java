package mobility;
/**
 * 07 April 2022
 * @author BarMor
 */
public class Point {

    private int x,y;
    private static final int maxX=800,maxY=600;

    public Point()
    {
        this.x=0;
        this.y=0;
    }
    /**
     *
     * @param x
     * @param y
     */
    public Point(int x,int y)
    {
        this.x=x;
        this.y=y;
    }
    /**
     *
     * @param p1
     */
    public Point(Point p1)
    {
        this.x=p1.getx();
        this.y=p1.gety();
    }
    /**
     *
     * @return x value
     */
    public int getx()
    {
        return this.x;
    }
    /**
     *
     * @return y value
     */
    public int gety()
    {
        return this.y;
    }
    /**
     *
     * @param p
     * @return true or false
     */
    public boolean checkBoundaries(Point p)
    {
        if(p.getx()<0||p.getx()>maxX||p.gety()<0||p.gety()>maxY)
        {
            return false;
        }
        return true;
    }
    /**
     *
     * @return point value
     */
    public String getPoint()
    {
        return this.x+","+this.y;
    }


}