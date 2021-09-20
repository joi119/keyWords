package com.joi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LevelOne {
    // 判断 关键字 是否包含在变量名中
    public boolean judgeItemInString(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9') || (c == '_');
    }

    public void getLevelOneCount(String[] keyWords, StringBuilder fileContent, int level) {
        fileContent.append("case "); // 拼接一个 case 最后需要删除

        Map map = new HashMap();
        int count = 0;
        int totalCount = 0;
        int caseCountTmp = 0;
        ArrayList caseCount= new ArrayList();

        for (String keyWord : keyWords) {
            String tmp = fileContent.toString();
            count = 0;
            caseCountTmp = 0;
            while (tmp.contains(keyWord)) {
                // 判断关键字是否包含在变量中 如果有这样的变量则删去
                char pre = tmp.charAt(tmp.indexOf(keyWord) - 1);
                char after = tmp.charAt(tmp.indexOf(keyWord) + keyWord.length());
                if (judgeItemInString(pre) || judgeItemInString(after)) {}
                else {
                    count++;
                    if (keyWord.equals("case")) {
                        if (tmp.indexOf("case") < tmp.indexOf("default")) {
                            caseCountTmp++;
                        } else {
                            caseCount.add(caseCountTmp);
                            caseCountTmp = 1;
                        }
                    }
                }
                tmp = tmp.substring(tmp.indexOf(keyWord) + keyWord.length());

            }
            map.put(keyWord, count);
        }
        for(Object item : map.keySet()) {
            totalCount += Integer.parseInt(map.get(item).toString());
        }
        totalCount -= 1;
        System.out.println("total num: " + totalCount);
        if(level == 2) {
            System.out.println("switch num: " + map.get("switch"));
            System.out.print("case num: ");
            for(Object item : caseCount) {
                System.out.printf("%d ", item);
            }
            System.out.println();
        }
    }
}
