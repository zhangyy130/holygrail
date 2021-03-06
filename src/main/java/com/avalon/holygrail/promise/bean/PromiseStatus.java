package com.avalon.holygrail.promise.bean;

/**
 * Promise状态
 * Created by 白超 on 2018/2/10.
 */
public enum PromiseStatus {
    /**
     * 进行中
     */
    PENDING,
    /**
     * 已完成
     */
    RESOLVED,
    /**
     * 已失败
     */
    REJECTED
}
