package animals;
import graphics.ZooPanel;
import mobility.Point;

import diet.Herbivore;
import diet.IDiet;
import food.*;
import java.util.Random;
import mobility.Point;
import utilities.MessageUtility;

/**
 * class of the animal: Giraffe
 * @version 07 April 2022
 * @author Itay_Asor
 *
 */

public class Giraffe extends Chew {

    private double neckLength;
    private final static Point gstartpoint = new Point(50,0);
    private final static IDiet giraffediet = new Herbivore();

    /**
     *
     * @param name
     */
    public Giraffe(String name)
    {
        super(name,gstartpoint);
        super.setWeight(450.0);
        super.setDiet(giraffediet);
        setNeckLength(1.5);
        MessageUtility.logConstractor("Giraffe", name);
    }
    /**
     *
     * @param name
     * @param p
     */
    public Giraffe(String name,Point p)
    {
        super(name,p);
        super.setWeight(450.0);
        super.setDiet(giraffediet);
        setNeckLength(1.5);
        MessageUtility.logConstractor("Giraffe", name);
    }

    public Giraffe(int size,String col,int horSpeed,int verSpeed,ZooPanel zp)
    {
        super(gstartpoint,size,col,horSpeed,verSpeed,zp);
        super.setDiet(giraffediet);
        super.setWeight(size*2.2);

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
     * @param nl
     * @return true or false
     */
    public boolean setNeckLength(double nl)
    {
        if(nl>2.5||nl<1.0)
        {
            MessageUtility.logSetter(getName(), "setNeckLength()",nl, false);
            return false;
        }
        else
        {
            this.neckLength=nl;
            MessageUtility.logSetter(getName(), "setNeckLength()",nl, true);
            return true;
        }
    }
    /**
     *
     * @return neck name and lenght
     */
    public double getNeckLengthe()
    {
        MessageUtility.logGetter(getName(),"getName()", this.neckLength);
        return this.neckLength;
    }
    /**
     * @return massage
     */
    public void chew()
    {
        MessageUtility.logSound(super.getName(),"Bleats and Stomps its legs, then chews");
    }
    /**
     * @return Giraffe name
     */
    public String toString()
    {
        return "[Giraffe]:" + this.getName();
    }
}