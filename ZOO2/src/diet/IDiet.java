package diet;
import animals.*;
import food.EFoodType;
import food.IEdible;

public interface IDiet {
	/**
	 * 
	 * @param food
	 */
 public boolean canEat(EFoodType food);
 /**
  * 
  * @param animal
  * @param food
  */
 public double eat(Animal animal, IEdible food);
 
 
 
}