package com.joi;

import java.io.*;
import java.util.ArrayList;

public class KeyWords {
    public String filePath;
    public StringBuilder fileContent;

    KeyWords(String filePath) {
//        this.filePath = filePath;
        this.filePath = "C:\\Users\\joi\\Documents\\bubblesort.cpp";
    }

    void getFileContent() throws IOException {
        FileReader fileReader = new FileReader(this.filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line = bufferedReader.readLine(); // 读入一行
        StringBuilder fileContent = new StringBuilder();

        while(line != null) {
            /*
            * 去掉字符串
            * */
            char quotationMark = '"';
            if(line.indexOf(quotationMark) != -1) {
                CharBetween charBetween = new CharBetween(quotationMark, line);
                line = charBetween.getBetweenString();
            }

            // 去掉单行注释
            String noteInline = "//";
            if(line.indexOf(noteInline) != -1) {
                int tmp = line.indexOf(noteInline);
                if(tmp == 0) {
                    line = bufferedReader.readLine(); // 读取下一行
                    continue;
                }
                else  line = line.substring(0, tmp);
            }
            /*
            * 拼接字符串
            * */
            fileContent.append(line);
            line = bufferedReader.readLine(); // 读取下一行
        }
        fileContent = new TrimNote().trimNote(fileContent);

        this.fileContent = fileContent;
        System.out.println(this.fileContent);
        bufferedReader.close();
        fileReader.close();
    }

    int getKeyWordsLevelOne() {


        return 0;
    }

    int getKeyWordsLevelTwo() {


        return 0;
    }

    int getKeyWordsLevelThree() {


        return 0;
    }

    int getKeyWordsLevelFour() {


        return 0;
    }


}
