package service;

import entity.HotEvents;
import util.PageBean;

import java.util.List;

public interface HotEventsService {

    //分页查询所有热点事件信息
    List<HotEvents> selectAll(String keyword, PageBean pageBean);

    //查询记录数
    int selectCount(String keyword);

    //根据id获取具体热点信息
    HotEvents selectById(Integer id);

    //收索指数增加1
    int updateNum(Integer id);
}
