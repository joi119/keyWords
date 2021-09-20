package com.joi;

public class TrimNote {
    public StringBuilder trimNote (StringBuilder string) {
        String noteBlockStart = "/*";
        String noteBlockEnd = "*/";
        
        while(string.indexOf("/*") != -1) {
            int startIndex = string.indexOf(noteBlockStart);
            int endIndex = string.indexOf(noteBlockEnd, startIndex + 1);

            if(startIndex < 0 || endIndex < 0) break;
            string.replace(startIndex, endIndex + 2, "");
        }
        return string;
    }
}
