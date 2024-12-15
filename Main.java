public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();
        
        Barang barang1 = new Barang("001", "Barang A", "Kategori A", 100, 5000);
        Barang barang2 = new Barang("002", "Barang B", "Kategori B", 50, 7000);
        Barang barang3 = new Barang("003", "Barang C", "Kategori C", 200, 3000);
        
        stack.push(barang1);
        stack.push(barang2);
        stack.push(barang3);
      
        stack.tampilkan();
        
        System.out.println("\nMelakukan pop:");
        Barang barangPopped = stack.pop();
        System.out.println("Barang yang di-pop: ID = " + barangPopped.id + ", Nama = " + barangPopped.nama);
       
        stack.tampilkan();
        
        Barang barang4 = new Barang("004", "Barang D", "Kategori D", 80, 6000);
        stack.push(barang4);
        
        System.out.println("\nMenambahkan barang ke-4 dan menampilkan stack:");
        stack.tampilkan();
    }
}
