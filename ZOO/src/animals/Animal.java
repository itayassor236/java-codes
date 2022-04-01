package animals;
import mobility.*;
import food.*;
import diet.IDiet;
import utilities.MessageUtility;


public abstract class Animal extends Mobile implements IEdible{
	private String name;
	private double weight;
	private IDiet diet;
	
	public Animal(String name_,Point location_) 
	{
		super(location_);
		setName(name_);
		MessageUtility.logConstractor("Animal", name_);
	}
	
	public abstract boolean eat(IEdible food);
	
	public double getweight()
	{
		MessageUtility.logGetter(name,"getWeight()", this.weight);
		return this.weight;
	}
	
	public boolean setWeight(double w)
	{
		if (w>0.0)
		{
			this.weight=w;
			MessageUtility.logSetter(name, "setWeight()",w, true);
			return true;
		}
		MessageUtility.logSetter(name, "setWeight()",w, false);
		return false;	
	}
	
	public boolean setName(String name)
	{
		this.name=name;
		MessageUtility.logSetter(name, "setName()",name, true);
		return true;
	}
	
	public String getName()
	{
		MessageUtility.logGetter(name,"getName()", this.name);
		return this.name;
	}
	
	public void makesound()
	{
		
	}
	
	
	public boolean setDiet(IDiet d)
	{
		this.diet=d;
		MessageUtility.logSetter(name, "setDiet()",d.getClass().getSimpleName(), true);
		return true;
	}
	
	public IDiet getDiet()
	{
		MessageUtility.logGetter(name,"getDiet()", this.diet);
		return this.diet;
	}
	
	public double move(Point p3) 
	{
		double d=calcDistance(p3);
		if(d>0)
		{
		 super.setLocation(p3);
		 super.setTotalDistance(super.getTotalDistance()+d);
		 this.weight-=(d*weight*0.00025);
		}
		return d;
		
	}
	public abstract String toString()
	{}
	
	

}
