package com.company;

public class Main {
    public static void main(String... args) {
        String white = "\033[4;37m";
        String purple = "\033[4;35m";
        String a = "\u2588";
        int n = 7;
        int m = 10;
        int p = 2;

        boolean[][] field = fillArray(n, m, p);

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j]) {
                    System.out.print(white+a+" " );
                } else {
                    System.out.print(purple+countBomb(field, i, j) + " ");
                }
            }
            System.out.println();
        }

    }

    public static int countBomb(boolean[][] field, int i, int j) {
        int countBomb = 0;
        boolean up = false, down = false, left = false, right = false,
                leftUp = false, rightUp = false, rightDown = false, leftDown = false;

        if (i - 1 >= 0)
            up = field[i - 1][j];

        if (j - 1 >= 0)
            left = field[i][j - 1];

        if (j + 1 < field[i].length)
            right = field[i][j + 1];

        if (i + 1 < field.length)
            down = field[i + 1][j];

        if (i - 1 >= 0 && j + 1 < field[0].length)
            rightUp = field[i - 1][j + 1];

        if (i - 1 >= 0 && j - 1 >= 0)
            leftUp = field[i - 1][j - 1];

        if (i + 1 < field.length && j - 1 >= 0)
            leftDown = field[i + 1][j - 1];

        if (i + 1 < field.length && j + 1 < field[0].length)
            rightDown = field[i + 1][j + 1];


        countBomb += right ? 1 : 0;

        countBomb += left ? 1 : 0;

        countBomb += down ? 1 : 0;

        countBomb += up ? 1 : 0;

        countBomb += leftUp ? 1 : 0;

        countBomb += leftDown ? 1 : 0;

        countBomb += rightUp ? 1 : 0;

        countBomb += rightDown ? 1 : 0;

        return countBomb;
    }


    public static boolean[][] fillArray(int n, int m, int p) {
        boolean[][] field = new boolean[n][m];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                double rand = (Math.random() * p);
                if (rand > p / 2.0) {
                    field[i][j] = true;
                } else {
                    field[i][j] = false;
                }

            }
        }
        return field;
    }
}

