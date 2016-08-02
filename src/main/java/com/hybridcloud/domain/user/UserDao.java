/**
 * 
 */
package com.hybridcloud.domain.user;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao
{
    @Resource
    private JdbcTemplate jdbcTemplate;
    
    public List<User> listUsers()
    {
        String sql = "select * from user";
        return jdbcTemplate.query(sql, new UserRowMapper());
    }
    
    public void addUser(User user)
    {
        String sql = "insert into user (id, name, email) values(?, ?, ?)";
        jdbcTemplate.update(sql, user.getId(), user.getName(), user.getEmail());
    }
    
    public User getUser(int id)
    {
        String sql = "select * from user where id = " + id;
        return jdbcTemplate.queryForObject(sql, new UserRowMapper());
    }
    
    public void editUser(User user)
    {
        String sql = "update user set name = ?, email = ? where id = ?";
        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getId());
    }
    
    public void deleteUser(int id)
    {
        String sql = "delete from user where id = " + id;
        jdbcTemplate.update(sql);
    }
}
