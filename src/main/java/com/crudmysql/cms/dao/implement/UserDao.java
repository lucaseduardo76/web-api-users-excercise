package com.crudmysql.cms.dao.implement;

import com.crudmysql.cms.dao.DaoFactory;
import com.crudmysql.cms.dao.interfac.UserDaoInter;
import com.crudmysql.cms.db.DB;
import com.crudmysql.cms.db.DbException;
import com.crudmysql.cms.entities.Departament;
import com.crudmysql.cms.entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements UserDaoInter {

    private Connection conn = null;

    public UserDao(Connection conn){
        this.conn = conn;
    }

    @Override
    public User insert(User obj) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(
                    "INSERT INTO users "
                            +"(Name, Email, Age, Departamento_id) "
                            +"VALUES "
                            +"(?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1, obj.getName());
            st.setString(2, obj.getEmail());
            st.setInt(3, obj.getAge());
            Long depId = obj.getDepartament() != null ? obj.getDepartament().getId() : 0L;
            st.setLong(4, depId);
            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                rs = st.getGeneratedKeys();
                if (rs.next()) {
                    Long id = rs.getLong(1);
                    return findById(id);
                } else {
                    throw new DbException("Falha ao obter o id gerado após a inserção.");
                }
            } else {
                throw new DbException("Nenhuma linha afetada ao inserir o usuário.");
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public User update(Long id, User obj) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("UPDATE users SET Name = ?, Email = ?, Age = ?, departamento_id = ? WHERE Id = ?");
            st.setString(1, obj.getName());
            st.setString(2, obj.getEmail());
            st.setInt(3, obj.getAge());
            st.setLong(4, obj.getDepartament().getId());
            st.setLong(5, id);
            st.executeUpdate();
            return findById(id);
        }catch(SQLException e) {
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
        }

    }

    @Override
    public void delete(Long id) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("DELETE FROM users WHERE Id = ?");

            st.setLong(1, id);
            st.executeUpdate();
        }catch(SQLException e) {
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public User findById(Long id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {

            st =  conn.prepareStatement("select * from users WHERE Id = ?");
            st.setLong(1, id);
            rs = st.executeQuery();


            if(rs.next()) {
                Departament dep = null;
                Long idDep = rs.getLong("departamento_id");

                return new User(rs.getLong("id"), rs.getString("name"), rs.getString("email"), rs.getInt("age"), rs.getLong("departamento_id"));
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
    public List<User> findAll() {

        Statement st = null;
        ResultSet rs = null;
        List<User> uList = new ArrayList<>();

        try {


            st = conn.createStatement();
            rs = st.executeQuery("select * from users");

            while(rs.next()) {

                User user = new User(rs.getLong("id"), rs.getString("name"), rs.getString("email"), rs.getInt("age"), rs.getLong("departamento_id"));
                uList.add(user);
            }
        }catch(SQLException e) {
            throw new DbException(e.getMessage());
        }finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
        return uList;
    }
}
