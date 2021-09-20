package com.joi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class LevelThree {
    public Stack<String> keyWord = new Stack<>();
    public ArrayList<String> keyWordTmp = new ArrayList<>();

    public int getMinIndex(int index1, int index2, int index3) {
        int[] arr = {index1, index2, index3};
        int min = Integer.MAX_VALUE;
        ArrayList<Integer> indexArr = new ArrayList<>();

        for(int i = 0; i < 3; i++) {
            if(arr[i] != -1) indexArr.add(arr[i]);
        }

        if(indexArr.size() == 0) return 0;

        for (Integer integer : indexArr) {
            min = Math.min(min, integer);
        }

        return min;
    }
    /*
    * 判断 关键字 是否包含在变量名中
    * */
    public boolean judgeItemInString(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9') || (c == '_');
    }
    /*
    * 统计 if else-if else
    *    总是统计三个下标最小的那个(非 -1)
    *    切割字符串
    * */
    public void getLevelThreeCount(StringBuilder fileContent, int level) {
        String strIf = "if";
        String strElseIf = "else if";
        String strElse = "else";
        int index1 = -1;
        int index2 = -1;
        int index3 = -1;
        int minIndex = 0;
        String tmp = fileContent.toString();

        /*
        * 统计关键字
        * */
        while(tmp.length() != 0) {
            index1 = tmp.indexOf(strIf);
            index2 = tmp.indexOf(strElseIf);
            index3 = tmp.indexOf(strElse);
            minIndex = getMinIndex(index1, index2, index3);
            int keyWordLength = 0;

            // 统计要截取的第一个下标
            // minIndex 非 0 表示还存在关键字
            if (minIndex != 0) {
                // 统计关键词长度
                if (minIndex == index1) keyWordLength = 2;
                else if (minIndex == index2) keyWordLength = 7;
                else keyWordLength = 4;
                char pre = tmp.charAt(minIndex - 1);
                char after = tmp.charAt(minIndex + keyWordLength);
                if (judgeItemInString(pre) || judgeItemInString(after)) {} // 不计入关键字
                else { // 计入关键字
                    switch (keyWordLength) {
                        case 2:
                            this.keyWordTmp.add("1");
                            break;
                        case 7:
                            this.keyWordTmp.add("2");
                            break;
                        case 4:
                            this.keyWordTmp.add("3");
                            break;
                    }
                }
                tmp = tmp.substring(minIndex + keyWordLength);
            } else
                break;
        }

        statisticsKeyWord(level);

    }

    public void statisticsKeyWord(int level) {
        int ifElseCount = 0;
        int ifElseIfElseCount = 0;
        for(int i = 0; i < this.keyWordTmp.size(); i++) {
            if(this.keyWordTmp.get(i).equals("1")) this.keyWord.push("1");
            if(this.keyWordTmp.get(i).equals("2")) {
                this.keyWord.push("2");
            }
            if(this.keyWordTmp.get(i).equals("3")) {
                if(this.keyWord.peek().equals("2")) {
                    while(this.keyWord.peek().equals("2")) this.keyWord.pop();
                    ifElseIfElseCount++;
                } else
                    ifElseCount++;
                this.keyWord.pop();
            }
        }

        if(level == 3) {
            System.out.print("if-else num: " + ifElseCount);
        }
        if(level == 4) {
            System.out.println("if-else num: " + ifElseCount);
            System.out.println("if-elseif-else num: " + ifElseIfElseCount);
        }
    }

    /*
     * 通过快速访问遍历Stack
     * */
    public static void iteratorThroughRandomAccess(List list) {
        String val = null;
        for (int i = 0; i < list.size(); i++) {
            val = (String) list.get(i);
            System.out.print(val+" ");
        }
        System.out.println();
    }

    /*
     * 通过迭代器遍历Stack
     * */
    public static void iteratorThroughIterator(List list) {

        String val = null;
        for(Iterator iter = list.iterator(); iter.hasNext();) {
            val = (String)iter.next();
            System.out.print(val+" ");
        }
        System.out.println();
    }
}
