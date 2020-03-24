package DAO;
import Model.*;
import Connect.Connection;
import Converter.StudentConverter;
import com.mongodb.BasicDBObject;
import java.util.List;
import java.util.ArrayList;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
/**
 *
 * @author Sakshi Sinha
 */
public class StudentDAO 
{
private DBCollection col;
public StudentDAO()
        {
            Connection con=Connection.getConnection();
            this.col=con.mongo.getDB("Reports").getCollection("Student");
	}
        //Creating the DB Entry
        public Student createStudent(Student s) 
        {
		DBObject doc = StudentConverter.toDBObject(s);
		this.col.insert(doc);
		String id = (String) doc.get("Name");
		s.setName(id);
		return s;
	}
        public void updateStudent(Student s) 
        {
		DBObject query = BasicDBObjectBuilder.start().append("Name", s.getName()).get();
		this.col.update(query, StudentConverter.toDBObject(s));
	}
         public Student readStudent(String Name) 
       {
         DBObject query = BasicDBObjectBuilder.start().append("Name",Name).get();
         DBObject data = this.col.findOne(query);
         return StudentConverter.tostudent(data);
       }
       public List<Student> StudHist(String Name)
       {
            List<Student>store=new ArrayList<Student>();
            BasicDBObject query = new BasicDBObject();
            query.put("Name",Name);
            DBCursor cursor = col.find(query);
            while(cursor.hasNext())
            {
                DBObject doc = cursor.next();
                Student s=StudentConverter.tostudent(doc);
	        store.add(s);
            }
            return(store);
       }
}
