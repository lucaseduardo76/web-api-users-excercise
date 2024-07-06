package com.crudmysql.cms.entities;

import com.crudmysql.cms.dao.DaoFactory;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable{
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String email;
    private Integer age;
    private Departament departament;

    public User() {
    }

    public User(Long id, String name, String email, Integer age, Long idDep ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        if(idDep != null) {
            this.departament = DaoFactory.createDepartamentDao().findById(idDep);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Departament getDepartament(){
        return departament;
    }

    public void setDepartament(Long idDep){
        if(idDep != null) {
            this.departament = DaoFactory.createDepartamentDao().findById(idDep);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        return Objects.equals(id, other.id);
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}

