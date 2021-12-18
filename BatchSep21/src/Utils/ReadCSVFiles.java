package Utils;

import java.io.*;
import java.util.Scanner;

public class ReadCSVFiles {

	public void readCSV() throws IOException {
		String path = "src\\Sample.CSV";
		String array = "";
		
		Scanner sc = new Scanner(new FileReader(path));
		while(sc.hasNext()) {
			String[] str = sc.nextLine().split(",");
			System.out.println(str[0]);
		}
		
		/*
		 * Using Buffered Reader
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			while ((array = reader.readLine()) != null) {
				System.out.println(array);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ReadCSVFiles obj = new ReadCSVFiles();
		obj.readCSV();
	}

}
