package animals;
import mobility.Point;
import diet.Omnivore;
import diet.IDiet;
import food.*;
import utilities.MessageUtility;

public class Bear extends Roar {
	
	private String furColor;
	private final static IDiet beardiet=new Omnivore();
	private final static Point startlocation=new Point(100,5);
	
	
	public Bear(String name)
	{
		super(name,startlocation);
		super.setWeight(308.2);
		super.setDiet(beardiet);
		setFurColor("GRAY");
		MessageUtility.logConstractor("Bear", name);
	}
	
	public Bear(String name,Point p)
	{
		super(name,p);
		super.setWeight(308.2);
		super.setDiet(beardiet);
		setFurColor("GRAY");
		MessageUtility.logConstractor("Bear", name);
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
    
    public String getFurColor()
    {
    	MessageUtility.logGetter(getName(), "getFurColor()",this.furColor);
    	return this.furColor;
    }
    	
    public void roar()
    {
    		MessageUtility.logSound(super.getName(),"Stands on its hind legs, roars and scratches its belly");
    }
    
    public String toString()
    {
    	return this.getName();
    }
    	


    }

