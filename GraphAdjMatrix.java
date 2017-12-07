public class GraphAdjMatrix implements Graph{
    
	int vertices;
	int[][] graph;
	

	public GraphAdjMatrix(int vertices) {
		this.vertices = vertices;
		graph = new int[vertices][vertices];
	}
	
	public void addEdge (int v1, int v2, int w) {
		graph[v2][v1] = w;
		graph[v1][v2] = w;
	}
	
	public int getEdge (int v1, int v2){
		return graph[v1][v2];
	}
	
	int minKey(int key[], Boolean mstSet[])
    {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index=-1;
 
        for (int v = 0; v < vertices; v++)
            if (mstSet[v] == false && key[v] < min)
            {
                min = key[v];
                min_index = v;
            }
 
        return min_index;
    }
	
	public int createSpanningTree () {
		return spanningTreeHelper(graph);
	}
	
	public int spanningTreeHelper(int[][] graph) {
		int parent[] = new int[vertices];
		 
        int key[] = new int [vertices];
 
        Boolean mstSet[] = new Boolean[vertices];
 
        for (int i = 0; i < vertices; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }
 
        key[0] = 0;    
        parent[0] = -1; 
 
        for (int count = 0; count < vertices - 1; count++) {
            int u = minKey(key, mstSet);
            mstSet[u] = true;
            for (int v = 0; v < vertices; v++) {
                if (graph[u][v]!=0 && mstSet[v] == false && graph[u][v] <  key[v]) {
                    parent[v]  = u;
                    key[v] = graph[u][v];
                }
            }
        }
        int weight = 0;

 		for (int i = 1; i < vertices; i++)
        	weight += graph[i][parent[i]];
        
 		return weight;
	}
}
