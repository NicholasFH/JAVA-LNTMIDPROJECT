import java.util.*;

public class Main {

	Scanner sc = new Scanner(System.in);
	Vector<String> vnamaKar = new Vector<String>();
	Vector<String> vkodeKar = new Vector<String>();
	Vector<String> vgenderKar = new Vector<String>();
	Vector<String> vjabatanKar = new Vector<String>();
	Vector<Integer> vgajiKar = new Vector<Integer>();

	public Main() {

		Integer choice = -1;

		do {
			mainMenu();
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				insertData();
				dataSort();
				break;

			case 2:
				viewData();
				break;

			case 3:
				updateData();
				break;

			case 4:
				deleteData();
				break;
			}

		} while (choice != 5);

	}

	private void deleteData() {

		if (vnamaKar.size() == 0) {
			System.out.println("Tidak ada data yang bisa dihapus, ENTER to return...");
			sc.nextLine();
		}
		int delChoose = -1;
		viewData();

		System.out.print("Input nomor urutan karyawan yang ingin dihapus: ");
		try {
			delChoose = sc.nextInt();
		} catch (Exception err) {
			System.out.println("Masukkan angka!");
		} finally {
			sc.nextLine();
		}

		System.out.println("Karyawan dengan kode " + vkodeKar.get(delChoose - 1) + " berhasil dihapus");

		vnamaKar.remove(delChoose - 1);
		vjabatanKar.remove(delChoose - 1);
		vkodeKar.remove(delChoose - 1);
		vgajiKar.remove(delChoose - 1);
		vgenderKar.remove(delChoose - 1);

		System.out.println("ENTER to return...");
		sc.nextLine();
	}

	private void updateData() {

		if (vnamaKar.size() == 0) {
			System.out.println("Tidak ada data yang bisa diupdate, ENTER to return...");
			sc.nextLine();
		}
		int updChoose = -1;
		viewData();

		System.out.print("Input nomor urutan karyawan yang ingin diupdate: ");
		try {
			updChoose = sc.nextInt();
		} catch (Exception err) {
			System.out.println("Masukkan angka!");
		} finally {
			sc.nextLine();
		}

		String newnamaKar = "";
		String newgenderKar = "";
		String newjabatanKar = "";
		int newgajiKar = -1;
		int bonus = -1;

		do {
			System.out.print("Input nama karyawan: ");
			newnamaKar = sc.nextLine();
		} while (newnamaKar.length() < 3 && !newnamaKar.equals("0"));

		if (!newnamaKar.equals("0")) {
			vnamaKar.set(updChoose - 1, newnamaKar);
		}

		do {
			System.out.print("Masukkan gender karyawan [Laki-Laki | Perempuan] (Case Sensitive): ");
			newgenderKar = sc.nextLine();
		} while (!newgenderKar.equals("Laki-Laki") && !newgenderKar.equals("Perempuan") && !newgenderKar.equals("0"));

		if (!newgenderKar.equals("0")) {
			vgenderKar.set(updChoose - 1, newgenderKar);
		}

		do {
			System.out.print("Masukkan jabatan karyawan [Manager | Supervisor | Admin (Case Sensitive): ");
			newjabatanKar = sc.nextLine();
		} while (!newjabatanKar.equals("Manager") && !newjabatanKar.equals("Supervisor")
				&& !newjabatanKar.equals("Admin") && !newjabatanKar.equals("0"));

		if (newjabatanKar.equals("Manager")) {
			newgajiKar = 8000000;
		}
		if (newjabatanKar.equals("Supervisor")) {
			newgajiKar = 6000000;
		}
		if (newjabatanKar.equals("Admin")) {
			newgajiKar = 4000000;
		}

		if (!newjabatanKar.equals("0")) {
			vjabatanKar.set(updChoose - 1, newjabatanKar);
		}

		System.out.println("Berhasil mengupdate karyawan dengan ID " + vkodeKar.get(updChoose - 1));
		System.out.println("ENTER to return");
		sc.nextLine();
	}

	private void viewData() {
	    if (vnamaKar.isEmpty()) {
	        System.out.println("Tidak ada data yang bisa ditampilkan");
	    } else {
	    	System.out.println("|---------------|----------------------|---------------|---------------|---------------|");
	        System.out.println("| Kode Karyawan | Nama karyawan        | Jenis kelamin | Jabatan       | Gaji karyawan |");
	        System.out.println("|---------------|----------------------|---------------|---------------|---------------|");
	        for (int i = 0; i < vnamaKar.size(); i++) {
	            System.out.printf("| %-13s | %-20s | %-13s | %-13s | %-13d |%n",
	                              vkodeKar.get(i), vnamaKar.get(i), vgenderKar.get(i), vjabatanKar.get(i), vgajiKar.get(i));
	        }
	        System.out.println("|---------------|----------------------|---------------|---------------|---------------|");
	    }
	}



	private void dataSort() {

		for (int i = vnamaKar.size() - 1; i > 1; i--) {
			for (int j = 0; j < i; j++) {
				if ((vnamaKar.get(j).compareTo(vnamaKar.get(j + 1)) > 0)) {

					String tempName = vnamaKar.get(j);
					vnamaKar.set(j, vnamaKar.get(j + 1));
					vnamaKar.set(j + 1, tempName);

					Integer tempGaji = vgajiKar.get(j);
					vgajiKar.set(j, vgajiKar.get(j + 1));
					vgajiKar.set(j + 1, tempGaji);

					String tempJabatan = vjabatanKar.get(j);
					vjabatanKar.set(j, vjabatanKar.get(j + 1));
					vjabatanKar.set(j + 1, tempJabatan);

					String tempGender = vgenderKar.get(j);
					vgenderKar.set(j, vgenderKar.get(j + 1));
					vgenderKar.set(j + 1, tempGender);

					String tempKode = vkodeKar.get(j);
					vkodeKar.set(j, vkodeKar.get(j + 1));
					vkodeKar.set(j + 1, tempKode);

				}
			}
		}

	}

	private void insertData() {

		String num = "0123456789";
		String chara = "ABCDEFGHIJKLMNOPQRSTUVXYZ";
		String namaKar = "";
		String genderKar = "";
		String jabatanKar = "";
		int gajiKar = -1;
		int bonus = -1;

		String kodeKar1 = "" + chara.charAt((int) (Math.random() * chara.length() % chara.length()))
				+ chara.charAt((int) (Math.random() * chara.length() % chara.length()));

		String kodeKar2 = kodeKar1 + "-" + num.charAt((int) (Math.random() * num.length() % num.length()))
				+ num.charAt((int) (Math.random() * num.length() % num.length()))
				+ num.charAt((int) (Math.random() * num.length() % num.length()))
				+ num.charAt((int) (Math.random() * num.length() % num.length()));

		do {
			System.out.print("Input nama karyawan [>=3]: ");
			namaKar = sc.nextLine();
		} while (namaKar.length() < 3);

		do {
			System.out.print("Masukkan gender karyawan [Laki-Laki | Perempuan] (Case Sensitive): ");
			genderKar = sc.nextLine();
		} while (!genderKar.equals("Laki-Laki") && !genderKar.equals("Perempuan"));

		do {
			System.out.print("Masukkan jabatan karyawan [Manager | Supervisor | Admin (Case Sensitive): ");
			jabatanKar = sc.nextLine();
		} while (!jabatanKar.equals("Manager") && !jabatanKar.equals("Supervisor") && !jabatanKar.equals("Admin"));

		if (jabatanKar.equals("Manager")) {
			gajiKar = 8000000;
		}
		if (jabatanKar.equals("Supervisor")) {
			gajiKar = 6000000;
		}
		if (jabatanKar.equals("Admin")) {
			gajiKar = 4000000;
		}

		Map<String, Double[]> job_salary_and_bonus = new HashMap<String, Double[]>();
		job_salary_and_bonus.put("Manager", new Double[] { 8000000d, 10.0d });
		job_salary_and_bonus.put("Supervisor", new Double[] { 6000000d, 7.5d });
		job_salary_and_bonus.put("Admin", new Double[] { 4000000d, 5.0d });

		int karSama = 0;
		Vector<String> kodekarBonus = new Vector<String>();

		for (String work_type : this.vjabatanKar) {
			if (work_type.equals(jabatanKar)) {
				karSama++;
			}
		}

		karSama++; 

		int quotient = (int) Math.floor(karSama / 3);
		int remainder = karSama % 3;

		Double gajiAwal = job_salary_and_bonus.get(jabatanKar)[0];
		Double gajiBonus = job_salary_and_bonus.get(jabatanKar)[1];

		if (remainder == 0 || quotient == 0) {
			gajiBonus = 0.0d;
		} else {
			
			for (int i = 0; i < this.vjabatanKar.size() - remainder + 1; i++) {
				if (this.vjabatanKar.get(i).equals(jabatanKar)) {
					
					kodekarBonus.add(this.vkodeKar.get(i));

					this.vgajiKar.set(i, (int) Math.round(gajiAwal * ((100d + gajiBonus)/100d)));
				}
			}
		}

		System.out.println("Berhasil menambahkan karyawan dengan ID: " + kodeKar2);

		if (!gajiBonus.equals(0.0d)) {
			System.out.printf("Bonus sebesar %.2f%% telah diberikan kepada karyawan dengan ID: %s", gajiBonus,
					kodekarBonus);
		}

		vnamaKar.add(namaKar);
		vkodeKar.add(kodeKar2);
		vgajiKar.add(gajiKar);
		vjabatanKar.add(jabatanKar);
		vgenderKar.add(genderKar);

	}

	private void mainMenu() {

		System.out.println("");

		System.out.println("1. Insert data");
		System.out.println("2. View data karyawan");
		System.out.println("3. Update data karyawan");
		System.out.println("4. Delete data karyawan");
		System.out.print(">> ");

	}

	public static void main(String[] args) {

		new Main();

	}

}