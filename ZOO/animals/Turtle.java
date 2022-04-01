package animals;
import mobility.Point;
import diet.Herbivore;
import diet.IDiet;
import food.*;
import java.util.Random;
import mobility.Point;
import utilities.MessageUtility; 

public class Turtle extends Chew {
	
	private int age;
	private final static Point tstartpoint = new Point(80,0);
	private final static IDiet turtlediet = new Herbivore();
	
	
	public Turtle(String name)
	{
		super(name,tstartpoint);
		super.setWeight(1.0);
		super.setDiet(turtlediet);
		setAge(1);
		MessageUtility.logConstractor("Turtle", name);
	}
	
	public Turtle(String name,Point p)
	{
		super(name,p);
		super.setWeight(1.0);
		super.setDiet(turtlediet);
		setAge(1);
		MessageUtility.logConstractor("Turtle", name);
	}
	
	public EFoodType getFoodType()
	{
		return EFoodType.MEAT;
	}
	
	public boolean eat(IEdible food)
	{
		double newweight = super.getDiet().eat(this, food);
    	if (newweight>super.getweight())
    	{
    		super.makeSound();
    		super.setWeight(newweight);
    		return true;
    		
    	}
    	return false;
	}
	
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
	
	public double getAge()
	{
		MessageUtility.logGetter(getName(),"getAge()", this.age);
		return this.age;
	}
	
	public void chew()
	{
		MessageUtility.logSound(super.getName(),"Retracts its head in then eats quietly");
	}
	
	public String toString()
    {
		return this.getName();
    }
}