package com.program.bank;

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
			pilih = baca.nextInt();
			System.out.println("------------------------");
		}
	}
}
