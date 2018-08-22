package com.mywuwu.qiniu.utils;

/**
 * @Package: com.mywuwu.qiniu.utils
 * @Description： TODO
 * @Author: 梁乐乐
 * @Date: Created in 2018/8/12 17:50
 * @Company: ywuwu.com
 * @Copyright: Copyright (c) 2018
 * @Version: 0.0.1
 * @Modified By:
 */
public class QiNiuMedia {

    private static QiNiuMedia media = null;
    public static final String ACCESSKEY = "lVMIJR3O0S1dGJ0Yjojxa-nRb47Ido7mFvvGczYX";
    public static final String SECRETKEY = "YjXBy8eX90bGTIgpQFQM3SxPXYIeqGZSBg_HBr8p";
    public static final String BUCKETNAME = "player";
    public static final String DOMAIN = "http://pdg0calnc.bkt.clouddn.com";
    private String accessKey;// 设置accessKey
    private String secretKey;// 设置secretKey
    private String bucketName;// 设置存储空间
    private String domain;// 设置七牛域名

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    /**
     * 实例化一个QiNiuMedia实例
     * @uesr "xinzhifu@knet.cn"
     * @date 2016年11月19日下午2:58:27
     */
    public static synchronized QiNiuMedia getInstance() {
        if (media == null) {
            media = new QiNiuMedia();
            media.setAccessKey(ACCESSKEY);
            media.setSecretKey(SECRETKEY);
            media.setBucketName(BUCKETNAME);
            media.setDomain(DOMAIN);
        }
        return media;
    }
}