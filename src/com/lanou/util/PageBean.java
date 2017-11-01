package com.lanou.util;

import java.util.List;

/**
 * 分页信息
 * Created by dllo on 2017/10/27.
 */
public class PageBean<T> {

    // 必选项
    private int pageNum; // 第几页

    private int pageSize; // 每页显示的条目数

    private int totalRecord; // 总的记录数

    // 计算项
    private int startIndex; //开始索引

    private int totalPage; //总分页数

    // 数据
    private List<T> data; //分页数据

    // 动态显示进度条
    private int start; // 动态显示条的开始
    private int end; // 动态显示条的结束


    @Override
    public String toString() {
        return "PageBean{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", totalRecord=" + totalRecord +
                ", startIndex=" + startIndex +
                ", totalPage=" + totalPage +
                ", data=" + data +
                ", start=" + start +
                ", end=" + end +
                '}';
    }

    public PageBean(int pageNum, int pageSize, int tatalRecord) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalRecord = tatalRecord;
        this.start = 1;
        this.end = 10;
//        if(this.totalPage <= 10){
//            this.end = this.totalPage;
//        } else {
//            // totalPage = 23
//            //3.3 当前页 前4后5
//            this.start = this.pageNum - 4;
//            this.end = this.pageNum + 5;
//            // pageNum = 1
//            if(this.start < 1){
//                this.start = 1;
//                this.end = 10; }
//            // pageNum = 23
//            if(this.end > this.totalPage){
//                this.end = this.totalPage;
//                this.start = this.totalPage - 9;
//            } }
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

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getStartIndex() {

        return (pageNum - 1) * pageSize;

    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getTotalPage() {

        if (totalRecord % pageSize == 0) {

            totalPage = totalRecord / pageSize;

        } else {

            totalPage = totalRecord / pageSize + 1;
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

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}

