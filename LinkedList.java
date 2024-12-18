public class LinkedList {
    private Node head;

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

    public void sortById() {
        if (head == null || head.next == null) {
            return;
        }
        boolean swapped;
        do {
            swapped = false;
            Node current = head;
            while (current.next != null) {
                if (current.data.id.compareTo(current.next.data.id) > 0) { 
                    Barang temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
        System.out.println("List berhasil diurutkan berdasarkan ID.");
    }
    
    public Barang binarySearchById(String id) {
       
        sortById();
        int left = 0, right = getSize() - 1;
        Node[] nodes = toArray(); 
        while (left <= right) {
            int mid = (left + right) / 2;
            int compare = nodes[mid].data.id.compareTo(id);
            if (compare == 0) {
                return nodes[mid].data; 
            } else if (compare < 0) {
                left = mid + 1; 
            } else {
                right = mid - 1; 
            }
        }
        return null; 
    }
    
    private Node[] toArray() {
        int size = getSize();
        Node[] array = new Node[size];
        Node current = head;
        for (int i = 0; i < size; i++) {
            array[i] = current;
            current = current.next;
        }
        return array;
    }

    public Barang searchById(String id) {
        Node current = head;
        while (current != null) {
            if (current.data.id.equals(id)) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    public int getSize() {
        int size = 0;
        Node current = head;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }
}
