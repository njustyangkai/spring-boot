/**
 * 
 */
package com.hybridcloud.service;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.hybridcloud.Main;
import com.hybridcloud.domain.user.User;

/** 
 * <p>  
 * 版权所有：中兴通讯股份有限公司   
 * </p>  
 * <p>  
 * 项目名称：ORG  
 * </p>  
 * <p>   
 * 类名称：UserServiceTest   
 * </p>  
 * <p>  
 * 类描述： Junit测试类  
 * </p>  
 * <p>  
 * 创建人：10155603  --梁尔镇 
 * </p>  
 * <p>  
 * 创建时间：2016年7月29日 上午11:10:38 
 * </p>  
 * <p>    
 * 修改人：10155603  
 * </p>  
 * <p>  
 * 修改时间：2016年7月29日 上午11:10:38  
 * </p>  
 * <p>   
 * 修改备注： 
 * </p>    
 * @version 1.0   
 *    
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Main.class)
@WebAppConfiguration
@Transactional
@Rollback
public class UserServiceTest extends AbstractTransactionalJUnit4SpringContextTests
{
    @Autowired
    private UserService userService;

    /**
     * Test method for {@link com.hybridcloud.service.UserService#listUsers()}.
     */
    @Test
    public void testListUsers()
    {
        List<User> userList = userService.listUsers();
        assertTrue("listUsers should return userList", userList != null);
    }

    /**
     * Test method for {@link com.hybridcloud.service.UserService#addUser(com.hybridcloud.domain.user.User)}.
     */
    @Test
    public void testAddUser()
    {
        User user = new User();
        user.setId(1);
        user.setName("Test1");
        userService.addUser(user);
    }

    /**
     * Test method for {@link com.hybridcloud.service.UserService#getUser(int)}.
     */
    @Test
    public void testGetUser()
    {
        userService.getUser(2);
    }

    /**
     * Test method for {@link com.hybridcloud.service.UserService#editUser(com.hybridcloud.domain.user.User)}.
     */
    @Test
    public void testEditUser()
    {
        User user = new User();
        user.setId(1);
        user.setName("Test2");
        userService.editUser(user);;
    }

    /**
     * Test method for {@link com.hybridcloud.service.UserService#deleteUser(int)}.
     */
    @Test
    public void testDeleteUser()
    {
        userService.deleteUser(1);
    }
}
