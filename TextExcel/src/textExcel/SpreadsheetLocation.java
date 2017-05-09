package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
	int row;
	int col;
	private String cellName;
    @Override
    public int getCol()
    {
    	row =  Integer.parseInt(cellName.substring(1, 2));
    	return row - 1;
    }

    @Override
    public int getRow()
    {
    	col = cellName.charAt(0);
    	return col - 'A';
    }
    
    public SpreadsheetLocation(String cellName)
    {
        this.cellName = cellName;
    }
}
