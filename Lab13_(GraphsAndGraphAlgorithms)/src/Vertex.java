//Each Vertex contains a name and state for keeping vertex names and visited status. 
public class Vertex {

	private VertexState state;
	private String name;
	
	//Creates new vertex. 
	public Vertex(String n)
	{
		state=VertexState.Unvisited;
		setName(n);
	}
	//Gets State
	public VertexState getState()
	{
		return state;
	}
	//Sets State
	public void setState(VertexState n)
	{
			state=n;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
}
