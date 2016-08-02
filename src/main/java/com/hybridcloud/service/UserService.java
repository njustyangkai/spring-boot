/**
 * 
 */
package com.hybridcloud.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hybridcloud.domain.user.User;
import com.hybridcloud.domain.user.UserDao;

@Service
public class UserService
{
    @Resource
    private UserDao userDao;
    
    public List<User> listUsers()
    {
        return userDao.listUsers();
    }
    
    public void addUser(User user)
    {
        userDao.addUser(user);
    }
    
    public User getUser(int id)
    {
        return userDao.getUser(id);
    }
    
    public void editUser(User user)
    {
        userDao.editUser(user);
    }
    
    public void deleteUser(int id)
    {
        userDao.deleteUser(id);
    }
}
