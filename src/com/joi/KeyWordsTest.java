package com.joi;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class KeyWordsTest {
    public static void main(String[] args) throws IOException {
        String filePath;
        int level;

        // 输入文件路径和完成等级
        Scanner sc = new Scanner(System.in);
        filePath = sc.next();
        level = sc.nextInt();

        KeyWords keyWords = new KeyWords(filePath);
        keyWords.getFileContent();
    }


}
