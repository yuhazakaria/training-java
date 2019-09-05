package bukualamat;

public class BookSystem {
	private String nama, alamat, email;
	private long telepon;
	BookSystem(){
		nama="Tidak didefini";
		alamat="Tidak didefinisi";
		email="Tidak didefinisi";
		telepon=0;
	}
	
	BookSystem(String nama, String alamat, String email, long telepon){
		this.nama = nama;
		this.alamat = alamat;
		setEmail(email);
		this.telepon = telepon;
	}
	void setNama(String nama) {
		this.nama = nama;
	}
	void setEmail(String email) {
		if (email.contains("@") && email.contains(".")) {
			this.email = email;			
		} else {
			System.out.println("Email Tidak Valid");
		}
	}
	void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	void setTelepon(long telepon) {
		this.telepon = telepon;
	}
	
	String getNama() {
		return nama;
	}
	String getAlamat() {
		return alamat;
	}
	long getTelepon() {
		return telepon;
	}
	String getEmail() {
		return email;
	}
}
