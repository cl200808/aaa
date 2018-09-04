package service;

import entity.Comments;
import mapper.CommentsMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("commentsService")
@Transactional
public class CommentsServiceImpl implements  CommentsService {
    @Resource(name = "commentsMapper")
    private CommentsMapper commentsMapper;

    public List<Comments> selectByPrimaryKey(Long id) {
        return commentsMapper.selectByPrimaryKey(id);
    }

    public int insert(Comments record) {
        return commentsMapper.insert(record);
    }
}
