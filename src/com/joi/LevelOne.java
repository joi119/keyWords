package com.joi;

import java.util.HashMap;
import java.util.Map;

public class LevelOne {
    public void getLevelOneCount(String[] keyWords, StringBuilder fileContent) {
        Map map = new HashMap();
        int count = 0;
        int totalCount = 0;

        for(int i = 0; i < keyWords.length; i++) {
            String tmp = fileContent.toString();
            count = 0;
            while(tmp.contains(keyWords[i])) {
                // 判断关键字是否包含在变量中
                char pre = tmp.charAt(tmp.indexOf(keyWords[i]) - 1);
                char after = tmp.charAt(tmp.indexOf(keyWords[i]) + keyWords[i].length());
                if((pre >= 'a' && pre <= 'z') || (pre >= 'A' && pre <= 'Z') || (pre >= '0' && pre <= '9') || (pre == '_')
                        || (after >= 'a' && after<='z' ) || (after >= 'A' && after<='Z') || ( after >= '0' && after <= '9')
                        || (after == '_')) {}
                else
                    count++;
                tmp = tmp.substring(tmp.indexOf(keyWords[i]) + keyWords[i].length());
            }
            map.put(keyWords[i], count);
        }
        for(Object item : map.keySet()) {
            totalCount += Integer.parseInt(map.get(item).toString());
        }
        System.out.println("total num: " + totalCount);
    }
}
