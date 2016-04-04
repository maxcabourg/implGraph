package implementation;

import graph.Graph;
import graph.Edge;
import graph.Vertex;

public class ImplementationGraph implements Graph
{
	private int[][] adjacentMatrix;

	public ImplementationGraph(int[][] array)
	{
		adjacentMatrix = array;
	}

}