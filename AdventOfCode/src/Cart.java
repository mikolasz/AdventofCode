
public class Cart implements Comparable<Cart>{
	int posX;
	int posY;
	char direction;
	String nextTurn;
	boolean turn;
	boolean crashed;
	
	public Cart(int posx, int posy, char direction, String nextTurn, boolean turn, boolean crashed) {
		super();
		this.posX = posx;
		this.posY = posy;
		this.direction = direction;
		this.nextTurn = nextTurn;
		this.turn = turn;
		this.crashed = crashed;
	}
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posx) {
		this.posX = posx;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posy) {
		this.posY = posy;
	}
	public char getDirection() {
		return direction;
	}
	public void setDirection(char direction) {
		this.direction = direction;
	}
	public String getNextTurn() {
		return nextTurn;
	}
	public void setNextTurn(String nextTurn) {
		this.nextTurn = nextTurn;
	}
	public boolean isTurn() {
		return turn;
	}
	public void setTurn(boolean turn) {
		this.turn = turn;
	}
	
	public boolean isCrashed() {
		return crashed;
	}
	public void setCrashed(boolean crashed) {
		this.crashed = crashed;
	}
	@Override
	public int compareTo(Cart other) {
		return Integer.compare(this.posX, other.posX);
	}
	
}
