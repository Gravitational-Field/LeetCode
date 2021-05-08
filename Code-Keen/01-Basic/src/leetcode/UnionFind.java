package leetcode;

class UnionFind {
    public int count = 0;  //记录有几个群组，连通分量的个数
    public int[] parent;

    public UnionFind(int n) {
        count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int p) {  //找到p元素所在group的代表元素
        int target = p;
        while (p != parent[p]) {  // 不断向上找，直到找到了p == parent[p]，即找到了代表元素
            //parent[p] = parent[parent[p]];
            p = parent[p];
        }
        //路径压缩
        while (target != parent[target]) {
            int temp = target;  //从底到 代表元素，
            target = parent[target];
            parent[temp] = p;
        }
        return p;
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        parent[rootP] = rootQ;  //不相等的情况
        count--;
    }
}