package service;

import entity.HotEvents;
import mapper.HotEventsMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.PageBean;

import javax.annotation.Resource;
import java.util.List;

@Service("hotEventsService")
@Transactional
public class HotEventsServiceImpl implements HotEventsService{
    @Resource(name = "hotEventsMapper")
    private HotEventsMapper hotEventsMapper;

    public List<HotEvents> selectAll(String keyword, PageBean pageBean) {
        return hotEventsMapper.selectAll(keyword,pageBean);
    }

    public int selectCount(String keyword) {
        return hotEventsMapper.selectCount(keyword);
    }

    public HotEvents selectById(Integer id) {
        return hotEventsMapper.selectById(id);
    }

    public int updateNum(Integer id){
        return hotEventsMapper.updateNum(id);
    }
}