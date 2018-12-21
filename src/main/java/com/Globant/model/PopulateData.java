package com.Globant.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

	public class PopulateData {
		
		int rows = 0;
		int colums =0;
	

		public PopulateData(int rows, int colums) {
			this.rows = rows;
			this.colums = colums;
		}


		public int getRows() {
			return rows;
		}


		public void setRows(int rows) {
			this.rows = rows;
		}


		public int getColums() {
			return colums;
		}


		public void setColums(int colums) {
			this.colums = colums;
		}

		 /**
	     * Populates 2d array with the vcs file
	     */ 
		public int [][] payload()  throws FileNotFoundException{
			boolean done = false;
			int payload[][] =  new int [rows] [colums] ; 
			Scanner scanner = new Scanner(new File(System.getProperty("user.home") + "/" + "payLoad.csv"));
			 int i=0;

			    while (!done) {
			        String str[] = scanner.nextLine().split(","); 
			        for (int element = 0; element < str.length; element++) {
			        	payload[i][element] = Integer.valueOf(str[element].trim());
			           if (i >= rows) {
			                Arrays.copyOf(payload, payload.length * 2);
			           }
			        }
			        if (!scanner.hasNextLine())
			            done = true;
			        else
			            i++;
			    }
			    scanner.close();
			return payload;
			
		}
	
		
	}

