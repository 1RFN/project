public class Stack {
    private Node top;
    
    private class Node{
        Barang data;
        Node next;

        Node(Barang data){
            this.data = data;
            this.next = null;
        }
    }

    public Stack(){
        top = null;
    }

    public void push(Barang barang){
        Node newNode = new Node(barang);
        if(top == null){
            top = newNode;
        }else{
            newNode.next = top;
            top = newNode;
        }
    }

    public Barang pop(){
        if(top == null){
            System.out.println("Stack kosong, tidak ada barang yang dikeluarkan");
            return null;
        }
        Barang barang = top.data;
        top = top.next;
        return barang;
    }

    public Barang peek(){
        if(top == null){
            System.out.println("Stack kosong, tidak ada barang untuk dilihat");
            return null;
        }
        return top.data;
    }

    public void tampilkan(){
        if(top == null){
            System.out.println("Kosong");
            return;
        }
        Node current = top;
        System.out.println("Riwayat Pengiriman atau Penerimaan Barang ");
        while(current != null){
            System.out.println("ID: " + current.data.id + ", nama: " + current.data.nama + 
            ", kategori: " + current.data.kategori + 
            ", jumlah stok: " + current.data.jumlah_stok +
            ", Harga Satuan: " + current.data.harga_satuan);
            current = current.next;          
        }
    }
} 

