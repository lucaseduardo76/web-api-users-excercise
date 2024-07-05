package com.crudmysql.cms.services;

import com.crudmysql.cms.dao.DaoFactory;
import com.crudmysql.cms.dao.implement.UserDao;
import com.crudmysql.cms.entities.User;

import java.util.List;

public class UserServices {

    public static UserDao userDao = DaoFactory.createUserDao();

    public static List<User> findAll(){
        return userDao.findAll();
    }

    public static User findById(Long id){
        return userDao.findById(id);
    }

    public static void delete(Long id){
        userDao.delete(id);
    }

    public static User update(Long id, User obj){
        return userDao.update(id, obj);
    }

    public static User insert(User obj){
        return userDao.insert(obj);
    }

}
