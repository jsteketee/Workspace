
public class Graph {
				
	private double[][] edgeMatrix;  //stores edges.
	private Vertex V[];				//stores vertices. Keeps track of visited/unvisited. 
	int Vnum;						//keeps track of index at which to add vertex.

	
	//Creates graph object of size 'size'. 
	public Graph (int size)		
	{
		edgeMatrix= new double [size][size];
		V=new Vertex[size];
		Vnum=0;
	}
	
	//Creates vertex with name. 
	public void addVertex(String name)	
	{								 	
		if (Vnum >= edgeMatrix.length)								//Checks if V[] has room. 
			System.out.println("No room for more verticies!");
		else
		{
			V[Vnum]=new Vertex(name);							//else adds Vertex to V[].
			Vnum++;	
		}
	}
	
	//Adds undirected unweighted edge  (vA)<===>(vB).
	public void addEdge(int va, int vb) 	 
	{
		//First, checks if vertices exists. 
		if (va >= edgeMatrix.length || vb>=edgeMatrix.length)	 		
			System.out.println("Verticies do not exist");
		
		//Then adds values into the adj matrix.
		else
		{
			edgeMatrix[va][vb]=1;	
			edgeMatrix[vb][va]=1;
		}
	}
	
	//Adds directed unweighted edge from (va)===>(vb).
	public void addDirectedEdge(int va, int vb) 
	{
		//First checks if vertices exists. 
		if (va >= edgeMatrix.length || vb>=edgeMatrix.length)	 
			System.out.println("Verticies do not exist");
		
		//Adds one value into adj matrix. 
		else 
		{
			edgeMatrix[va][vb]=1;		
		}
	}
	
	//Adds undirected weighted edge from (va)<===>(vb).
	public void addEdgeWithWeight(int va, int vb, double weight) 
	{
		//First checks if vertices exists. 
		if (va >= edgeMatrix.length || vb>=edgeMatrix.length)	 //Checks if vertices exists. 
			System.out.println("Verticies do not exist");
		
		//Adds weight values to adj matrix. 
		else
		{
			edgeMatrix[va][vb]=weight;
			edgeMatrix[vb][va]=weight;
		}
	}
	
	//Adds directed edge with weight from (va)===>(vb).
	public void addDirectedEdgeWithWeight (int va, int vb, double weight) 
	{		
		//First checks if vertices exists. 
		if (va >= edgeMatrix.length || vb>=edgeMatrix.length)	 
			System.out.println("Verticies do not exist");
		
		//Adds weight value to adj matrix. 
		else
		{
			edgeMatrix[va][vb]=weight; 
		}	
	}
	
	//Breadth First Search
	public String BFS(int start)
	{
		if (start>=Vnum)
			return "Vertex Out of Bounds";
		
		//Sets all vertices to unvisited. 
		setAllUnvisited();
		
		int tempVertIdx;
		String toReturn="";			
	 
		Queue theQ = new Queue();   //Q manages drives search
		theQ.enqueue(start);		//puts start node in Q.
	
		while (!theQ.isEmpty())		//Keeps Dequeuing until nothing left.
		{
			tempVertIdx=(theQ.dequeue());					//DQs next vertex idx. 
			String stringToAdd=V[tempVertIdx].getName();	//Gets and concatenates that
			toReturn+=" "+stringToAdd+"("+tempVertIdx+")";	//vertex's name and #.
			V[tempVertIdx].setState(VertexState.Visited);   //Sets State to Visited. 
			
			for (int i=0;i<edgeMatrix.length;i++)			
			{					
				//checks all adj edges and adds to Vertices Q if unvisited. 
				if (edgeMatrix[tempVertIdx][i]!=0 && isUnvisited(i))		
				{
					theQ.enqueue(i);
					V[i].setState(VertexState.Visiting);
				}
			}
		}			    
		return toReturn;
	}
	
	//Depth First Search starter methodd. Utilizes recursive stack. 
	public String DFS(int start)
	{
		if (start>=Vnum)
			return "Vertex Out of Bounds";
		
		setAllUnvisited();  //Sets vertices to unvisited. 
		int curVert=start;	
		String toReturn="";
										
		return DFS(curVert, toReturn); //Passes starting Vidx and string to return. 
	}
	
	//Depth First Search driver method. 
	public String DFS(int curVert, String toReturn)
	{
		//Sets Current Vertex to visited. 
		V[curVert].setState(VertexState.Visited);		
		
		//Concatonates vert info to toReturn string. 
		toReturn+=" "+V[curVert].getName()+"("+curVert+")"; 
		
		//Checks for adj unvisited vertices to move on to. 
		for (int i=0;i<edgeMatrix.length;i++)
		{										
			if (edgeMatrix[curVert][i]!=0 && isUnvisited(i))	//Calls method on unvisited adj vertices.	
			{													//Once all adj vertices have been hit(for a given vertex),
				toReturn= DFS(i , toReturn);					//program backtracks through the stack until no unvisited vertices are left.
			}									
		}
		return toReturn;
	}
	
	//Shorest Path. (Similar to BFS). 
	public String shortestPath(int start)
	{
		if (start>=Vnum)
			return "Vertex Out of Bounds";
		
		//sets all vertices to unvisited.
		setAllUnvisited();					
		
		//Creates pathlength array with path to start V=0. 
		int path[]=new int [Vnum];					
		path[start]=0;				
		
		Queue theQ = new Queue();	//Q drives search. 
		theQ.enqueue(start);		//puts start node in Q.
		
		int tempV;
		while (!theQ.isEmpty())		//Keeps Dequeuing until nothing left.
		{
			tempV=(theQ.dequeue());				     	//DQs next vertex idx. 			   
			V[tempV].setState(VertexState.Visited);		//Sets State to Visited. 
			
			for (int i=0;i<edgeMatrix.length;i++)			
			{
				//checks all unvisted adj vertices and adds to Q.
				if (edgeMatrix[tempV][i]!=0 && isUnvisited(i))		
				{
					//enqueues and keeps pathlength of adj vertex. 
					theQ.enqueue(i);		
					
					//Each vertex pathlength is one greater then the adj vertex it came from. 
					path[i]=path[tempV]+1;	
					V[i].setState(VertexState.Visiting);	
				}
			}
		}
		//Prints pathlength array and returns. 
		String toReturn="";
		for(int z=0;z<path.length;z++)
			toReturn+=V[start].getName()+" to "+V[z].getName()+" path length = "+path[z]+"\n";
		
		return toReturn;
	}
	
	//Dijkstras Algorithm. 
	public String Dijkstras(int startV)
	{
		if (startV>=Vnum)
			return "Vertex Out of Bounds";
		
		//Sets All vertices to unvisited. 
		setAllUnvisited();
		
		int path[]=new int [Vnum];			//Creates pathlength array. 
		
		for (int i=0;i<path.length;i++)					
			path[i]=Integer.MAX_VALUE;		//Sets all lengths to max Value. 
		
		path[startV]=0;								//Sets path to starting v to be zero. 
		
		PriorityQueue PQ = new PriorityQueue(100);  //Creates Priority Q
		PQ.enqueue(startV, 0);						//Enqueues start V 
		
		while (!PQ.isEmpty())
		{
			int vertex=-1;
			while (vertex==-1||!isUnvisited(vertex))		//Finds vertex that is unvisited. 
			{										
				vertex=PQ.dequeue();
				if (PQ.isEmpty())
					break;			    
			}
			
			if (!isUnvisited(vertex))				//In case no unvisited vertices exist, breaks. 
				break;
				
			V[vertex].setState(VertexState.Visited);		//sets DQued vertex to visited. 
			
			for (int adjV=0;adjV<edgeMatrix.length;adjV++)				
			{
				//Finds adj unvisited vertices
				if (edgeMatrix[vertex][adjV]!=0 && isUnvisited(adjV))		
				{
					//Updates pathlength if shorter and enqueues vertex. 
					if(path[adjV]>(edgeMatrix[vertex][adjV]+path[vertex]))
					{
						path[adjV]=(int) (path[vertex]+edgeMatrix[vertex][adjV]);
						PQ.enqueue(adjV, path[adjV]);
					}
				}									
			}
		}
		//prints and returns pathlength array. 
		String toReturn="";
		for (int z=0;z<Vnum;z++)
			toReturn+="Minimum weight path from "+startV+" to "+z+" is "+path[z]+"\n";
		
		return toReturn;
	}
	
	//Just prints entire adj matrix for testing purposes.
	public void Print()
	{
		for (int i=0;i<edgeMatrix.length;i++)
		{
			System.out.print("row "+i+":  ");
			
			for (int j=0; j<edgeMatrix.length;j++)
			{
				System.out.print(" "+edgeMatrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	//Sets V[] to all unvisited. ]
	public void setAllUnvisited()
	{
		for (int j=0;j<Vnum;j++)
			V[j].setState(VertexState.Unvisited);
	}
	
	//Checks if vertex is unvisited. 
	public boolean isUnvisited(int i)
	{
		return (V[i].getState().equals(VertexState.Unvisited));
		
	}
}
