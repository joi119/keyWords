package com.joi;

import java.util.ArrayList;

public class CharBetween {
    char character;
    String string;

    CharBetween(char character, String string) {
        this.character = character;
        this.string = string;
    }

    String getBetweenString() {
        int flag = 0;
        ArrayList<Integer> indexArr = new ArrayList<>();
        ArrayList<Character> str = new ArrayList<>();
        ArrayList<Character> newStr = new ArrayList<>();

        for(int i = 0; i< this.string.length(); i++) {
            str.add(this.string.toCharArray()[i]);
            if(str.get(i) == this.character) {
                flag++;
                indexArr.add(i);
            }
        }

        /*
        * 1. flag 为偶数
        *   - indexArr 两两分组 进行下标删除
        * 2. flag 为奇数
        *   - indexArr 最后一个元素到string结束全部删除， 除最后一个两两分组 进行下标删除
        * */
        if(flag % 2 == 1) {
            int lastIndex = indexArr.get(indexArr.size() - 1);
            for(int i = lastIndex; i < this.string.length(); i++) {
                str.remove(i);
            }
        }
        int j = 0;
        for(int i = 0; i < str.size(); i++) {
            if(i != indexArr.get(j)) newStr.add(str.get(i));
            else {
                j++;
                i = indexArr.get(j);
                if(j != indexArr.size() - 1)
                    j++;
            }
        }
        StringBuilder finalString = new StringBuilder();
        for (Character character : newStr) {
            finalString.append(character);
        }
        return finalString.toString();
    }
}
