package crud.mainmenu;

import java.util.Scanner;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		
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
		isLanjutkan = getYesorNo("Apakah anda ingin melanjutkan ?");
	}
	
	}
	
	private static void tampilkanData() throws IOException{
		
	}
	
	private static boolean getYesorNo(String message) {
		Scanner terminalInput = new Scanner(System.in);
		System.out.print("\n" + message + "(y/n) ? ");
		String pilihanUser = terminalInput.next();
		
		while (pilihanUser.equalsIgnoreCase( anotherString: "y") && pilihanUser.equalsIgnoreCase( anotherString: "n")) {
			System.out.println("Pilihan anda bukan y atau n");
			System.out.print("\n" + message + "(y/n) ? ");
			pilihanUser = terminalInput.next();
		}
		return pilihanUser.equalsIgnoreCase( anotherString: "y");
		
	}
	
	private static void clearScreen() {
		try {
			if (System.getProperty("os.name").contains("Windows")) {
				new ProcessBuilder(..command:"cmd","/c","cls").inheritIO().start(),waitFor();
			} else {
				System.out.print("\833\143");
			}
			
		} catch (Exception ex) {
			System.err.println("tidak bisa clear screen");
		}
	}
	
}
