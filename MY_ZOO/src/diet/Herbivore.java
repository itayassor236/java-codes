package diet;

import animals.Animal;
import food.EFoodType;
import food.IEdible;
/**
 * A Class of vegetarian animals
 * @version 07 April 2022
 * @author BarMor
 *@see IDiet
 */
public class Herbivore implements IDiet{
    /**
     * @param food
     * @return true or false
     */
    public boolean canEat(EFoodType food)
    {
        if(food.equals(EFoodType.VEGTABLE))
        {
            return true;
        }
        return false;
    }
    /**
     * @param animall
     * @param food
     * @return animal weight
     */
    public double eat(Animal animal, IEdible food)
    {
        if(canEat(food.getFoodType()))
        {
            double neweight=animal.getweight()*0.07;
            return neweight;
        }
        return 0;
    }

}