import java.util.ArrayList;

public class Node
{
	Integer numOfChild;
	
	Integer numOfMetadata;
	ArrayList<Integer> metadata;
	
	public Node(Integer numOfChild, Integer numOfMetadata, ArrayList<Integer> metadata) {
		super();
		this.numOfChild = numOfChild;
		this.numOfMetadata = numOfMetadata;
		this.metadata = metadata;
	}
	
	public Integer getNumOfChild() {
		return numOfChild;
	}
	public void setNumOfChild(Integer numOfChild) {
		this.numOfChild = numOfChild;
	}
	public Integer getNumOfMetadata() {
		return numOfMetadata;
	}
	public void setNumOfMetadata(Integer numOfMetadata) {
		this.numOfMetadata = numOfMetadata;
	}
	public ArrayList<Integer> getMetadata() {
		return metadata;
	}
	public void setMetadata(ArrayList<Integer> metadata) {
		this.metadata = metadata;
	}
	
	
}