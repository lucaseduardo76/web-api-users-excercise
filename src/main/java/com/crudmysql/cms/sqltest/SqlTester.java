package com.crudmysql.cms.sqltest;

import com.crudmysql.cms.dao.DaoFactory;
import com.crudmysql.cms.dao.implement.UserDao;
import com.crudmysql.cms.entities.User;

public class SqlTester {

    public static void main(String[] args) {
        UserDao userDao = DaoFactory.createUserDao();

        User user = new User();
        user.setAge(10);
        user.setEmail("Lucas@gmail.com");
        user.setName("MAteus");

        System.out.println(userDao.insert(user));
    }
}
