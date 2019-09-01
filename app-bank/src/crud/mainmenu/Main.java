package crud.mainmenu;

import java.util.Scanner;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		
		Scanner terminalInput = new Scanner(System.in);
		String pilihanUser;
		boolean isLanjutkan = true;
		
		while (isLanjutkan) {
		clearScreen();
		System.out.println("DATABASE PERPUSTAKAAN\n");
		System.out.println("1. Lihat seluruh buku");
		System.out.println("2. Cari buku");
		System.out.println("3. Tambah data buku");
		System.out.println("4. Ubah data buku");
		System.out.println("5. Hapus data buku");
		
		System.out.print("\nMasukan pilihan anda : ");
		pilihanUser = terminalInput.next();
	
		switch (pilihanUser) {
		case "1":
			System.out.println("LIST SELURUH BUKU");
			break;
		case "2":
			System.out.println("CARI BUKU");
			break;
		case "3":
			System.out.println("TAMBAH DATA BUKU");
			break;
		case "4":
			System.out.println("UBAH DATA BUKU");
			break;
		case "5":
			System.out.println("HAPUS DATA BUKU");
			break;
		default:
			System.err.println("\nIput anda tidak ditamukan\n silahkan pilih 1-5");
		}
		System.out.print("\nApakah anda ingin melajutkan (y/n) ? ");
		pilihanUser = terminalInput.next();
		isLanjutkan = pilihanUser.equalsIgnoreCase( anotherString: "y");
	}
	
	}
	
	private static void clearScreen() {
		try {
			if (System.getProperty("os.name").contains("Windows")) {
				new ProcessBuilder(..command:"cmd","/c","cls").inheritIO().start(),waitFor();
			} else {
				System.out.println("\833\143");
			}
			
		} catch (Exception ex) {
			System.out.println("tidak bisa clear screen");
		}
	}
	
}
