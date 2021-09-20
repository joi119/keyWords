package com.joi;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class MyTest {
    public String[] keyWords = {
            "auto", "break", "case", "char", "const", "continue", "default", "do",
            "double", "else", "enum", "extern",	"float", "for",	"goto",	"if",
            "int", "long", "register", "return", "short", "signed",	"sizeof", "static",
            "struct", "switch", "typedef", "union", "unsigned", "void",	"volatile", "while"
    };

    @Test
    void testCasesCount() {
        String casesTestStr1 = "    switch(i){\n" +
                "        case 0:\n" +
                "            break;\n" +
                "        case 1:\n" +
                "            break;\n" +
                "        case 2:\n" +
                "            break;\n" +
                "        default:\n" +
                "            break;\n" +
                "    }";
        String casesTestStr2 = "    switch(i){\n" +
                "        case 0:\n" +
                "            break;\n" +
                "        case 1:\n" +
                "            break;\n" +
                "        default:\n" +
                "            break;\n" +
                "    }";
        assertArrayEquals(new int[]{3}, new LevelOne().getLevelOneCount(this.keyWords,
                new StringBuilder(casesTestStr1), 2));
        assertArrayEquals(new int[]{2}, new LevelOne().getLevelOneCount(this.keyWords,
                new StringBuilder(casesTestStr2), 2));
    }

    @Test
    void testIfElseCount() {
        String ifElseStr = "    if(i<0){\n" +
                "        if(i<-1){}\n" +
                "        else{}\n" +
                "    }\n" +
                "    else if(i>0){\n" +
                "        if (i>2){}\n" +
                "        else if (i==2) {}\n" +
                "        else if (i>1) {}\n" +
                "        else {}\n" +
                "    }\n" +
                "    else{\n" +
                "        if(j!=0){}\n" +
                "        else{}\n" +
                "    }";
        assertEquals(2, new LevelThree().getLevelThreeCount(new StringBuilder(ifElseStr), 3));
        assertEquals(2, new LevelThree().getLevelThreeCount(new StringBuilder(ifElseStr), 4));

    }

}
