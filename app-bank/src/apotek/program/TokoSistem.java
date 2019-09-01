package apotek.program;

import java.util.HashMap;

public class TokoSistem {

	private static HashMap <String, String> data = new HashMap<>(); //kode nama barang
	private static HashMap <String, Integer> data2 = new HashMap<>(); //kode harga
	private static HashMap <String, Integer> data3 = new HashMap<>(); //kode jumlah
	private static HashMap <String, Integer> data4 = new HashMap<>(); //data barang keluar
	private long uang; //uang kantor
	private int transaksi; //dartar transaksi
	private int persediaan; //persediaan
	private static final String user = "yuha";
	private static final String password = "123";
	private long pembelian;
	
	TokoSistem() { //construct
		uang = 0;
	}
	
	void resetPembeli() {
		pembelian = 0;
	}
	
	TokoSistem(long uang) {
		this.uang = uang;
	}
	
	void tambahBarang(String nama, String kode, int harga, int jumlah) {
		data.put(kode, nama);
		data2.put(kode, harga);
		data3.put(kode, jumlah);
		persediaan += jumlah;
	} //untuk menambah barang
	
	void beli(String kode, int jumlah) {
		if (data.containsKey(kode)) { //jika data kode yang dicari 
			int sedia = data2.get(kode); //sedia nilai data 3
			if (sedia >= jumlah) { //jika sedia lebih dari pesan
				data3.put(kode, sedia - jumlah);
				this.uang +=(data2.get(kode)*jumlah);
				persediaan -= jumlah; //persedian barang dikurangi
				transaksi++; //transaksi bertambah
				pembelian += data2.get(kode) * jumlah;
				if (data4.containsKey(kode)) { //jika data 4 ada kode
					data4.put(kode, data4.get(kode) + jumlah); //tambah nilai kedata4 (history of product
				} else { //jika data 4 belum ada
					data4.put(kode, jumlah); //tambah data
				}
			} else { //barang ada tapi permintaan terlalu banyak
				System.out.println("Pembelian tidak dapat dilanjutkan \n barang tidak mencukupi");
				
			}
		} else { //barang tidak ada di data
			System.out.println("BARANG TIDAK ADA (transaksi dibatalkan");
		}
		
	} //membeli barang
	
	long total() {//total pembalian
		long pembelian = this.pembelian;
		return pembelian;
	}
	
	void displayBarang() { //cetak data
		if (data.isEmpty()) { //jika data kosong
			System.out.println("-\t-\t\t-\t-"); //cetak tulisan ini
			System.out.println("Barang masih kosong");
			
		} else { //jika tidak maka tampilkan data
			for (String kode : data.keySet()) {
				if (data.get(kode).length() <= 7) {
					System.out.println(kode + "\t" + data.get(kode) + "\t\t" + data3.get(kode) + "\t" + data2.get(kode)); 
				} else {
					System.out.println(kode + "\t" + data.get(kode) + "\t" + data3.get(kode) + "\t" + data2.get(kode));
					
				}
			}
		}
	}
	
	void cekUang() { //cek saldo kasir
		System.out.println("saldo kasir sejumlah : " + this.uang);
		}
	
	void cariBarang(String kode) {
		if (data.containsKey(kode) && data3.get(kode) > 0) {
			System.out.println("Barang dengan kode " + kode + "tersedia");
		} else {
			System.out.println("Barang sedang tidak ada/habis");
		}
	}
	
	void trx() {
		System.out.println("jumlah transaksi hari ini sejumlah" + transaksi);
	}
	
	boolean verif(String usern, String passw) {
		return (usern.equals(this.user) && passw.equals(password));
	}
	void hapusBarang(String kode) {
		if (data.containsKey(kode)) {
			System.out.println("Remove" + data.get(kode) + " berhasil");
			data.remove(kode);
			data2.remove(kode);
			data3.remove(kode);
		} else {
			System.out.println("barang tidak bisa dihapus karena barang tidak ada");
		}
	}
	
	void start() {
		tambahBarang("Mixagrip", "mxg", 2000, 50);
		tambahBarang("Ponstan", "pon", 2500, 60);
		tambahBarang("Panadol", "pan", 3000, 40);
		tambahBarang("Entrostop", "etr", 1500, 40);
		tambahBarang("Decogen", "dcg", 3000, 70);
		tambahBarang("Parasetamol", "prm", 3000, 100);
		tambahBarang("Acyclovir", "acv", 17000, 10);
		tambahBarang("Ibuproven", "ibp", 19000, 120);
		tambahBarang("Oksitosin", "oks", 1700, 30);
		
	}
	
	void barangKeluar() {
		System.out.println("-------------------");
		if (data4.isEmpty()) {
			System.out.println("Belum ada barang keluar hari ini");
		} else {
			System.out.println("Kode\tNama\t\tJumlah");
			for (String kode : data4.keySet()) {
				if (data.get(kode).length() <= 7) {
					System.out.println(kode + "\t" + data.get(kode) + "\t\t" + data4.get(kode)); 
				} else { 
					System.out.println(kode + "\t" + data.get(kode) + "\t" + data4.get(kode));
				}
			}
		}
	}
}
