package com.jyh.demo;

public class Solution {
    int[] parent;
    int count;


    public int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;
        count = len;
        parent = new int[len + 1];
        for (int i = 1; i < len + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (isConnected[i][j] == 1) {
                    union(i + 1, j + 1);
                }
            }
        }

        return count;
    }

    private void union(int index1, int index2) {
        int parent1 = find(index1);
        int parent2 = find(index2);
        if (parent1 != parent2) {
            // 修改index2的parent结点(parent2)的parent结点为parent1
            // 即在index1的parent结点(parent1)处添加一个右孩子parent2
            // union操作后的整树parent结点为parent1
            parent[parent2] = parent1;
            count--; // 合并到一起, 集合数量--
        }
    }

    // 调用find()找到parent结点
    private int find(int index) {
        while (parent[index] != index) index = parent[index];
        return index; // return parent[index];
    }
}
