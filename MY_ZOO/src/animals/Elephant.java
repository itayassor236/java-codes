package animals;
import graphics.ZooPanel;
import mobility.Point;
import diet.Herbivore;
import diet.IDiet;
import food.*;
import mobility.Point;
import utilities.MessageUtility;
/**
 * class of the animal: Elephant
 * @version 1 07 April 2022
 * @author BarMor
 *
 */
public class Elephant extends Chew {

    private double trunkLength;
    private final static Point estartpoint = new Point(50,90);
    private final static IDiet elephantdiet = new Herbivore();

    /**
     *
     * @param name
     */
    public Elephant(String name)
    {
        super(name,estartpoint);
        super.setWeight(500.0);
        super.setDiet(elephantdiet);
        setTrunkLength(1.0);
        MessageUtility.logConstractor("Elephant", name);
    }
    /**
     *
     * @param name
     * @param p
     */
    public Elephant(String name,Point p)
    {
        super(name,p);
        super.setWeight(500.0);
        super.setDiet(elephantdiet);
        setTrunkLength(1.0);
        MessageUtility.logConstractor("Elephant", name);
    }

    public Elephant(int size,String col,int horSpeed,int verSpeed,ZooPanel zp)
    {
        super(estartpoint,size,col,horSpeed,verSpeed,zp);
        super.setDiet(elephantdiet);
        super.setWeight(size*10);

    }
    /**
     * @return food type
     */
    public EFoodType getFoodType()
    {
        return EFoodType.MEAT;
    }
    /**
     * @param food
     * @return true or false
     */
    public boolean eat(IEdible food)
    {
        double newweight = super.getDiet().eat(this, food);
        if (newweight>0.0)
        {
            super.makeSound();
            super.setWeight(newweight+this.getweight());
            super.setEatCount(super.getEatCount()+1);
            return true;

        }
        return false;
    }
    /**
     *
     * @param tl
     * @return true or false
     */
    public boolean setTrunkLength(double tl)
    {
        if(tl>3.5||tl<0.5)
        {
            MessageUtility.logSetter(getName(), "setTrunkLength()",tl, false);
            return false;
        }
        else
        {
            MessageUtility.logSetter(getName(), "setTrunkLength()",tl, true);
            this.trunkLength=tl;
            return true;
        }
    }
    /**
     *
     * @return lenght
     */
    public double getTrunkLengthe()
    {
        MessageUtility.logGetter(getName(),"getTrunkLength()", this.trunkLength);
        return this.trunkLength;
    }
    /**
     * @return massage
     */
    public void chew()
    {
        MessageUtility.logSound(super.getName(),"Trumpets with joy while flapping its ears, then chews");
    }
    /**
     * @return elephant name
     */
    public String toString()
    {
        return "[Elephant]:" + this.getName();
    }

}