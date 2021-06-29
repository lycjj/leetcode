package com.ly.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 思路：记录下前i个点所有能够连成直线的点，然后计算前i+1个点所有能够连成直线的点
 * @author ly.
 * @date 2021/6/26
 */
public class Question149 {
    public int maxPoints(int[][] points) {
        List<List<Point>> list = new ArrayList<List<Point>>();
        List<List<Point>> temp;
        int onePointX, onePointY, twoPointX, twoPointY, threePointX, threePointY;
        List<Point> pointList;
        Point point;
        for (int i = 0; i < points.length; i++) {
            point = new Point(points[i][0], points[i][1]);
            temp = new ArrayList<List<Point>>();
            for (List<Point> pl : list) {
                if (pl.size() == 1) {
                    pointList = new ArrayList<Point>();
                    pointList.addAll(pl);
                    temp.add(pointList);
                    pl.add(point);
                } else {
                    onePointX = points[i][0];
                    onePointY = points[i][1];
                    twoPointX = pl.get(0).getX();
                    twoPointY = pl.get(0).getY();
                    threePointX = pl.get(1).getX();
                    threePointY = pl.get(1).getY();
                    if ((onePointY - twoPointY) * (twoPointX - threePointX) == (twoPointY - threePointY) * (onePointX - twoPointX)) {
                        pl.add(point);
                    }
                }
            }
            list.addAll(temp);

            pointList = new ArrayList<Point>();
            pointList.add(point);
            list.add(pointList);
        }
        int maxLength = 0;
        for (List<Point> pl : list) {
            if (pl.size() > maxLength) {
                maxLength = pl.size();
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[][] points = {{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
        //int[][] points = {{1, 1}, {2, 2}, {3, 3}};
        System.out.println(new Question149().maxPoints(points));
    }

    class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

}
