package com.crudmysql.cms.resourses;


import com.crudmysql.cms.entities.Departament;
import com.crudmysql.cms.entities.User;
import com.crudmysql.cms.services.DepartamentServices;
import com.crudmysql.cms.services.UserServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @DeleteMapping(value = "del/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        DepartamentServices.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Departament> update(@PathVariable Long id, @RequestBody Departament obj){
        return ResponseEntity.ok().body(DepartamentServices.update(id, obj));
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Departament> insert(@RequestBody Departament obj){
        Departament dep =  DepartamentServices.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dep.getId()).toUri();
        return ResponseEntity.created(uri).body(dep);
    }
}
