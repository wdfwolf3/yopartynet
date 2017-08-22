package com.yoparty;

import com.yoparty.bean.User;
import com.yoparty.mapper.UserMapper;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wdf on 17-8-20.
 */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"classpath:WEB-INF/application.xml"});
        context.start();
        UserMapper userMapper = (UserMapper) context.getBean("userMapper");
        User user = userMapper.selectByName("wdf");
        System.out.println(user.getNickname());
    }
}
