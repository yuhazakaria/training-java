package bukualamat;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.Set;

public class BookMain {

	static TreeMap <String,Integer> urutan = new TreeMap<>();
	public static void main(String[] args) {
		Scanner baca = new Scanner(System.in);
		try {
			BookSystem bio[] = new BookSystem[50];
			int pilih, x = 0;
			System.out.println("Program Data Buku Alamat");
			do {
				System.out.println("Menu    : \n");
				System.out.println("1. Input Data");
				System.out.println("2. Ubah Data");
				System.out.println("3. Pencarian Data");
				System.out.println("4. Print Data");
				System.out.println("5. EXIT");
				System.out.println("Masukkan Pilihan : ");
				pilih = baca.nextInt();
				switch(pilih) {
				case 1:
					String input ;
					do { 
						System.out.println("INPUT BIODATA");
						System.out.println("Masukkan Nama  : ");
						String n = baca.next();
						System.out.println("Masukkan Alamat : ");
						String a = baca.next();
						System.out.println("Masukkan No.Telp");
						long no = baca.nextLong();
						baca.nextLine();
						System.out.println("Masukkan Email  : ");
						String e = baca.next();
						bio[x]=new biodata(n,a,e,no);
						urutan.put(n.toLowerCase(), x);
						x++;
						System.out.println("Lanjut ? (ya/tidak)");
						input = baca.nextLine().toLowerCase();
					} while (input == "ya");
					break;
				case 2:
					System.out.println("Ubah Data");
					System.out.println("Nama Biodata yang diubah  : ");
					String bi = baca.next().toLowerCase();
					if (urutan.toString().contains(bi)) {
						int no = 0;
						for (String nama:urutan.keySet()) {
							nama = nama.toLowerCase();
							if (nama.contains(bi)) {
								no = urutan.get(nama);
								break;
							}
						}
						System.out.println("Data Ditemukan");
						System.out.println("Masukan Data Baru");
						System.out.println("Nama    : " + bio[no].getNama());
						System.out.print("Alamat  : ");
						bio[no].setAlamat(baca.nextLine());
						System.out.print("No. Telp : ");
						bio[no].setTelepon(baca.nextLong());
						baca.nextLine();
						System.out.print("Email   : ");
						bio[no].setEmail(baca.nextLine());						
					} else {
						System.out.println("Data yang dirubah tidak tersedia");
					}
					break;
				case 3:
					System.out.println("Cari Data");
					System.out.print("Nama Biodata yang dicari  : ");
					String ca = baca.nextLine().toLowerCase();
					if (urutan.toString().contains(ca)) {
						int no = 0;
						for (String nama:urutan.keySet()) {
							nama = nama.toLowerCase();
							if(nama.contains(ca)) {
								no = urutan.get(nama);
								break;
							}
						}
						System.out.println("Data Ditemukan");
						System.out.println("Nama    : " + bio[no].getNama());
						System.out.println("Alamat  : " + bio[no].getAlamat());
						System.out.println("No. Telp : " + bio[no].getTelepon());
						System.out.println("Email   : " + bio[no].getEmail());
					} else {
						System.out.println("Data yang dicari tidak tersedia");
					}
					break;
				case 4:
					System.out.println("Print data");
					System.out.println("---------------");
					if(urutan.isEmpty()==false) {
						for (int no:urutan.values()) {
						System.out.println("Nama     : " + bio[no].getNama());
						System.out.println("Alamat   : " + bio[no].getAlamat());
						System.out.println("No Telp  : " + bio[no].getTelepon());
						System.out.println("Email    : " + bio[no].getEmail());
						System.out.println("---------------------");
						}	
					}else {
						System.out.println("Data masih kosong");
					}
					break;
				case 5:
					break;
					default:
						System.out.println("Palihan tidak tersedia");
				}
			} while (pilih!=5);
		}catch(Exception e) {
			System.out.println("Software mengalami permasalahan dengan inputan anda");
			System.out.println("mohon maaf atas ketidaknyamanan");
			
		}finally {
			System.out.println("Bye..");
		}
	}
}

