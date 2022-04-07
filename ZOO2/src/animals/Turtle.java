package animals;
import mobility.Point;
import diet.Herbivore;
import diet.IDiet;
import food.*;
import java.util.Random;
import mobility.Point;
import utilities.MessageUtility; 
/**
 * class of the animal: Turtle
 * @version 07 April 2022
 * @author Bar_Mor
 *
 */
public class Turtle extends Chew {
	
	private int age;
	private final static Point tstartpoint = new Point(80,0);
	private final static IDiet turtlediet = new Herbivore();
	
	/**
	 * 
	 * @param name
	 */
	public Turtle(String name)
	{
		super(name,tstartpoint);
		super.setWeight(1.0);
		super.setDiet(turtlediet);
		setAge(1);
		MessageUtility.logConstractor("Turtle", name);
	}
	/**
	 * 
	 * @param name
	 * @param p
	 */
	public Turtle(String name,Point p)
	{
		super(name,p);
		super.setWeight(1.0);
		super.setDiet(turtlediet);
		setAge(1);
		MessageUtility.logConstractor("Turtle", name);
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
    		return true;
    		
    	}
    	return false;
	}
	/**
	 * 
	 * @param ta
	 * @return true or false
	 */
	public boolean setAge(int ta)
	{
		if(ta>500||ta<0)
		{
			MessageUtility.logSetter(getName(), "setAge()",ta, false);
			return false;
		}
		else
		{
			this.age=ta;
			MessageUtility.logSetter(getName(), "setAge()",ta, true);
			return true;
		}
	}
	/**
	 * 
	 * @return age
	 */
	public double getAge()
	{
		MessageUtility.logGetter(getName(),"getAge()", this.age);
		return this.age;
	}
	/**
	 * @return massage
	 */
	public void chew()
	{
		MessageUtility.logSound(super.getName(),"Retracts its head in then eats quietly");
	}
	/**
	 * @return Turtle name
	 */
	public String toString()
    {
		return "[Turtle]:" + this.getName();
    }
}