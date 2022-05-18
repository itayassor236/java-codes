package diet;
import animals.Animal;
import food.EFoodType;
import food.IEdible;
/**
 * A class of animals that eat everything
 * @version April 2022
 * @author Itay_asor
 *@see IDiet
 */
public class Omnivore implements IDiet{

    private static Herbivore h = new Herbivore();
    private static Carnivore c = new Carnivore();
    /**
     * @param food
     * @return true or false
     */
    public boolean canEat(EFoodType food)
    {
        if (!(food.equals(EFoodType.NOTFOOD)))
        {
            return true;
        }
        return false;
    }
    /**
     * @param animal
     * @param food
     * @return animal weight
     */
    public double eat(Animal animal,IEdible food)
    {
        double animalweight = animal.getweight();
        if(canEat(food.getFoodType()))
        {

            if (food.equals(EFoodType.VEGTABLE))
            {
                double neweight = h.eat(animal,food);
                return neweight;
            }

            else
            {
                double neweight = c.eat(animal,food);
                return neweight;
            }

        }
        return 0;
    }


}