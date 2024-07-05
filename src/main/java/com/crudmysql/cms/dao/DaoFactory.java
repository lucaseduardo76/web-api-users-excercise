package com.crudmysql.cms.dao;

import com.crudmysql.cms.dao.implement.UserDao;
import com.crudmysql.cms.db.DB;

public class DaoFactory {

    public static UserDao createUserDao(){
        return new UserDao(DB.getConnection());
    }

}
