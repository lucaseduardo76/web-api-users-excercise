package com.crudmysql.cms.resourses;


import com.crudmysql.cms.entities.Departament;
import com.crudmysql.cms.entities.User;
import com.crudmysql.cms.services.DepartamentServices;
import com.crudmysql.cms.services.UserServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/departament")
public class DepartamentResourse {

    @GetMapping
    public ResponseEntity<List<Departament>> findAll() {
        List<Departament> dList = DepartamentServices.findAll();
        return ResponseEntity.ok().body(dList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Departament> findById(@PathVariable Long id){
        Departament dep = DepartamentServices.findById(id);
        return ResponseEntity.ok().body(dep);
    }

}
