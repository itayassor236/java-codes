package animals;
import mobility.*;
import food.*;
import diet.IDiet;
import utilities.MessageUtility;
import graphics.IAnimalBehavior;
import graphics.IDrawable;
import graphics.ZooPanel;

/**
 * An abstract class of all animals
 * @version 1.4 07 April 2022
 * @author Bar_Mor
 *@see Roar
 */
public abstract class Animal extends Mobile implements IEdible,IDrawable,IAnimalBehavior{
	private String name;
	private double weight;
	private IDiet diet;
	private final int EAT_DISTANCE = 10;
	private int size;
	private String col;
	private int horSpeed;
	private int verSpeed;
	private boolean colordChanged;
	private Thread thread;
	private int x_dir;
	private int y_dir;
	private int eatCount;
	private ZooPanel pan;
	private BufferedImage img1, img2;
/**
 * 
 * @param name_
 * @param location_
 */
	public Animal(String name_,Point location_) 
	{
		super(location_);
		setName(name_);
		this.colordChanged=false;
		this.eatCount=0;
		MessageUtility.logConstractor("Animal", name_);
	}

	public Animal(Point point,int size,String col,int horSpeed,int verSpeed)
	{
		super(point);
		setName(" ");
		this.colordChanged=false;
		this.eatCount=0;
		this.size=size;
		this.col=col;
		this.horSpeed=horSpeed;
		this.verSpeed=verSpeed;
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
	
	public int getEatCount()
	{
		return this.eatCount;
	}
	
	public void setEatCount()
	{
	this.eatCount+=1;
	}
	
	public boolean getChanges ()
	{
		return this.colordChanged;
	}
	public void setChanges (boolean state)
	{
		if(state)
		{
			this.colordChanged=true;
		}
		
	}
	public String getAnimalName()
	{
		return this.name;
	}
	public int getSize()
	{
		return this.size;
	}
	public void eatInc()
	{
		this.eatCount++;
	}
	
	
	
}


