package com.joi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LevelOne {
    // 判断 关键字 是否包含在变量名中
    public boolean judgeItemInString(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9') || (c == '_');
    }

    public int[] getLevelOneCount(String[] keyWords, StringBuilder fileContent, int level) {
        Map map = new HashMap();
        int count = 0;
        int totalCount = 0;
        int caseCountTmp = 0;
        ArrayList caseCount= new ArrayList();
        Stack<String> bracket = new Stack<>();

        for (String keyWord : keyWords) {
            String tmp = fileContent.toString();
            count = 0;
            caseCountTmp = 0;
            int flag = 0;
            while (tmp.contains(keyWord)) {
                // 判断关键字是否包含在变量中 如果有这样的变量则删去
                char pre = tmp.charAt(tmp.indexOf(keyWord) - 1);
                char after = tmp.charAt(tmp.indexOf(keyWord) + keyWord.length());
                if (judgeItemInString(pre) || judgeItemInString(after)) {}
                else {
                    count++;
                    if (keyWord.equals("case") && flag == 0) {
                        String tmp2 = tmp;
                        for(int i = tmp2.indexOf("switch"); i < tmp2.length() && tmp2.contains("switch"); i++) {
                            if(tmp2.charAt(i) == '{') {
                                bracket.push("{");
                            }
                            if(tmp2.charAt(i) == '}') {
                                bracket.pop();
                                if(bracket.size() == 0) {
                                    caseCount.add(caseCountTmp);
                                    caseCountTmp = 0;
                                    tmp2 = tmp2.substring(i + 1);
                                    i = tmp2.indexOf("switch");
                                }
                            }
                            if(tmp2.contains("switch")) {
                                if(tmp2.charAt(i) == 'c' && tmp2.charAt(i+1) == 'a' && tmp2.charAt(i+2) == 's'
                                        && tmp2.charAt(i+3) == 'e') {
                                    caseCountTmp++;
                                }
                            }
                        }
                        flag = 1;
                    }
                }
                tmp = tmp.substring(tmp.indexOf(keyWord) + keyWord.length());
            }
            map.put(keyWord, count);
        }
        for(Object item : map.keySet()) {
            totalCount += Integer.parseInt(map.get(item).toString());
        }
        System.out.println("total num: " + totalCount);
        int[] res = {0};
        if(level >= 2) {
            System.out.printf("switch num: %d", Integer.parseInt(String.valueOf(map.get("switch"))));
            System.out.print("\ncase num: ");
            for(int i = 0; i < caseCount.size(); i++) {
                System.out.printf("%d ", caseCount.get(i));
                res[i] = (int) caseCount.get(i);
            }
            System.out.println();
        }
        return res;
    }

}
