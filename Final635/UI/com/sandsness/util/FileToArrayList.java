package com.sandsness.util;

import java.io.*;
import java.util.ArrayList;
import java.io.BufferedReader;

/*
 * Steps
 * 1. Read data from file into a string array list
 * 2. Pull the part of the string before the colon into a settings array list
 * 3. Pull the numbers out of each array list item and put into the settings.
 * 4. close file
 * 5. Pass data to the application
 */

public class FileToArrayList 
{

	/**
	 * @param args
	 */
		
	public static ArrayList<String> fileToStringList(String fileName) throws IOException
	{
		//this method pulls file data into an array list of strings.
		ArrayList<String> stringList = new ArrayList<String>();
		String s;
		BufferedReader fileIn = new BufferedReader(new FileReader(fileName));
		
		while ((s = fileIn.readLine()) != null)
		{
			stringList.add(s);
		}
		
		fileIn.close();
		
		return stringList;
		
	}//end method fileToArrayList
	
		
	public static ArrayList<Double> aLStringToALDouble(ArrayList<String> aLString, int column) 
	{
		//the following steps convert an array list of strings to an array list of doubles
		ArrayList<Double> aLDouble = new ArrayList<Double>();

		for ( int i = 0; i < aLString.size(); i++)
		{
			String value = aLString.get(i);
			String[] furry = value.split("\\s*,\\s*");//split values
			double n = Double.parseDouble(furry[column]);//add the second item
			aLDouble.add(n);
		}
		return aLDouble;
		
	}//end method aLStringToALDouble
	
	public static ArrayList<Integer> aLStringToALInt(ArrayList<String> aLString, int column) 
	{
		//the following steps convert an array list of strings to an array list of integers
		ArrayList<Integer> aLInt = new ArrayList<Integer>();

		for ( int i = 0; i < aLString.size(); i++)
		{
			String value = aLString.get(i);
			String[] furry = value.split("\\s*,\\s*");//split values
			int n = Integer.parseInt(furry[column]);//add the second item
			aLInt.add(n);
		}
		return aLInt;
		
	}//end method aLStringToALDouble
	
	public static double[] aLDoubleToDoubleArray (ArrayList<Double> aLDouble)
	{
		//pass ArrayList<Double> to convert into an array of doubles.
		
		int arraysize = aLDouble.size();//initialize array size
		double data[] = new double[arraysize];
				
		for (int i = 0; i < arraysize; i++)
		{
			data[i] = aLDouble.get(i);
		}
		
	
		return data;
	}//end method aLDoubleToDoubleArray
	
	public static int[] aLIntToIntArray (ArrayList<Integer> aLInt)
	{
		//pass ArrayList<Double> to convert into an array of integers
		int arraysize = aLInt.size();//initialize array size
		int data[] = new int[arraysize];
				
		for (int i = 0; i < arraysize; i++)
		{
			data[i] = aLInt.get(i);
		}
		
	
		return data;
	}//end method aLDoubleToDoubleArray
	
}//end class file to array list
