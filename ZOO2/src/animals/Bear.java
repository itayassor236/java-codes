package animals;
import mobility.Point;
import diet.Omnivore;
import diet.IDiet;
import food.*;
import utilities.MessageUtility;

/**
 *class of the animal: bear
 * @version 1.4 07 April 2022
 * @author Bar_Mor
 */
public class Bear extends Roar {
	
	private String furColor;
	private final static IDiet beardiet=new Omnivore();
	private final static Point startlocation=new Point(100,5);
	
	/**
	 * 
	 * @param name
	 */
	public Bear(String name)
	{
		super(name,startlocation);
		super.setWeight(308.2);
		super.setDiet(beardiet);
		setFurColor("GRAY");
		MessageUtility.logConstractor("Bear", name);
	}
	/**
	 * 
	 * @param name
	 * @param p
	 */
	public Bear(String name,Point p)
	{
		super(name,p);
		super.setWeight(308.2);
		super.setDiet(beardiet);
		setFurColor("GRAY");
		MessageUtility.logConstractor("Bear", name);
	}
	
	public Bear(int size,String col,int horSpeed,int verSpeed)
	{
		super(startlocation,size,col,horSpeed,verSpeed);
		super.setDiet(beardiet);
		super.setWeight(size*1.5);
		
		
		
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
    		super.setEatCount();
    		return true;
    		
    	}
    	return false;
    }
	
    /**
     * 
     * @param fur
     * @return true or false
     */
    public boolean setFurColor(String fur)
    {
    	if(fur.equals("GRAY")||fur.equals("BLACK")||fur.equals("WHITE"))
    	{
    		this.furColor=fur;
    		MessageUtility.logSetter(getName(), "setFurColor()",fur, true);
    		return true;
    	}
    	else
    	{
    		MessageUtility.logSetter(getName(), "setFurColor()",fur, false);
    		return false;
    	}
    }
    /**
     * 
     * @return color
     */
    public String getFurColor()
    {
    	MessageUtility.logGetter(getName(), "getFurColor()",this.furColor);
    	return this.furColor;
    }
    	
    public void roar()
    {
    		MessageUtility.logSound(super.getName(),"Stands on its hind legs, roars and scratches its belly");
    }
    /**
     * @return Bear name
     */
    public String toString()
    {
    	return "[Bear]:" + this.getName();
    }
    	


    }