package com.crudmysql.cms.resourses;

import java.net.URI;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.crudmysql.cms.entities.User;
import com.crudmysql.cms.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.crudmysql.cms.db.DB;
import com.crudmysql.cms.db.DbException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/api/users")
public class UsersResourses {



    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> uList = UserServices.findAll();
        return ResponseEntity.ok().body(uList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User user = UserServices.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @DeleteMapping(value = "del/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        UserServices.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){
        return ResponseEntity.ok().body(UserServices.update(id, obj));
    }

    @PostMapping(value = "/add")
    public ResponseEntity<User> insert(@RequestBody User obj){
        User user =  UserServices.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(user);
    }


}