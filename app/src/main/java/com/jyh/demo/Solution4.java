package com.jyh.demo;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;
//128. 最长连续序列
public class Solution4 {
    class UnionFind{
        Map<Integer, Integer> parents;

        public UnionFind(int[] arr) {
            parents = new HashMap<>();
            for (int i : arr) {
                parents.put(i, i);
            }
        }

        public Integer find(int x) {
            if (!parents.containsKey(x)) return null;
            int t = parents.get(x);
            if(x != t) parents.put(x, find(t));
            return parents.get(x);
        }

        public boolean union(int x, int y) {
            Integer rootX = find(x), rootY = find(y);
            if (rootX == null || rootY == null) return false;
            if(rootX.equals(rootY)) return false;
            parents.put(rootX, rootY);
            return true;
        }
    }
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        UnionFind u = new UnionFind(nums);
        for (int num : nums) {
            u.union(num, num + 1);
        }
        int max = 1;
        for (int num : nums) {
            max = Math.max(max,u.find(num) - num +1);
            Log.e("jyh","max="+max+" "+"num ="+num);
        }
        return max;
    }
}
