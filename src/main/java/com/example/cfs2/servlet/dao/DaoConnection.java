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

import com.example.cfs2.servlet.beans.Disegnatori;
import com.example.cfs2.servlet.beans.Fumetti;
import com.example.cfs2.servlet.beans.Generi;
import com.example.cfs2.servlet.beans.Libri;
import com.example.cfs2.servlet.beans.Manga;
import com.example.cfs2.servlet.beans.Mangaka;
import com.example.cfs2.servlet.beans.Scrittori;
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

	public Utenti signUp(String nome, String cognome, String email, String password) {
		Utenti user = new Utenti();
		user.setEmail(email);
		user.setPassword(password);
		user.setName(nome);
		user.setSurname(cognome);
		try (Connection conn = ds.getConnection()) {

			String query = """
					INSERT INTO utente (nome,cognome,email,password) VALUES(?,?,?,?)""";
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

	public boolean logInUser(Utenti user) {
		boolean isUser = false;
		try (Connection conn = ds.getConnection()) {
			String query = """
					SELECT email, password FROM utente WHERE email = ? AND  password =?""";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, user.getEmail());
			stmt.setString(2, user.getPassword());
			try (ResultSet rs = stmt.executeQuery();) {
				if (!rs.next()) {
					isUser = false;
				} else {
					isUser = true;
				}
			}
		} catch (SQLException ex) {
			throw new IllegalStateException(ex);
		}
		return isUser;
	}

	public List<Libri> retrieveLibri() {

		List<Libri> libri = new ArrayList<>();
		try (Connection conn = ds.getConnection()) {
			String query = """
										SELECT l.titolo, l.url, s.nome, s.cognome, g.nome
					FROM libri l JOIN scrittori s ON l.scrittori_id = s.scrittori_id
					JOIN generi g ON l.generi_id = g.generi_id""";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String titolo = rs.getString(1);
				String url = rs.getString(2);
				Scrittori scrittore = new Scrittori(rs.getString(3), rs.getString(4));
				Generi genere = new Generi(rs.getString(5));
				Libri libro = new Libri(titolo, url, scrittore, genere);
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
					SELECT f.titolo, f.url, d.nome, d.cognome, g.nome FROM fumetti f JOIN disegnatori d ON f.fumetti_id=d.fumetti_id
					JOIN generi g ON g.generi_id=f.generi_id""";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String titolo = rs.getString(1);
				String url = rs.getString(2);
				Disegnatori disegnatore = new Disegnatori(rs.getString(3), rs.getString(4));
				Generi genere = new Generi(rs.getString(5));
				Fumetti fumetto = new Fumetti(titolo, url, disegnatore, genere);
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
					SELECT m.titolo, m.url, mk.nome, mk.cognome, g.nome
						FROM manga m JOIN mangaka mk ON m.manga_id=mk.manga_id
						JOIN generi g ON g.generi_id=m.generi_id """;
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String titolo = rs.getString(1);
				String url = rs.getString(2);
				Mangaka mangaka = new Mangaka(rs.getString(3), rs.getString(4));
				Generi genere = new Generi(rs.getString(5));
				Manga manga = new Manga(titolo, url, mangaka, genere);
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
					SELECT s.titolo, s.url, g.nome FROM serietv s JOIN generi g ON s.generi_id = g.generi_id """;
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String titolo = rs.getString(1);
				String url = rs.getString(2);
				Generi genere = new Generi(rs.getString(3));
				SerieTv serieTv = new SerieTv(titolo, url, genere);
				serieTvList.add(serieTv);
			}

		} catch (SQLException ex) {
			throw new IllegalStateException(ex);
		}
		return serieTvList;
	}
}
