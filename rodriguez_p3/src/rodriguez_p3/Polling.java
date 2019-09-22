package rodriguez_p3;

import java.util.Scanner;

public class Polling {

	public static void main(String[] args) 
	{
		String[] topics, topics_tb;
		String more_users;
		int[][] responses;
		int rating, i, j, total_weighted, total_row, value_temp, row_temp;
		double average;
		boolean more_responses, valid_response;
		Scanner scan;
		
		topics = new String[5];
		topics[0] = "Video Games";
		topics[1] = "Comics";
		topics[2] = "Gun Control";
		topics[3] = "Immigration";
		topics[4] = "Welfare";
		
		topics_tb = new String[5];
		topics_tb[0] = "Video Games ";
		topics_tb[1] = "Comics      ";
		topics_tb[2] = "Gun Control ";
		topics_tb[3] = "Immigration ";
		topics_tb[4] = "Welfare     ";
		
		responses = new int[5][10];
		
		scan = new Scanner(System.in);
		more_responses = true;
		valid_response = false;
		while(more_responses)
		{
			for(i = 0; i < 5; i++)
			{
				valid_response = false;
				while(!valid_response)
				{
					System.out.println("Rate the importance of the topic (1 - 10): " + topics[i]);
					rating = scan.nextInt();
					if(rating < 0 || rating > 10)
					{
						System.out.println("Invalid Response");
					}
					else
					{
						responses[i][rating - 1]++;
						valid_response = true;
					}
				}
			}
			
			valid_response = false;
			while(!valid_response)
			{
				System.out.println("Is there another participant? (y/n):");
				more_users = scan.next();
				if(more_users.equalsIgnoreCase("y"))
				{
					more_responses = true;
					valid_response = true;
				}
				else if(more_users.equalsIgnoreCase("n"))
				{
					more_responses = false;
					valid_response = true;
				}
				else
				{
					System.out.println("Invalid response");
				}
			}
		}
		scan.close();
		for(i = 0; i < 5; i++)
		{
			System.out.print(topics_tb[i]);
			total_weighted = 0;
			total_row = 0;
			average = 0;
			for(j = 0; j < 10; j++)
			{
				System.out.print(responses[i][j] + " ");
				total_weighted += (responses[i][j] * (j + 1));
				total_row += responses[i][j];
			}
			average = total_weighted / total_row;
			System.out.println("Avg: " + average);
		}
		
		row_temp = 0;
		value_temp = 0;
		total_weighted = 0;
		for(i = 0; i < 5; i++)
		{
			total_weighted = 0;
			total_row = 0;
			average = 0;
			for(j = 0; j < 10; j++)
			{
				total_weighted += (responses[i][j] * (j + 1));
			}
			if(value_temp < total_weighted)
			{
				row_temp = i;
				value_temp = total_weighted;
			}
		}
		System.out.println("The issue with the highest point total is " + topics[row_temp] + " with " + value_temp + " points");
		
		row_temp = 0;
		value_temp = 0;
		total_weighted = 0;
		
		for(i = 0; i < 5; i++)
		{
			total_weighted = 0;
			total_row = 0;
			average = 0;
			for(j = 0; j < 10; j++)
			{
				total_weighted += (responses[i][j] * (j + 1));
			}
			if(value_temp != 0 && value_temp > total_weighted)
			{
				row_temp = i;
				value_temp = total_weighted;
			}
			else
			{
				value_temp = total_weighted;
				row_temp = i;
			}
		}
		System.out.println("The issue with the lowest point total is " + topics[row_temp] + " with " + value_temp + " points");
	}

}
