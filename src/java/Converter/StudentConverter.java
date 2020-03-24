/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;
import Model.Student;;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
/**
 *
 * @author Sakshi Sinha
 */
public class StudentConverter 
{
 public static DBObject toDBObject(Student s) 
 {

		BasicDBObjectBuilder builder = BasicDBObjectBuilder.start();
		builder.append("Name",s.getName());
                builder.append("Score",s.getScore());
		return builder.get();
 }
 public static Student tostudent(DBObject doc)throws NullPointerException
 {
	        Student s=new Student();
                s.setName((String)doc.get("Name"));
                s.setScore((Integer)doc.get("Score"));
		return s;
}    
}
