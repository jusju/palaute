package fi.palaute.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;

import fi.palaute.bean.Toteutus;
import fi.palaute.bean.ToteutusImpl;
import fi.palaute.dao.ToteutusDAO;
import fi.palaute.dao.ToteutusDAOSpringJdbcImpl;



public class readExcel {
	
	@Autowired
	private ToteutusDAO dao;
 
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream(new File("/Users/evgenybecker/Desktop/2016k_Helsinki.xls"));
		
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		
		HSSFSheet sheet = wb.getSheetAt(0);
		
		ArrayList<Toteutus> toteutukset = new ArrayList<Toteutus>();
		
		for(Row row : sheet){
			Toteutus toteutus = new ToteutusImpl();
			if(row.getCell(4).toString().contains("ICT") || row.getCell(4).toString().contains("SWD")){
			String tunnus,nimi,ope;
			if(row.getCell(4) == null){
				tunnus = "tyhja";
			}else{
				tunnus = row.getCell(4).toString();
			}
			if(row.getCell(5) == null){
				nimi = "tyhja";
			}else{
				nimi = row.getCell(5).toString();
			}
			if(row.getCell(9) == null){
				ope = "tyhja";
			}else{
				ope = row.getCell(9).toString();
			}

			toteutus.setToteutusNimi(nimi);
			toteutus.setToteutusTunnus(tunnus);
			toteutus.setOpettajaNimi(ope);

			toteutukset.add(toteutus);
			}

			dao.insertBatch(toteutukset);
		}
		

	}
}
