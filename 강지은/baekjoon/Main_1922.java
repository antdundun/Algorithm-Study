import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1922 {
	
	static int N, M;
	static int[] p, r;
	static class Edge implements Comparable<Edge> {
		int s;
		int e;
		int w;
		public Edge(int s, int e, int w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}
		@Override
		public int compareTo(Edge eg) {
			return this.w-eg.w;
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		p = new int[N+1];
		r = new int[N+1];
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			pq.add(new Edge(s, e, w));
		}
		
		makeset();
		
		int cnt = 0;
		int min = 0;
		while (cnt != N-1) {
			Edge edge = pq.poll();
			
			if (union(edge.s, edge.e)) {
				cnt++;
				min += edge.w;
			}
		}
		
		System.out.println(min);
		
	}

	private static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if (x==y) return false;
		if (r[x]<r[y]) {
			r[y] += r[x];
			p[x] = y;
		} else {
			r[x] += r[y];
			p[y] = x;
		}
		
		return true;
	}

	private static int find(int x) {
		if (x==p[x]) return p[x];
		return p[x] = find(p[x]);
	}

	private static void makeset() {
		for (int i = 1; i < N+1; i++) {
			p[i] = i;
			r[i] = 1;
		}
		
	}
}
