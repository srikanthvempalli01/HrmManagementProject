package com.HrmManagement.Utilities;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
public class ReadConfig 
{
	Properties pro;
	public ReadConfig()
	{
		File f=new File("./Configuration\\config.properties");
		try 
		{
			FileInputStream file=new FileInputStream(f);
			pro=new Properties();
			pro.load(file);
		} 
		catch (Exception e)
		{
			System.out.println("Exception is:"+e.getMessage());
		}
	}
	public String getApplicationUrl()
	{
		String url=pro.getProperty("baseURL");
		return url;
	}
	public String getApplicationUrl1()
	{
		String url1=pro.getProperty("baseURL1");
		return url1;
	}
	
	public String getUsername()
	{
		String usr=pro.getProperty("username");
		return usr;
	}
	public String getPassword()
	{
		String pwd=pro.getProperty("passwd");
		return pwd;
	}
	public String getChromePath()
	{
		String cpath=pro.getProperty("chromepath");
		return cpath;
	}
	public String getEdgePath()
	{
		String epath=pro.getProperty("edgepath");
		return epath;
	}
	public String getFirefoxPath()
	{
		String fpath=pro.getProperty("firefoxpath");
		return fpath;
	}
	

}
