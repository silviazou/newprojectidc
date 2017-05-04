package textExcel;

public class TextCell implements Cell {
	
	private String text;
	
	public TextCell(String text){
		this.text = text;
	}
	
	@Override
	public String abbreviatedCellText() {
		if((text.length())> 10){
			return truncate(text);
		}else if(text.length() < 10){
			return pad(text);
		}else{
			return text;
		}
		
	}
	
	public String truncate(String text){
		int num2Remove = text.length() - 10;
		for(int i = 0; i < num2Remove; i++){
			text = text.substring(0, text.length() -1);
		}
		return text;
	}
	
	public String pad(String text){
		int numSpaces = 10 - text.length();
		for(int i = 0; i < numSpaces; i++){
			text += " ";
		}
		return text;
	}

	@Override
	public String fullCellText() {
		return text;
	}
}
