package assignment_six;

import java.sql.*;

public class PaperReviewDriver {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/paper_reviews";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "JJay17!*jr";

	public static void main(String[] args) throws SQLException {
		try {
			GetPaper("sking@gmail.com");
			System.out.println("");
			GetAllReviews(1);
			System.out.println("");
			GetPaperCount();
			System.out.println("");
			CreateNewPaper(4, "My Test Paper", "test.txt", "Oh what a test it was...");
			System.out.println("");
			DeleteAuthor("dkoontz@gmail.com");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("All queries complete.");
		}

	}// end main

	// Get Paper's Details by Author's Primary Key
	public static void GetPaper(String authorEmail) {
		System.out.println("Getting Paper Details...");
		Connection conn = null;
		Statement stmt = null;
		String sql;
		sql = "SELECT title, abstract, fileN FROM paper WHERE authorEmail=\"" + authorEmail + "\"";
		System.out.println(sql);

		try {
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
		
			
			if (rs.next() == false) {
				System.out.println("No results to show.");
			} else {
				rs.previous();
			}

			while (rs.next()) {
				String title = rs.getString("title");
				String abs = rs.getString("abstract");
				String fileN = rs.getString("fileN");

				System.out.println("Title: " + title);
				System.out.println("Abstract: " + abs);
				System.out.println("File Name: " + fileN);
			}


			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}

	// Get all reviews for a paper by paper's ID
	public static void GetAllReviews(int paperID) {
		System.out.println("Getting all reviews...");
		Connection conn = null;
		Statement stmt = null;
		String sql;
		sql = "SELECT recommendation, meritScore, readabilityScore, reviewerId, originalityScore, relevanceScore FROM review WHERE paperId="
				+ paperID;

		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if (rs.next() == false) {
				System.out.println("No results to show.");
			} else {
				rs.previous();
			}


			while (rs.next()) {
				String rec = rs.getString("recommendation");
				String merit = rs.getString("meritScore");
				String readability = rs.getString("readabilityScore");
				String reviewer = rs.getString("reviewerId");
				String orig = rs.getString("originalityScore");
				String relevance = rs.getString("relevanceScore");

				System.out.println("Recommendation: " + rec);
				System.out.println("Merit: " + merit);
				System.out.println("Readability: " + readability);
				System.out.println("Reviewer ID: " + reviewer);
				System.out.println("Originality: " + orig);
				System.out.println("Relevance: " + relevance);
			}

			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}

	// Get a count of all papers submitted
	public static void GetPaperCount() {
		System.out.println("Counting all papers...");
		Connection conn = null;
		Statement stmt = null;
		String sql;
		sql = "SELECT COUNT(*) AS RowCount FROM paper";

		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next() == false) {
				System.out.println("No results to show.");
			} else {
				rs.previous();
			}
			
			while (rs.next()) {
				int count = rs.getInt("RowCount");

				System.out.println("Count: " + count);
			}


			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}

	// Create a new paper submission
	public static void CreateNewPaper(int id, String title, String fileName, String abs) {
		System.out.println("Creating new paper...");
		Connection conn = null;
		Statement stmt = null;
		String sql;
		sql = "INSERT INTO paper (id, title, fileN, abstract)" + "VALUES(" + id + ",\"" + title + "\", \"" + fileName
				+ "\", \"" + abs + "\")";

		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}

	// Try to delete first author row by author's ID. Print error to console
	public static void DeleteAuthor(String email) {
		System.out.println("Attempting to delete author...");
		Connection conn = null;
		Statement stmt = null;
		String sql;
		sql = "DELETE FROM author WHERE emailAddress=\"" + email + "\"";

		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}
}
