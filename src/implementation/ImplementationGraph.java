package implementation;

import graph.Graph;
import graph.Edge;
import graph.Vertex;
import graph.DirectedEdge;
import graph.UndirectedEdge;

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
	    adjacentMatrix[Integer.parseInt(Double.toString(sourceVertex.getCoordinates()[0]))][Integer.parseInt(Double.toString(targetVertex.getCoordinates()[0]))] = 1;
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
		return adjacentMatrix[Integer.parseInt(Double.toString(edge.getEnds()[0].getCoordinates()[0]))][Integer.parseInt(Double.toString(edge.getEnds()[1].getCoordinates()[0]))] == 1;
	}

	public boolean containsVertex(Vertex vertex)
	{
		return vertex.getCoordinates()[0] < adjacentMatrix.length;
	}

	public Edge[] getAllEdges()
	{
		Edge[] tabEdge = new Edge[100];
		int nbEdges = 0;
		for(int i = 0; i<adjacentMatrix.length; i++)
		{
			for(int j = 0; j<adjacentMatrix[i].length; j++)
			{
				if(adjacentMatrix[i][j] == 1)
				{
					double[] d1 = new double[1];
					d1[0] = i;
					double[] d2 = new double[1];
					d2[0] = j;
					Edge e = new UndirectedEdge(new Vertex(d1), new Vertex(d2));
					tabEdge[nbEdges] = e;
					nbEdges++;
				}
			}
		}
		return tabEdge;
	}

	public Vertex[] getAllVertex()
	{
		Vertex[] tabVertex = new Vertex[adjacentMatrix.length];
		for(int i = 0; i<adjacentMatrix.length; i++)
		{
			double[] d1 = new double[1];
			d1[0] = i;
			Vertex v = new Vertex(d1);
			tabVertex[i] = v;
		}
		return tabVertex;
	}

	public Edge getEdge(Vertex sourceVertex, Vertex targetVertex)
	{
		if(adjacentMatrix[Integer.parseInt(Double.toString(sourceVertex.getCoordinates()[0]))][Integer.parseInt(Double.toString(targetVertex.getCoordinates()[0]))] == 1)
			return new UndirectedEdge(sourceVertex, targetVertex);
		else 
			return null;
	}

	public boolean isAdjacent(Edge A, Edge B)
	{
		return true;
	}

	public boolean isDirected(Edge edge)
	{
		return edge instanceof DirectedEdge;
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
		if(Integer.parseInt(Double.toString(vertex.getCoordinates()[0])) >= adjacentMatrix.length)
			return false;
		else
		{
			int[][] newAdjacentMatrix = new int[adjacentMatrix.length-1][adjacentMatrix.length-1];
			for(int i = 0; i<adjacentMatrix.length; i++)
			{
				for(int j = 0; j<adjacentMatrix[i].length; j++)
				{
					if(i>Integer.parseInt(Double.toString(vertex.getCoordinates()[0])) && j <= Integer.parseInt(Double.toString(vertex.getCoordinates()[0])))
						newAdjacentMatrix[i-1][j] = adjacentMatrix[i][j]; //Il faut remonter d'une ligne en haut
					else if(i<=Integer.parseInt(Double.toString(vertex.getCoordinates()[0])) && j > Integer.parseInt(Double.toString(vertex.getCoordinates()[0])))
						newAdjacentMatrix[i][j-1] = adjacentMatrix[i][j]; //Il faut decaler d'un cran a gauche
					else if(i > Integer.parseInt(Double.toString(vertex.getCoordinates()[0])) && j > Integer.parseInt(Double.toString(vertex.getCoordinates()[0])))
						newAdjacentMatrix[i-1][j-1] = adjacentMatrix[i][j]; //Il faut faire les deux a la fois
					else
						newAdjacentMatrix[i][j] = adjacentMatrix[i][j];
				}
			}
			adjacentMatrix = newAdjacentMatrix;
		}
		
		return true;
	}

}