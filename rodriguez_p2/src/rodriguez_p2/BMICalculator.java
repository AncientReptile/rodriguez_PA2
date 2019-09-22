package rodriguez_p2;

import java.util.Scanner;

public class BMICalculator 
{

	public static void main(String[] args) 
	{
		String system_type, weight_type, height_type, result_category;
		int conversion_factor;
		double result, weight, height;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter which system you would like to use (imperial / metric): ");
		system_type = scan.next();
		
		if(system_type.equalsIgnoreCase("imperial"))
		{
			weight_type = "pounds: ";
			height_type = "inches: ";
			conversion_factor = 703;
		}
		else if(system_type.equalsIgnoreCase("metric"))
		{
			weight_type = "kilograms: ";
			height_type = "meters: ";
			conversion_factor = 1;
		}
		else
		{
			System.out.println("Invalid system");
			return;
		}
		
		System.out.println("Enter your weight in " + weight_type);
		weight = scan.nextDouble();
		
		System.out.println("Enter your height in " + height_type);
		height = scan.nextDouble();
		scan.close();
		
		result = conversion_factor * weight;
		result = result / Math.pow(height, 2);
		
		System.out.println("\n" + "Your BMI is " + result);
		
		if(result < 18.5)
		{
			result_category = "Underweight";
		}
		else if(result >= 18.5 && result < 25)
		{
			result_category = "Normal weight";
		}
		else if(result >= 25 && result < 30)
		{
			result_category = "Overweight";
		}
		else
		{
			result_category = "Obesity";
		}
		
		System.out.println("Your BMI category is " + result_category + "\n");
		
		System.out.println(
		"BMI Categories:" + "\n" 
		+ "Underweight =  < 18.5" + "\n" + "Normal weight = 18.5 - 24.9" + "\n"
		+ "Overweight = 25 - 29.9" + "\n" + "Obesity = >= 30"
		);
	}

}
