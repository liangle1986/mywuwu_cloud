package com.mywuwu.qiniu.service;

import com.qiniu.api.auth.AuthException;
import org.json.JSONException;

import java.io.File;
import java.io.InputStream;

/**
 * @Package: com.mywuwu.qiniu.service
 * @Description： 七牛网文件上传
 * @Author: 梁乐乐
 * @Date: Created in 2018/8/12 17:49
 * @Company: ywuwu.com
 * @Copyright: Copyright (c) 2018
 * @Version: 0.0.1
 * @Modified By:
 */
public interface IQiniuMediaUtilService {

    /**
     * @Description： 通过文件路径上传文件
     * @param localFile 文件的所在路径
     * @Author: 梁乐乐
     * @Date: Created in 2018/8/12 18:12
     * @return boolean
     */
    boolean uploadFile(String localFile) throws AuthException, JSONException ;

    /**
     * @Description： 通过文件流上传
     * @param file   文件流
     * @Author: 梁乐乐
     * @Date: Created in 2018/8/12 18:13
     * @return boolean
     */
    boolean uploadFile(File file) throws AuthException, JSONException;

    /**
     * @Description： 中写入七牛
     * @param fileName 文件名
     * @param in 输入流
     * @Author: 梁乐乐
     * @Date: Created in 2018/8/12 18:24
     * @return boolean
     */
    boolean uploadFile(String fileName,InputStream in)
            throws AuthException, JSONException;
    /**
     * 获得下载地址
     * @Description： 这个获取的就是你上传文件资源的链接
     * @param filename 文件名
     * @Author: 梁乐乐
     * @Date: Created in 2018/8/12 18:26
     * @return java.lang.String
     */
    String getFileResourceUrl(String filename) throws Exception;

    /**
     * @Description： 七牛上将文件删除
     * @param fileName 文件名
     * @Author: 梁乐乐
     * @Date: Created in 2018/8/12 18:27
     * @return void
     */
    void delete(String fileName);
    /**
     * @Description： 七牛的视频截图
     * @param fileName 要截图文件名称
     * @param format 截图的类型(jpg.png)
     * @Author: 梁乐乐
     * @Date: Created in 2018/8/12 18:28
     * @return java.lang.String
     */
    String qiNiuMediaPrtScreen(String fileName, String format);

    /**
     * @Description： 七牛的视频转码
     * @param fileName 要转换的文件名称
     * @param format 要转成的视频格式
     * @Author: 梁乐乐
     * @Date: Created in 2018/8/12 18:29
     * @return java.lang.String
     */
    String qiNiuTransCodeToAny(String fileName, String format);


    /**
     * @Description： 判断文件是否存在
     * @param fileName 文件名
     * @Author: 梁乐乐
     * @Date: Created in 2018/8/12 18:31
     * @return boolean
     */
    boolean isExist(String fileName);
}
