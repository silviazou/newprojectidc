package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	private int rows = 20;
	private int cols = 12;
	private Cell[][] cellSpreadSheet;
	private String grid;
	
	public Spreadsheet(){
		cellSpreadSheet = new Cell[rows][cols];
		for(int i = 0; i < rows; i ++){
			for(int j =0; j < cols; j++){
				cellSpreadSheet[i][j] = new EmptyCell();
			}
		}
	}
	
	
	@Override

	public String processCommand(String command)
	{
		if(command.trim() == ""){
			return "";
		}else{
			String[] split = command.split(" ");
			if(command.equals("clear")){
				return grid;
			}else if(split.length == 1){
				cellInspection(command);
				return getGridText();
			} else if(command.contains("=")){
				assign(command);
			}else if(command.contains("clear")){
				clearCell(command);
			}
		}
		return "Process Command";
	}
	
	public Cell cellInspection(String command){
		int row = command.charAt(0) - 'A';
		int col = Integer.parseInt(command.substring(1));
		return cellSpreadSheet[row][col];
	}
	
	public void assign(String command){
		String text;
		int row = command.charAt(0) - 'A';
		int column = command.charAt(1);
		text = command.substring(command.indexOf("=") + 2, command.length() - 1);
		cellSpreadSheet[row][column] = new TextCell(text);
	}
	
	public Cell[][] clear(){
		for(int i = 0; i < rows; i ++){
			for(int j =0; j < cols; j++){
				cellSpreadSheet[i][j] = new EmptyCell();
			}
		}
		return cellSpreadSheet;
	}
	public void clearCell(String command){
		for(int i = 0; i < rows; i ++){
			for(int j =0; j < cols; j++){
				cellSpreadSheet[i][j] = new EmptyCell();
			}
		}
	}
	@Override
	
	
	public int getRows()
	{
		return this.rows;
	}

	@Override
	public int getCols()
	{
		return this.cols;
	}

	@Override
	public Cell getCell(Location loc)
	{
		int row = loc.getRow();
		int col = loc.getCol();
		Cell cell;
		cell = cellSpreadSheet[row][col];
		return cell;
	}

	@Override
	public String getGridText()
	{
		grid = "   |";
		char letter = 'A';
		for(int i = 0; i < 12; i++){
			grid =  grid + letter + "          |"; 
			letter++;
		}
		grid = grid + "\n1  ";
		for(int i = 0; i < 20; i++){
			for(int j = 0; j < 12; j++){
				grid = grid +  "|" + cellSpreadSheet[i][j].abbreviatedCellText();
			}
			int index  = i + 2;
			if(index >= 21){
				grid = grid + "|" + "\n";
			}else{
				grid = grid + "| " + "\n" + index + " ";
				if(index < 10){
					grid = grid + " ";
				}
			}
		}
		return grid;
	}

}
