import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static LinkedList barangList = new LinkedList();
    static Stack riwayatStack = new Stack();
    static Tree tree = new Tree();
    static Queue pengirimanQueue = new Queue();
    public static void main(String[] args) {
       

        tree.insertKategori("Elektronik");
        tree.insertKategori("Furniture");
        tree.insertKategori("Alat Tulis");
        tree.insertKategori("Aksesoris");
        
        /* 
        barangList.tambah(new Barang("A001", "Laptop", "Elektronik", 10, 7000000, "2024-12-01"));
        barangList.tambah(new Barang("B002", "Meja Kantor", "Furniture", 5, 1500000, "2024-12-01"));
        barangList.tambah(new Barang("C003", "Buku Tulis", "Alat Tulis", 50, 8000, "2024-12-01"));
        barangList.tambah(new Barang("A004", "Kipas Angin", "Elektronik", 8, 250000, "2024-12-01"));
        barangList.tambah(new Barang("A005", "Printer", "Elektronik", 7, 1200000, "2024-12-01"));
        barangList.tambah(new Barang("D006", "Mouse", "Aksesoris", 25, 150000, "2024-12-01"));
        barangList.tambah(new Barang("D007", "Tas Laptop", "Aksesoris", 15, 200000, "2024-12-01"));2
        barangList.tambah(new Barang("C008", "Whiteboard", "Alat Tulis", 3, 350000, "2024-12-01"));
        barangList.tambah(new Barang("A009", "Kabel HDMI", "Elektronik", 20, 75000, "2024-12-01"));
        barangList.tambah(new Barang("D010", "Headset", "Aksesoris", 12, 300000, "2024-12-01"));
        */
        tree.tambahBarang("Elektronik", new Barang("A001", "Laptop", "Elektronik", 10, 7000000, "2024-12-01"));
        tree.tambahBarang("Furniture", new Barang("B002", "Meja Kantor", "Furniture", 5, 1500000, "2024-12-01"));
        tree.tambahBarang("Aksesoris", new Barang("D006", "Mouse", "Aksesoris", 25, 150000, "2024-12-01"));
        tree.tambahBarang("Elektronik", new Barang("A004", "Kipas Angin", "Elektronik", 8, 250000, "2024-12-01"));
        tree.tambahBarang("Elektronik", new Barang("A005", "Printer", "Elektronik", 7, 1200000, "2024-12-01"));
        tree.tambahBarang("Aksesoris", new Barang("D007", "Tas Laptop", "Aksesoris", 15, 200000, "2024-12-01"));
        tree.tambahBarang("Alat Tulis", new Barang("C003", "Buku Tulis", "Alat Tulis", 50, 8000, "2024-12-01"));
        tree.tambahBarang("Alat Tulis", new Barang("C008", "Whiteboard", "Alat Tulis", 3, 350000, "2024-12-01"));
        tree.tambahBarang("Elektronik", new Barang("A009", "Kabel HDMI", "Elektronik", 20, 75000, "2024-12-01"));
        tree.tambahBarang("Aksesoris", new Barang("D010", "Headset", "Aksesoris", 12, 300000, "2024-12-01"));
        
        while (true) {
            showMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            switch (choice) {
                case 1:
                    manageBarang();
                    break;
                case 2:
                    lihatBarang();
                    break;
                case 3:
                    pengirimanBarang();
                    break;
                // case 4:
                //     penerimaanBarang();
                //     break;
                case 4:
                    System.out.println("Terima kasih! Anda telah keluar.");
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
//        System.out.println("4. PENERIMAAN BARANG");
        System.out.println("4. EXIT");
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
                    editBarang();
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
        System.out.print("Masukkan Kategori Barang: ");
        String kategori = scanner.nextLine();
        System.out.print("Masukkan Stok Barang: ");
        int stok = scanner.nextInt();
        System.out.print("Masukkan Harga Per Unit: ");
        int harga = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Masukkan Tanggal Diterima (yyyy-mm-dd): ");
        String tanggal = scanner.nextLine();

        Barang barang = new Barang(id, nama, kategori, stok, harga, tanggal);

        // barangList.tambah(barang);
        tree.tambahBarang(kategori, barang);
        System.out.println("Barang berhasil ditambahkan.");
    }
    
    private static void editBarang() {
        System.out.print("Masukkan ID Barang yang akan diedit: ");
        String id = scanner.nextLine();
    
        System.out.print("Masukkan Field yang akan diedit (nama, stok, tanggal): ");
        String field = scanner.nextLine();
    
        Object newValue;
        switch (field.toLowerCase()) {
            case "nama":
                System.out.print("Masukkan Nama Barang Baru: ");
                newValue = scanner.nextLine();
                break;
            case "stok":
                System.out.print("Masukkan Stok Baru: ");
                newValue = scanner.nextInt();
                scanner.nextLine(); 
                break;
            case "tanggal":
                System.out.print("Masukkan Tanggal Diterima Baru: ");
                newValue = scanner.nextLine();
                break;
            default:
                System.out.println("Field tidak valid. Silakan coba lagi.");
                return;
        }
        try {
            tree.updateBarang(id, field, newValue);
            System.out.println("Barang berhasil diperbarui.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NoSuchElementException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void hapusBarang() {
        System.out.print("Masukkan ID Barang yang akan dihapus: ");
        String id = scanner.nextLine();
        tree.hapusBarang(id);
    }

    private static void lihatBarang() {
        while (true) {
            System.out.println("\n===========================");
            System.out.println("    LIHAT DAFTAR BARANG");
            System.out.println("===========================");
            tree.display();
            System.out.println("===========================");
            System.out.println("1. Sortir Barang");
            System.out.println("2. Cari Barang");
            System.out.println("3. Kembali");
            System.out.println("===========================");
            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                sortBarang();
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
        
    }

    public static void sortBarang() {
        System.out.print("Masukkan Kategori yang akan diurutkan: ");
        String kategori = scanner.nextLine();
    
        System.out.print("Masukkan Field yang akan diurutkan (nama, stok, tanggal): ");
        String field = scanner.nextLine();
    
        try {
            tree.sortBarangInKategori(kategori, field);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void cariBarang() {
        System.out.print("Masukkan ID Barang yang ingin dicari: ");
        String idSearch = scanner.nextLine();
        Barang result = tree.cariBarangById(idSearch); // Gunakan tree untuk mencari barang
        if (result != null) {
            System.out.printf("+------------+------------------+------------+----------------+------------------+\n");
            System.out.printf("| ID Barang | Nama Barang      | Stok Barang | Harga Per Unit | Tanggal Diterima |\n");
            System.out.printf("+------------+------------------+------------+----------------+------------------+\n");
            System.out.printf("| %-10s | %-16s | %-10d | %-14d | %-16s |\n",
                    result.id, result.nama, result.jumlah_stok,
                    result.harga_satuan, result.tanggal_diterima);
        } else {
            System.out.println("Barang tidak ditemukan.");
        }
    }

    private static void pengirimanBarang() {
        while (true) {
            System.out.println("\n===========================");
            System.out.println("     PENGIRIMAN BARANG");
            System.out.println("===========================");
            System.out.println("1. Tambah ke Antrian Pengiriman");
            System.out.println("2. Proses Pengiriman Barang");
            System.out.println("3. Riwayat Pengiriman Barang");
            System.out.println("4. Tampilkan Daftar Barang");
            System.out.println("5. Hapus Barang dari Antrian");
            System.out.println("6. Kembali");
            System.out.println("===========================");
            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            switch (choice) {
                case 1:
                System.out.print("Masukkan kategori barang: ");
                String kategori = scanner.nextLine();
                Tree.Node kategoriNode = tree.searchKategori(kategori);
                
                if (kategoriNode != null) {
                    System.out.print("Masukkan ID Barang yang akan dikirim: ");
                    String idBarang = scanner.nextLine();
                    Barang barang = kategoriNode.barangList.searchById(idBarang);
                    if (barang != null) {
                        pengirimanQueue.enqueue(barang); // Tambahkan barang ke antrian pengiriman
                        System.out.println("Barang " + barang.nama + " berhasil ditambahkan ke antrian pengiriman.");
                    } else {
                        System.out.println("Barang dengan ID " + idBarang + " tidak ditemukan dalam kategori " + kategori + ".");
                    }
                } else {
                    System.out.println("Kategori " + kategori + " tidak ditemukan!");
                }
                    break;
                case 2:
                    Barang barangDikirim = pengirimanQueue.dequeue();

                    if (barangDikirim != null) {
                        System.out.print("Masukkan jumlah barang yang dikirim: ");
                        int jumlah = scanner.nextInt();
                        scanner.nextLine(); // consume newline
                        if (barangDikirim.jumlah_stok >= jumlah) {
                            barangDikirim.jumlah_stok -= jumlah;
                            riwayatStack.push(new Barang(
                                barangDikirim.id,
                                barangDikirim.nama,
                                barangDikirim.kategori,
                                jumlah,
                                barangDikirim.harga_satuan,
                                ""
                            ));
                            System.out.println("Barang " + barangDikirim.nama + " sejumlah " + jumlah + " berhasil dikirim.");
                        } else {
                            System.out.println("Stok barang tidak mencukupi. Stok saat ini: " + barangDikirim.jumlah_stok);
                        }
                    } else {
                        System.out.println("Antrian pengiriman kosong.");
                    }
                    break;
                case 3:
                    System.out.println("Riwayat Pengiriman:");
                    riwayatStack.tampilkan();
                    break;
                case 4:
                    tampilkanAntrian();
                    break;
                case 5:
                    hapusDariAntrian();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Pilihan tidak valid, coba lagi.");
            }
        }
    }
    private static void tampilkanAntrian() {
        System.out.println("Daftar Antrian Pengiriman:");
        pengirimanQueue.tampilkan();
    }

    private static void hapusDariAntrian() {
        System.out.print("Masukkan ID Barang yang ingin dihapus dari antrian: ");
        String idBarang = scanner.nextLine();
    
        boolean success = pengirimanQueue.hapus(idBarang);
    
        if (success) {
            System.out.println("Barang dengan ID " + idBarang + " berhasil dihapus dari antrian.");
        } else {
            System.out.println("Barang dengan ID " + idBarang + " tidak ditemukan dalam antrian.");
        }
    }
    /* 
    private static void pengirimanBarang() {
        while (true) { 
            System.out.println("\n===========================");
            System.out.println("     PENGIRIMAN BARANG");
            System.out.println("===========================");
            System.out.println("===========================");
            System.out.println("1. Buat Pengiriman Barang");
            System.out.println("2. Riwayat Pengirirman Barang");
            // System.out.println("3. Cari Pengiriman Berdasarkan ID");
            System.out.println("3. Kembali");
            System.out.println("===========================");
            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            switch (choice) {
                case 1:
                System.out.print("Masukkan ID Barang yang dikirim: ");
                String idKirim = scanner.nextLine();
                Barang barangKirim = barangList.searchById(idKirim);
                if (barangKirim != null) {
                    System.out.print("Masukkan jumlah barang yang dikirim: ");
                    int jumlahKirim = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    tree.enqueue(barangKirim);

                    if (barangKirim.jumlah_stok >= jumlahKirim) {
                        barangKirim.jumlah_stok -= jumlahKirim; // Kurangi stok
                        riwayatStack.push(new Barang(barangKirim.id, barangKirim.nama, barangKirim.kategori, jumlahKirim, barangKirim.harga_satuan, ""));
                        System.out.println("Barang " + barangKirim.nama + " sejumlah " + jumlahKirim + " berhasil dikirim.");
                    } else {
                        System.out.println("Stok tidak mencukupi. Stok tersedia: " + barangKirim.jumlah_stok);
                    }
                } else {
                    System.out.println("Barang dengan ID " + idKirim + " tidak ditemukan.");
                }
                tree.dequeue(barangkirim;)
                break;
                case 2:
                riwayatStack.tampilkan();
                    break;
                case 3:
                    return;
                case 4:
                    return; 
                default:
                    System.out.println("Pilihan tidak valid, coba lagi.");
            }
        }
       
        
    }
    */

//    private static void penerimaanBarang() {
//          while (true) {
//             System.out.println("\n===========================");
//             System.out.println("     PENERIMAAN BARANG");
//             System.out.println("===========================");
//             System.out.println("===========================");
//             System.out.println("1. Tambah Barang Masuk");
//             System.out.println("2. Riwayat penerimaan Barang");
//             System.out.println("3. Kembali");
//             System.out.println("===========================");
//             System.out.print("Pilih menu: ");
//             int choice = scanner.nextInt();
//             scanner.nextLine(); 
//             switch (choice) {
//                 case 1:
//                     tambahBarang();
//                     break;
//                 case 2:
//                     break;
//                 case 3:
//                     return;
//                 default:
//                     System.out.println("Pilihan tidak valid, coba lagi.");
//             }
//         }
       
//     }
}

