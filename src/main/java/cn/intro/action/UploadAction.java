package cn.intro.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class UploadAction extends ActionSupport {


    //封装上传到服务器的文件对象
    private File upload;
    //封装上传文件的类型
    private String uploadContentType;
    //封装上传文件名称
    private String uploadFileName;
    //获取上传文件的保存路径,是应用上下文中的相对路径
    private String savePath;

  /*  //上传的文件对应jsp中的<s:file name="upload"/>
    private File[] upload;

    //上传文件的类型
    private String[] uploadContentType;

    //上传文件的名字例如  demo.jpg
    private String[] uploadFileName;

    //用于上传后图片的保存路径，该路径需要在项目中的WebRoot下新建目录
    private String savePath = "/upload";

    public File[] getUpload() {
        return upload;
    }*/

    public File getUpload() {
        return upload;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public String getUploadContentType() {
        return uploadContentType;
    }

    public void setUploadContentType(String uploadContentType) {
        this.uploadContentType = uploadContentType;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public String getSavePath() {
        return ServletActionContext.getServletContext().getRealPath(savePath);
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }


    /**
     * 单个文件上传
     *
     * @return
     * @throws Exception
     */
/*    public String upload() throws Exception {
        System.out.println("上传的文件名：" + this.getUploadFileName());
        File destFile = new File(ServletActionContext.getRequest()
                .getRealPath(this.savePath) + "\\" + this.getUploadFileName());
        FileUtils.copyFile(upload, destFile);
        return Action.SUCCESS;
    }*/

    public String upload() throws Exception {
       /* System.out.println("上传的文件名：" + this.getUploadFileName());
        File destFile = new File(ServletActionContext.getRequest()
                .getRealPath(this.savePath) + "\\" + this.getUploadFileName());
        FileUtils.copyFile(upload, destFile);
        return Action.SUCCESS;*/
        byte[]buffer=new byte[1024];
        //读取文件
        FileInputStream fis=new FileInputStream(getUpload());
        //保存文件，并设置保存目录的路径
        FileOutputStream fos=new FileOutputStream(getSavePath()+"\\"
                +this.getUploadFileName());
        int length=fis.read(buffer);
        while (length>0){
            //每次写入length长度的内容
            fos.write(buffer,0,length);
            length=fis.read(buffer);
        }
        System.out.println(uploadContentType);
        System.out.println(uploadFileName);
        System.out.println(savePath);
        fis.close();
        fos.flush();
        fos.close();
        /*File destFile=new File(ServletActionContext.getRequest()
                .getRealPath("/upload")+this.getUploadFileName());
        FileUtils.copyFile(upload,destFile);*/
        return Action.SUCCESS;

    }

   /* *//**
     * 多文件上传
     * @return
     * @throws Exception
     *//*
    public String uploadArray() throws Exception {
        for (int i = 0; i < upload.length; i++) {
            File file = upload[i];
            System.out.println("上传的文件名：" + uploadFileName[i]);
            File destFile = new File(ServletActionContext.getRequest()
                    .getRealPath(this.savePath) + "\\" + uploadFileName[i]);
            FileUtils.copyFile(file, destFile);
        }
        return Action.SUCCESS;
    }
*/
}

