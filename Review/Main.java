
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Produk> daftarProduk = new ArrayList<>();

        int pilihan;

        do {
            System.out.println("\n=== E-COMMERCE SYSTEM ===");
            System.out.println("1. Tambah Produk Elektronik");
            System.out.println("2. Tambah Produk Pakaian");
            System.out.println("3. Tampilkan Semua Produk");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");

            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                case 2:
                    System.out.print("Nama produk: ");
                    String nama = input.nextLine();

                    System.out.print("Harga produk: Rp");
                    double harga = input.nextDouble();

                    System.out.print("Diskon (%): ");
                    double diskon = input.nextDouble();
                    input.nextLine();

                    if (harga <= 0 || diskon < 0 || diskon > 100) {
                        System.out.println(
                            "Harga harus positif dan diskon 0-100."
                        );
                        break;
                    }

                    if (pilihan == 1) {
                        daftarProduk.add(
                            new ProdukElektronik(nama, harga, diskon)
                        );
                    } else {
                        daftarProduk.add(
                            new ProdukPakaian(nama, harga, diskon)
                        );
                    }

                    System.out.println("Produk berhasil ditambahkan.");
                    break;

                case 3:
                    if (daftarProduk.isEmpty()) {
                        System.out.println("Belum ada produk.");
                    } else {
                        System.out.println("\n=== DAFTAR PRODUK ===");

                        for (Produk p : daftarProduk) {
                            System.out.println("Jenis: " + p.getJenis());
                            System.out.println("Nama: " + p.getNama());
                            System.out.printf(
                                "Harga awal: Rp%.2f%n", p.getHarga()
                            );
                            System.out.printf(
                                "Harga akhir: Rp%.2f%n",
                                p.hitungHargaAkhir()
                            );
                            System.out.println("----------------------");
                        }
                    }
                    break;

                case 0:
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }

        } while (pilihan != 0);

        input.close();
    }
}
