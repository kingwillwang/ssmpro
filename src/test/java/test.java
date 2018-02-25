import com.hk.dao.TestUserDao;
import com.hk.entity.TestUser;
import com.hk.service.TestUserService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class test {
//    @Resource
//    private TestUserDao testUserDao;
//
//    @Test
//    public void tt(){
//        List<TestUser> users = testUserDao.getUser();
//        System.out.println(users.get(0).getUserName());
//        System.out.println(users.get(0).getPassword());
//    }
//
//    @Test
//    public void add() {
//        TestUser test = new TestUser();
//        test.setUserName("bbb");
//        test.setPassword("123");
//        testUserDao.addUser(test);
//    }

    private final Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private TestUserService testUserService;

    @Test
    public void getTN(){
        List<String> mm = testUserService.getAllUserName();
        for (String m : mm) {
            System.out.println(m);
            logger.info(m);
        }

    }
}
