package com.kecq.index;

import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;
import com.mongodb.DB;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class IndexService {
	
	private DB db;
	public IndexService(DB db)
	{
		this.db=db;
	}

	public final static String  COLLECTION_NAME="index"; 

	/**
	 * ��������������
	 * @param list
	 * @param primaryKey ������
	 * @return
	 * @throws UnknownHostException
	 */
	public String Update(List<Map<String, Object>> list,String primaryKey) throws UnknownHostException
	{
		DBCollection mongoCollection = db.getCollection(COLLECTION_NAME);
		for(Map<String, Object> map : list)
		{
			DBObject data = new BasicDBObject(map); 
			DBObject query = new BasicDBObject(); 
			query.put(primaryKey, map.get(primaryKey));
          	DBCursor cursor = mongoCollection.find(query);
          	 if(cursor.hasNext())  //������������
          	 {
          		mongoCollection.update(query,data);
          	 }
          	 else
          	 {
          		mongoCollection.insert(data);
          	 }
		}
		
		return "{\"code\":\"1\",\"msg\":\"���������ɹ�\"}";
	}
	
	 public String Delete(String token, String ids,String  primaryKey) throws UnknownHostException
     {
			DBCollection mongoCollection = db.getCollection(COLLECTION_NAME);
			for(String id : ids.split(","))
			{
				DBObject query = new BasicDBObject(); 
				query.put(primaryKey, id);
				mongoCollection.remove(query);
			}

			return "{\"code\":\"1\",\"msg\":\"ɾ�������ɹ�\"}";
     }
}
