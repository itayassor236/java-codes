package diet;
import animals.*;
import food.*;


public class Carnivore implements IDiet{
	
	public boolean canEat(EFoodType food)
	{
		if(food.equals(EFoodType.MEAT))
		{
			return true;
		}
		return false;
	}
	
	public double eat(Animal animal, IEdible food)
	{
		if(canEat(food.getFoodType()))
		{
			double neweight=animal.getweight()*1.1;
			return neweight;
		}
		return animal.getweight();
	}

}
