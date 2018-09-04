package service;

import entity.Comments;

import java.util.List;

public interface CommentsService {
    //查看评论
    List<Comments> selectByPrimaryKey(Long id);

    //添加评论
    int insert(Comments record);
}
