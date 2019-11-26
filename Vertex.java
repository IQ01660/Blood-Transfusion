import java.util.*;

public class Vertex 
{
    
    public String name; 
    public int id;
    public boolean visited;

    /**Implementing Adjacency List to store neighbors
    of this vertex (as Edge objects)
    **/
    //public List<Edge> neighbors = new Vector<Edge>();

    public Vertex(String _name, int _id)
    {
        this.name = _name;
        this.id = _id;
    }

    /**
     * returns the name and id of the vertex as a string
     */
    public String toString()
    {
        return this.id + " " + this.name;
    }

    /**
     * turns a vertex into a sink 
     * only if it is not a source
     */
    public void makeSink()
    {
        if (!this.isSource)
        {
            this.isSink = true;
        }
    }


    /**
     * turns a vertex into a source
     * only if it is not a sink
     */
    public void makeSource()
    {
        if (!this.isSink)
        {
            this.isSource = true;
        }
    }

    /**
     * Creating an edge of the specified 
     * capacity to the given neighbor with a flow of 0.
     * Only use this when creating original graph
     * @param _neighbor
     * @param _capacity
     */
    public void addNeighbor(Vertex _neighbor, int _capacity)
    {
        Edge addedEdge = new Edge(this, _neighbor, _capacity, 0);
        this.neighbors.add(addedEdge);
    }
    
}