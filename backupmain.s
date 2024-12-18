mport java.util.Scanner;

public class Main {
     static Scanner scanner = new Scanner(System.in);
     static LinkedList barangList = new LinkedList();
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
                    manageBarang();
                    break;
                case 2:
                    lihatBarang();
                    break;
                case 3:
                    pengirimanBarang();
                    break;
                case 4:
                    penerimaanBarang();
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
                    System.out.println("Pilihan tidak valid, coba lagi.");
            }
        }
        
    }
    private static void showMainMenu() {
        System.out.println("===========================");
        System.out.println("        STOCK TRACK");
        System.out.println("===========================");
        System.out.println("1. MANAJEMEN BARANG");
        System.out.println("2. LIHAT DAFTAR BARANG");
        System.out.println("3. PENGIRIMAN BARANG");
        System.out.println("4. PENERIMAAN BARANG");
        System.out.println("5. EXIT");
        System.out.println("===========================");
        System.out.print("Pilih menu: ");
    }

    public static void manageBarang() {
        while (true) {
            System.out.println("\n===========================");
            System.out.println("     MANAJEMEN BARANG");
            System.out.println("===========================");
            System.out.println("1. Tambah Barang");
            System.out.println("2. Edit Barang");
            System.out.println("3. Hapus Barang");
            System.out.println("4. Kembali");
            System.out.println("===========================");
            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            switch (choice) {
                case 1:
                    tambahBarang();
                    break;
                case 2:
                    // editBarang();
                    break;
                case 3:
                    hapusBarang();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Pilihan tidak valid, coba lagi.");
            }
        }
    }

    private static void tambahBarang() {
        System.out.print("Masukkan ID Barang: ");
        String id = scanner.nextLine();
        System.out.print("Masukkan Nama Barang: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Kaetgori Barang: ");
        String kategori = scanner.nextLine();
        System.out.print("Masukkan Stok Barang: ");
        int stok = scanner.nextInt();
        System.out.print("Masukkan Harga Per Unit: ");
        int harga = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Masukkan Tanggal Diterima (yyyy-mm-dd): ");
        String tanggal = scanner.nextLine();

        barangList.tambah(new Barang(id, nama, kategori, stok, harga, tanggal));
        System.out.println("Barang berhasil ditambahkan.");
    }

    // private static void editBarang() {
    //     System.out.print("Masukkan ID Barang yang akan diedit: ");
    //     String id = scanner.nextLine();
    //     System.out.print("Masukkan Nama Barang Baru: ");
    //     String nama = scanner.nextLine();
    //     System.out.print("Masukkan Stok Baru: ");
    //     int stok = scanner.nextInt();
    //     System.out.print("Masukkan Harga Baru: ");
    //     int harga = scanner.nextInt();
    //     scanner.nextLine(); // consume newline
    //     System.out.print("Masukkan Tanggal Diterima Baru: ");
    //     String tanggal = scanner.nextLine();

    //     barangList.update(id, nama, stok, harga, tanggal);
    // }

    private static void hapusBarang() {
        System.out.print("Masukkan ID Barang yang akan dihapus: ");
        String id = scanner.nextLine();
        barangList.hapus(id);
    }

    private static void lihatBarang() {
        System.out.println("\n===========================");
        System.out.println("    LIHAT DAFTAR BARANG");
        System.out.println("===========================");
        barangList.tampilkan();
        System.out.println("===========================");
        System.out.println("1. Sortir Barang");
        System.out.println("2. Cari Barang");
        System.out.println("3. Kembali");
        System.out.println("===========================");
        System.out.print("Pilih menu: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline
        switch (choice) {
            case 1:
            barangList.sortById();
                break;
            case 2:
            cariBarang();
                break;
            case 3:
                return;
            default:
                System.out.println("Pilihan tidak valid, coba lagi.");
        }
    }

    private static void cariBarang() {
        System.out.print("Masukkan ID Barang yang ingin dicari: ");
        String idSearch = scanner.nextLine();
        Barang result = barangList.binarySearchById(idSearch);
        if (result != null) {
            System.out.printf("| %-10s | %-16s | %-10d | %-14d | %-16s |\n",
                    result.id, result.nama, result.jumlah_stok,
                    result.harga_satuan, result.tanggal_diterima);
        } else {
            System.out.println("Barang tidak ditemukan.");
        }
    }

    private static void pengirimanBarang() {
        System.out.println("\n===========================");
        System.out.println("     PENGIRIMAN BARANG");
        System.out.println("===========================");
        // Implementasi pengiriman barang bisa ditambahkan disini.
    }

    private static void penerimaanBarang() {
        System.out.println("\n===========================");
        System.out.println("     PENERIMAAN BARANG");
        System.out.println("===========================");
        // Implementasi penerimaan barang bisa ditambahkan disini.
    }
}