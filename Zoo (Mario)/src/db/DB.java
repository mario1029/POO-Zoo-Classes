package db;

import java.sql.*;
import java.util.ArrayList;

public class DB {

	private static DB DB= new DB();
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String driverDB = "org.postgresql.Driver";
	private String dbName = "zoo";
	private String urlDB = "jdbc:postgresql://localhost:5432/"+this.dbName;
	private String userDB = "postgres";
	private String passDB = "apwmwg.ga";
	public DB() {
		try {
			Class.forName(driverDB);
			this.conn = DriverManager.getConnection(urlDB,userDB,passDB);
		}catch (ClassNotFoundException| SQLException e) {
			e.printStackTrace();  
		}
	}
	
	public static DB getInstances() {
		return DB;
	}
	
	public ResultSet dbStatement(String query, ArrayList<Object[]> lista) {
		try {
			this.stmt = this.conn.createStatement();
			this.rs = this.stmt.executeQuery(query);
				while(rs.next()) {
					Object[] e= {rs.getString(1),rs.getString(2),rs.getString(3),
					rs.getFloat(4),rs.getFloat(5),rs.getInt(6),rs.getString(7),rs.getString(8)};
					
					lista.add(e);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				try {
					this.stmt.close();
					this.rs.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			return rs;
		}
	
	public void dbPrepareStatement(String query, Object[] obj) {
		try {
			this.pstmt=this.conn.prepareStatement(query);
			if(obj.length==1) {
				this.pstmt.setString(1, (String)obj[0]);
			}else if(obj.length==3){
				this.pstmt.setString(2, (String)obj[1]);
				if(obj[2]=="alimentacion"||obj[2]=="descripcion"||obj[2]=="atributo") {
					this.pstmt.setString(1, (String)obj[0]);
				}else if (obj[2]=="peso"||obj[2]=="altura") {
					this.pstmt.setFloat(1, Float.parseFloat((String)obj[0]));
				}else if(obj[2]=="edad"){
					this.pstmt.setInt(1, Integer.parseInt((String)obj[0]));
				}
			}else {
				this.pstmt.setString(1, (String)obj[0]);
				this.pstmt.setString(2, (String)obj[1]);
				this.pstmt.setString(3, (String)obj[2]);
				this.pstmt.setFloat(4, (Float)obj[3]);
				this.pstmt.setFloat(5, (Float)obj[4]);
				this.pstmt.setInt(6, (Integer)obj[5]);
				this.pstmt.setString(7, (String)obj[6]);
				this.pstmt.setString(8, (String)obj[7]);
			}
			this.pstmt.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				this.pstmt.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void dbClose() {
		try {
			this.conn.close();
			System.out.println("Conexion cerrada");
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean existe(String sample) {
		try {
			this.stmt = this.conn.createStatement();
			this.rs = this.stmt.executeQuery("select * from animales");
			while(rs.next()) {
				String clave=rs.getString("descripcion");
				if(clave.equalsIgnoreCase(sample)) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
