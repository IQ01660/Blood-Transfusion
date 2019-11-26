import java.util.*;

public class FlowNetwork
{
    public int numOfVertices;
    public int numOfEdges;
    private List<List<Edge>> adjacencyLists;

    public FlowNetwork(int numOfVertices)
    {
        this.numOfEdges = numOfVertices;
        this.numOfEdges = 0;
        this.adjacencyList = new ArrayList<>();

        for (int i = 0; i < numOfVertices; i++)
        {
            List<Edge> edgeList = new ArrayList<>();
            adjacencyList.add(edgeList);
        }
    }

    public void addEdge(Edge e)
    {
        Vertex v = e.startVertex;
        Vertex w = e.endVertex;
        this.adjacencyList.get(v.id).add(e);
        this.adjacencyList.get(w.id).add(e);
        this.numOfEdges++;
    }

    public List<Edge> getAdjacencyList(Vertex v)
    {
        return this.adjacencyLists.get(v.id);
    }

}