public class Edge
{
    //starting point of the edge
    public Vertex startVertex;
    //ending point of the edge
    public Vertex endVertex;
    //the weight of the edge
    public int capacity;
    //the flow through the edge
    public int flow;

    /**
     * Creates a usual graph edge 
     * @param _start
     * @param _end
     * @param _capacity
     * @param _flow
     */
    public Edge(Vertex _start, Vertex _end, int _capacity, int _flow)
    {
        if (_weight > 0)
        {
            this.startVertex = _start;
            this.endVertex = _end;
            this.weight = _weight;
            this.flow = _flow;
        }
    }

    /**
     * Knowing whether to make a forward
     * or a backward edge out of initial graph edge,
     * this constructor creates a residualGraph edge.
     * @param _usualGraphEdge
     * @param _isForward
     */
    public Edge(Edge _usualGraphEdge, boolean _isForward)
    {
        if (_isForward == true)
        {
            this.capacity = _usualGraphEdge.capacity - _usualGraphEdge.flow;
            this.startVertex = _usualGraphEdge.startVertex;
            this.endVertex = _usualGraphEdge.endVertex;
        }
        else
        {
            this.capacity = _usualGraphEdge.flow;
            this.startVertex = _usualGraphEdge.endVertex;
            this.endVertex = _usualGraphEdge.startVertex;
        }
    }
}