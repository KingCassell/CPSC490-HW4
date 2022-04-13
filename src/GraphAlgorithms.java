
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;


public class GraphAlgorithms {

  
  // singleton
  private GraphAlgorithms() {}

  
  // TODO: Copy your previous algorithms here (or copy your HW3
  // version and add the following)

  
  //----------------------------------------------------------------------
  // HW4
  //----------------------------------------------------------------------
  
  /**
   * Computes the unweighted transitive closure of the given
   * graph. Adds the new, transitive edges to the given graph. The
   * graph is unweighted in that new edges have null edge weights.
   * @param g a directed graph
   */ 
  public static void transitiveClosure(Graph g) {
    // TODO
  }

  /**
   * Computes the strongly connected components of the given directed
   * graph.
   * @param g a directed graph
   * @returns a map of node ids to their corresponding component number
   */ 
  public static Map<Integer,Integer> stronglyConnectedComponents(Graph g) {
    // TODO
  }

  /**
   * Fills in the reduced graph with the transitive reduction.
   * @param g the directed input graph (with edges)
   * @param reduced a directed graph with same number of nodes as g,
   *        but no edges, which are filled in by the function
   */ 
  public static void transitiveReduction(Graph g, Graph reduced) {
    // TODO
  }

  
}
