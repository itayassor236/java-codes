package diet;

import animals.Animal;
import food.EFoodType;
import food.IEdible;

public class Herbivore implements IDiet{
	public boolean canEat(EFoodType food)
	{
		if(food.equals(EFoodType.VEGTABLE))
		{
			return true;
		}
		return false;
	}
	
	public double eat(Animal animal, IEdible food)
	{
		if(canEat(food.getFoodType()))
		{
			double neweight=animal.getweight()*1.07;
			return neweight;
		}
		return animal.getweight();
	}

}
