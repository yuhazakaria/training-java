package com.program.bank;

import java.util.Scanner;

public class Menu {
	
	public static void main(String[] args) {
		Scanner baca = new Scanner(System.in);
		Bank menu = new Bank();
		System.out.println("Selamat datang di bank-bank ojek");
		int pilih;
		do {
			System.out.println("------------------------");
			System.out.println("-DAFTAR LAYANAN-");
			System.out.println("1. Cek Saldo");
			System.out.println("2. Transfer Saldo");
			System.out.println("3. Ambil Uang");
			System.out.println("4. Tambah Saldo");
			System.out.println("5. Menu Lainnya");
			System.out.println("6. EXIT");
			System.out.print("Masukan Pilihan : ");
			pilih = baca.nextInt();
			System.out.println("------------------------");
			switch (pilih){
				case 1:
					menu.cekSaldo();
					break;
				case 2: 
					menu.transfer();
					break;
				case 3:
					System.out.println("masukan Uang yang anda ambil : Rp ");
					double am = baca.nextDouble();
					menu.ambilUang(am);
					break;
				case 4:
					System.out.println("Masukan uang yang anda tambah");
					double tb = baca.nextDouble();
					menu.tambahUang(tb);
					break;
				case 5:
					menu.menuLain();
					break;
				case 6:
					System.out.println("Terima kasih sudah menggunakan layanan kami");
					break;
				default:
					System.out.println("Layanan tidak tersedia");
			}
		} while (pilih != 6);
	}
}
