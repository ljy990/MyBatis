package cn.edu.guet;

import cn.edu.guet.bean.User;
import cn.edu.guet.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {
    SqlSession sqlSession;
    @Before
    public void init() throws ClassNotFoundException {
        InputStream in=Class.forName("cn.edu.guet.AppTest")
                .getResourceAsStream("/mybatis-config.xml");
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory=builder.build(in);
        sqlSession=sqlSessionFactory.openSession();//相当于以前的connection
    }

    @Test
    public void testSaveUser(){
        User user=new User();
        user.setId("e1217c5d18dc41aa966e37ab8fdd9003");
        user.setName("lijinyu");
        user.setNick_name("李金玉");
        user.setPassword("aabbccddeeff1234567xxxxxxxxxx");
        user.setSalt("aabbccddeeff1234567xxxxxxxxxx");


        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        userMapper.saveUser(user);
    }

    @Test
    public void testGetAllUser(){
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        List<User> userList=userMapper.getAllUser();
    }
    @After
    public void destory(){
        //sqlSession.commit();//提交
        sqlSession.close();//关闭链接
    }

}
