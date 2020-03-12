package com.rookie.springbootest.entity;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Copy{
    public static void main(String[] args){
        FileReader in =null;
        FileWriter out=null;
        List list=new ArrayList();
        //创建文件目录
        File file=new File("文件复制目标目录");
        try {
            //创建新文件
            file.createNewFile();
            //构造输入流，读取数据
            in =new FileReader("源文件目录");
            //构造输出流，将输入流读取的文件输出到新文件中
            out=new FileWriter(file);
            //采用遍历，逐个读取，实现文件拷贝
            int fi;
            while((fi=in.read())!=-1){
                out.write(fi);
            }
            //关闭资源
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
