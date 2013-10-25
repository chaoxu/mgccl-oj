import java.util.*;
public class maxflow {
    // code from here. https://sites.google.com/site/indy256/algo/dinic_flow
    // Dinic
  static class Edge {
    int t, r, c, f;
    public Edge(int t, int r, int c) {
      this.t = t;
      this.r = r;
      this.c = c;
    }
  }
  public static List<Edge>[] createGraph(int n) {
    List<Edge>[] g = new List[n];
    for (int i = 0; i < n; i++)
      g[i] = new ArrayList<Edge>();
    return g;
  }

  public static void addEdge(List<Edge>[] g, int s, int t, int c) {
    g[s].add(new Edge(t, g[t].size(), c));
    g[t].add(new Edge(s, g[s].size() - 1, 0));
  }

  static boolean bfs(List<Edge>[] g, int s, int t, int[] d) {
    Arrays.fill(d, -1);
    d[s] = 0;
    int[] q = new int[g.length];
    int l = 0;
    q[l++] = s;
    for (int i = 0; i < l; i++) {
      int u = q[i];
      for (Edge e : g[u]) {
        if (d[e.t] < 0 && e.f < e.c) {
          d[e.t] = d[u] + 1;
          q[l++] = e.t;
        }
      }
    }
    return d[t] >= 0;
  }
  static int dfs(List<Edge>[] g, int[] p, int[] d, int t, int u, int f) {
    if (u == t)
      return f;
    for (; p[u] < g[u].size(); ++p[u]) {
      Edge e = g[u].get(p[u]);
      if (d[e.t] == d[u] + 1 && e.f < e.c) {
        int df = dfs(g, p, d, t, e.t, Math.min(f, e.c - e.f));
        if (df > 0) {
          e.f += df;
          g[e.t].get(e.r).f -= df;
          return df;
        }
      }
    }
    return 0;
  }
  public static int maxFlow(List<Edge>[] g, int s, int t) {
    int f = 0;
    int[] d = new int[g.length];
    while (bfs(g, s, t, d)) {
      int[] ptr = new int[g.length];
      while (true) {
        int df = dfs(g, ptr, d, t, s, Integer.MAX_VALUE);
        if (df == 0)
          break;
        f += df;
      }
    }
    return f;
  }

  // Usage example
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int z = in.nextInt();
    Map<String, Integer> h = new HashMap<String, Integer>();
    h.put("L", 2);
    h.put("XXL",3);
    h.put("XL",4);
    h.put("M",5);
    h.put("S",6);
    h.put("XS",7);
    for(int o=0;o<z;o++){
        int n = in.nextInt()/6;
        int m = in.nextInt();
        List<Edge>[] g = createGraph(8+m);
        for(int i=2;i<8;i++){
            addEdge(g, i, 1, n);
        }
        for(int i=0;i<m;i++){
            addEdge(g, 0, i+8, 1);
            addEdge(g, i+8, h.get(in.next()), 1);
            addEdge(g, i+8, h.get(in.next()), 1);
        }
        if(maxFlow(g,0,1)==m){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
    
  }
}