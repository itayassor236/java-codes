package animals;
import mobility.Point;
import diet.Herbivore;
import diet.IDiet;
import food.*;
import java.util.Random;
import mobility.Point;
import utilities.MessageUtility;

public class Giraffe extends Chew {
	
	private double neckLength;
	private final static Point gstartpoint = new Point(50,0);
	private final static IDiet giraffediet = new Herbivore();
	
	
	public Giraffe(String name)
	{
		super(name,gstartpoint);
		super.setWeight(450.0);
		super.setDiet(giraffediet);
		setNeckLength(1.5);
		MessageUtility.logConstractor("Giraffe", name);
	}
	public Giraffe(String name,Point p)
	{
		super(name,p);
		super.setWeight(450.0);
		super.setDiet(giraffediet);
		setNeckLength(1.5);
		MessageUtility.logConstractor("Giraffe", name);
	}
	
	public EFoodType getFoodType()
	{
		return EFoodType.MEAT;
	}
	
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
	
	public double getNeckLengthe()
	{
		MessageUtility.logGetter(getName(),"getName()", this.neckLength);
		return this.neckLength;
	}
	
	public void chew()
	{
		MessageUtility.logSound(super.getName(),"Bleats and Stomps its legs, then chews");
	}
	
	public String toString()
    {
		return "[Giraffe]:" + this.getName();
    }
}