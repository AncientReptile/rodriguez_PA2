package rodriguez_p1;

import java.util.Scanner;

public class Encryption 
{

	public static void main(String[] args) 
	{
		int[] input_array = new int[4];
		int i, temp;
		
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		scan.close();
		
		for(i = 3; i >= 0; i--)
		{
			input_array[i] = input % 10;
			input = input / 10;
		}
		
		for(i = 0; i <= 1; i++)
		{
			temp = input_array[2 + i];
			input_array[2 + i] = (input_array[i] + 7) % 10;
			input_array[i] = (temp + 7) % 10;
		}
		
		for(i = 0; i < 4; i++)
		{
			System.out.print(input_array[i]);
		}
		
	}
	
}
