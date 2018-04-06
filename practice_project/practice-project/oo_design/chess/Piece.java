package chess;

public class Piece implements Moveable {
	PieceType type;
	Color color;
	
	
	@Override
	public void move(BoardSquare currentPos, BoardSquare newPos) {
		// TODO Auto-generated method stub
		
	}
	
	public String getId(){
		return this.color.getName() + "." + this.type.getName();
	}

}
