package implementation;

import graph.Graph;
import graph.Edge;
import graph.Vertex;
import graph.DirectedEdge;

public class ImplementationGraph implements Graph
{
	private int[][] adjacentMatrix;
	private Edge[] edgeList;
	private Vertex[] vertexList;

	public ImplementationGraph(int[][] array, Edge[] el, Vertex[] vl)
	{
		adjacentMatrix = array;
		edgeList = el;
		vertexList = vl;
	}

	public Edge addEdge(Vertex sourceVertex, Vertex targetVertex)
	{
		Edge e = new DirectedEdge(sourceVertex, targetVertex);
		Edge[] newEdgeArray = new Edge[edgeList.length + 1];

	    //Copie  
	    for (int i = 0; i < edgeList.length; i++){
	        newEdgeArray[i] = edgeList[i];
	    }
		//Ajout de l'edge    
	    newEdgeArray[newEdgeArray.length - 1] = e;
	    edgeList = newEdgeArray;
	    return e;
	}

	public boolean addEdgeToGraph(Vertex sourcevertex, Vertex targetVertex, Edge edge)
	{	
		return true;
	}

	public boolean addVertexToGraph(Vertex vertex)
	{
		Vertex[] newVertexArray = new Vertex[vertexList.length + 1];

	    //Copie  
	    for (int i = 0; i < vertexList.length; i++){
	        newVertexArray[i] = vertexList[i];
	    }
		//Ajout de l'edge    
	    newVertexArray[newVertexArray.length - 1] = vertex;
	    vertexList = newVertexArray;
	    return true;
	}

	public boolean containsEdge(Edge edge)
	{
		boolean contient = false;
		for(Edge e : edgeList)
		{
			Vertex[] v = new Vertex[2];
			v[0] = edge.getEnds()[0];
			v[1] = edge.getEnds()[1];
			if(e.getEnds()[0].isTheSamePoint(v) && e.getEnds()[1].isTheSamePoint(v))
				contient = true;
		}
		return contient;
	}

	public boolean containsVertex(Vertex vertex)
	{
		return vertex.isTheSamePoint(vertexList);
	}

	public Edge[] getAllEdges()
	{
		return edgeList;
	}

	public Vertex[] getAllVertex()
	{
		return vertexList;
	}

	public Edge getEdge(Vertex sourceVertex, Vertex targetVertex)
	{
		return null;
	}

	public boolean isAdjacent(Edge A, Edge B)
	{
		return true;
	}

	public boolean isDirected(Edge edge)
	{
		return true;
	}

	public Edge[] isInEdges(Vertex vertex)
	{
		return null;
	}

	public boolean removeAllEdges(Edge[] edges)
	{
		return true;
	}

	public boolean removeAllVertices(Vertex[] vertices)
	{
		return true;
	}

	public boolean removeEdge(Edge edge)
	{
		return true;
	}

	public boolean removeVertex(Vertex vertex)
	{
		return true;
	}

}