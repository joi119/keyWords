package com.joi;

import java.io.*;
import java.util.ArrayList;

public class KeyWords {
    public String filePath;
    public StringBuilder fileContent;
    public String[] keyWords = {
            "auto", "break", "case", "char", "const", "continue", "default", "do",
            "double", "else", "enum", "extern",	"float", "for",	"goto",	"if",
            "int", "long", "register", "return", "short", "signed",	"sizeof", "static",
            "struct", "switch", "typedef", "union", "unsigned", "void",	"volatile", "while"
    };


    KeyWords(String filePath) {
//        this.filePath = filePath;
        this.filePath = "C:\\Users\\joi\\Documents\\testtest.cpp";
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
        bufferedReader.close();
        fileReader.close();
    }

    void getKeyWordsLevelOne() {
        new LevelOne().getLevelOneCount(this.keyWords, this.fileContent);
    }

    void getKeyWordsLevelTwo() {


    }

    void getKeyWordsLevelThree() {


    }

    void getKeyWordsLevelFour() {


    }


}
