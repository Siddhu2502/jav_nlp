package com.siddhu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Random;

public class Tokenizer {

    private static final int TOKEN_SIZE = 128;

    public float[][] processFile(String filepath) throws Exception{
        File file = new File(filepath);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        HashSet<String> tokens = buildTokens(reader);
        int vocabularySize = getVocabularySize(tokens);
        float[][] tokenMatrix = tokenize(tokens, vocabularySize, TOKEN_SIZE);

        return tokenMatrix;
    }

    public float[][] tokenize(HashSet<String> tokens, int vocabularySize, int tokenSize) {
        tokenSize = TOKEN_SIZE; // Set the custom token size (128)
    
        float[][] tokenmatrix = new float[tokens.size()][tokenSize]; // Correct dimensions
        Random random = new Random();
    
        // For each word in the vocabulary, generate a random token of size 128
        int i = 0;
        
        // for every token available for every token size put some random number
        // NOTE: Not so sure if this is the correct way might fix it later!
        for (@SuppressWarnings("unused") String token : tokens) {
            for (int j = 0; j < tokenSize; j++) {
                tokenmatrix[i][j] = random.nextInt(1000);
            }
            i++;
        }
    
        return tokenmatrix;
    }


    public int getVocabularySize(HashSet<String> tokens) {
        return tokens.size();
    }

    public HashSet<String> buildTokens(BufferedReader reader) {
        HashSet<String> words = new HashSet<String>();
        try {
            String line = reader.readLine();
            while (line != null) {
                String[] tokens = line.split(", ");
                for (String token: tokens) {
                    words.add(token);
                }
                line = reader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return words;
    }
}
