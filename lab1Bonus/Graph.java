import java.util.LinkedList;
class Graph {

    int V;
    LinkedList<Integer>[] adjListArray;

    // constructor 
    Graph(int V) {
        this.V = V;
        adjListArray = new LinkedList[V];
        for(int i = 0; i < V ; i++){
            adjListArray[i] = new LinkedList<Integer>();
        }
    }

    void addEdge( int src, int dest) {

        adjListArray[src].add(dest);
        adjListArray[dest].add(src);
    }

    void DFS(int v, boolean[] visited,String[] words) {

        visited[v] = true;
        System.out.print(words[v]+" ");
        for (int x : adjListArray[v]) {
            if(!visited[x]) DFS(x,visited,words);
        }

    }
    void connectedComponents(String[] words) {
        boolean[] visited = new boolean[V];
        for(int v = 0; v < V; ++v) {
            if(!visited[v]) {
                DFS(v,visited,words);
                System.out.println();
            }
        }
    }


}