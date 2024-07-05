package com.crudmysql.cms.dao.interfac;

import com.crudmysql.cms.entities.Departament;

import java.util.List;

public interface DepartamentDaoInter {
    Departament insert(Departament obj);
    Departament update(Long id, Departament obj);
    void delete(Long id);
    Departament findById(Long id);
    List<Departament> findAll();
}
