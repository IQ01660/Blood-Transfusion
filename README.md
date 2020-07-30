# Blood-Transfusion
Maximizing the amount of blood received by patients using network-flow and Ford-Fulkerson Algorithm 

## Description:

Suppose you work for a hospital, and your job is to determine whether the current supply of blood will be enough to meet 
the projected demand over the next week for blood transfusions.

**Unfortunately, it’s not as simple as checking whether the number of liters currently available is greater
than the number of liters required: people have blood types that constrain the types of blood they can receive.**

There are four blood types: ***A, B, AB, and O***. A patient with type-A blood can receive only blood types A or O in 
a transfusion, a patient with type-B blood can receive only blood types B or O, a patient with type-AB blood 
can receive any of the four types, and a patient with type-O blood can only receive blood type O.
In the blood transfusion problem, we have:

> Input: sA, sB, sAB, and sO: the supply of each of the different blood types (assume these are all positive integers),
and dA, dB, dAB, and dO denote the demand of each of the different blood types 
in the next week (again, assume positive integers)

> Output: “yes” or “no” to the question: is it possible to meet the demand for each blood type? And if so, how?

## Algorithm

(i)
I will solve this problem using **Network-Flow and Bipartite Matching**
,as well as running the **Fold Fulkerson Algorithm**

The algorithm creates 10 vertices overall:
> 4 vertices for patients’ blood types
> 4 vertices for blood types coming from the supply
> 1 vertex as a source and 1 vertex as a sink


Then the vertices are connected with the following edges:
4 edges from the sink to each of the ***“supply”*** vertices - the capacities of the edges are 
(e.g. edge from the sink to “supply A” vertex has a capacity of ). 
These edges represent the amount of supply for each blood type.


4 edges from each ***“patient blood type”*** vertex to the sink -
the capacities of the edges are  (e.g. edge from “AB patients” vertex to the sink has a capacity of ). 
These edges represent the amount of blood transfused to patients with the four different blood types.


4 edges from ***“supply O”*** to all four “patient blood type” vertices (as all blood types are allowed to have 
O blood type transfusion)


3 more edges from ***“supply A”, “supply B”, and “supply AB” to “AB type patients”*** vertex


1 edge from ***“A supply” to “A type patient” and one more edge from “B supply” to “B type patient”***.

Note the last 9 edges described represent which blood types are appropriate for transfusion for the
4 different patient blood types. All of those 9 edges have a capacity of infinity.


(ii) 
After running the Ford-Fulkerson Algorithm on the graph, we should get the maximum possible flow for this network flow
problem. According to the flow conservation constraint, we know that the flow into each “patient blood type” 
node should be equal to the flow out of that node into the sink.

We also have a capacity constraint for the edges from the “patient blood type” nodes to the sink; therefore, if the flow through those edges (to the sink) is not saturated then the blood demand is not met.
For example, if the demand for A type patients is , and the edge from “A type patient” node to the sink is not saturated, the flow into the “A type patient” node is also less than  (which means the supply is not enough for A type patients).
On the other hand, if all edges going into the sink are saturated (flow = capacity), the supply is enough for the demands to be met for each blood type.
(iii)
If the blood supply is sufficient, we can look up the flow for all edges from “supply blood type” 
vertices to “patient blood type” vertices. Those flow values represent the amount of blood sent from 
each blood type supply to each patient with a specific blood type. For example, there are two edges ending at 
“A blood type patients” vertex, one from “A supply” and the other from “O supply” node, and their flows represent
how much A type blood and how much O type blood, 
