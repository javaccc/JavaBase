package com.tools.pattern;

public class StringReplacePatternImpl implements IPattern {

    private String oldStr;
    private String newStr;

    public StringReplacePatternImpl(String oldStr, String newStr) {
        this.oldStr = oldStr;
        this.newStr = newStr;
    }

    @Override
    public String edit(String src) {
        if (null == src) {
            return null;
        } else {
            return src.replace(oldStr, newStr);
        }
    }
}
