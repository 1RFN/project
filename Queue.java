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
        Barang barang = front.barang;
        front = front.next;
        if (front == null) rear = null;
        return barang;
    }
}
