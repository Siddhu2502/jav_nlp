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

        

    }

    private static void printmatrix(float[][] tk) {
        for (int i = 0; i < tk.length; i++) {
            for (int j = 0; j < tk[i].length; j++) {
            System.out.print(tk[i][j] + " ");
            }
            System.out.println();
        }
    }
}