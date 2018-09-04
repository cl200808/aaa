package entity;
import java.sql.Timestamp;
public class Comments {
    private Long id;//评论编号

    private Long hoteventsid;//热点事件编号

    private Timestamp commentdate;//评论时间

    private String content;//评论内容

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHoteventsid() {
        return hoteventsid;
    }

    public void setHoteventsid(Long hoteventsid) {
        this.hoteventsid = hoteventsid;
    }

    public Timestamp getCommentdate() {
        return commentdate;
    }

    public void setCommentdate(Timestamp commentdate) {
        this.commentdate = commentdate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
