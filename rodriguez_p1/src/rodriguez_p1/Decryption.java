package rodriguez_p1;

import java.util.Scanner;

public class Decryption 
{

	public static void main(String[] args) 
	{
		int[] input_array = new int[4];
		int temp;
		
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		scan.close();
		
		input_array[3] = input % 10;
		input = input / 10;
		
		input_array[2] = input % 10;
		input = input / 10;
		
		input_array[1] = input % 10;
		input = input / 10;
		
		input_array[0] = input % 10;
		input = input / 10;
		
		temp = input_array[2];
		input_array[2] = (input_array[0] + 7) % 10;
		input_array[0] = (temp + 7) % 10;
		
		temp = input_array[3];
		input_array[3] = (input_array[1] + 7) % 10;
		input_array[1] = (temp + 7) % 10;
		
		System.out.print(input_array[0]);
		System.out.print(input_array[1]);
		System.out.print(input_array[2]);
		System.out.print(input_array[3]);
	}

}
