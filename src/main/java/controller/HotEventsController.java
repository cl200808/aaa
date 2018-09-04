package controller;


import entity.Comments;
import entity.HotEvents;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.CommentsService;
import service.HotEventsService;
import util.PageBean;

import javax.annotation.Resource;
import java.util.List;

//控制器注入容器
@Controller("hotEventsController")
public class HotEventsController {
    //从容器中取出bean
    @Resource
    private HotEventsService hotEventsService;
    @Resource
    private CommentsService commentsService;

    //请求映射路径
    @RequestMapping("/main.do")
    public String main(String keyword, String currPage, Model model){
        int pageNo;
        //获取当前页下标pageNo
        if(currPage!=null && !currPage.equals("")){
            //String->Integer类型转换
            pageNo=Integer.parseInt(currPage);
        }else{
            //当前pageNo为首页,默认1
            pageNo=1;
        }
        //调用查询所有热点事件条数
        int countTotal=hotEventsService.selectCount(keyword);
        //分页
        PageBean pageBean=new PageBean(pageNo,2,countTotal);
        //调用查询所有热点事件信息
        List<HotEvents> list=hotEventsService.selectAll(keyword,pageBean);
        //塞值
        model.addAttribute("list",list);
        model.addAttribute("pageNo",pageNo);
        model.addAttribute("keyword",keyword);
        model.addAttribute("countTotal",countTotal);
        model.addAttribute("pageTotal",pageBean.getPageTotal());
        //跳转mian页面
        return "main";
    }

    //请求映射路径
    @RequestMapping("/search.do")
    public String search(Integer id,Model model){
        //调用根据主键查询一条热点信息
        HotEvents hotEvents=hotEventsService.selectById(id);
        //调用根据主键查询一条热点事件的所有评论
        List<Comments> comments=commentsService.selectByPrimaryKey((long)id);
        //塞值
        model.addAttribute("hotEvents",hotEvents);
        model.addAttribute("comments",comments);
        return "search";
    }

    //jackson传对象
    @RequestMapping(value="/confirm.do",produces={"application/json;charset=utf-8"})
    @ResponseBody
    public String confirm(Integer id,Comments comments) {
        String message ="";
        comments.setHoteventsid((long)id);
        //调用插入热点信息评论方法
        int flag = commentsService.insert(comments);
        if (flag > 0) {
            //插入成功,收索指数加1
            hotEventsService.updateNum(id);
            message="success";

        }else{
            //插入失败
            message="fail";
        }
        return message;
    }
}

