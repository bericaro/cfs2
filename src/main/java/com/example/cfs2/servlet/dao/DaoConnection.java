package com.example.cfs2.servlet.dao;

import java.security.spec.DSAGenParameterSpec;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.example.cfs2.servlet.beans.Libri;
import com.example.cfs2.servlet.beans.User;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class DaoConnection {
	@Resource(name = "jdbc/storyflow")
	private DataSource ds;

	public void setDs(DataSource ds) {
		this.ds = ds;
	}

	public User signUp(String nome, String cognome, String email, String password) {
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		user.setName(nome);
		user.setSurname(cognome);
		try (Connection conn = ds.getConnection()) {

			String query = """
					INSERT INTO users (nome,cognome,email,password) VALUES(?,?,?,?)""";
			try (PreparedStatement stmt = conn.prepareStatement(query)) {
				stmt.setString(1, user.getName().toString());
				stmt.setString(2, user.getSurname().toString());
				stmt.setString(3, user.getEmail().toString());
				stmt.setString(4, user.getPassword().toString());
				int rs = stmt.executeUpdate();
			} catch (Exception e) {

			}
		} catch (SQLException ex) {
			throw new IllegalStateException(ex);
		}
		return user;
	}

	public List<User> logInUser(String email, String password) {
		User user = new User(email, password);
		List<User> users = new ArrayList<>();
		try (Connection conn = ds.getConnection()) {
			String query = """
					SELECT id FROM users WHERE email = ? AND  password =?""";
			try (PreparedStatement stmt = conn.prepareStatement(query)) {
				stmt.setString(1, user.getEmail());
				stmt.setString(2, user.getPassword());
				ResultSet rs = stmt.executeQuery();
				if(rs.next()) {
					users.add(user);
				}else{
					users = null;
				}
				
			} catch (Exception e) {

			}
		} catch (SQLException ex) {
			throw new IllegalStateException(ex);
		}
		return users;
	}
	public List<Libri> retrieveLibri() {
		Libri libro = new Libri();
		List<Libri> libri = new ArrayList<>();
		try (Connection conn = ds.getConnection()) {
			String query = """
					SELECT id FROM users WHERE email = ? AND  password =?""";
			try (PreparedStatement stmt = conn.prepareStatement(query)) {
				stmt.setString(1, libro.getTitolo());
				ResultSet rs = stmt.executeQuery();
				if(rs.next()) {
					libri.add(libro);
				}
				
			} catch (Exception e) {

			}
		} catch (SQLException ex) {
			throw new IllegalStateException(ex);
		}
		return libri;
	}	
	
}
