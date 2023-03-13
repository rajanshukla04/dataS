package Graph.pratice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class WeightGraph{
    public static class Edge{
        int src;
        int dec;
        int weight;
        Edge(int s,int d, int weight){
            this.src=s;
            this.dec=d;
            this.weight=weight;

        }
    }
    // crate the garpah using arraylist 
    public static void Crate(ArrayList<Edge> Graph[]){
        // crate the graph for the weight graph 

        
        for(int i=0;i<Graph.length;i++){
            Graph[i]=new ArrayList<Edge>();
        }
        Graph[0].add(new Edge(0, 2, 2));
        Graph[1].add(new Edge(1, 2, 10));
        Graph[1].add(new Edge(1, 3, 0));

        Graph[2].add(new Edge(2, 0,-1 ));
        Graph[2].add(new Edge(2,3,-1));
        Graph[2].add(new Edge(2,1,10));

        Graph[3].add(new Edge(3,1,0));
        Graph[3].add(new Edge(3 ,2, -1));

    }

    // write the function for bfs search in weight graph 
    public static void bfsW(ArrayList<Edge> Graph[],int v){
        boolean vis[]=new boolean[v];
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()){
            int curr=q.remove();
            if(vis[curr]==false){
                System.out.println(curr+" ");
                vis[curr]=true;
                for(int i=0;i<Graph[curr].size();i++){
                    Edge e=Graph[curr].get(i);
                    q.add(e.dec);
                }
            }
        }}


 public static void main(String[] args) {
    int v=4;
    ArrayList<Edge> Graph[]=new ArrayList[v];
    Crate(Graph);
    bfsW(Graph, v);
    
  }
    
}