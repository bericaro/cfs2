package com.example.cfs2.servlet.dao;

import java.security.spec.DSAGenParameterSpec;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.example.cfs2.servlet.beans.Fumetti;
import com.example.cfs2.servlet.beans.Libri;
import com.example.cfs2.servlet.beans.Manga;
import com.example.cfs2.servlet.beans.SerieTv;
import com.example.cfs2.servlet.beans.Utenti;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class DaoConnection {
	@Resource(name = "jdbc/storyflow")
	private DataSource ds;

	public void setDs(DataSource ds) {
		this.ds = ds;
	}

	public Utenti signUp(String nome, String cognome, String email, String password, Date birth) {
		Utenti user = new Utenti();
		user.setEmail(email);
		user.setPassword(password);
		user.setName(nome);
		user.setSurname(cognome);
		user.setBirth(birth);
		try (Connection conn = ds.getConnection()) {

			String query = """
					INSERT INTO utente (nome,cognome,email,password,birth) VALUES(?,?,?,?,?)""";
			try (PreparedStatement stmt = conn.prepareStatement(query)) {
				stmt.setString(1, user.getName().toString());
				stmt.setString(2, user.getSurname().toString());
				stmt.setString(3, user.getEmail().toString());
				stmt.setString(4, user.getPassword().toString());
				stmt.setDate(5, user.getBirth());
				int rs = stmt.executeUpdate();
			} catch (Exception e) {

			}
		} catch (SQLException ex) {
			throw new IllegalStateException(ex);
		}
		return user;
	}

	public boolean logInUser(Utenti user) {
		try (Connection conn = ds.getConnection()) {
			String query = """
					SELECT email, password FROM utente WHERE email = ? AND  password =?""";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, user.getEmail());
			stmt.setString(2, user.getPassword());
			try (ResultSet rs = stmt.executeQuery();) {
				return rs.next();
			}
		} catch (SQLException ex) {
			throw new IllegalStateException(ex);
		}
	}

	public List<Libri> retrieveLibri() {

		List<Libri> libri = new ArrayList<>();
		try (Connection conn = ds.getConnection()) {
			String query = """
					SELECT titolo, url FROM libri """;
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String titolo = rs.getString(1);
				String url = rs.getString(2);
				Libri libro = new Libri(titolo, url);
				libri.add(libro);
			}

		} catch (SQLException ex) {
			throw new IllegalStateException(ex);
		}
		return libri;
	}

	public List<Fumetti> retrieveFumetti() {

		List<Fumetti> fumetti = new ArrayList<>();
		try (Connection conn = ds.getConnection()) {
			String query = """
					SELECT titolo, url FROM fumetti """;
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String titolo = rs.getString(1);
				String url = rs.getString(2);
				Fumetti fumetto = new Fumetti(titolo, url);
				fumetti.add(fumetto);
			}

		} catch (SQLException ex) {
			throw new IllegalStateException(ex);
		}
		return fumetti;
	}

	public List<Manga> retrieveManga() {

		List<Manga> mangaList = new ArrayList<>();
		try (Connection conn = ds.getConnection()) {
			String query = """
					SELECT titolo, url FROM manga """;
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String titolo = rs.getString(1);
				String url = rs.getString(2);
				Manga manga = new Manga(titolo, url);
				mangaList.add(manga);
			}

		} catch (SQLException ex) {
			throw new IllegalStateException(ex);
		}
		return mangaList;
	}

	public List<SerieTv> retrieveSerieTv() {

		List<SerieTv> serieTvList = new ArrayList<>();
		try (Connection conn = ds.getConnection()) {
			String query = """
					SELECT titolo, url FROM serietv """;
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String titolo = rs.getString(1);
				String url = rs.getString(2);
				SerieTv serieTv = new SerieTv(titolo, url);
				serieTvList.add(serieTv);
			}

		} catch (SQLException ex) {
			throw new IllegalStateException(ex);
		}
		return serieTvList;
	}
}
