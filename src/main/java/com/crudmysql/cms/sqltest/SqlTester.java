package com.crudmysql.cms.sqltest;

import com.crudmysql.cms.dao.DaoFactory;
import com.crudmysql.cms.dao.implement.DepartamentDao;
import com.crudmysql.cms.dao.implement.UserDao;
import com.crudmysql.cms.entities.User;

public class SqlTester {

    public static void main(String[] args) {
        UserDao userDao = DaoFactory.createUserDao();
        DepartamentDao dpDao = DaoFactory.createDepartamentDao();

        System.out.println(userDao.findAll());
    }
}
