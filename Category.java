import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Category {

	private DoublyLinkedListImpl<Flashcard> myList;
	//instance variables for the database connection!!
	 private Connection connect = null;
     private Statement statement = null;
     private PreparedStatement preparedStatement = null;
     private ResultSet resultSet = null;
	 private String name;
	 
	 
	public Category (String name) throws Exception {		
		
		try {
			 // This will load the MySQL driver, each DB has its own driver
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        // Setup the connection with the DB
	        connect = DriverManager
	                        .getConnection("jdbc:mysql://127.0.0.1:3306/catagories?"
	                                        + "user=root&password=king");
	     // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            
            preparedStatement = connect
                    .prepareStatement("create table " + name + " (word VARCHAR(100), definition VARCHAR(1000))");
//	        preparedStatement.(1, name);
	        
	        preparedStatement.executeUpdate();
	        
		}
		catch (Exception e) {
            throw e;
            }
		
		this.name = name;
		myList = new DoublyLinkedListImpl<Flashcard>();
		
	}
	
	public void insert(Flashcard myFlashcard, String tableName) throws Exception {
		try {
			 // This will load the MySQL driver, each DB has its own driver
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        // Setup the connection with the DB
	        connect = DriverManager
	                        .getConnection("jdbc:mysql://127.0.0.1:3306/catagories?"
	                                        + "user=root&password=king");
	        
	     // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement
                            .executeQuery("select * from catagories.japanese");
            writeResultSet(resultSet);
	        
	        preparedStatement = connect
                    .prepareStatement("insert into  catagories."+ tableName + " (word, definition) values (?, ?)");
	        preparedStatement.setString(1, myFlashcard.getWord());
	        preparedStatement.setString(2, myFlashcard.getDefinition());
	        
	        preparedStatement.executeUpdate();
	        
	        //testing purposes
	        resultSet = statement
                    .executeQuery("select * from catagories.japanese");
                    writeMetaData(resultSet);
		}
		catch (Exception e) {
            throw e;
            }
		

		myList.addFirst(myFlashcard);			
	}
	/*
	 * temporary (I HOPE)
	 */
	 private void writeMetaData(ResultSet resultSet) throws SQLException {
         //         Now get some metadata from the database
         // Result set get the result of the SQL query

         System.out.println("The columns in the table are: ");

         System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
         for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
                 System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
         }
	 }
	 /*
		 * temporary (I HOPE)
		 */
	 private void writeResultSet(ResultSet resultSet) throws SQLException {
         // ResultSet is initially before the first data set
         while (resultSet.next()) {
                 // It is possible to get the columns via name
                 // also possible to get the columns via the column number
                 // which starts at 1
                 // e.g. resultSet.getSTring(2);
                 String word = resultSet.getString("word");
                 String definition = resultSet.getString("definition");
                 System.out.println("word: " + word);
                 System.out.println("definition: " + definition);
         }
	 }
	
	public void delete(Node<Flashcard> current, String tableName) throws Exception {
		try {
		 // This will load the MySQL driver, each DB has its own driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        // Setup the connection with the DB
        connect = DriverManager
                        .getConnection("jdbc:mysql://127.0.0.1:3306/catagories?"
                                        + "user=root&password=king");
        
     // Statements allow to issue SQL queries to the database
        statement = connect.createStatement();
        // Result set get the result of the SQL query
        resultSet = statement
                        .executeQuery("select * from catagories.japanese");
        writeResultSet(resultSet);
        
        preparedStatement = connect
                .prepareStatement("delete from  catagories." + tableName + " where word = ?");
        preparedStatement.setString(1, current.getElement().getWord());
//        preparedStatement.setString(2, myFlashcard.getDefinition());
        
        preparedStatement.executeUpdate();
        
        //testing purposes
        resultSet = statement
                .executeQuery("select * from catagories.japanese");
                writeMetaData(resultSet);
		}
                
	catch (Exception e) {
        throw e;
        }
		
		myList.remove(current);
	}
	
	public void iterateBackward () {
		myList.iterateBackward();
	}
	
	public void iterateForward () {
		myList.iterateForward();
	}
	
	public Flashcard prev(Node<Flashcard> curNode) {
		return (Flashcard)curNode.getPrev().getElement();
	}
	
	public Flashcard next(Node<Flashcard> curNode) {		
		return (Flashcard)curNode.getNext().getElement();
	}

	public Node<Flashcard> getLast() {
		return myList.getLast();
	}
	
	public Node<Flashcard> getFirst() {
		return myList.getFirst();
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public static void main(String args[]) throws Exception
	{
//		Category myCategory = new Category ("test1");
//		myCategory.insert(new Flashcard ("dog", "animal"), "test1");
//		
//		myCategory.delete(myCategory.getFirst());
//		myCategory.insert(new Flashcard ("bbb", "bbb"));
//		myCategory.insert(new Flashcard ("ccc", "ccc"));
//		myCategory.insert(new Flashcard ("ddd", "ddd"));
//		myCategory.insert(new Flashcard ("eee", "eee"));
////		myCategory.delete(myCategory.getLast());
////	    myCategory.iterateBackward();
////	    myCategory.iterateForward();
//    	myCategory.delete(myCategory.getFirst().getNext());
//		myCategory.delete(myCategory.getLast().getPrev().getPrev());
//		myCategory.iterateForward();
//		myCategory.iterateBackward();
//		myCategory.prev(myCategory.getLast());
	}
}
