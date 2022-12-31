package com.four.bookstore.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.four.bookstore.domain.User;
import com.four.bookstore.utils.DataSourceUtils;

public class UserDao {
    // 添加用户
    public void addUser(User user) throws SQLException {
        String sql = "insert into user(username,password,gender,email,telephone,introduce,activecode) values(?,?,?,?,?,?,?)";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        int row = runner.update(sql, user.getUsername(), user.getPassword(),
                user.getGender(), user.getEmail(), user.getTelephone(),
                user.getIntroduce(), user.getActiveCode());
        if (row == 0) {
            throw new RuntimeException();
        }
    }

    // 根据激活码查找用户
    public User findUserByActiveCode(String activeCode) throws SQLException {
        String sql = "select * from user where activecode=?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        return runner.query(sql, new BeanHandler<User>(User.class), activeCode);

    }

    // 激活用戶
    public void activeUser(String activeCode) throws SQLException {
        String sql = "update user set state=? where activecode=?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        runner.update(sql, 1, activeCode);
    }

    //根据用户名与密码查找用户
    public User findUserByUsernameAndPassword(String username, String password) throws SQLException {
        String sql = "select * from user where username=? and password=?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        return runner.query(sql, new BeanHandler<User>(User.class), username, password);
    }

    //找回密码
    public User forget(String username, String telephone, String email) throws SQLException {
        String sql = "select * from user where username=? and telephone=? and email=?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        return runner.query(sql, new BeanHandler<User>(User.class), username, telephone, email);
    }

    //重置密码
    public void UpdateUser(String password, String username, String email, String Phone) throws SQLException {
        String sql = "update user set password=? where username=? and email=? and telephone=?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        runner.update(sql, password, username, email, Phone);
    }

    //查找用户是否存在
    public User findUserByUsername(String username) throws SQLException {
        String sql = "select * from user where username=?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        return runner.query(sql, new BeanHandler<User>(User.class), username);
    }

    //修改密码
    public int UpdatePassword(String username, String email, String password, String Phone, String gender) throws SQLException {
        String sql = "update user set password=? , telephone=? ,gender=? where username=? and email=?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        int x = runner.update(sql, password, Phone, gender, username, email);
        return x;
    }
}
