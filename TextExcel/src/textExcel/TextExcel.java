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
	}
}
