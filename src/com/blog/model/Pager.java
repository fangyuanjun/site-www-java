package com.blog.model;

import java.util.ArrayList;
import java.util.List;

public class Pager {

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public int getMaxShowPageSize() {
		return maxShowPageSize;
	}

	public void setMaxShowPageSize(int maxShowPageSize) {
		this.maxShowPageSize = maxShowPageSize;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getUrlFormat() {
		return urlFormat;
	}

	public void setUrlFormat(String urlFormat) {
		this.urlFormat = urlFormat;
	}

	public String getFirstPageText() {
		return firstPageText;
	}

	public void setFirstPageText(String firstPageText) {
		this.firstPageText = firstPageText;
	}

	public String getPrePageText() {
		return prePageText;
	}

	public void setPrePageText(String prePageText) {
		this.prePageText = prePageText;
	}

	public String getNextPageText() {
		return nextPageText;
	}

	public void setNextPageText(String nextPageText) {
		this.nextPageText = nextPageText;
	}

	public String getLastPageText() {
		return LastPageText;
	}

	public void setLastPageText(String lastPageText) {
		LastPageText = lastPageText;
	}

	/**
	 * 当前页码
	 */
	private int pageIndex=1;
	
	/**
	 * 总记录数
	 */
	private int recordCount;
	
	/**
	 * 显示页码列表的最大个数 默认为10
	 */
	private int maxShowPageSize=10;
	
	/**
	 * 每页分页尺寸 默认为15
	 */
	private int pageSize=15;
	
	private String urlFormat;
	
	/**
	 * 最前一页文字显示 默认显示为"首页"
	 */
	private String firstPageText="首页";
	
	/**
	 * 上一页文字显示 默认显示为"上一页"
	 */
	private String prePageText="上一页";
	
	/**
	 * 下一页文字显示 默认显示为"下一页"
	 */
	private String nextPageText="下一页";
	
	/**
	 * 末页文字显示 默认显示为"末页"
	 */
	private String LastPageText="末页";
	
	public List<PagerModel> getCollection()
	{
		 List<PagerModel> list = new ArrayList<PagerModel>();

         int pageNum = this.recordCount / this.pageSize + 1;//总页数
         if (this.recordCount > 0 && this.recordCount % this.pageSize == 0)
         {
             pageNum = this.recordCount / this.pageSize;
         }

         //当前层数  最小0
         int pagecount = this.pageIndex / this.maxShowPageSize;
         pagecount = this.pageIndex % this.maxShowPageSize == 0 ? pagecount - 1 : pagecount;//清除当 当前页数为分页页码数的整数倍页时除数多一的状况

         if (this.pageIndex > 1)
         {
             PagerModel model = new PagerModel();
             model.setFirst(true);
             model.setUrl(String.format(this.urlFormat, 1).replace("page-1.html", ""));
             model.setText(this.firstPageText);
             list.add(model);
         }

         if (this.pageIndex > 1)
         {
             PagerModel model = new PagerModel();
             model.setPrev(true); 
             model.setUrl( String.format(this.urlFormat, this.pageIndex - 1).replace("page-1.html", ""));
             model.setText ( this.prePageText);
             list.add(model);
         }


         for (int i = this.maxShowPageSize * pagecount + 1; i <= Math.min(pageNum, this.maxShowPageSize * (pagecount + 1)); i++)
         {
             PagerModel model = new PagerModel();
             model.setText( i + "");
             model.setUrl ( String.format(this.urlFormat, i).replace("page-1.html", ""));
             model.setCurrent(i == this.pageIndex);
             list.add(model);
         }

         if (this.pageIndex < pageNum)
         {
             PagerModel model = new PagerModel();
             model.setNext(true); 
             model.setUrl (String.format(this.urlFormat, this.pageIndex + 1));
             model.setText ( this.nextPageText);
             list.add(model);
         }

         if (this.pageIndex < pageNum)
         {
             PagerModel model = new PagerModel();
             model.setLast ( true);
             model.setUrl ( String.format(this.urlFormat, pageNum));
             model.setText ( this.LastPageText);
             list.add(model);
         }

         return list;
	}
}
