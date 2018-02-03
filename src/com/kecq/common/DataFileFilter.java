package com.kecq.common;

import java.io.FilenameFilter;
import java.io.File;

public class DataFileFilter implements FilenameFilter
{
	public boolean accept(File dir, String name) 
	{
		// TODO Auto-generated method stub
		if(name.endsWith(".dmp"))
		{
			return true;
		}
		return false;
	}


}
