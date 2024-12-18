import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList list = new LinkedList();
        Stack riwayatStack = new Stack();
        Tree tree = new Tree();

        tree.insertKategori("Elektronik");
        tree.insertKategori("Furniture");
        tree.insertKategori("Alat Tulis");
        tree.insertKategori("Aksesoris");

        list.tambah(new Barang("B001", "Laptop", "Elektronik", 10, 7000000));
        list.tambah(new Barang("B002", "Meja Kantor", "Furniture", 5, 1500000));
        list.tambah(new Barang("B003", "Buku Tulis", "Alat Tulis", 50, 8000));
        list.tambah(new Barang("B004", "Kipas Angin", "Elektronik", 8, 250000));
        list.tambah(new Barang("B005", "Printer", "Elektronik", 7, 1200000));
        list.tambah(new Barang("B006", "Mouse", "Aksesoris", 25, 150000));
        list.tambah(new Barang("B007", "Tas Laptop", "Aksesoris", 15, 200000));
        list.tambah(new Barang("B008", "Whiteboard", "Alat Tulis", 3, 350000));
        list.tambah(new Barang("B009", "Kabel HDMI", "Elektronik", 20, 75000));
        list.tambah(new Barang("B010", "Headset", "Aksesoris", 12, 300000));

        while (true) {
            System.out.println("\n=== Menu Utama ===");
            System.out.println("1. Tambah Barang");
            System.out.println("2. Hapus Barang");
            System.out.println("3. Lihat Barang");
            System.out.println("4. Cari Barang");
            System.out.println("5. Sortir Barang");
            System.out.println("6. Pengiriman Barang");
            System.out.println("7. Penerimaan Barang");
            System.out.println("8. Lihat Riwayat");
            System.out.println("9. Keluar");
            System.out.print("Pilih opsi: ");
            
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan ID Barang: ");
                    String id = scanner.nextLine();
                    System.out.print("Masukkan Nama Barang: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan Kategori Barang: ");
                    String kategori = scanner.nextLine();
                    System.out.print("Masukkan Jumlah Stok: ");
                    int jumlahStok = scanner.nextInt();
                    System.out.print("Masukkan Harga Satuan: ");
                    int hargaSatuan = scanner.nextInt();
                    scanner.nextLine(); // Membersihkan newline

                    Barang barangBaru = new Barang(id, nama, kategori, jumlahStok, hargaSatuan);
                    list.tambah(barangBaru);
                    System.out.println("Barang berhasil ditambahkan!");
                    break;

                case 2:
                    System.out.print("Masukkan ID Barang yang ingin dihapus: ");
                    String idHapus = scanner.nextLine();
                    list.hapus(idHapus);
                    System.out.println("Barang berhasil dihapus (jika ditemukan)!");
                    break;

                case 3:
                    System.out.println("\n=== Daftar Barang ===");
                    list.tampilkan();
                    break;

                case 4:
                    System.out.print("Masukkan ID Barang yang ingin dicari: ");
                    String idSearch = scanner.nextLine();
                    Barang result = list.binarySearchById(idSearch);
                    if (result != null) {
                        System.out.println("Barang ditemukan: ID = " + result.id + ", Nama = " + result.nama);
                    } else {
                        System.out.println("Barang tidak ditemukan.");
                    }
                    break;
                
                case 5:
                    list.sortById();
                    break; 
            
                case 6: 
                    System.out.print("Masukkan ID Barang yang dikirim: ");
                    String idKirim = scanner.nextLine();
                    Barang barangKirim = list.searchById(idKirim);
                    if (barangKirim != null && barangKirim.jumlah_stok > 0) {
                        barangKirim.jumlah_stok--; 
                        riwayatStack.push(barangKirim); 
                        System.out.println("Barang " + barangKirim.nama + " berhasil dikirim.");
                    } else {
                        System.out.println("Barang tidak tersedia atau stok tidak cukup.");
                    }
                    break;

                case 7: 
                    System.out.print("Masukkan ID Barang yang diterima: ");
                    String idTerima = scanner.nextLine();
                    Barang barangTerima = list.searchById(idTerima);
                    if (barangTerima != null) {
                        barangTerima.jumlah_stok++; 
                        riwayatStack.push(barangTerima); 
                        System.out.println("Barang " + barangTerima.nama + " berhasil diterima.");
                    } else {
                        System.out.println("Barang tidak ditemukan.");
                    }
                    break;

                case 8: 
                    riwayatStack.tampilkan();
                    break;

                case 9:
                    System.out.println("Keluar dari program. Terima kasih!");
                    scanner.close();
                    return;
                                
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }
}
