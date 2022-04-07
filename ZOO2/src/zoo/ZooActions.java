package zoo;
import animals.*;
import food.IEdible;
import mobility.Point;
import utilities.MessageUtility;

import java.util.*;
/**
 * 
 * @author ItayAsor
 *
 */
public class ZooActions {
	/**
	 * 
	 * @param animal
	 * @param food
	 * @return true or false
	 */
	public boolean eat(Object animal,IEdible food)
	{
		if(animal instanceof Animal)
		{
			if (((Animal)animal).eat(food))
            {
  	         return true;
            }
            return false;
        
		}
		return false;
	}
	/**
	 * 
	 * @param animal
	 * @param point
	 * @return true or false
	 */
	
	public static boolean move(Object animal, Point point)
	{
		if(point.checkBoundaries(point))
		{
			if (animal instanceof Lion)
			{
			 ((Lion)animal).move(point);
			 return true;
			}
			else if (animal instanceof Bear)
			{
			 ((Bear)animal).move(point);
			 return true;
			}
			else if (animal instanceof Elephant)
			{
			 ((Elephant)animal).move(point);
			 return true;
			}
			else if (animal instanceof Giraffe)
			{
			 ((Giraffe)animal).move(point);
			 return true;
			}
			else if (animal instanceof Turtle)
			{
			 ((Turtle)animal).move(point);
			 return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}

    
	/**
	 * 
	 * @param args
	 */
   public static void main(String[] args)
   {
	   Animal array[];
       String nameofanimal,bearfur;
	   int sizeofarray,choice,choice2,choice3,numofscars,turtleage,x,y;
	   double giraffenecklength,elephanttrunklength;
	   Scanner sc=new Scanner(System.in);
	   System.out.print("Enter size for the array :\n");
	   sizeofarray=sc.nextInt();
	   while(sizeofarray<3)
	   {
		   System.out.print("Wrong number entered !,try again \n");
		   sizeofarray=sc.nextInt();
	   }
	   array=new Animal [sizeofarray];
	   for(int i=0;i<sizeofarray;i++)
	   {
		   System.out.print("Please enter animal name :\n");
		   nameofanimal=sc.next();
		   System.out.print("Please select type of animal :\n");
		   System.out.print("1)Lion \n2)Bear \n3)Elephant \n4)Giraffe \n5)Turtle \n");
		   choice=sc.nextInt();
		   while(choice<1||choice>5)
		   {
			   System.out.print("Not in range choice!,please try again \n");
			   System.out.print("1)Lion \n2)Bear \n3)Elephant \n4)Giraffe \n5)Turtle \n");
			   choice=sc.nextInt();
		   }
		   System.out.print("Would you like to enter a start point for the animal :\n");
		   System.out.print("1)Yes \n2)No \n");
		   choice2=sc.nextInt();
		   while(choice2!=1&&choice2!=2)
		   {
			   System.out.print("Try again! \n");
			   System.out.print("1)Yes \n2)No \n");
			   choice2=sc.nextInt();
		   }
		   if(choice2==1)
		   {
			   System.out.print("Enter value of x in point :\n");
			   x=sc.nextInt();
			   System.out.print("Enter value of y in point :\n");
			   y=sc.nextInt();
			   Point p = new Point(x,y);
			   while(!p.checkBoundaries(p))
			   {
				   System.out.print("Out of range point!, please try again :\n");
				   System.out.print("Enter value of x in point :\n");
				   x=sc.nextInt();
				   System.out.print("Enter value of y in point :\n");
				   y=sc.nextInt();
				   p = new Point(x,y);
				   
			   }
			   
			   if(choice==1)
			   {
				   array[i]=new Lion(nameofanimal,p);
				   System.out.print("Does the lion have scars? \n");
				   System.out.print("1)Yes \n2)No \n");
				   choice3=sc.nextInt();
				   if(choice3!=1&&choice3!=2)
				   {
					   System.out.print("Try again! \n");
					   System.out.print("1)Yes \n2)No \n");
					   choice3=sc.nextInt();
				   }
				   if(choice3==1)
				   {
					   System.out.print("Enter number of scars:\n");
					   numofscars=sc.nextInt();
					   while (!((Lion)array[i]).setScars(numofscars))
						 {
						   System.out.print("Error number entered!, try again \n");
						   System.out.print("Enter number of scars:\n");
						   numofscars=sc.nextInt();
						 }
					   
				   }
			   }
			   else if(choice==2)
			   {
				   array[i]=new Bear(nameofanimal,p);
				   System.out.print("Would you like to enter bear fur color? \n");
				   System.out.print("1)Yes \n2)No \n");
				   choice3=sc.nextInt();
				   if(choice3!=1&&choice3!=2)
				   {
					   System.out.print("Try again! \n");
					   System.out.print("1)Yes \n2)No \n");
					   choice3=sc.nextInt();
				   }
				   if(choice3==1)
				   {
					   System.out.print("Enter fur color:\n");
					   bearfur=sc.next();
					   while(!((Bear)array[i]).setFurColor(bearfur))
					   {
						   System.out.print("Error color!,try again \n");
						   System.out.print("Enter fur color:\n");
						   bearfur=sc.next();
						   
					   }
					   
				   }
				   
			   }
			   else if(choice==3)
			   {
				   array[i]=new Elephant(nameofanimal,p);
				   System.out.print("Would you like to enter elephant trunk length? \n");
				   System.out.print("1)Yes \n2)No \n");
				   choice3=sc.nextInt();
				   if(choice3!=1&&choice3!=2)
				   {
					   System.out.print("Try again! \n");
					   System.out.print("1)Yes \n2)No \n");
					   choice3=sc.nextInt();
				   }
				   if(choice3==1)
				   {
					   System.out.print("Enter trunk length:\n");
					   elephanttrunklength=sc.nextDouble();
					   while(!((Elephant)array[i]).setTrunkLength(elephanttrunklength))
					   {
						   System.out.print("Error length!,try again \n");
						   System.out.print("Enter trunk length: \n");
						   elephanttrunklength=sc.nextDouble();
						   
					   }
					   
				   }
			   }
			   else if(choice==4)
			   {
				   array[i]=new Giraffe(nameofanimal,p);
				   System.out.print("Would you like to enter giraffe neck length? \n");
				   System.out.print("1)Yes \n2)No \n");
				   choice3=sc.nextInt();
				   if(choice3!=1&&choice3!=2)
				   {
					   System.out.print("Try again! \n");
					   System.out.print("1)Yes \n2)No \n");
					   choice3=sc.nextInt();
				   }
				   if(choice3==1)
				   {
					   System.out.print("Enter neck lengte: \n");
					   giraffenecklength=sc.nextDouble();
					   while(!((Giraffe)array[i]).setNeckLength(giraffenecklength))
					   {
						   System.out.print("Error length!,try again \n");
						   System.out.print("Enter neck length :\n");
						   giraffenecklength=sc.nextDouble();
						   
					   }
					   
				   }
			   }
			   else
			   {
				   array[i]=new Turtle(nameofanimal,p);
				   System.out.print("Would you like to enter turtle age? \n");
				   System.out.print("1)Yes \n2)No \n");
				   choice3=sc.nextInt();
				   if(choice3!=1&&choice3!=2)
				   {
					   System.out.print("Try again! \n");
					   System.out.print("1)Yes \n2)No \n");
					   choice3=sc.nextInt();
				   }
				   if(choice3==1)
				   {
					   System.out.print("Enter turtle age:\n");
					   turtleage=sc.nextInt();
					   while(!((Turtle)array[i]).setAge(turtleage))
					   {
						   System.out.print("Error age!,try again \n");
						   System.out.print("Enter turtle age:\n");
						   turtleage=sc.nextInt();
						   
					   }
					   
				   }
			   }
			   
		}
		   
		   else
			   if(choice==1)
			   {
				   array[i]=new Lion(nameofanimal);
				   System.out.print("Does the lion have scars? \n");
				   System.out.print("1)Yes \n2)No \n");
				   choice3=sc.nextInt();
				   if(choice3!=1&&choice3!=2)
				   {
					   System.out.print("Try again! \n");
					   System.out.print("1)Yes \n2)No \n");
					   choice3=sc.nextInt();
				   }
				   if(choice3==1)
				   {
					   System.out.print("Enter number of scars:\n");
					   numofscars=sc.nextInt();
					   while (!((Lion)array[i]).setScars(numofscars))
						 {
						   System.out.print("Error number entered!, try again \n");
						   System.out.print("Enter number of scars:\n");
						   numofscars=sc.nextInt();
						 }
					   
				   }
			   }
			   else if(choice==2)
			   {
				   array[i]=new Bear(nameofanimal);
				   System.out.print("Would you like to enter bear fur color? \n");
				   System.out.print("1)Yes \n2)No \n");
				   choice3=sc.nextInt();
				   if(choice3!=1&&choice3!=2)
				   {
					   System.out.print("Try again! \n");
					   System.out.print("1)Yes \n2)No \n");
					   choice3=sc.nextInt();
				   }
				   if(choice3==1)
				   {
					   System.out.print("Enter fur color:\n");
					   bearfur=sc.next();
					   while(!((Bear)array[i]).setFurColor(bearfur))
					   {
						   System.out.print("Error color!,try again \n");
						   System.out.print("Enter fur color:\n");
						   bearfur=sc.next();
						   
					   }
					   
				   }
				   
			   }
			   else if(choice==3)
			   {
				   array[i]=new Elephant(nameofanimal);
				   System.out.print("Would you like to enter elephant trunk length? \n");
				   System.out.print("1)Yes \n2)No \n");
				   choice3=sc.nextInt();
				   if(choice3!=1&&choice3!=2)
				   {
					   System.out.print("Try again! \n");
					   System.out.print("1)Yes \n2)No \n");
					   choice3=sc.nextInt();
				   }
				   if(choice3==1)
				   {
					   System.out.print("Enter trunk length:\n");
					   elephanttrunklength=sc.nextDouble();
					   while(!((Elephant)array[i]).setTrunkLength(elephanttrunklength))
					   {
						   System.out.print("Error length!,try again \n");
						   System.out.print("Enter trunk length: \n");
						   elephanttrunklength=sc.nextDouble();
						   
					   }
					   
				   }
			   }
			   else if(choice==4)
			   {
				   array[i]=new Giraffe(nameofanimal);
				   System.out.print("Would you like to enter giraffe neck length? \n");
				   System.out.print("1)Yes \n2)No \n");
				   choice3=sc.nextInt();
				   if(choice3!=1&&choice3!=2)
				   {
					   System.out.print("Try again! \n");
					   System.out.print("1)Yes \n2)No \n");
					   choice3=sc.nextInt();
				   }
				   if(choice3==1)
				   {
					   System.out.print("Enter neck lengte: \n");
					   giraffenecklength=sc.nextDouble();
					   while(!((Giraffe)array[i]).setNeckLength(giraffenecklength))
					   {
						   System.out.print("Error length!,try again \n");
						   System.out.print("Enter neck length :\n");
						   giraffenecklength=sc.nextDouble();
						   
					   }
					   
				   }
			   }
			   else
			   {
				   array[i]=new Turtle(nameofanimal);
				   System.out.print("Would you like to enter turtle age? \n");
				   System.out.print("1)Yes \n2)No \n");
				   choice3=sc.nextInt();
				   if(choice3!=1&&choice3!=2)
				   {
					   System.out.print("Try again! \n");
					   System.out.print("1)Yes \n2)No \n");
					   choice3=sc.nextInt();
				   }
				   if(choice3==1)
				   {
					   System.out.print("Enter turtle age:\n");
					   turtleage=sc.nextInt();
					   while(!((Turtle)array[i]).setAge(turtleage))
					   {
						   System.out.print("Error age!,try again \n");
						   System.out.print("Enter turtle age:\n");
						   turtleage=sc.nextInt();
						   
					   }
					   
				   }
			   
		        }
		   
		   
	   }
	   
  
   for(int i=0;i<sizeofarray;i++)
   {
	   System.out.print("Enter a point you like to move the animal to :\n");
	   x=sc.nextInt();	
	   y=sc.nextInt();
	   Point p1 = new Point(x,y);
	  
	
	   if(move(array[i],p1))
	    {
		   MessageUtility.logBooleanFunction(array[i].getName(), "move()", p1.getPoint(), true);
	    }
	   else 
	    {
		   MessageUtility.logBooleanFunction(array[i].getName(), "move()", p1.getPoint(), false);
	    }
	   
	   
	}
   for(int i=0;i<sizeofarray/2;i++)
   {
	   Random check =new Random();
	   Random check2= new Random();
	   int j=check.nextInt(sizeofarray-1),k=check2.nextInt(sizeofarray-1);
	   while(j==k) 
	   {
		   k=check2.nextInt(sizeofarray-1);
	   }
	   
	   if(array[j].eat(array[k]))
	   {
		   MessageUtility.logBooleanFunction(array[j].getName(), "eat()",array[k].getName(), true);
	   }
	   else
	   
	   
	   {
		   MessageUtility.logBooleanFunction(array[j].getName(), "eat()",array[k].getName(), false);
	   }
	   System.out.print("finish");
   }
   
   }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
 }