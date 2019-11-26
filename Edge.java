public class Edge
{
    //starting point of the edge
    public Vertex startVertex;
    //ending point of the edge
    public Vertex endVertex;
    //the weight of the edge
    public final int capacity;
    //the flow through the edge
    public int flow;

    /**
     * Creates a usual graph edge 
     * @param _start
     * @param _end
     * @param _capacity
     * @param _flow
     */
    public Edge(Vertex _start, Vertex _end, int _capacity)
    {
        this.startVertex = _start;
        this.endVertex = _end;
        this.weight = _weight;
        this.flow = 0;
    }

    /**
     * Knowing whether to make a forward
     * or a backward edge out of initial graph edge,
     * this constructor creates a residualGraph edge.
     * @param _usualGraphEdge
     * @param _isForward
     */
    public Edge(Edge _usualGraphEdge)
    {
        this.capacity = _usualGraphEdge.capacity - _usualGraphEdge.flow;
        this.startVertex = _usualGraphEdge.startVertex;
        this.endVertex = _usualGraphEdge.endVertex;
        this.flow = _usualGraphEdge.flow;
    }

    public String toString()
    {
        return this.startVertex.toString() + " " + this.endVertex.toString();
    }

    /**
     * Return the other endpoint of the edge
     * with a specified vertex
     * @param vertex
     * @return
     */
    public Vertex getOther(Vertex vertex)
    {
        if (vertex == this.startVertex)
        {
            return this.endVertex;
        }
        else
        {
            return this.startVertex;
        }
    }

    /**
     * returns the residual capacity of an edge
     * if the target of the residual edge is specified:
     * i.e. front vs backward edge
     * @param target
     * @return
     */
    public int getResCapacity(Vertex target)
    {
        if (target == this.startVertex)
        {
            return this.flow; // backward edge
        }

        else 
        {
            return (this.capacity - this.flow); // front edge
        }
    }

    public void addResFlowTo(Vertex vertex, int deltaFlow)
    {
        if (vertex == this.startVertex)
        {
            this.flow = this.flow - deltaFlow; // backward edge
        }
        else 
        {
            this.flow = this.flow + deltaFlow; // forward edge
        }
    }
}