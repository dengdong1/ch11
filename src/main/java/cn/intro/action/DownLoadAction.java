package cn.intro.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class DownLoadAction extends ActionSupport {
    //下载的文件名,对应前台jsp提交的文件名
    //该属性需在action配置<param name="contentDisposition">attachment;filename=${fileName}</param>
    private String fileName;

    //文件下载的路径,在后台获取.该处是在struts配置文件中获取<param name="inputPath">/upload</param>
    private String inputPath;

    //返回给客户端的输入流inputStream
    private InputStream inputStream;


    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getInputPath() {
        return inputPath;
    }

    public void setInputPath(String inputPath) {
        this.inputPath = inputPath;
    }

    public InputStream getInputStream() throws FileNotFoundException {

        //文件下载的路径
        String path = ServletActionContext.getRequest().getRealPath(inputPath + "\\" + fileName);
        System.out.println("文件下载的路径>>>>>>" + path);
        inputStream = new BufferedInputStream(new FileInputStream(path));
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public String download() {
        System.out.println("执行download method");
        return this.SUCCESS;
    }

}
