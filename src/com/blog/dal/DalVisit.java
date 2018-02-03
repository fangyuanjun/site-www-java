package com.blog.dal;

import java.net.URL;
import java.sql.ResultSet;
import java.util.Date;
import java.util.UUID;

import com.blog.entity.blog_tb_IpAddress;
import com.blog.entity.blog_tb_Visit;
import com.blog.entity.blog_tb_VisitCount;
import com.blog.entity.blog_tb_article;
import com.blog.idal.IDalVisit;
import com.kecq.data.EntityHelper;
import com.kecq.data.EntityHelperG;

public class DalVisit extends DalBase implements IDalVisit{

	 private int AddIPAddress(blog_tb_IpAddress entity) throws Exception
     {
			EntityHelperG<blog_tb_IpAddress> h = new EntityHelperG<blog_tb_IpAddress>(
					blog_tb_article.class, "blog_tb_IpAddress", true,
					this.getIDbHelper(), "ID");
			
         return h.insert(entity);
     }
	
	 
	 private int addCount(blog_tb_VisitCount entity) throws Exception
     {
		 EntityHelperG<blog_tb_VisitCount> h = new EntityHelperG<blog_tb_VisitCount>(
				 blog_tb_VisitCount.class, "blog_tb_VisitCount", true,
					this.getIDbHelper(), "ID");
		 
		 return h.insert(entity);

     }

	 private int updateCount(blog_tb_VisitCount entity) throws Exception
     {
         EntityHelperG<blog_tb_VisitCount> h = new EntityHelperG<blog_tb_VisitCount>(
				 blog_tb_VisitCount.class, "blog_tb_VisitCount", true,
					this.getIDbHelper(), "ID");
         
         return h.update(entity);
     }
     
	@Override
	public int addVisit(blog_tb_Visit entity) throws Exception {
		// TODO Auto-generated method stub

         String sql = "";

         URL u=new URL(entity.getVisitUrl());
         String domain = u.getHost();
         if (domain.startsWith("www."))
         {
             domain = domain.substring(4);
         }

         entity.setDomain (domain);

         try
         {
             if (!this.getIDbHelper().exists("select * from blog_tb_IpAddress where IP=?", entity.getVisitIP()))
             {
                 blog_tb_IpAddress address = new blog_tb_IpAddress();
                 address.setId(UUID.randomUUID().toString().replace("-", ""));
                 address.setIP (entity.getVisitIP());
                 address.setCity (entity.getCity());
                 address.setContry(entity.getCounty());
                 address.setADD_DATE( new Date());
                 address.setUPDATE_DATE(new Date());

                 AddIPAddress(address);
             }

             blog_tb_VisitCount countEntity = null;

             sql = "select * from blog_tb_VisitCount where Domain=? and datediff(CountDate,CURRENT_DATE)=0 ";
             ResultSet rs=this.getIDbHelper().GetResultSet(sql, domain);
             countEntity=EntityHelper.getEntity(blog_tb_VisitCount.class, rs);
             
             boolean isAddCount = (countEntity == null);
             if (countEntity == null)
             {
                 countEntity = new blog_tb_VisitCount();
                 countEntity.setDomain ( domain);
                 countEntity.setSiteID( entity.getSiteID());
                 countEntity.setID(UUID.randomUUID().toString().replace("-", ""));
                 countEntity.setADD_DATE( new Date());
                 countEntity.setCountDate(new Date());
             }

             countEntity.setPV(countEntity.getPV()+1);


             if (entity.getSessionID() != null)
             {
                 sql = "select 1 from blog_tb_Visit where Domain=? and SessionID=? and datediff(ADD_DATE,CURRENT_DATE)=0";
                 if (!this.getIDbHelper().exists(sql, domain,entity.getSessionID()))
                 {
                     countEntity.setUV(countEntity.getUV()+1);
                 }
             }

             sql = "select 1 from blog_tb_Visit where Domain=? and visitIP=? and datediff(ADD_DATE,CURRENT_DATE)=0";
             if (!this.getIDbHelper().exists(sql, domain,entity.getVisitIP()))
             {
                 countEntity.setIP(countEntity.getIP()+1);
             }

             countEntity.setUPDATE_DATE(new Date());

             if (isAddCount)
             {
                 countEntity.setUV(1);
                 countEntity.setIP(1);
                 addCount(countEntity);
             }
             else
             {
                 updateCount(countEntity);
             }
         }
         catch(Exception ex) 
         {
             throw ex;
         }
         finally
         {
        	 EntityHelperG<blog_tb_Visit> h = new EntityHelperG<blog_tb_Visit>(
        			 blog_tb_Visit.class, "blog_tb_Visit", true,
 					this.getIDbHelper(), "visitID");
        	 
        	 h.insert(entity);
        	 
         }

         return 1;
	}

}
