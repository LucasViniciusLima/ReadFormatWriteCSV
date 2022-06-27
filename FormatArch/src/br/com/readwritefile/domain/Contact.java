package br.com.readwritefile.domain;

import java.util.Scanner;

public class Contact {

	private String nome;
	private String telefone;

	public static Contact getFormatContact(String line) {
		Scanner sc = new Scanner(line);
		sc.useDelimiter(",");
		
		sc.next();
		sc.next();
		String nome = sc.next();
		sc.next();
		String phone = formatPhone(sc.next());

		sc.close();
		return new Contact(nome, phone);
	}

	public static String formatPhone(String oldPhone) {		
		String phone = oldPhone.replaceAll("[^0-9]", "");		
		if(phone.length() == 8) phone = "55349" + phone;
		if(phone.length() == 9) phone = "5534" + phone;
		if(phone.length() == 11) phone = "55" + phone;
		
		return phone;		
	}

	@Override
	public int hashCode() {
		return this.telefone.hashCode();
	}

	@Override
	public String toString() {
		return this.nome + ", " + this.telefone;
	}

	@Override
	public boolean equals(Object outro) {
		Contact outroContact = (Contact) outro;

		if (this.telefone.equals(outroContact.telefone)) {
			return true;
		}

		return false;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public Contact(String nome, String telefone) {
		this.nome = nome;
		this.telefone = telefone;
	}
}
