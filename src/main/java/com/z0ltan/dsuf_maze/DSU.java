package com.z0ltan.dsuf_maze;

public class DSU {
  private int[] parent;
  private int[] rank;
  private int n;

  public DSU(int n) {
    this.n = n;
    this.parent = new int[n];
    this.rank = new int[n];
    makeSet();
  }

  private void makeSet() {
    for (int i = 0; i < n; i++) {
      parent[i] = i;
      rank[i] = 0;
    }
  }

  public int find(int idx) {
    validate(idx);

    if (parent[idx] == idx) {
      return idx;
    }

    parent[idx] = find(parent[idx]);
    return parent[idx];
  }

  public void union(int idx1, int idx2) {
    validate(idx1);
    validate(idx2);

    int parentIdx1 = find(idx1);
    int parentIdx2 = find(idx2);

    if (parentIdx1 == parentIdx2) {
      return;
    }

    if (rank[parentIdx1] < rank[parentIdx2]) {
      parent[idx1] = parentIdx2;
    } else if (rank[parentIdx1] > rank[parentIdx2]) {
      parent[idx2] = parentIdx1;
    } else  {
      parent[idx1] = parentIdx2;
      rank[parentIdx2]++;
    }
  }

  private void validate(int idx) {
    if (idx < 0 || idx >= n) {
      throw new IllegalArgumentException("index out of bounds");
    }
  }
}
