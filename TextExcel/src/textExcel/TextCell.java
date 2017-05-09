package textExcel;

public class TextCell implements Cell {
	
	private String text;
	
	public TextCell(String text){
		this.text = text;
	}
	
	@Override
	public String abbreviatedCellText() {
		if((text.length())> 10){
			truncate();
		}else if(text.length() < 10){
			pad();
		}
		return text;
	}
	
	public void truncate(){
		while(text.length() > 10){
			text = text.substring(0, text.length() -1);
		}
	}
	
	public void pad(){
		while(text.length() < 10){
			text += " ";
		}
	}

	@Override
	public String fullCellText() {
		return text;
	}
}
