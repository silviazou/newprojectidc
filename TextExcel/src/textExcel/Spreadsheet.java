package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	private int gridRows = 20;
	private int gridCols = 12;
	private Cell[][] cellSpreadSheet;

	public Spreadsheet(){
		cellSpreadSheet = new Cell[gridRows][gridCols];
		for(int i = 0; i < gridRows; i ++){
			for(int j =0; j < gridCols; j++){
				cellSpreadSheet[i][j] = new EmptyCell();                        //Creates spreadsheet
			}
		}
	}


	@Override

	public String processCommand(String command)
	{
		String[] split = command.split(" ");
		SpreadsheetLocation loc = new SpreadsheetLocation(split[0].toUpperCase());  // find location
		int row = loc.getRow();
		int col = loc.getCol();

		if((command.trim()).equals("")){
			return "";                                                            //Checks for blank command
		}
		if(((command.trim()).toLowerCase()).equals("clear")){
			clear();
		}else if(split.length == 1){
			return cellInspection(row, col);
		} else if(command.contains("=")){                                         //checks which method to run
			assign(row, col, command.substring(command.indexOf("=")));
		}else if(command.contains("clear") && split.length > 1){
			clearCell(row, col);
		}
		return getGridText();
	}

	public String cellInspection(int row, int col){
		return cellSpreadSheet[row][col].fullCellText();
	}

	public void assign(int row, int col, String text){			//finds assignment value and assigns cells to value
		cellSpreadSheet[row][col] = new TextCell(text);				
	}

	public void clear(){
		for(int i = 0; i < gridRows; i ++){
			for(int j =0; j < gridCols; j++){
				cellSpreadSheet[i][j] = new EmptyCell();                //Assigns all cells to EmptyCell
			}
		}
	}
	public void clearCell(int row, int col){

		cellSpreadSheet[row][col] = new EmptyCell();                       //assigns to EmptyCell
	}
	@Override


	public int getRows()
	{
		return this.gridRows;                                    //returns num rows
	}

	@Override
	public int getCols()
	{
		return this.gridCols;                                 //returns num columns
	}

	@Override
	public Cell getCell(Location loc)
	{
		int row = loc.getRow();
		int col = loc.getCol();
		return cellSpreadSheet[row][col];                                  //Returns cell at location
	} 

	@Override
	public String getGridText()
	{
		String grid = "   |";
		for(char i = 'A'; i <= 'L'; i++){
			grid =  grid + i + "         |";   //Creates column names
		}
		for(int i = 1; i <= 20; i++){
			if(i<=9){
				grid = grid + "\n" + i + "  |";
			}else{
				grid = grid + "\n" + i + " |";
			}
			for(int j = 0; j<12;j++){
				grid = grid + cellSpreadSheet[i-1][j].abbreviatedCellText() + "|";   //adds text into cells
			}
		}
		grid = grid + "\n";
		return grid;
	}
}
