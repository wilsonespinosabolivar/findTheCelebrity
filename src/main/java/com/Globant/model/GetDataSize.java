package com.Globant.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

	public class GetDataSize {
		
		int rows = 0;
		int colums =0;
		Scanner scanner;

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


		public Scanner getScanner() {
			return scanner;
		}


		public void setScanner(Scanner scanner) {
			this.scanner = scanner;
		}

		 /**
	     * Calculates the size of the payload
	     */ 
		public void dataSize() throws FileNotFoundException{
			
			Scanner scanner = new Scanner(new File(System.getProperty("user.home") + "/" + "payLoad.csv"));
			scanner.useDelimiter(",");
		
			rows = 0;
			colums = 0;
			while (scanner.hasNextLine())
			{
				++rows;
			    String line = scanner.nextLine();
			    String[] fields = line.split(",");
			    colums =fields.length;

			}
			scanner.close();
		}
		
	}

