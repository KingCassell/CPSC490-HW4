/*
 * File: HW4Test.java
 * Date: Spring 2022
 * Auth: 
 * Desc: 
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Map;
import java.util.List;


/* TODO: You must do the following steps: 

   (1). Complete the simple DFS-based unweighted transitive closure
   function in GraphAlgorithms. Note this does not need to use the
   strongly connected components approach. Make sure your function
   passes the unit tests below.

   (2). Write two additional unit tests for transitive closure. You
   should have one test for a directed graph and one for an undirected
   graph. Your test should consider a significantly larger graph and
   be "interesting". Make sure your function passes your tests. 

   (3). Complete the strongly connected components function in
   GraphAlgorithms. Note the algorithm assumes the input graph is
   directed. Make sure your function passes the test below. 

   (4). Write two additional unit tests for your strongly connected
   components function. Your tests must be "interesting". Make sure
   your function passes your tests.

   (5). Complete the transitive reduction function in
   GraphAlgorithms. Note the algorithm assumes the input graph is
   directed, and the reduced graph is an empty directed graph with the
   same number of vertices as the input graph. Make sure your function
   passes the test below.

   (6). Write two additional unit tests for your transitive reduction
   function. Your tests must be "interesting". Make sure your function
   passes your tests.

   (7). Draw out the graphs you used to test each function, label them
   appropriately (so I know what graph is used for what test and
   algorithm/function), and turn in a pdf with your submission.

   (8). Be sure to push all of your code needed to run the unit tests.

*/



public class HW4Test {

  
  @Test
  public void basicDirectedTransitiveClosure() throws Exception {
    Graph<Integer> g = new AdjacencyList<>(5, true);
    g.add(0, null, 1);
    g.add(1, null, 2);
    g.add(1, null, 3);
    g.add(3, null, 4);
    assertEquals(4, g.edgeCount());
    // transitively close the graph
    GraphAlgorithms.transitiveClosure(g);
    assertEquals(8, g.edgeCount());
    // inferred edges
    assertTrue(g.hasEdge(0, 2));
    assertTrue(g.hasEdge(0, 3));    
    assertTrue(g.hasEdge(0, 4));    
    assertTrue(g.hasEdge(1, 4));    
  }

  @Test
  public void basicUndirectedTransitiveClosure() throws Exception {
    Graph<Integer> g = new AdjacencyList<>(5, false);
    g.add(0, null, 1);
    g.add(1, null, 2);
    g.add(1, null, 3);
    g.add(3, null, 4);
    assertEquals(4, g.edgeCount());
    // transitively close the graph
    GraphAlgorithms.transitiveClosure(g);
    assertEquals(10, g.edgeCount());
    // inferred edges
    assertTrue(g.hasEdge(0, 2));
    assertTrue(g.hasEdge(0, 3));    
    assertTrue(g.hasEdge(0, 4));    
    assertTrue(g.hasEdge(1, 4));    
    assertTrue(g.hasEdge(2, 3));    
    assertTrue(g.hasEdge(2, 4));    
  }

  @Test
  public void basicStronglyConnectedComponents() throws Exception {
    Graph<Integer> g = new AdjacencyList<>(12, true);
    g.add(0, null, 1);
    g.add(1, null, 3);
    g.add(1, null, 4);
    g.add(4, null, 1);
    g.add(2, null, 5);
    g.add(5, null, 2);
    g.add(1, null, 2);
    g.add(4, null, 5);
    g.add(4, null, 6);
    g.add(5, null, 7);
    g.add(6, null, 7);
    g.add(7, null, 10);
    g.add(10, null, 11);
    g.add(11, null, 9);
    g.add(9, null, 8);
    g.add(8, null, 6);
    g.add(6, null, 9);
    Map<Integer,Integer> components = 
      GraphAlgorithms.stronglyConnectedComponents(g);
    assertEquals(12, components.size());
    int[] counts = new int[5];
    counts[0] = components.get(0);
    counts[1] = components.get(3);
    counts[2] = components.get(1);
    counts[3] = components.get(2);
    counts[4] = components.get(6);
    // each count should be unique
    for (int i = 0; i < 4; ++i)
      for (int j = i + 1; j < 5; ++j)
        assertTrue(counts[i] != counts[j]);
    // check that the components are correct
    assertTrue(counts[2] == components.get(4));
    assertTrue(counts[3] == components.get(5));
    assertTrue(counts[4] == components.get(7));
    assertTrue(counts[4] == components.get(8));
    assertTrue(counts[4] == components.get(9));
    assertTrue(counts[4] == components.get(10));
    assertTrue(counts[4] == components.get(11));  
  }

  @Test
  public void basicTransitiveReduction() throws Exception {
    Graph<Integer> g = new AdjacencyList<>(5, true);
    g.add(0, null, 1);
    g.add(1, null, 0);
    g.add(1, null, 2);
    g.add(2, null, 1);
    g.add(2, null, 0);
    g.add(0, null, 2);
    g.add(1, null, 3);
    g.add(1, null, 4);
    g.add(2, null, 3);
    g.add(3, null, 4);
    g.add(4, null, 3);
    Graph<Integer> gr = new AdjacencyList<>(5, true);
    GraphAlgorithms.transitiveReduction(g, gr);
    assertEquals(6, gr.edgeCount());
    assertTrue(gr.hasEdge(0, 1) ^ gr.hasEdge(1, 0));  // xor
    assertTrue(gr.hasEdge(1, 2) ^ gr.hasEdge(2, 1));  // xor
    assertTrue(gr.hasEdge(2, 0) ^ gr.hasEdge(0, 2));  // xor
    assertTrue(gr.hasEdge(3, 4) && gr.hasEdge(4, 3)); // and
    assertTrue(gr.hasEdge(0, 3) ^ gr.hasEdge(0, 4) ^
               gr.hasEdge(1, 3) ^ gr.hasEdge(1, 4) ^
               gr.hasEdge(2, 3) ^ gr.hasEdge(2, 4));
  }    
  
}
