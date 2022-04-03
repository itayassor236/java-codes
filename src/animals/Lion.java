package animals;
import mobility.Point;
import diet.Carnivore;
import diet.IDiet;
import food.*;
import java.util.Random;
import utilities.MessageUtility;

public class Lion extends Roar {
	
	private int scarCount;
	private final static IDiet liondiet=new Carnivore();
	private final static Point startlocation=new Point(20,0);
	
	
	public Lion(String name)
	{
		super(name,startlocation);
		super.setWeight(408.2);
		super.setDiet(liondiet);
		this.scarCount=0;
		MessageUtility.logConstractor("Lion", name);
	}
	
	public Lion(String name,Point p)
	{
		super(name,p);
		super.setWeight(408.2);
		super.setDiet(liondiet);
		this.scarCount=0;
		MessageUtility.logConstractor("Lion", name);
	}
	
    public EFoodType getFoodType()
    {
    	return EFoodType.NOTFOOD;
    }
    
    public boolean eat(IEdible food)
    {
    	double newweight = super.getDiet().eat(this, food);
    	if (newweight>super.getweight())
    	{
    		Random scars=new Random();
    		this.scarCount=scars.nextInt(scarCount,scarCount+1);
    		super.makeSound();
    		super.setWeight(newweight);
    		return true;
    		
    	}
    	return false;
    }
	
    public int getScars()
    {
    	MessageUtility.logGetter(this.getName(),"getScars()", this.scarCount);
    	return this.getScars();
    }
    
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
    
	public void roar()
	{
		MessageUtility.logSound(super.getName(),"Roars, then stretches and shakes its mane");
	}
	
	public String toString()
    {
    	return this.getName();
    }

}
