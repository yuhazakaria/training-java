package siam.program;

import java.util.Scanner;

public class KRS {
	Scanner baca = new Scanner(System.in);
	String[][] db = new String[6][3];
	String[][] Krs (String[] database) {
		int total2 = 0, total = 0;
		String[][] krs = new String[6][3]; //array krs
		String[][] krsSmt = new String[6][3]; //array krs sementara
		int x = 0; //data ke=0
		int sisa1 = 0,sisa2; //variabel sisa krs
		boolean verifikasi; //untuk verifikasi krs
		int sksMax = sks(Double.parseDouble(database[2])); //mengetahui jumlah sks maksimum yg dapat diambil
		System.out.print("maksimal SKS yang dapat diambil : " + sksMax); //output sks maksimal yang dapat diambil
		System.out.println("----------------------------");
		do {
			System.out.print("Masukan kode mata kuliah   : ");
			krsSmt[x][0] = baca.next(); //input kode
			System.out.print("Masukan nama mata kuliah   : ");
			krsSmt[x][1] = baca.next(); //input namma matkul
			System.out.println("Masukan jumlah SKS       : ");
			krsSmt[x][2] = baca.next(); //input sks
			verifikasi = Verif(sisa1,Integer.parseInt(krsSmt[x][2]),krs,krsSmt,x); //verifikasi sks
			if (verifikasi) {total=total+Integer.parseInt(krsSmt[x][2]);
			krs = krsSmt;
			} else {
				total = total;
				x--;
			}
			sisa2 = sksMax-total; //variabel sisa
			x++; //data ke x
			System.out.println("Sisa SKS yang dapat diambil : "+ sisa2);//sisa dioutputkan
			System.out.println("------------------------------");
		} while (sksMax - total > 0);
		return krs;
	}	//mengembalikan data krs
	
	int sks (double ipk) { //cek krs max
		int sks;
		if (ipk >= 3.0) { //cek krs max
			sks = 24;
		} else if (ipk >= 2.5) {
			sks = 21;
		} else if (ipk >= 2.0) {
			sks = 18;
		}else if (ipk >=1.5) {
			sks= 15;
		} else {
			sks = 11;
		}
		return sks;
	}
	
	boolean Verif(int sisa, int sks, String[][] krs, String[][] krsSmt, int x) { //method u/ verifikasi
		boolean hasil;
		if (sks > sisa) {
			System.out.println("SKS yang diambil terlalu banyak");
			hasil = false;
		} else {
			hasil = true;
		}
		return hasil;
	}
}
