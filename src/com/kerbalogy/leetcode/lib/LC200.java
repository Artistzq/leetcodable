package com.kerbalogy.leetcode.lib;

import com.kerbalogy.leetcode.base.AbstractLeetcodable;
import com.kerbalogy.leetcode.base.Run;

/**
 * @author yaozongqing@outlook.com
 * @date 2023/8/7 19:40
 * @description
 */
@Run(
        code = 200,
        title = "岛屿数量",
        checkSolution = true,
        comment = "难",
        notice = true
)
public class LC200 extends AbstractLeetcodable<Integer> {
    @Override
    public Integer prepareDataAndRun() {
        char[][] grids = new char[][] {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };
        return numIslands(grids);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;
        UnionFindSet unionFindSet = new UnionFindSet(grid);
        for (int r = 0; r < row; r ++) {
            for (int c = 0; c < col; c ++) {
                if (grid[r][c] == '1') {
                    grid[r][c] = '0';

                    if (r - 1 >= 0 && grid[r-1][c] == '1') {
                        unionFindSet.union(r * col + c, (r-1) * col + c);
                    }

                    if (r + 1 < row && grid[r+1][c] == '1') {
                        unionFindSet.union(r * col + c, (r+1) * col + c );
                    }

                    if (c - 1 >= 0 && grid[r][c-1] == '1') {
                        unionFindSet.union(r * col + c, r * col + c - 1);
                    }

                    if (c + 1 < col && grid[r][c+1] == '1') {
                        unionFindSet.union(r * col + c, r * col + c + 1);
                    }
                }
            }
        }
        return unionFindSet.getCount();
    }

}

class UnionFindSet {

    int[] parent;
    int count;

    public UnionFindSet(char[][] grid) {
        count = 0;
        int m = grid.length;
        int n = grid[0].length;
        int size = grid.length * grid[0].length;
        parent = new int[size + 1];
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (grid[i][j] == '1') {
                    parent[i * n + j] = i * n + j;
                    count ++;
                }
            }
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);
        if (xParent == yParent) {
            return;
        }
        parent[xParent] = yParent;
        count --;
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

    public int getCount() {
        return count;
    }

}
