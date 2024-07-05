package com.crudmysql.cms.services;

import com.crudmysql.cms.dao.DaoFactory;
import com.crudmysql.cms.dao.implement.DepartamentDao;
import com.crudmysql.cms.dao.implement.DepartamentDao;
import com.crudmysql.cms.entities.Departament;
import com.crudmysql.cms.entities.User;

import java.util.List;

public class DepartamentServices {

    public static DepartamentDao departamentDao = DaoFactory.createDepartamentDao();

    public static List<Departament> findAll(){
        return departamentDao.findAll();
    }

    public static Departament findById(Long id){
        return departamentDao.findById(id);
    }

    public static void delete(Long id){ departamentDao.delete(id);
    }

    public static Departament update(Long id, Departament obj){
        return departamentDao.update(id, obj);
    }

    public static Departament insert(Departament obj){
        return departamentDao.insert(obj);
    }
}
