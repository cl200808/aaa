package entity;

import java.util.Date;

public class HotEvents {
    private Long id;//热点事件编号

    private String keyword;//关键词

    private String hotcontent;//热点事件内容

    private Long searchsum;//搜索指数

    private Date createdate;//创建时间

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getHotcontent() {
        return hotcontent;
    }

    public void setHotcontent(String hotcontent) {
        this.hotcontent = hotcontent;
    }

    public Long getSearchsum() {
        return searchsum;
    }

    public void setSearchsum(Long searchsum) {
        this.searchsum = searchsum;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}
