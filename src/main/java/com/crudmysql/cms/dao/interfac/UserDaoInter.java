package com.crudmysql.cms.dao.interfac;

import com.crudmysql.cms.entities.User;

import java.util.List;

public interface UserDaoInter {

    User insert(User obj);
    User update(Long id, User obj);
    void delete(Long id);
    User findById(Long id);
    List<User> findAll();


}
