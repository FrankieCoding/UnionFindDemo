package com.jyh.demo;
//684. 冗余连接
class Solution3 {
    int[] p;//节点数组
    private void init(int n){
        for(int i=1;i<n;i++){
            p[i]=i;//赋初值
        }
    }
    private void union(int a,int b){
        if(find(a)!=find(b)) p[find(b)]=find(a); //如果两个节点属于同一个集合，就进行合并
    }
    private int find(int x){
        if(p[x]==x) return x;//如果该节点的下标与值相同，就说明该节点是根节点，就返回该下标【下标是唯一确定的，用于表示值，值则是标志】
        else return p[x]=find(p[x]);//如果不同，进行递归，一层层往下找
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;//节点个数
        p=new int[n];//定义数组
        init(n);//对节点进行初始化
        for(int[] i:edges){//遍历每个节点
            if(find(i[0])!=find(i[1])){
                union(i[0],i[1]);//如果这两个连通点还没有连通，就进行合并
            } else{
                return i;//如果这两个点属于同一个集合，就说明该连通边就是导通树成为图的边，返回该节点
            }
        }
        return new int[0];
    }
}