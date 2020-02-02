import java.util.*;
public class BMICalculator {
	
	
	
	public static void main(String[] args) {
		
		int unitType = readUnitType();
		double height = getHeight(unitType);
		double weight = getWeight(unitType);
		double finalBMI = calculateBmi(unitType, height, weight);
		int bmiCategory = calculateBmiCategory(finalBMI);
		displayBmi(finalBMI, bmiCategory);
	}
	
	
	//read the measurement system the user wishes to use, assigned to an int value
	private static int readUnitType() {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the units of measurement for height "
				+ "you would like to use (Enter 0 for Imperial. Enter 1 for Metric.):");
		int unitType = input.nextInt();
		while (unitType < 0 || unitType > 1) {
			System.out.println("Please enter a valid number input "
					+ "(Enter 0 for Imperial. Enter 1 for Metric.):");
			unitType = input.nextInt();
		}
		return unitType;
	}
	
	//use the unitType to determine which method to use to get the correct height
	public static double getHeight(int unitType) {
		Scanner input = new Scanner(System.in);
		double finalHeight = 0;
		double temp = 0;
		
		//imperial height
		if (unitType == 0) {
			System.out.println("Please enter your height in feet: ");
			double heightFeet = input.nextDouble();
			
			System.out.println("Please enter the remaining inches, if any, in your height:");
			double heightInches = input.nextDouble();
			
			while(heightInches < 0 || heightInches > 11) {
				System.out.println("Please retry with inches between 0 and 11:");
				heightInches = input.nextInt();
			}
			finalHeight = (heightFeet * 12) + heightInches;
			System.out.println("Your height in inches is: " + finalHeight);
		} 
		// metric height
			else { 
			System.out.println("Please enter your height to the nearest meter: ");
			int heightMeters = input.nextInt();
			
			System.out.println("Please enter the remaining centimeters, if any, in your height:");
			int heightCentimeters = input.nextInt();
			
			while(heightCentimeters < 0 || heightCentimeters > 99) {
				System.out.println("Please retry with inches between 0 and 99:");
				heightCentimeters = input.nextInt();
			}
			temp = (heightMeters * 100) + heightCentimeters;
			finalHeight = temp/100;
			System.out.println("Your height in meters is: " + finalHeight);
		}
		return finalHeight;
	}
	
	//use the same value from unitType to determine which method is used to obtain the weight
	public static double getWeight(int unitType) {
		Scanner input = new Scanner(System.in);
		double finalWeight = 0;
		//imperial height
		if (unitType == 0) {
		 System.out.println("What is your weight in pounds? " );
	     double pounds = input.nextInt();
	     while (pounds < 0) {
	     System.out.println("Please enter a valid weight in pounds: " );
		 pounds = input.nextDouble();
	     }
	     finalWeight = pounds;
	     System.out.println("Your weight in pounds is: " + finalWeight);
	     return finalWeight;
		} 
		//metric height
			else {
			System.out.println("What is your weight in kilograms?");
		    double kilograms = input.nextDouble();
		    while (kilograms < 0) {
		    System.out.println("Please enter a valid weight in kilograms: " );
			kilograms = input.nextInt();
		    }
		    finalWeight = kilograms;
		    System.out.println("Your weight in kilograms is: " + finalWeight);
		}
		return finalWeight;
	  }
	
	//use the unitType value, the returned height value and the returned weight value to calculate
	//the correct BMI based on the measurement system used
	public static double calculateBmi(int unitType, double height, double weight) {
		double BMI = 0;
		if (unitType == 0) {
			BMI = (weight * 703) / (height * height);
		} else {
			BMI = (weight) / (height * height);
		}
		return BMI;
	}
	
	//use the returned BMI value to calculate and return the correct BMI category
	private static int calculateBmiCategory(double BMI){
		int category = 0;
		if (BMI < 18.5) {
			category = 1;
		} else if (BMI > 18.5 && BMI < 24.9) {
			category = 2;
		} else if (BMI > 25 && BMI < 29.9) {
			category = 3;
		} else {
			category = 4;
		}
		return category;
	}
	
	//finally, using the BMI and the BMI category, determine and print the correct BMI
	//and BMI category 
    public static void displayBmi(double BMI, int category)
    {
        System.out.println("Your BMI is: " + BMI);
        if (category == 1) {
        	System.out.println("Based on your BMI, you are underweight.");
        } else if (category == 2) {
        	System.out.println("Based on your BMI, you are normal weight.");
        } else if (category == 3) {
        	System.out.println("Based on your BMI, you are overweight.");
        } else if (category == 4) {
        	System.out.println("Based on your BMI, you are obese.");
        }
    }
}