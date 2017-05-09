package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

// Update this file with your own code.

public class TextExcel
{

	public static void main(String[] args)
	{
		Scanner userInput = new Scanner(System.in);
		Spreadsheet excel = new Spreadsheet();
		String command = userInput.nextLine();
		while(!command.equals("quit")){
			excel.processCommand(command);
			command = userInput.nextLine();
		}
		userInput.close();
		
		String word = "Hel3o";
		System.out.println(word.substring(0,1));
		int row =  Integer.parseInt(word.substring(3));
		System.out.println(row - 1);
	}
}
