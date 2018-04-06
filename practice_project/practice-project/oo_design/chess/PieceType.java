package chess;

public enum PieceType {
	QUEEN("Queen"),KNIGHT("Knight"),PAWN("Pawn"),ROOK("Rook"),KING("King"),BISHOP("Bishop");
	
	private String name;
	
	PieceType(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}

}
