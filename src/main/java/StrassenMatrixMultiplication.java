package main.java;

import java.util.Arrays;

/**
 * Created by dianwen on 4/28/15.
 */
public class StrassenMatrixMultiplication {
    public static int[][] multiply(int[][] x, int[][] y) {
        if(x.length == 1) {
            int[][] result = new int[1][1];
            result[0][0] = x[0][0] * y[0][0];
            return result;
        }

        int[][] A, B, C, D, E, F, G, H;
        A = partition(x, 0, x.length/2, 0, x.length/2);
        B = partition(x, x.length/2, x.length, 0, x.length/2);
        C = partition(x, 0, x.length/2, x.length/2, x.length);
        D = partition(x, x.length/2, x.length, x.length/2, x.length);
        E = partition(y, 0, x.length/2, 0, x.length/2);
        F = partition(y, x.length/2, x.length, 0, x.length/2);
        G = partition(y, 0, x.length/2, x.length/2, x.length);
        H = partition(y, x.length/2, x.length, x.length/2, x.length);

        int[][] P1, P2, P3, P4, P5, P6, P7;
        P1 = multiply(A, subtract(F, H));
        P2 = multiply(add(A, B), H);
        P3 = multiply(add(C, D), E);
        P4 = multiply(D, subtract(G, E));
        P5 = multiply(add(A, D), add(E, H));
        P6 = multiply(subtract(B, D), add(G, H));
        P7 = multiply(subtract(A, C), add(E, F));

        int[][] topLeft = add(subtract(add(P5, P4), P2), P6);
        int[][] topRight = add(P1, P2);
        int[][] bottomLeft = add(P3, P4);
        int[][] bottomRight = subtract(subtract(add(P1, P5), P3), P7);
        return combine(topLeft, topRight, bottomLeft, bottomRight);
    }

    private static int[][] combine(int[][] topLeft, int[][] topRight, int[][] bottomLeft, int[][] bottomRight) {
        int[][] result = new int[topLeft.length + bottomLeft.length][topLeft[0].length + topRight[0].length];
        for(int i = 0; i < topLeft.length; i++) {
            for(int j = 0; j < topLeft.length; j++) {
                result[i][j] = topLeft[i][j];
            }
        }
        for(int i = 0; i < topRight.length; i++) {
            for(int j = 0; j < topRight.length; j++) {
                result[i][j + topLeft.length] = topRight[i][j];
            }
        }
        for(int i = 0; i < bottomLeft.length; i++) {
            for(int j = 0; j < bottomLeft.length; j++) {
                result[i + topLeft.length][j] = bottomLeft[i][j];
            }
        }
        for(int i = 0; i < bottomRight.length; i++) {
            for(int j = 0; j < bottomRight.length; j++) {
                result[i + topLeft.length][j + topLeft.length] = bottomRight[i][j];
            }
        }
        return result;
    }

    private static int[][] addOrSubtract(int[][] a, int[][] b, int multiple) {
        int[][] result = new int[a.length][a.length];
        for(int i = 0; i < result.length; i++) {
            for(int j = 0; j < result.length; j++) {
                result[i][j] = a[i][j] + multiple * b[i][j];
            }
        }
        return result;
    }

    private static int[][] partition(int[][] a, int xStart, int xEnd, int yStart, int yEnd) {
        int[][] result = new int[yEnd-yStart][xEnd-xStart];
        for(int x = xStart; x < xEnd; x++) {
            for(int y = yStart; y < yEnd; y++) {
                result[y-yStart][x-xStart] = a[y][x];
            }
        }
        return result;
    }

    private static int[][] add(int[][] a, int[][] b) {
        return addOrSubtract(a, b, 1);
    }

    private static int[][] subtract(int[][] a, int[][] b) {
        return addOrSubtract(a, b, -1);
    }
}
