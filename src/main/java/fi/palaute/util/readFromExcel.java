package fi.palaute.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import jxl.Cell; 
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class readFromExcel 
{

private String inputFile;
String[][] data = null;
public void setInputFile(String inputFile) 
{
    this.inputFile = inputFile;
}

public String[][] read() throws IOException  
{
    File inputWorkbook = new File(inputFile);
    Workbook w;

    try 
    {
        w = Workbook.getWorkbook(inputWorkbook);
        // Get the first sheet


        Sheet sheet = w.getSheet(0);
        data = new String[sheet.getColumns()][sheet.getRows()];
        // Loop over first 10 column and lines
        //System.out.println(sheet.getColumns() +  " " +sheet.getRows());
        for (int j = 0; j <sheet.getColumns(); j++) 
        {
            for (int i = 0; i < sheet.getRows(); i++) 
            {
                Cell cell = sheet.getCell(j, i);
                data[j][i] = cell.getContents();
            }
        }
       ArrayList<String> filtered = new ArrayList<>();

            for (int i = 0; i <data[4].length; i++) 
            {
            	if(data[4][i].contains("ICT") || data[4][i].contains("SWD")){

            	filtered.add(data[4][i]+", "+data[5][i]+", "+data[9][i]);
            	}
            }

       
for(int n = 0; n < filtered.size(); n++){
	System.out.println(filtered.get(n));
}



    }catch (BiffException e) 
    {
        e.printStackTrace();
    }
    

return data;
}

/*
 * ArrayList<Toteutus> filtered = new ArrayList<>();

   // 4 = kurssi tunnus
   // 9 = opettajan nimi
   // 5 = kurssin nimi

   for (int i = 0; i < data[4].length; i++) {
    if (data[4][i] != null && !data[4][i].equals("") && !data[4][i].equals(" ")) {

     Toteutus toteutus = new Toteutus();
     toteutus.setNimi(data[5][i]);
     toteutus.setTunnus(data[4][i]);
     if (data[9][i] != null && !data[9][i].contains("puuttuu")) {
      toteutus.setOpettaja(data[9][i]);
     }

     filtered.add(toteutus);
    }
   }
 */

public static void main(String[] args) throws IOException 
{
	readFromExcel test = new readFromExcel();
	//Tähän oma linkki excel tauluun!
    test.setInputFile("/Users/evgenybecker/Desktop/2016k_Helsinki.xls");
    test.read();
}

}