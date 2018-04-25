package com.tools;

import com.tools.pattern.IPattern;
import com.tools.pattern.StringReplacePatternImpl;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * 文件内容编辑工具类
 */
public class FileContentEditTool {
    private List<IPattern> patterns = new LinkedList<>();

    public static void main(String[] args) {
        FileContentEditTool tool = new FileContentEditTool();
        tool.addPattern(new StringReplacePatternImpl("acebrook@gmail.com", ""))
                .addPattern(new StringReplacePatternImpl("", "acebrook"))
                .addPattern(new StringReplacePatternImpl("", "acebrook"))
//                .addPattern(new DecoratorClassCommentPatternImpl());
        ;

        String baseDir = "";
        List<File> list = tool.getFileList(baseDir);
        if (CollectionUtils.isEmpty(list)) {
            System.out.println("file list 不能为空");
            return;
        }
        for (File file : list) {
            String content = tool.getFileContent(file);
            String newContent = null;
            for (IPattern pattern : tool.getPatterns()) {
                newContent = pattern.edit(content);
            }
            tool.writeBack(file, newContent);
        }
    }

    private FileContentEditTool addPattern(IPattern pattern) {
        patterns.add(pattern);
        return this;
    }

    public List<IPattern> getPatterns() {
        return patterns;
    }

    private void writeBack(File file, String data) {
        try {
            if (data != null) {
                FileUtils.write(file, data, "UTF-8");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getFileContent(File file) {
        try {
            // 使用commons io工具类
            return FileUtils.readFileToString(file, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    // 获取某个目录下的所有文件
    private List<File> getFileList(String baseDir) {
        List<File> list = new LinkedList<>();
        iteratorFileDir(baseDir, list);

        return list;
    }

    // 遍历文件
    private void iteratorFileDir(String baseDir, List<File> list) {
        File file = new File(baseDir);
        File[] files = file.listFiles();
        if (files != null && files.length > 0) {
            for (File f : files) {
                if (f.isFile()) {
                    list.add(f);
                } else if (f.isDirectory()) {
                    // 递归遍历文件目录
                    iteratorFileDir(f.getAbsolutePath(), list);
                }
            }
        }
    }

}
