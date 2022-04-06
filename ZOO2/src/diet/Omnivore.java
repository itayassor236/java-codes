package diet;
import animals.Animal;
import food.EFoodType;
import food.IEdible;

public class Omnivore implements IDiet{
	
	private static Herbivore h = new Herbivore();
	private static Carnivore c = new Carnivore();
	
	public boolean canEat(EFoodType food)
	{
		if (!(food.equals(EFoodType.NOTFOOD)))
		{
			return true;
		}
		return false;
	}
	
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