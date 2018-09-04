package mapper;

import entity.HotEvents;
import org.apache.ibatis.annotations.Param;
import util.PageBean;

import java.util.List;

public interface HotEventsMapper {
    //分页查询所有热点事件信息
    List<HotEvents> selectAll(@Param("keyword") String keyword, @Param("pageBean") PageBean pageBean);

    //查询记录数
    int selectCount(@Param("keyword") String keyword);

    //根据id获取具体热点信息
    HotEvents selectById(@Param("id") Integer id);

    //收索指数增加1
    int updateNum(@Param("id")Integer id);
}
