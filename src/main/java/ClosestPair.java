package main.java;

import javafx.geometry.Point2D;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by dianwen on 4/30/15.
 */
public class ClosestPair {
    public static final Comparator X_COMPARATOR = new CompareByX();
    public static final Comparator Y_COMPARATOR = new CompareByY();

    public static Point2D[] bruteForceFindClosestPair(Point2D[] points) {
        double closestDistance = Double.MAX_VALUE;
        Point2D[] closestPair = null;
        for(int i = 0; i < points.length; i++) {
            for(int j = i + 1; j < points.length; j++) {
                if(points[i].distance(points[j]) < closestDistance) {
                    closestDistance = points[i].distance(points[j]);
                    closestPair = new Point2D[]{points[i], points[j]};
                }
            }
        }
        return closestPair;
    }

    public static Point2D[] findClosestPair(Point2D[] points) {
        if(points.length == 1) {
            return null;
        }
        // Check for duplicate points
        Arrays.sort(points, X_COMPARATOR);
        for(int i = 0; i < points.length - 1; i++) {
            if(points[i].equals(points[i + 1])) {
                return new Point2D[]{points[i], points[i + 1]};
            }
        }

        return findClosestPairHelper(points);
    }

    private static Point2D[] findClosestPairHelper(Point2D[] points) {
        if(points.length == 1) {
            return new Point2D[] {new Point2D(Double.MIN_VALUE, Double.MIN_VALUE), new Point2D(Double.MAX_VALUE, Double.MAX_VALUE)};
        }
        // Create left and right halves of points
        Point2D[] leftHalf = new Point2D[points.length/2];
        System.arraycopy(points, 0, leftHalf, 0, points.length / 2);
        Point2D[] rightHalf = new Point2D[points.length - points.length/2];
        System.arraycopy(points, points.length/2, rightHalf, 0, points.length - points.length/2);
        // Created arrays of points sorted by x and y coordinates
        Arrays.sort(points, X_COMPARATOR);
        Point2D[] pointsSortedX = new Point2D[points.length];
        System.arraycopy(points, 0, pointsSortedX, 0, points.length);
        Arrays.sort(points, Y_COMPARATOR);
        Point2D[] pointsSortedY = new Point2D[points.length];
        System.arraycopy(points, 0, pointsSortedY, 0, points.length);

        Point2D[] closestLeftPair = findClosestPairHelper(leftHalf);
        Point2D[] closestRightPair = findClosestPairHelper(rightHalf);
        double delta = Math.min(closestLeftPair[0].distance(closestLeftPair[1]), closestRightPair[0].distance(closestRightPair[1]));
        Point2D[] closestSplitPair = findClosestSplitPair(pointsSortedX, pointsSortedY, delta);

        double closestDistance = Double.MAX_VALUE;
        Point2D[] closestPair = null;
        for(Point2D[] pair : new Point2D[][]{closestLeftPair, closestRightPair, closestSplitPair}) {
            if(pair != null && pair[0].distance(pair[1]) < closestDistance) {
                closestDistance = pair[0].distance(pair[1]);
                closestPair = pair;
            }
        }
        return closestPair;
    }

    private static Point2D[] findClosestSplitPair(Point2D[] sortedByX, Point2D[] sortedByY, double delta) {
        double xBar = sortedByX[sortedByX.length/2].getX();
        Point2D[] sortedByYSubset = new Point2D[sortedByY.length]; // Can be optimized by using a resizable array
        int i = 0;
        for(Point2D point : sortedByY) {
            if(point.getX() < xBar + delta || point.getX() > xBar - delta) {
                sortedByYSubset[i++] = point;
            }
        }
        double closestDistance = delta;
        Point2D[] closestPair = null;
        int rangeToCheck = 7;
        if(sortedByX.length <= rangeToCheck) {
            rangeToCheck = sortedByX.length - 1;
        }
        for(i = 0; i < sortedByYSubset.length - rangeToCheck; i++) {
            for(int j = 1; j <= rangeToCheck; j++) {
                if(sortedByYSubset[i] != null && sortedByYSubset[i + j] != null &&
                        sortedByY[i].distance(sortedByYSubset[i + j]) < closestDistance) {
                    closestDistance = sortedByY[i].distance(sortedByYSubset[i + j]);
                    closestPair = new Point2D[]{sortedByYSubset[i], sortedByYSubset[i + j]};
                }
            }
        }
        return closestPair;
    }

    static class CompareByX implements Comparator<Point2D> {
        @Override
        public int compare(Point2D o1, Point2D o2) {
            if(o1.getX() == o2.getX()) {
                if(o1.getY() == o2.getY()) {
                    return 0;
                }
                return o1.getY() > o2.getY() ? 1 : -1;
            }
            return o1.getX() > o2.getX() ? 1 : -1;
        }
    }

    static class CompareByY implements Comparator<Point2D> {
        @Override
        public int compare(Point2D o1, Point2D o2) {
            if(o1.getY() == o2.getY()) {
                if(o1.getX() == o2.getX()) {
                    return 0;
                }
                return o1.getX() > o2.getX() ? 1 : -1;
            }
            return o1.getY() > o2.getY() ? 1 : -1;
        }
    }
}
