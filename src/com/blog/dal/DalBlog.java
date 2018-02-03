package com.blog.dal;


import java.sql.PreparedStatement;
import java.sql.ResultSet;


import com.blog.common.XmlHelper;
import com.blog.entity.blog_tb_blog;
import com.blog.entity.blog_tb_slider;
import com.blog.idal.IDalBlog;
import com.blog.model.*;
import com.blog.viewmodel.BaseViewModel;
import com.blog.viewmodel.IndexViewModel;
import com.blog.viewmodel.SitemapViewModel;
import com.kecq.data.EntityHelper;
import com.kecq.data.EntityHelperG;

public class DalBlog extends DalBase implements IDalBlog {

	private EntityHelperG<blog_tb_blog> h = null;

	public DalBlog() {
		h = new EntityHelperG<blog_tb_blog>(blog_tb_blog.class, "blog_tb_blog",
				true, this.getIDbHelper(), "blogID");
	}

	@Override
	public blog_tb_blog getBlog(String id) throws Exception {
		// TODO Auto-generated method stub
		blog_tb_blog entity = h.getEntity(id);

		return entity;
	}

	

	@Override
	public blog_tb_blog getFirstEntity() throws Exception {
		// TODO Auto-generated method stub
		String sql = "select  * from blog_tb_blog  where blogIsDisabled=0 limit 0,1";
		ResultSet rs = this.getIDbHelper().GetResultSet(sql);
		blog_tb_blog blog = EntityHelper.getEntity(blog_tb_blog.class, rs);
		this.getIDbHelper().closeResultSet(rs);
		
		return blog;
	}

	@Override
	public blog_tb_blog getSingleBlogByUserID() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public blog_tb_blog getSingleBlogByDomain(String domain) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select  * from blog_tb_blog where replace(blogDomain,'www.','')=? limit 0,1";
		domain = domain.replace("www.", "");

		ResultSet rs = this.getIDbHelper().GetResultSet(sql, domain);
		blog_tb_blog blog = EntityHelper.getEntity(blog_tb_blog.class, rs);

		if (blog == null) {
			sql = "select blogID from blog_tb_category where categoryDomain=?";
			Object obj = this.getIDbHelper().getObject(sql, "blogID", domain);
			if (obj != null) {
				return this.getBlog(obj.toString());
			}

			return this.getFirstEntity();
		}

		this.getIDbHelper().closeResultSet(rs);
		return blog;
	}

	
	@Override
	public BaseViewModel getBlogViewModel(String blogID) throws Exception {
		// TODO Auto-generated method stub
		BaseViewModel model = new BaseViewModel();
		String sql = XmlHelper.GetXmlSql("getBlogMaster");

		PreparedStatement ps = this.getIDbHelper().getCurrentConnection()
				.prepareStatement(sql);
		ps.setObject(1, blogID);
		ps.setObject(2, blogID);
		ps.setObject(3, blogID);
		ps.setObject(4, blogID);

		ps.execute();

		ResultSet rs = ps.getResultSet();

		// ResultSetMetaData rsmd = rs.getMetaData();
		// int columnCount=rsmd.getColumnCount();
		blog_tb_blog blog = EntityHelper.getEntity(blog_tb_blog.class, rs);
		model.setBlog(blog);

		int index = 1;
		while (ps.getMoreResults()) {
			rs = ps.getResultSet();
			if (index == 1) {
				if (rs.next()) {
					model.setTotalArticleCount(rs.getInt("TotalArticleCount"));
					model.setTotalArticleViewCount(rs
							.getInt("TotalArticleViewCount"));
					model.setTotalArticleCommentCount(rs
							.getInt("TotalArticleCommentCount"));
				}
			}

			if (index == 2) {
				model.setMenus(EntityHelper.GetEntityList(MenuModel.class, rs));
			}

			if (index == 3) {
				model.setLinkCollection(EntityHelper.GetEntityList(
						LinkModel.class, rs));
			}

			index++;
		}

		this.getIDbHelper().closeResultSet(rs);

		return model;
	}

	@Override
	public IndexViewModel getIndexViewModel(String blogID) throws Exception {
		// TODO Auto-generated method stub
		IndexViewModel model = new IndexViewModel();
		String sql = XmlHelper.GetXmlSql("getBlogIndex");

		PreparedStatement ps = this.getIDbHelper().getCurrentConnection()
				.prepareStatement(sql);
		ps.setObject(1, blogID);
		ps.setObject(2, blogID);
		ps.setObject(3, blogID);
		ps.setObject(4, blogID);
		ps.setObject(5, blogID);
		ps.setObject(6, blogID);
		ps.setObject(7, blogID);
		ps.setObject(8, blogID);
		ps.setObject(9, blogID);
		ps.setObject(10, blogID);
		ps.setObject(11, blogID);
		ps.setObject(12, blogID);
		ps.execute();

		ResultSet rs = ps.getResultSet();

		model.setNewArticles(EntityHelper.GetEntityList(ArticleModel.class, rs));

		int index = 1;
		while (ps.getMoreResults()) {
			rs = ps.getResultSet();
			if (index == 1) {
				model.setMostViewArticles(EntityHelper.GetEntityList(
						ArticleModel.class, rs));
			}

			if (index == 2) {
				model.setMostCommentArticles(EntityHelper.GetEntityList(
						ArticleModel.class, rs));
			}

			if (index == 3) {
				model.setMonths(EntityHelper
						.GetEntityList(MonthModel.class, rs));
			}

			if (index == 4) {
				model.setCategorys(EntityHelper.GetEntityList(
						CategoryModel.class, rs));
			}

			if (index == 5) {
				model.setTags(EntityHelper.GetEntityList(TagModel.class, rs));
			}

			if (index == 6) {
				model.setTopArticles(EntityHelper.GetEntityList(
						ArticleModel.class, rs));
			}

			if (index == 7) {
				model.setRandomArticles(EntityHelper.GetEntityList(
						ArticleModel.class, rs));
			}
			
			if (index == 8) {
				model.setSliderCollection(EntityHelper.GetEntityList(
						blog_tb_slider.class, rs));
			}
			
			if (index == 9) {
				model.setMainArticlePics(EntityHelper.GetEntityList(
						ArticleModel.class, rs));
			}
			
			index++;
		}

		this.getIDbHelper().closeResultSet(rs);

		return model;
	}

	@Override
	public IndexViewModel getArticlePage(String blogID, int page,
			int pageSize, String categoryID, String tagID, int year, int month)
			throws Exception {
		// TODO Auto-generated method stub
		IndexViewModel model = new IndexViewModel();
		String basesql = XmlHelper.GetXmlSql("getArticlePage");
		StringBuilder sb=new StringBuilder();
		//置顶文章的sql
        String topsql = basesql + "   AND articleIsTop = 1  ORDER BY articleDatetime DESC  ;  ";
        sb.append(topsql);
        String limit = ((page - 1) * pageSize) + "," + pageSize;
        if(tagID!=null&&!tagID.equals(""))
        {
        	sb.append(basesql+XmlHelper.GetXmlSql("tagPage"));
        }
        
        else if (year > 0 && month > 0)
        {
        	sb.append(basesql+XmlHelper.GetXmlSql("monthPage"));
        }
        
        else if(categoryID!=null&&!categoryID.equals(""))
        {
        	sb.append(basesql+XmlHelper.GetXmlSql("categoryPage"));
        }
        else
        {
        	sb.append(basesql+XmlHelper.GetXmlSql("indexPage"));
        }
        
        String sql=sb.toString().replace("{0}", limit);
        
        PreparedStatement ps = this.getIDbHelper().getCurrentConnection()
				.prepareStatement(sql);
        
        if(tagID!=null&&!tagID.equals(""))
        {
        	ps.setObject(1, blogID);
        	ps.setObject(2, blogID);
    		ps.setObject(3, tagID);
    		ps.setObject(4, tagID);
    		ps.setObject(5, tagID);
        }
        
        else if (year > 0 && month > 0)
        {
        	ps.setObject(1, blogID);
        	ps.setObject(2, blogID);
        	ps.setObject(3, year);
        	ps.setObject(4, month);
        	ps.setObject(5, year);
        	ps.setObject(6, month);
        	ps.setObject(7, blogID);
        	ps.setObject(8, year);
        	ps.setObject(9, month);
        	ps.setObject(10, blogID);
        }
        
        else if(categoryID!=null&&!categoryID.equals(""))
        {
        	ps.setObject(1, blogID);
        	ps.setObject(2, blogID);
    		ps.setObject(3, categoryID);
    		ps.setObject(4, categoryID);
    		ps.setObject(5, categoryID);
        }
        else
        {
        	ps.setObject(1, blogID);
        	ps.setObject(2, blogID);
    		ps.setObject(3, blogID);
    		ps.setObject(4, blogID);
        }
        
        ps.execute();
        
        ResultSet rs = ps.getResultSet();

		model.setTopArticles(EntityHelper.GetEntityList(ArticleModel.class, rs));

		int index = 1;
		while (ps.getMoreResults()) {
			rs = ps.getResultSet();
			if (index == 1) {
				model.setIndexArticles(EntityHelper.GetEntityList(
						ArticleModel.class, rs));
			}

			if (index == 2) {
				int recordCount=0;
				if(rs.next())
				{
					recordCount=rs.getInt(1);
				}
				
				model.setRecordCount(recordCount);
			}

			index++;
		}

		this.getIDbHelper().closeResultSet(rs);
        
		return model;
	}

	@Override
	public SitemapViewModel GetSitemap(String blogID) throws Exception {
		// TODO Auto-generated method stub
		SitemapViewModel model = new SitemapViewModel();
		String sql = XmlHelper.GetXmlSql("getSitemap");

		PreparedStatement ps = this.getIDbHelper().getCurrentConnection()
				.prepareStatement(sql);
		ps.setObject(1, blogID);
		ps.setObject(2, blogID);
		ps.setObject(3, blogID);
		ps.setObject(4, blogID);

		ps.execute();

		ResultSet rs = ps.getResultSet();

		 model.setMenu(EntityHelper.GetEntityList(MenuModel.class, rs));
		int index = 1;
		while (ps.getMoreResults()) {
			rs = ps.getResultSet();

			if (index == 1) {
				model.setCategory(EntityHelper.GetEntityList(CategoryModel.class, rs));
			}
			
			if (index == 2) {
				model.setMonth(EntityHelper.GetEntityList(MonthModel.class, rs));
			}

			if (index == 3) {
				model.setArticle(EntityHelper.GetEntityList(ArticleModel.class, rs));
			}

			index++;
		}

		this.getIDbHelper().closeResultSet(rs);

		return model;
	}

}
