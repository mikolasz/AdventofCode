
public class Player implements Comparable<Player>{
	int posX;
	int posY;
	char type;
	int HP;
	
	public Player(int posx, int posy, char type) {
		super();
		this.posX = posx;
		this.posY = posy;
		this.type = type;
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
	public char getType() {
		return type;
	}
	public void setType(char type) {
		this.type = type;
	}
	
	public int getHP() {
		return HP;
	}
	public void setHP(int hP) {
		HP = hP;
	}
	@Override
	public int compareTo(Player other) {
		if(Integer.compare(this.posX, other.posX) == 0) {
			return Integer.compare(this.posY, other.posY);
		} else {
			return Integer.compare(this.posX, other.posX);
		}
		
	}
	@Override
  public String toString() {
    return String.valueOf(this.type) + ", " + String.valueOf(this.posX) + ":" + String.valueOf(this.posY);
  }
	
}
