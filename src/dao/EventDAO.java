package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

import model.Event;

public class EventDAO {

	//----------初期情報----------
	private final String HOST ="localhost";//ホスト名
	private final String PORT ="5432";//ポート番号
	private final String DBNAME ="CarolinaReaper";//データベース名
	private String ROLENAME = "postgres";//ロール名
	private final String PASSWORD = "0000";//パスワード
	private final String URL = "jdbc:postgresql://" +HOST+":"+ PORT + "/" + DBNAME;

	//---------------- Methods----------------------------------------------------------------------------
	//----------------SELECT文生成----------
	public  static String selectEventVenue(int index){//eventIDを入れてeventIDごとのEVENTVENUE TABLEのSELECT文を返す
		return "SELECT EVENTID , EVENTVENUE, EVENTVENUEID FROM EVENTVENUE"+ String.valueOf(index) ;
	}

	public static String selectAutherRemark (int index ){
		return "SELECT EVENTID , AUTHERREMARK, AUTHERREMARKID FROM AUTHERREMARK"+ String.valueOf(index) ;
	}

	public static String selectPricePerPerson (int index){
		return "SELECT EVENTID , PRICEPERPERSON, PRICEPERPERSONID FROM PRICEPERPERSON"+ String.valueOf(index) ;
	}

	public static String selectCandidate(int index){
		return "SELECT EVENTID , CANDIDATE, CANDIDATEID FROM PRICEPERPERSON"+ String.valueOf(index) ;
	}
	public static String selectBordItems(int index){
		return  "SELECT EVENTID ,ITEMID ,USERNAME , USERPASS , USERREMARK ,USERREGISTDAY FROM BORDITEMS"+String.valueOf(index);
	}

	public static String selectPreferredFlag(int index){
		return "SELECT EVENTID ,ITEMID ,PREFERREDFLAG ,PREFERREDFLAGID FROM PREFERREDFLAG"+String.valueOf(index);
	}

	//------------CREATE TABLE文生成----------

	public  static String createEventVenue(int index){//eventIDを入れてeventIDごとのEVENTVENUE CREATE TABLE文を返す
		return "CREATE TABLE EVENTVENUE" + String.valueOf(index)+" ( EVENTID integer, EVENTVENUE text, EVENTVENUEID integer)";
	}

	public static String createAutherRemark (int index ){
		 return "CREATE TABLE AUTHERREMARK" + String.valueOf(index)+" (EVENTID integer, AUTHERREMARK text, AUTHERREMARKID integer)";
	}

	public static String createPricePerPerson (int index){
		return "CREATE TABLE PRICEPERPERSON" + String.valueOf(index)+" (EVENTID integer, PRICEPERPERSONID integer , PRICEPERPERSONID integer)";
	}

	public static String createCandidate(int index){
		return "CREATE TABLE CANDIDATE" + String.valueOf(index)+" (EVENTID integer , CANDIDATE time without time zone, CANDIDATEID integer)";
	}

	public static String createBordItems(int index){
		return  "CREATE TABLE BORDITEMS" + String.valueOf(index)+" ( EVENTID integer ,ITEMID integer , USERNAME text , USERPASS text, USERREMARK text , USERREGISTDAY time without time zone)";
	}

	public static String createPreferredFlag(int index){
		return "CREATE TABLE PREFERREDFLAG" + String.valueOf(index)+"( EVENTID integer ,ITEMID integer ,PREFERREDFLAG integer ,PREFERREDFLAGID integer)";
	}

	public  ArrayList <String> getEventVenue(int index){//indexにeventIDを入力すると、そのeventIDのeventVenueを返す
		ArrayList<String> eventVenueList = new ArrayList<String>();//取り出したデータの格納先
		//----------接続パラメータ設定----------
			Connection conn = null;
		    Statement  statement = null; // SQL文オブジェクト
		    ResultSet  resultSet = null; // 問合せ結果オブジェクト

		try {
			//--------------JDBCドライバ読み込み----------
			Class.forName("org.postgresql.Driver");

			//----------------DBに接続---------------------
			conn=DriverManager.getConnection(URL,ROLENAME,DBNAME);

			statement = conn.createStatement();


			//SELECT文準備
			PreparedStatement pStmt = conn.prepareStatement(selectEventVenue(index));
			//----------SQL文実行----------
			pStmt.executeQuery();
			while(resultSet.next()){
				int eventId = resultSet.getInt("EVENTID");
				String eventVenue = resultSet.getString("EVENTVENUE");
				if(eventId == index){
					eventVenueList.add(eventVenue);
				}
			}




		//---------------------ここからエラー処理-----------------------
		} catch (SQLException e){
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e){
			e.printStackTrace();
			return null;
		} finally {
			//-----DB切断-----
			if(conn != null){
				try{
					conn.close();
				}catch(SQLException e){
					e.printStackTrace();
					return null;
				}
			}
		}
		//--------------------ここまでエラー処理---------------------------
		return eventVenueList;//------returnしたいものを書け------

	}


	public  ArrayList <String> getAutherRemark(int index){//indexにeventIDを入力すると、そのeventIDのAutherRemarkを返す
		ArrayList<String> autherRemarkList = new ArrayList<String>();//取り出したデータの格納先
		//----------接続パラメータ設定----------
			Connection conn = null;
		    Statement  statement = null; // SQL文オブジェクト
		    ResultSet  resultSet = null; // 問合せ結果オブジェクト

		try {
			//--------------JDBCドライバ読み込み----------
			Class.forName("org.postgresql.Driver");

			//----------------DBに接続---------------------
			conn=DriverManager.getConnection(URL,ROLENAME,DBNAME);

			statement = conn.createStatement();


			//SELECT文準備
			PreparedStatement pStmt = conn.prepareStatement(selectAutherRemark(index));
			//----------SQL文実行----------
			pStmt.executeQuery();
			while(resultSet.next()){
				int eventId = resultSet.getInt("EVENTID");
				String autherRemark = resultSet.getString("AUTHERREMARK");
				if(eventId == index){
					autherRemarkList.add(autherRemark);
				}
			}




		//---------------------ここからエラー処理-----------------------
		} catch (SQLException e){
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e){
			e.printStackTrace();
			return null;
		} finally {
			//-----DB切断-----
			if(conn != null){
				try{
					conn.close();
				}catch(SQLException e){
					e.printStackTrace();
					return null;
				}
			}
		}
		//--------------------ここまでエラー処理---------------------------
		return autherRemarkList;//------returnしたいものを書け------

	}



	public  ArrayList <String> getPricePerPerson(int index){//indexにeventIDを入力すると、そのeventIDのPricePerPersonを返す
		ArrayList<String> pricePerPersonList = new ArrayList<String>();//取り出したデータの格納先
		//----------接続パラメータ設定----------
			Connection conn = null;
		    Statement  statement = null; // SQL文オブジェクト
		    ResultSet  resultSet = null; // 問合せ結果オブジェクト

		try {
			//--------------JDBCドライバ読み込み----------
			Class.forName("org.postgresql.Driver");

			//----------------DBに接続---------------------
			conn=DriverManager.getConnection(URL,ROLENAME,DBNAME);

			statement = conn.createStatement();


			//SELECT文準備
			PreparedStatement pStmt = conn.prepareStatement(selectPricePerPerson(index));
			//----------SQL文実行----------
			pStmt.executeQuery();
			while(resultSet.next()){
				int eventId = resultSet.getInt("EVENTID");
				int pricePerPerson = resultSet.getInt("PRICEPERPERSON");
				if(eventId == index){
					pricePerPersonList.add(String.valueOf(pricePerPerson));
				}
			}




		//---------------------ここからエラー処理-----------------------
		} catch (SQLException e){
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e){
			e.printStackTrace();
			return null;
		} finally {
			//-----DB切断-----
			if(conn != null){
				try{
					conn.close();
				}catch(SQLException e){
					e.printStackTrace();
					return null;
				}
			}
		}
		//--------------------ここまでエラー処理---------------------------
		return pricePerPersonList;//------returnしたいものを書け------

	}



	public  ArrayList <Calendar> getCandidate(int index){//indexにeventIDを入力すると、そのeventIDのCandidateを返す
		ArrayList<Calendar> eventCandidate = new ArrayList<Calendar>();//取り出したデータの格納先
		//----------接続パラメータ設定----------
			Connection conn = null;
		    Statement  statement = null; // SQL文オブジェクト
		    ResultSet  resultSet = null; // 問合せ結果オブジェクト

		try {
			//--------------JDBCドライバ読み込み----------
			Class.forName("org.postgresql.Driver");

			//----------------DBに接続---------------------
			conn=DriverManager.getConnection(URL,ROLENAME,DBNAME);

			statement = conn.createStatement();


			//SELECT文準備
			PreparedStatement pStmt = conn.prepareStatement(selectCandidate(index));
			//----------SQL文実行----------
			pStmt.executeQuery();
			while(resultSet.next()){
				int eventId = resultSet.getInt("EVENTID");
				String candidate = resultSet.getString("CANDIDATE");
				if(eventId == index){
					eventCandidate.add(Candidate);
				}
			}




		//---------------------ここからエラー処理-----------------------
		} catch (SQLException e){
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e){
			e.printStackTrace();
			return null;
		} finally {
			//-----DB切断-----
			if(conn != null){
				try{
					conn.close();
				}catch(SQLException e){
					e.printStackTrace();
					return null;
				}
			}
		}
		//--------------------ここまでエラー処理---------------------------
		return eventVenueList;//------returnしたいものを書け------

	}



	public  ArrayList<Event> getEventDB(){
		//----------接続パラメータ設定----------
		Connection conn = null;
		    Statement  statement = null; // SQL文オブジェクト
		    ResultSet  resultSet = null; // 問合せ結果オブジェクト

		try {
			//--------------JDBCドライバ読み込み----------
			Class.forName("org.postgresql.Driver");

			//----------------DBに接続---------------------
			conn=DriverManager.getConnection(URL,ROLENAME,DBNAME);

			statement = conn.createStatement();
			ArrayList eventList = new ArrayList();
			//----------SQL文----------
			while(resultSet.next()){

			}




		//---------------------ここからエラー処理-----------------------
		} catch (SQLException e){
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e){
			e.printStackTrace();
			return null;
		} finally {
			//-----DB切断-----
			if(conn != null){
				try{
					conn.close();
				}catch(SQLException e){
					e.printStackTrace();
					return null;
				}
			}
		}
		//--------------------ここまでエラー処理---------------------------
		return null;//------returnしたいものを書け------

	}
}