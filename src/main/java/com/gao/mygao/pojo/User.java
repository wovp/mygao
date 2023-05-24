package com.gao.mygao.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * ClassName: User
 * Package: com.gao.mygao.pojo
 * Description:
 * Author: my
 * Creat: 2023/4/16 19:29
 * @author 11
 */
@Data
@AllArgsConstructor
@Repository
@NoArgsConstructor
public class User {
    private String nickname;
    private String user;
    private String password;
    private String data;
    public User(String user, String password){
        this.nickname = "临时user";
        this.user = user;
        this.password = password;
        this.data = String.valueOf(new Date());
    }
}
