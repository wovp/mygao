package com.gao.mygao.mapper;

import com.gao.mygao.pojo.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ClassName: UserMapper
 * Package: com.gao.mygao.mapper
 * Description:
 * Author: my
 * Creat: 2023/4/17 9:19
 */
@Repository
public interface UserMapper {
    public List<User> getAll();
    public List<String> getName();
    public String getPasswordByUser(String username);
    public int addUser(User user);
    public String findOnlyUser(String username);
}
