public class Barang {
    String id;
    String nama;
    String kategori;
    int jumlah_stok;
    int harga_satuan;
    String tanggal_diterima;
    
    Barang(String id, String nama, String kategori, int jumlah_stok, int harga_satuan) {
        this.id = id;
        this.nama = nama;
        this.kategori = kategori;
        this.jumlah_stok = jumlah_stok;
        this.harga_satuan = harga_satuan;
        this.tanggal_diterima = tanggal_diterima;
    }
}
