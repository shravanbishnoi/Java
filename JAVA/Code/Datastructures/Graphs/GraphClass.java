/*
 * Here is the basic class program for
 * implementing Graphs in java
 * 
 * Author: Shravan
 * Date: 13-03-2024
 */

import java.util.*;

public class GraphClass {

    public static class Edge{
        int src;
        int dest;

        Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph){
        for (int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));
        
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 2));
    }

    public static void main(String[] args) {
        int vertices = 4; //Number of vertices in our graph

        ArrayList<Edge> graph[] = new ArrayList[vertices];

        createGraph(graph);

        System.out.println("From: "+graph[0].get(0).src+" To: "+ graph[0].get(0).dest);

        System.out.println("From: "+graph[1].get(0).src+" To: "+ graph[1].get(0).dest);
        System.out.println("From: "+graph[1].get(1).src+" To: "+ graph[1].get(1).dest);


    }
}