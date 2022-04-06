package animals;
import mobility.Point;
import diet.Herbivore;
import diet.IDiet;
import food.*;
import mobility.Point;
import utilities.MessageUtility;

public class Elephant extends Chew {
	
	private double trunkLength;
	private final static Point estartpoint = new Point(50,90);
	private final static IDiet elephantdiet = new Herbivore();
	
	
	public Elephant(String name)
	{
		super(name,estartpoint);
		super.setWeight(500.0);
		super.setDiet(elephantdiet);
		setTrunkLength(1.0);
		MessageUtility.logConstractor("Elephant", name);
	}

	public Elephant(String name,Point p)
	{
		super(name,p);
		super.setWeight(500.0);
		super.setDiet(elephantdiet);
		setTrunkLength(1.0);
		MessageUtility.logConstractor("Elephant", name);
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
	
	public double getTrunkLengthe()
	{
		MessageUtility.logGetter(getName(),"getTrunkLength()", this.trunkLength);
		return this.trunkLength;
	}
	
	public void chew()
	{
		MessageUtility.logSound(super.getName(),"Trumpets with joy while flapping its ears, then chews");
	}
	
	public String toString()
    {
		return "[Elephant]:" + this.getName();
    }

}