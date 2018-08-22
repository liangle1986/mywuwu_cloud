package com.mywuwu.entity;

/**
* @Author:梁乐乐
* @Description: 信息返回类
* @Date: 2018/5/5 18:48
*/
public class ManagerResult {

    /**
     * 返回正确还是错误信息
     */
    private boolean success;

    /**
     * 返回信息
     */
    private String manage;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getManage() {
        return manage;
    }

    public void setManage(String manage) {
        this.manage = manage;
    }


}
