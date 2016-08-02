/**
 * 
 */
package com.hybridcloud.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.hybridcloud.domain.user.User;
import com.hybridcloud.service.UserService;

@RestController
@EnableAutoConfiguration
@RequestMapping("/users")
public class UserController extends CommonController
{
    @Resource
    private UserService userService;
    
    @RequestMapping("")
    public String listUsers()
    {
        return i18nUtil.getMessage("org.name") + JSON.toJSONString(userService.listUsers());
    }
    
    @RequestMapping(value="", method = RequestMethod.POST)
    public void addUser(@RequestBody User user, HttpServletRequest request, HttpServletResponse response)
    {
        userService.addUser(user);
    }
    
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public String getUser(@PathVariable int id, HttpServletRequest request, HttpServletResponse response)
    {
        return JSON.toJSONString(userService.getUser(id));
    }
    
    @RequestMapping(value="/{id}", method = RequestMethod.PUT)
    public void editUser(@PathVariable int id, @RequestBody User user, HttpServletRequest request, HttpServletResponse response)
    {
        user.setId(id);
        userService.editUser(user);
    }
    
    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable int id, HttpServletRequest request, HttpServletResponse response)
    {
        userService.deleteUser(id);
    }
}
