package br.com.ftt.lpII.RegistroEstoque.DAO;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.Scanner;

public class HelperTxt {
	private String fileName;
	
	public HelperTxt(String fileName) {
		this.fileName = fileName;
	}
	
	public Scanner LoadFile() throws Exception {
		return new Scanner(new File(this.fileName));
	}
	
	public void SaveFile(String content, String fileName) throws IOException {
		File file = new File(fileName);
		PrintWriter pw = new PrintWriter(file, StandardCharsets.UTF_8);
		
		pw.write(content);
		
		pw.close();
	}
	
	

}
