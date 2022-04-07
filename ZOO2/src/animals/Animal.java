package animals;
import mobility.*;
import food.*;
import diet.IDiet;
import utilities.MessageUtility;

/**
 * An abstract class of all animals
 * @version 1.4 07 April 2022
 * @author Bar_Mor
 *@see Roar
 */
public abstract class Animal extends Mobile implements IEdible{
	private String name;
	private double weight;
	private IDiet diet;
/**
 * 
 * @param name_
 * @param location_
 */
	public Animal(String name_,Point location_) 
	{
		super(location_);
		setName(name_);
		MessageUtility.logConstractor("Animal", name_);
	}
	/**
	 * 
	 * @param food
	 */
	public abstract boolean eat(IEdible food);
	/**
	 * 
	 * @return weight
	 */
	public double getweight()
	{
		MessageUtility.logGetter(name,"getWeight()", this.weight);
		return this.weight;
	}
	/**
	 * 
	 * @param w
	 * @return true or false
	 */
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
	/**
	 * 
	 * @param name
	 * @return true
	 */
	public boolean setName(String name)
	{
		this.name=name;
		MessageUtility.logSetter(name, "setName()",name, true);
		return true;
	}
	/**
	 * 
	 * @return name
	 */
	public String getName()
	{
		MessageUtility.logGetter(name,"getName()", this.name);
		return this.name;
	}
	
	public void makesound()
	{
		
	}
	
	/**
	 * 
	 * @param d
	 * @return true
	 */
	public boolean setDiet(IDiet d)
	{
		this.diet=d;
		MessageUtility.logSetter(name, "setDiet()",d.getClass().getSimpleName(), true);
		return true;
	}
	/**
	 * 
	 * @return diet
	 */
	public IDiet getDiet()
	{
		MessageUtility.logGetter(name,"getDiet()", this.diet.getClass().getSimpleName());
		return this.diet;
	}
	/**
	 * 
	 * @param p3
	 * @return distance
	 */
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

	public abstract String toString();
}


