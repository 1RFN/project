public class LinkedList {
    private Node head;

    private class Node {
        Barang data;
        Node next;

        Node(Barang data) {
            this.data = data;
            this.next = null;
        }
    }

    public void tambah(Barang barang) {
        Node newNode = new Node(barang);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void hapus(String id) {
        if (head == null) {
            return;
        }
        if (head.data.id.equals(id)) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.data.id.equals(id)) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }
    public void terima(Barang barang) {
        Node current = head;
        while (current != null) {
            if (current.data.id.equals(barang.id)) {
                current.data.jumlah_stok += barang.jumlah_stok;
                return;
            }
            current = current.next;
        }
        tambah(barang);
    }

    public void tampilkan() {
        Node current = head;
        while (current != null) {
            System.out.println("ID: " + current.data.id + ", Nama: " + current.data.nama + 
                               ", Kategori: " + current.data.kategori + 
                               ", Jumlah Stok: " + current.data.jumlah_stok + 
                               ", Harga Satuan: " + current.data.harga_satuan);
            current = current.next;
        }
    }
}
