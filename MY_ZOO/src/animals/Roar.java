package animals;
import diet.IDiet;
import food.IEdible;
import graphics.ZooPanel;
import mobility.Point;
import utilities.MessageUtility;
/**
 * An abstract class of roaring animals
 * @version 07 April 2022
 * @author Itay_Asor
 *
 */
public abstract class Roar extends Animal{
    private String name;
    private double weight;
    private IDiet diet;

    public Roar(String name,Point location)
    {
        super(name,location);
    }

    public Roar(Point startlocation, int size, String col, int horSpeed, int verSpeed,ZooPanel zp) {
        super(startlocation,size,col,horSpeed,verSpeed,zp);

    }

    public abstract void roar();

    public void makeSound()
    {
        roar();
    }

    /**
     *
     * @return weight
     */
    public double getweight() {
        MessageUtility.logGetter(name,"getWeight()", this.weight);
        return this.weight;
    }

    /**
     *
     * @param w
     * @return true or false
     */
    public boolean setWeight(double w) {
        if (w>0.0)
        {
            this.weight=w;
            MessageUtility.logSetter(name, "setWeight()",w, true);
            return true;
        }
        MessageUtility.logSetter(name, "setWeight()",w, false);
        return false;
    }

    /**
     *
     * @param name
     * @return true
     */
    public boolean setName(String name) {
        this.name=name;
        MessageUtility.logSetter(name, "setName()",name, true);
        return true;
    }

    /**
     *
     * @return name
     */
    public String getName() {
        MessageUtility.logGetter(name,"getName()", this.name);
        return this.name;
    }

    public void makesound() {

    }

    /**
     *
     * @param d
     * @return true
     */
    public boolean setDiet(IDiet d) {
        this.diet=d;
        MessageUtility.logSetter(name, "setDiet()",d.getClass().getSimpleName(), true);
        return true;
    }

    /**
     *
     * @return diet
     */
    public IDiet getDiet() {
        MessageUtility.logGetter(name,"getDiet()", this.diet.getClass().getSimpleName());
        return this.diet;
    }

    /**
     *
     * @param p3
     * @return distance
     */
    public double move(Point p3) {
        double d=calcDistance(p3);
        if(d>0)
        {
            super.setLocation(p3);
            super.setTotalDistance(super.getTotalDistance()+d);
            this.weight-=(d*weight*0.00025);
        }
        return d;

    }

    /**
     *
     * @param food
     */
    public abstract boolean eat(IEdible food);

    public abstract String toString();




}