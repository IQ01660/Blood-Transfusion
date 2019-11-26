public class Graph
{
    //source can be used in Ford-Fulkerson
    public Vertex source;
    public Vertex sink;

    /**
     * Creates a new graph with sourrce and sink
     * provided that all supply and demand values 
     * are given as parameters to the problem
     * @param s_A
     * @param s_B
     * @param s_AB
     * @param s_O
     * @param d_A
     * @param d_B
     * @param d_AB
     * @param d_O
     */
    public Graph(int s_A, int s_B, int s_AB, int s_O, int d_A, int d_B, int d_AB, int d_O)
    {
        this.source = new Vertex("S");
        this.sink = new Vertex("T");
        this.create_connectNodes(s_A, s_B, s_AB, s_O, d_A, d_B, d_AB, d_O);
    }

    /**
     * Creates all supply and demand nodes and connects them
     * to each other and the sink and source
     * @param s_A
     * @param s_B
     * @param s_AB
     * @param s_O
     * @param d_A
     * @param d_B
     * @param d_AB
     * @param d_O
     */
    private void create_connectNodes(int s_A, int s_B, int s_AB, int s_O, int d_A, int d_B, int d_AB, int d_O)
    {
        //supply nodes
        Vertex Asupply = new Vertex("As");
        Vertex Bsupply = new Vertex("Bs");
        Vertex ABsupply = new Vertex("ABs");
        Vertex Osupply = new Vertex("Os");

        //demand nodes
        Vertex Ademand = new Vertex("Ad");
        Vertex Bdemand = new Vertex("Bd");
        Vertex ABdemand = new Vertex("ABd");
        Vertex Odemand = new Vertex("Od");

        //sink has a connection to all supply nodes
        this.sink.addNeighbor(Asupply, s_A);
        this.sink.addNeighbor(Bsupply, s_B);
        this.sink.addNeighbor(ABsupply, s_AB);
        this.sink.addNeighbor(Osupply, s_O);

         //A can give its blood only to A and AB
         Asupply.addNeighbor(Ademand, Integer.MAX_VALUE);
         Asupply.addNeighbor(ABdemand, Integer.MAX_VALUE);
 
         //B can give its blood only to B and AB
         Bsupply.addNeighbor(Bdemand, Integer.MAX_VALUE);
         Bsupply.addNeighbor(ABdemand, Integer.MAX_VALUE);
 
         //AB can give its blood only to AB
         ABsupply.addNeighbor(ABdemand, Integer.MAX_VALUE);
 
         //O can give its blood to all four
         Osupply.addNeighbor(Odemand, Integer.MAX_VALUE);
         Osupply.addNeighbor(Ademand, Integer.MAX_VALUE);
         Osupply.addNeighbor(Bdemand, Integer.MAX_VALUE);
         Osupply.addNeighbor(ABdemand, Integer.MAX_VALUE);

         //all demand nodes have to have a path to sink
         Odemand.addNeighbor(this.sink, d_O);
         Ademand.addNeighbor(this.sink, d_A);
         ABdemand.addNeighbor(this.sink, d_AB);
         Bdemand.addNeighbor(this.sink, d_B);
    }
}