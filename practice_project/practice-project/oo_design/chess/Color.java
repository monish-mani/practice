package chess;

public enum Color {
	
	BLACK("Black"),WHITE("White");
	
	private String name;
	
	Color(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}

}
