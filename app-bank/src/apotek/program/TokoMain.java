package apotek.program;

import java.util.Scanner;

public class TokoMain {
	
	public static void main(String[] args) {
		Scanner baca = new Scanner(System.in);
		System.out.println("SELAMAT DATANG DI APOTEK SEHAT");
		System.out.println("SISTEM MANAJEMEN TERPADU APOTEK");
		System.out.print("Masukan jumlah modal uang di toko (kasir) : ");
		long uang;
		try { //text exception handling
			uang = baca.nextInt();
		} catch (Exception e) { //jika kode diatas error maka akan ditampilkan
			baca.nextLine();
			System.out.println("-------------------");
			System.out.println("system says : masukan salah tidak integer");
			System.out.println("masukkan uang sekali lagi : ");
			baca.nextLine();
			uang = baca.nextInt();
		}
			int pilih = 0;
			boolean verifikasi = false;
			TokoSistem toko = new TokoSistem(uang); //create objek toko
			baca.nextLine();
			toko.start(); //memulai isi data
			do {
				if (verifikasi != true) { //login
					System.out.println("-------------------");
					System.out.println("Login User");
					System.out.println("Masukan Username : ");
					String user = baca.next();
					System.out.println("Masukan Password : ");
					String pass = baca.next();
					verifikasi = toko.verif(user, pass);
					if (verifikasi != true) { //jika login gagal
						System.out.println("System says : password salah");
					} //akhir dari login
				} else { //jika login berhasil
					System.out.println("---------------------------");
					System.out.println("-Daftar Layanan-");
					System.out.println("1.Tambah Barang");
					System.out.println("2.Daftar Barang");
					System.out.println("3.Cari Barang");
					System.out.println("4.Pembelian");
					System.out.println("5.Hapus Barang");
					System.out.println("6.Cek Kas Saldo");
					System.out.println("7.Cek Jumlah Transaksi");
					System.out.println("8.History Barang Keluar");
					System.out.println("0.EXIT");
					System.out.print("Masukkan Piihan : ");	
					try { pilih = baca.nextInt(); //pilihan user
						baca.nextLine();
					} catch (Exception e) { //exception handling salah
						System.out.println("System says : Input salah");
						System.out.println("Ulangi Pilihan");
						System.out.println("Masukkan Pilihan : ");
						pilih = baca.nextInt();
						baca.nextLine();
					}
					
					char lanjut;
					System.out.println("-------------------------");
					switch (pilih) { //switch @nilai dari pilih
					case 1 :
						System.out.println("tambah barang");
						do {
							System.out.print("Masukan kode barang 		: ");
							String kode = baca.next();
							System.out.println("Masukan nama barang		: ");
							String nama = baca.next();
							System.out.println("Masukan harga barang    : ");
							int harga = 0;
							try { //exception handling
								harga = baca.nextInt();
							} catch (Exception e) {
								System.out.println("System says : Inputan tidak valid(ulangi)");
								System.out.println("Masukan harga barang : ");
								baca.nextLine();
							}//akhir exception
							
							System.out.println("Masukan jumlah barang : ");
							int jumlah = 0;
							try { //another exception
								jumlah = baca.nextInt();
								baca.nextLine();
							} catch (Exception e) {
								System.out.println("System says : Inputan tidak valid(ulangi)");
								System.out.println("Masukan harga barang : ");
								baca.nextLine();
							}// end of exception
						toko.tambahBarang(nama, kode, harga, jumlah);
						System.out.println("Lanjut ? (y/n) ");
						try { //another exception (again)
							lanjut = baca.nextLine().toLowerCase().charAt(0);
						} catch (Exception e) {
							System.out.println("System says : Inputan tidak valid");
							System.out.println("Lanjut (y/n) ");
							lanjut = baca.nextLine().toLowerCase().charAt(0);
						} //end of exception (again)
						} while (lanjut == 'y');
						break;
					case 2: //menu daftar barang
						System.out.println("Daftar Barang");
						System.out.println("Kode\tNama\t\tStok\tHarga");
						toko.displayBarang();
						break;
					case 3: //menu cari
						System.out.println("Pencarian Barang");
						System.out.print("Masukkan kode : ");
						String kode = baca.nextLine().toLowerCase();
						toko.cariBarang(kode);
						break;
					case 4: //menu pembelian
						System.out.println("Pembelian Barang");
						do {
							System.out.println("Masukan kode Barang        : ");
							kode = baca.next();
							System.out.println("Masukan jumlah barang      : ");
							int jumlah = baca.nextInt();
							baca.nextLine();
							toko.beli(kode, jumlah);
							System.out.println("Lanjut (y/n) ");
							lanjut = baca.nextLine().toLowerCase().charAt(0);
						} while (lanjut == 'y');
						System.out.println("Total Pembelian anda adalah : Rp." + toko.total());
						break;
					case 5: //hapus barang dari database 
						System.out.println("hapus barang");
						System.out.print("Masukan kode  : ");
						kode = baca.nextLine();
						toko.hapusBarang(kode);
						break;
					case 6: //cek saldo kasir
						System.out.println("Kas saldo Kasir");
						toko.cekUang();
					case 7: //history transaksi
						System.out.println("History Transaksi");
						toko.trx();
					case 8: //info barang keluar
						System.out.println("Data Barang Keluar");
						toko.barangKeluar();
						break;
					case 9:
						break;
						default:
							System.out.println("Menu tidak tersedia");
					}
				}
			}while (pilih != 9);
			System.out.println("System says : Bye Bye ");
			System.out.println("See you");
		
	}
}
