package com.crudmysql.cms.dao.implement;

import com.crudmysql.cms.dao.interfac.DepartamentDaoInter;
import com.crudmysql.cms.db.DB;
import com.crudmysql.cms.db.DbException;
import com.crudmysql.cms.entities.Departament;
import com.crudmysql.cms.entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartamentDao implements DepartamentDaoInter {

    private Connection conn = null;

    public DepartamentDao(Connection conn){
        this.conn = conn;
    }

    @Override
    public Departament insert(Departament obj) {
        return null;
    }

    @Override
    public Departament update(Long id, Departament obj) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Departament findById(Long id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {

            st =  conn.prepareStatement("select * from departamentos WHERE Id = ?");
            st.setLong(1, id);
            rs = st.executeQuery();


            if(rs.next()) {
                return new Departament(rs.getLong("id"), rs.getString("nome_departamento"));
            }

        }catch(SQLException e) {
            throw new DbException(e.getMessage());
        }finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }

        return null;
    }

    @Override
    public List<Departament> findAll() {
        Statement st = null;
        ResultSet rs = null;
        List<Departament> dList = new ArrayList<>();

        try {
            st = conn.createStatement();
            rs = st.executeQuery("select * from departamentos");

            while(rs.next()) {
                Departament dep = new Departament(rs.getLong("id"), rs.getString("nome_departamento"));
                dList.add(dep);
            }
        }catch(SQLException e) {
            throw new DbException(e.getMessage());
        }finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
        return dList;
    }
}
