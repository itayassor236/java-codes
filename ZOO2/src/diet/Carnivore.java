package diet;
import animals.*;
import food.*;

/**
 * A class of predators
 * @version 07 April 2022
 * @author Itay_Asor
 *@see IDiet
 */
public class Carnivore implements IDiet{
	/**
	 * @param food
	 * @return true or false
	 */
	public boolean canEat(EFoodType food)
	{
		if(food.equals(EFoodType.MEAT))
		{
			return true;
		}
		return false;
	}
	/**
	 * @param animal
	 * @param food
	 * @return weight of animal
	 */
	public double eat(Animal animal, IEdible food)
	{
		if(canEat(food.getFoodType()))
		{
			double neweight=animal.getweight()*0.1;
			return neweight;
		}
		return 0;
	}

}