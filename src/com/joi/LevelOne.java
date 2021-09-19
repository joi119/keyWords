package com.joi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LevelOne {
    public boolean judgeItemInString(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9') || (c == '_');
    }

    public void getLevelOneCount(String[] keyWords, StringBuilder fileContent, int level) {
        fileContent.append("case "); // 拼接一个 case 最后需要删除

        Map map = new HashMap();
        int count = 0;
        int totalCount = 0;
        int caseCountTmp = 0;
        ArrayList<Integer> caseCount= new ArrayList();

        for(int i = 0; i < keyWords.length; i++) {
            String tmp = fileContent.toString();
            count = 0;
            caseCountTmp = 0;
            while(tmp.contains(keyWords[i])) {
                // 判断关键字是否包含在变量中
                char pre = tmp.charAt(tmp.indexOf(keyWords[i]) - 1);
                char after = tmp.charAt(tmp.indexOf(keyWords[i]) + keyWords[i].length());
                if(judgeItemInString(pre) || judgeItemInString(after)) {}
                else {
                    count++;
                    if(keyWords[i] == "case") {
                        if(tmp.indexOf("case") < tmp.indexOf("default")) {
                            caseCountTmp++;
                        } else {
                            caseCount.add(caseCountTmp);
                            caseCountTmp = 1;
                        }
                    }
                }
                tmp = tmp.substring(tmp.indexOf(keyWords[i]) + keyWords[i].length());

            }
            map.put(keyWords[i], count);
        }
        for(Object item : map.keySet()) {
            totalCount += Integer.parseInt(map.get(item).toString());
        }
        totalCount -= 1;
        System.out.println("total num: " + totalCount);
        if(level == 2) {
            System.out.println("switch num: " + map.get("switch"));
            System.out.printf("case num: ");
            for(int item : caseCount) {
                System.out.printf("%d ", item);
            }
            System.out.println();
        }
    }
}
