package com.lanou.dps.util;

import java.util.List;

/**
 * 分页信息
 * Created by dllo on 2017/10/27.
 */
public class PageBean<T> {

    // 必选项
    private int pageNum; // 第几页

    private int pageSize; // 每页显示的条目数

    private int tatalRecord; // 总的记录数

    // 计算项
    private int startIndex; //开始索引

    private int totalPage; //总分页数

    // 数据
    private List<T> data; //分页数据

    public PageBean(int pageNum, int pageSize, int tatalRecord) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.tatalRecord = tatalRecord;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTatalRecord() {
        return tatalRecord;
    }

    public void setTatalRecord(int tatalRecord) {
        this.tatalRecord = tatalRecord;
    }

    public int getStartIndex() {

        return (pageNum - 1) * pageSize;

    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getTotalPage() {

        if (tatalRecord % pageSize == 0) {

            totalPage = tatalRecord / pageSize;

        } else {

            totalPage = tatalRecord / pageSize + 1;
        }

        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}

