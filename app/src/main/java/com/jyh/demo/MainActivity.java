package com.jyh.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void test(View view) {
//        int[][] data = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
//        int[][] data = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
//        int[][] data = {{1, 0, 0, 1},
//                {0, 1, 1, 0},
//                {0, 1, 1, 1},
//                {1, 0, 1, 1}};
        int[][] data =
                       {{1, 1, 0, 0, 0},
                        {1, 1, 0, 0, 0},
                        {0, 0, 1, 0, 0},
                        {0, 0, 0, 1, 1}};
        Solution solution = new Solution();
        int count = solution.findCircleNum(data);
        Log.d("jyh", "count =" + count);
    }
}