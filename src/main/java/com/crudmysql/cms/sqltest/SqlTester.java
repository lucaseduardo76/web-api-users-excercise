package com.crudmysql.cms.sqltest;

import com.crudmysql.cms.dao.DaoFactory;
import com.crudmysql.cms.dao.implement.DepartamentDao;
import com.crudmysql.cms.dao.implement.UserDao;
import com.crudmysql.cms.entities.Departament;
import com.crudmysql.cms.entities.User;

public class SqlTester {

    public static void main(String[] args) {
        UserDao userDao = DaoFactory.createUserDao();
        DepartamentDao dpDao = DaoFactory.createDepartamentDao();
        Departament dp = new Departament(5L, "Oficina");

        User u = userDao.findById(16L);
        u.setDepartament(31L);

        userDao.update(16L, u);
    }
}
