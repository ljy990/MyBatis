package cn.edu.guet.mapper;

import cn.edu.guet.bean.User;

import java.util.List;

/**
 * @author jinyu
 * @date 2022/6/14 20:25
 */
public interface UserMapper {
    int saveUser(User user);
    List<User> getAllUser();

    User getUsername(String name);
}
