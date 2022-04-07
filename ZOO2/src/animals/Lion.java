package animals;
import mobility.Point;
import diet.Carnivore;
import diet.IDiet;
import food.*;
import java.util.Random;
import utilities.MessageUtility;
/**
 * class of the animal: Lion
 * @version 07 April 2022
 * @author Bar_Mor
 *
 */
public class Lion extends Roar {
	
	private int scarCount;
	private final static IDiet liondiet=new Carnivore();
	private final static Point startlocation=new Point(20,0);
	
	/**
	 * 
	 * @param name
	 */
	public Lion(String name)
	{
		super(name,startlocation);
		super.setWeight(408.2);
		super.setDiet(liondiet);
		this.scarCount=0;
		MessageUtility.logConstractor("Lion", name);
	}
	/**
	 * 
	 * @param name
	 * @param p
	 */
	public Lion(String name,Point p)
	{
		super(name,p);
		super.setWeight(408.2);
		super.setDiet(liondiet);
		this.scarCount=0;
		MessageUtility.logConstractor("Lion", name);
	}
	/**
	 * @return foot type
	 */
    public EFoodType getFoodType()
    {
    	return EFoodType.NOTFOOD;
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
    		Random scars=new Random();
    		this.scarCount=scars.nextInt(scarCount,scarCount+1);
    		super.makeSound();
    		super.setWeight(newweight+this.getweight());
    		return true;
    		
    	}
    	return false;
    }
	
    /**
     * 
     * @return number of scars
     */
    public int getScars()
    {
    	MessageUtility.logGetter(this.getName(),"getScars()", this.scarCount);
    	return this.getScars();
    }
    /**
     * 
     * @param s
     * @return true or false
     */
    public boolean setScars(int s)
    {
    	if(s>0)
    	{
    		this.scarCount=s;
    		MessageUtility.logSetter(getName(), "setScars()",s, true);
    		return true;
    	}
    	MessageUtility.logSetter(getName(), "setScars()",s, false);
    	return false;
    }
    /**
     * @return massage 
     */
	public void roar()
	{
		MessageUtility.logSound(super.getName(),"Roars, then stretches and shakes its mane");
	}
	/**
	 * @return the name of lion
	 */
	public String toString()
    {
		return "[Lion]:" + this.getName();
    }

}