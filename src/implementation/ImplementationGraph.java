package implementation;

import graph.Graph;
import graph.Edge;
import graph.Vertex;
import graph.DirectedEdge;

public class ImplementationGraph implements Graph
{
	private int[][] adjacentMatrix;

	public ImplementationGraph(int nbVertex)
	{
		adjacentMatrix = new int[nbVertex][nbVertex];
		for(int i = 0; i<nbVertex; i++)
		{
			for(int j = 0; j<nbVertex; j++)
			{
				adjacentMatrix[i][j] = 0;
			}
		}
	}

	public Edge addEdge(Vertex sourceVertex, Vertex targetVertex)
	{
		Edge e = new DirectedEdge(sourceVertex, targetVertex);
	    adjacentMatrix[(int)(sourceVertex.getCoordinates()[0]+sourceVertex.getCoordinates()[1])][(int)(targetVertex.getCoordinates()[0]+targetVertex.getCoordinates()[1])] = 1;
	    return e;
	}

	public boolean addEdgeToGraph(Vertex sourcevertex, Vertex targetVertex, Edge edge)
	{	
		boolean b1 = addVertexToGraph(sourcevertex);
		boolean b2 = addVertexToGraph(targetVertex);
		Edge e = addEdge(sourcevertex, targetVertex);
		return b1 && b2;
	}

	public boolean addVertexToGraph(Vertex vertex)
	{
		int[][] newAdjacentMatrix = new int[adjacentMatrix[0].length+1][adjacentMatrix[0].length+1];
		for(int i = 0; i<adjacentMatrix.length; i++)
		{
			for(int j = 0; j<adjacentMatrix[i].length; j++)
			{
				newAdjacentMatrix[i][j] = adjacentMatrix[i][j];
			}
		}

		for(int i = 0; i<newAdjacentMatrix[0].length; i++)
		{
			newAdjacentMatrix[adjacentMatrix.length][i] = 0;
			newAdjacentMatrix[i][adjacentMatrix.length] = 0;
		}
		adjacentMatrix = adjacentMatrix;
	    return true;
	}

	public boolean containsEdge(Edge edge)
	{
		boolean contient = false;
		return contient;
	}

	public boolean containsVertex(Vertex vertex)
	{
		return true;
	}

	public Edge[] getAllEdges()
	{
		return null;
	}

	public Vertex[] getAllVertex()
	{
		return null;
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