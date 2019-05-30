package gitHubAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;

public class gitHub
{

	public static void main(String[] args) throws MalformedURLException, IOException 
	{
	//Command to display what the user should input
	System.out.println("Enter the exact user name of the GitHub account you would like to search: ");
	//Command to take the input and assign it to a variable "gitHubURL"
	Scanner keyboard = new Scanner(System.in);
	String gitHubURL = keyboard.nextLine();

	// To get the URL request, named connection
	// Takes the user input, 'gitHubURL' variable, and turns it to a URL to find the GitHub user 
	HttpURLConnection connection = (HttpURLConnection) new URL("https://api.github.com/users/" + gitHubURL + "/following").openConnection();
	connection.addRequestProperty("User-Agent", "Mozilla/67.0");
	
	// BufferedReader to read the JSON return
	BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	
	//Parse the return into JSON format
	String line = "", inputLine;
	while ((inputLine = in.readLine()) !=null) 
		{
		line += "\n" + inputLine;
		//Prints the Return in JSON format, only if you are logged in AND it's your profile.
		System.out.println(line);
		}
	

			{
				//Stop the return
				in.close();
				//Parse/Consume the JSON return by '\' , 'login' of the follower, and give the name that follows the next ':'.
				//Use Manual Manufacture parsing with the new lambda expression to loop through and find ALL followers
				//Print the names of all the followers with a max return of 5 followers
				Arrays.stream(line.split("\"login\":")).map(l -> l.split(",")[0]).limit(6).forEach(l -> System.out.println(l));
			}

	}
}
