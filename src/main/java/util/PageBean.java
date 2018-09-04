package util;

public class PageBean {
    private Integer pageNo;//当前页
    private Integer pageTotal;//总页数
    private Integer pageSize;//每页记录数
    private Integer countTotal;//总记录数
    private Integer rowStart;//起始页

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCountTotal() {
        return countTotal;
    }

    public void setCountTotal(Integer countTotal) {
        this.countTotal = countTotal;
    }

    public Integer getRowStart() {
        return rowStart;
    }

    public void setRowStart(Integer rowStart) {
        this.rowStart = rowStart;
    }

    public PageBean(){}

    public PageBean(Integer pageNo, Integer pageSize, Integer countTotal) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.countTotal = countTotal;
        this.pageTotal=countTotal%pageSize==0?countTotal/pageSize:countTotal/pageSize+1;
        this.rowStart=(pageNo-1)*pageSize;
    }
}
