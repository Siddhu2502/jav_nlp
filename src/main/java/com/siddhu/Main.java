package com.siddhu;

public class Main {

    public static void main(String[] args) {
        
        Tokenizer tokenized = new Tokenizer();

        float[][] tk;
        try {
            tk = tokenized.processFile("src/main/resources/text/traindata.txt");
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        
        printmatrix(tk);
        printdims(tk);

        

    }

    private static void printmatrix(float[][] tk) {
        System.out.print("[");
        for (int i = 0; i < tk.length; i++) {
            System.out.print("[");
            for (int j = 0; j < tk[i].length; j++) {
                System.out.print(tk[i][j]);
                if (j < tk[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print("]");
            if (i < tk.length - 1) {
                System.out.println(",");
            }
        }
        System.out.println("]");
    }

    private static void printdims(float[][] tk) {
        System.out.println("Rows: " + tk.length);
        System.out.println("Columns: " + tk[0].length);
    }
}