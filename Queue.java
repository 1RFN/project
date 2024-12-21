public class Queue {
    Node front, rear;

    void enqueue(Barang barang) {
        Node newNode = new Node(barang);
        if (rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }
    Barang dequeue() {
        if (front == null) return null;
        Barang barang = front.data;
        front = front.next;
        if (front == null) rear = null;
        return barang;
    }
    void tampilkan() {
        if (front == null) {
            System.out.println("Antrian kosong.");
            return;
        }
        Node temp = front;
        int posisi = 1;
        while (temp != null) {
            System.out.println(posisi + ". " + temp.data.nama + " (ID: " + temp.data.id + ")");
            temp = temp.next;
            posisi++;
        }
    }
    boolean hapus(String idBarang) {
        if (front == null) return false;
        if (front.data.id.equals(idBarang)) {
            front = front.next;
            if (front == null) rear = null;
            return true;
        }
        Node current = front;
        while (current.next != null && !current.next.data.id.equals(idBarang)) {
            current = current.next;
        }
        if (current.next == null) return false;
        current.next = current.next.next;
        if (current.next == null) rear = current;
        return true;
    }
}
