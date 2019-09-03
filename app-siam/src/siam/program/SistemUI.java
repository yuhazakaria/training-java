package siam.program;

import java.util.Scanner;

public class SistemUI {
	static KRS krs = new KRS();
	static String[] dataBase = new String[4];
	static String[][] dataBASE = new String[6][3];
	
	public static void main(String[] args) {
		Scanner baca = new Scanner(System.in);
		int x;
		System.out.println("Selamat datang di SIAM");
		do {
			System.out.println("Menu :");
			System.out.println("1.Input Nama");
			System.out.println("2.Input Nilai");
			System.out.println("3.Cek SKS maksimal");
			System.out.println("4.Print data");
			System.out.println("EXIT");
			System.out.println("pilih : ");
			x = baca.nextInt();
			System.out.println("--------------------");
			switch (x) {
			case 1 :
				inputSiam();
				break;
			case 2 : inputNilai();
				break;
			case 3 : sks();
				break;
			case 4 : printSiam();
				break;
			case 5 : System.out.println("bye-bye");
				break;
			default :
				System.out.println("Menu tidak tersedia");
			}
		} while (x != 5);
	}
	
	static void inputSiam() {
		Scanner baca = new Scanner(System.in);
		String[] data = new String[4];
		System.out.print("Masukan Nama     : ");
		data[0] = baca.next();
		System.out.print("Masukan Nim      : ");
		data[1] = baca.next();
		System.out.print("Masukan IP       : ");
		data[2] = baca.next();
		System.out.print("Masukan Jurusan  : ");
		data[3] = baca.next();
		dataBase = data;
		System.out.println("------------------");	
	}
	
	static void printSiam() {
		int sks = 0;
		System.out.println("Nama      : " + dataBase[0]);
		System.out.println("NIM       : " + dataBase[1]);
		System.out.println("IP        : " + dataBase[2]);
		System.out.println("Jurusan   : " + dataBase[3]);
		System.out.println("--------------------------");
		System.out.println("DATA MATA KULIAH");
		for (int i = 0; i < 6; i++) {
			System.out.println("Kode mata kuliah   : " +dataBASE[i][0]);
			System.out.println("Nama Mata kuliah   : " +dataBASE[i][0]);
			System.out.println("SKS Mata Kuliah    : " +dataBASE[i][0]);
			System.out.println("---------------------");
			sks = sks+Integer.parseInt(dataBASE[i][2]);
		}
	}
	static void sks() {
		System.out.println("SKS yang dapat diambil : " + krs.sks(Double.parseDouble(dataBase[2])));
		System.out.println("------------------------");
	}
	static void inputNilai() {
		dataBASE = krs.Krs(dataBase);
	}
}

