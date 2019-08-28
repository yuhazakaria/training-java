package siam.program;

import java.util.Scanner;

public class KRS {
	Scanner baca = new Scanner(System.in);
	String[][] db = new String[6][3];
	String[][] Krs = new String[6][3];
		int total2 = 0, total = 0;
		String[][] krs = new String[6][3]; //array krs
		String[][] krsSmt = new String[6][3]; //array krs sementara
		int x = 0; //data ke=0
		int sisa1,sisa2; //variabel sisa krs
		boolean verifikasi; //untuk verifikasi krs
		int sksMax = sks(Double.parseDouble(database[2])); //mengetahui jumlah sks maksimum yg dapat diambil
		
			System.out.print("Masukan kode mata kuliah   : ");
			krsSmt[x][0] = baca.next();
			System.out.print("Masukan nama mata kuliah   : ");
			krsSmt[x][1] = baca.next();
			System.out.println("Masukan jumlah SKS       : ");
			krsSmt[x][2] = baca.next();
			
			
		}
		
}
