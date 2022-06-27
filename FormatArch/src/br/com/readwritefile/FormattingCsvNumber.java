package br.com.readwritefile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import br.com.readwritefile.domain.Contact;

public class FormattingCsvNumber {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("Membros.csv");
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);

		FileOutputStream fos = new FileOutputStream("phoneNumberFormated.txt");
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(osw);

		bw.write("nome, telefone");
		bw.newLine();
		
		String line = br.readLine();	

		while (line != null) {
			
			Contact contato = Contact.getFormatContact(line);
			
			if(contato.getTelefone().length() > 7) {				
				bw.write(contato.toString());
				bw.newLine();
				
			}			

			line = br.readLine();
		}

		br.close();
		bw.close();
		
		System.out.println("finish");
	}

}
