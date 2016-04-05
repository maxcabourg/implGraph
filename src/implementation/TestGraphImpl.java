package implementation;

import graph.Graph;
import graph.Edge;
import graph.Vertex;
import graph.DirectedEdge;
import graph.UndirectedEdge;

public class TestGraphImpl
{
	public static void main(String[] args)
	{
		ImplementationGraph ig = new ImplementationGraph(10); //Graphe a 10 vertex sans aretes
		System.out.println("Creation d'un graphe a 10 vertex");
		double[] d = new double[1];
		d[0] = 11.0;
		double[] d2 = new double[1];
		d2[0] = 12.0;
		Vertex v = new Vertex(d);
		Vertex v2 = new Vertex(d2);
		ig.addVertexToGraph(v);
		ig.addVertexToGraph(v2);
		System.out.println("Ajout de 2 sommets");
		ig.addEdge(v, v2);
		System.out.println("Ajout d'une arete entre ces 2 sommets");
	}
}