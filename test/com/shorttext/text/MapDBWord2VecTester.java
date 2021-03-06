package com.shorttext.text;

import com.shorttext.word2vec.MapDBWord2VecUtil;
import com.shorttext.word2vec.WordEmbeddingModelUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by hok on 1/19/17.
 */
public class MapDBWord2VecTester {
    public static void main(String[] args) throws IOException {
        WordEmbeddingModelUtil wordEmbeddingModelUtil = new MapDBWord2VecUtil(new File(args[0]));

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean tonext = true;
        while (tonext) {
            System.out.print("word1> ");
            String word1 = reader.readLine().trim();
            System.out.print("word2> ");
            String word2 = reader.readLine().trim();
            double similarity = wordEmbeddingModelUtil.similarity(word1, word2);
            System.out.println("similarity = "+similarity);
            System.out.println(wordEmbeddingModelUtil.getWordMatrix(word1));

            System.out.print("continue? (y/n) ");
            tonext = (reader.readLine().equalsIgnoreCase("y"));
        }
    }
}
