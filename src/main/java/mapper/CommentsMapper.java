package mapper;

import entity.Comments;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentsMapper {

    //添加评论
    int insert(Comments record);

    //通过id查看评论
    List<Comments> selectByPrimaryKey(@Param("id") Long id);
}
