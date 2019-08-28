package com.program.bank;

import java.util.Scanner;

public class Bank {
	Scanner baca = new Scanner(System.in);
	double saldo = 0;
	
	void cekSaldo() {
		System.out.println("Saldo anda saat ini sebesar : Rp " + saldo+ "-,");
	}
	void ambilUang(double am) {
		System.out.println("anda akan mengambil sejumlah : Rp " + am + "-,");
		transaksi(am);
	}
	void tambahUang(double tb) {
		System.out.println("anda akan mengambil sejumlah : Rp " + tb + "-,");
		this.saldo +=tb;
	}
	void transfer() {
		System.out.print("Masukan rekening tujuan : ");
		String no = baca.next();
		System.out.print("Masukan Jumlah kiriman: ");
		int nominal = baca.nextInt();
		System.out.print("Anda akan menstransfer sejumlah " +nominal+ " ke Rekening " +no);
		System.out.print("apakah benar data tsb? (y/n)");
		char l = baca.next().charAt(0);
		if (l == 'y') {
			System.out.println("Transaksi sedang diproses");
			transaksi(nominal);
		} else {
			System.out.println("Transaksi Dibatakan user");
		}
	}
	
	void menuLain() {
		System.out.println("Menu tambahan");
		System.out.println("1. Pulsa");
		System.out.println("2. Listrik");
		System.out.println("3. Pembelian");
		System.out.print("Pilihan Anda : ");
		int masuk = baca.nextInt();
		switch (masuk) {
		case 1 :
			System.out.print("Masukkan no HP     : ");
			String no = baca.next();
			System.out.println("Masukkan Nominal : ");
			int nominal = baca.nextInt();
			String tipe;
			switch (no.substring(0, 3)) {
			case "081":
				tipe = "Telkomsel";
				break;
			case "083":
				tipe = "Axis";
				break;
			case "089":
				tipe = "Three";
			case "085":
				tipe = "Indosat";
				break;
			case "087":
				tipe = "XL";
				break;
			case "088":
				tipe = "Smartfren";
				break;
			default:
				tipe = "tipe tidak tersedia";
			}
			System.out.println("Pengisian untuk no : " +no+ "("+tipe+")" + " Sejumlah " +nominal+ " telah berhasil");
			transaksi(nominal);
			break;
		case 2:
			System.out.println("massukan no pelanggan  : ");
			no = baca.next()	;
			System.out.println("Masukan nominal : ");
			nominal = baca.nextInt();
			System.out.println("Pengisian untuk no : " +no+ " Sejumlah " +nominal+ " telah berhasil");
			transaksi(nominal);
			break;
		case 3:
			System.out.println("Masukan kode pembelian : ");
			no = baca.next();
			if (no.length() > 9) {
				String tr = no.substring(0, 8);
				System.out.println("Pembelian untuk kode " +no+ " Telah berhasil sejumlah Rp " + tr);
				transaksi(Double.parseDouble(tr));
			} else {
				System.out.println("Transaksi dengan kode " +no+ " tidak tersedia \n transaksi dibatalkan");
			}
			break;
			default:
				System.out.println("fitur tidak tersedia");
		}
	}
	
	public double transaksi(double tr) {
		if (this.saldo < tr) {
			System.out.println("Transaksi tidak dapat dilanjutkan \n Uang anda tidak mencukupi untuk transaksi ini \n Sisa saldo anda sebesar Rp " +this.saldo);
			
		} else {
			System.out.println("Transaksi Berhasil");
			return this.saldo -= tr;
			
		}
		return this.saldo;
	}
}
