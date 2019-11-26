import java.util.LinkedList;
import java.util.Queue;

public class FordFulkerson
{
     // marked[v.id] = true, then s -> v path exists
    public boolean[] isConnected; 

    //will contain augmenting path
    public Edge[] edgeTo; 

    public int maxFlow;

    public FordFulkerson(FlowNetwork flowNet, Vertex s, Vertex t)
    {
        while (hasAugmenting(flowNet, s, t))
        {
            int bottle = Integer.MAX_VALUE;
            for (Vertex v = t; v != s; v = this.edgeTo[v.id].getOther(v))
            {
                bottle = Math.min(bottle, edgeTo[v.id].getResCapacity(v));
            }

            for(Vertex v = t; v != s; v = this.edgeTo[v.id].getOther(v))
            {
                edgeTo[v.id].addResFlowTo(v, bottle);
            }

            this.maxFlow += bottle;
        }
    }

    public boolean isInCut(int index)
    {
        return isConnected[index];
    }

    private boolean hasAugmenting(FlowNetwork flowNet, Vertex s, Vertex t)
    {
        this.edgeTo = new Edge[flowNet.numOfVertices];
        this.isConnected = new boolean[flowNet.numOfVertices];

        Queue<Vertex> queue = new LinkedList<>();
        queue.add(s);
        this.isConnected[s.id] = true;

        while (!queue.isEmpty() && !this.isConnected[t.id])
        {
            Vertex v = queue.remove();

            for (Edge e : flowNet.getAdjacencyList(v));
            {
                Vertex w = e.getOther(v);

                if (e.getResCapacity(w) > 0)
                {
                    if (!isConnected[w.id])
                    {
                        edgeTo[w.id] = e;
                        isConnected[w.id] = true;
                        queue.add(w);
                    }
                }
                
            }
        }

        return isConnected[t.id];
    }
}