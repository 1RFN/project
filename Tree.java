import java.util.NoSuchElementException;

public class Tree {
    public class Node {
        String kategori;
        LinkedList barangList;
        Node left, right, nextSibling, firstChild;

        Node(String kategori) {
            this.kategori = kategori;
            this.barangList = new LinkedList();
            this.left = this.right = this.nextSibling = this.firstChild = null;
        }
    }
    private Node root;
    
    public Tree (String kategori){
        this.root = new Node (kategori);
    }
    
    public void insertKategori(String parentKategori, String childKategori) {
        Node parentNode = searchKategori(parentKategori);
        if (parentNode == null) {
          System.out.println("Parent Kategori " + parentKategori + " tidak ditemukan!");
          return;
        }
        if (parentNode.firstChild == null) {
            parentNode.firstChild = new Node(childKategori);
        } else {
            Node sibling = parentNode.firstChild;
            while (sibling.nextSibling != null){
                sibling = sibling.nextSibling;
            }
            sibling.nextSibling = new Node(childKategori);
        }
      }
    /*public void insertKategori(String kategori) {
        root = insertKategoriRecursive(root, kategori);
    }

    private Node insertKategoriRecursive(Node root, String kategori) {
        if (root == null) {
            root = new Node(kategori);
            return root;
        }

        if (kategori.compareTo(root.kategori) < 0) {
            root.left = insertKategoriRecursive(root.left, kategori);
        } else if (kategori.compareTo(root.kategori) > 0) {
            root.right = insertKategoriRecursive(root.right, kategori);
        }

        return root;
    }*/
    
    public void tambahBarang(String kategori, Barang barang) {
        Node node = searchKategori(kategori); // Cari kategori berdasarkan nama
        if (node != null) {
            node.barangList.tambah(barang); // Tambahkan barang ke dalam daftar barang
        } else {
            System.out.println("Kategori " + kategori + " tidak ditemukan!");
        }
    }
    

    public Node searchKategori(String kategori) {
        return searchKategoriRecursive(root, kategori);
    }

    private Node searchKategoriRecursive(Node node, String kategori) {
        if (node == null ) {
            return null;
        }
        if (node.kategori.equals(kategori)){
            return node;
        }
        Node found = searchKategoriRecursive(node.firstChild, kategori);
        if (found != null) {
            return found;
        }
        return searchKategoriRecursive(node.nextSibling, kategori);
    }

    public void hapusBarang(String id) {
        hapusBarangRecursive(root, id);
    }

    private void hapusBarangRecursive(Node node, String id) {
        if (node == null) {
            return;
        }
        node.barangList.hapus(id);
        hapusBarangRecursive(node.firstChild, id);
        hapusBarangRecursive(node.nextSibling, id);
    }

    public void updateBarang(String id, String field, Object newValue) {
        updateBarangRecursive(root, id, field, newValue);
    }

    private void updateBarangRecursive(Node node, String id, String field, Object newValue) {
        if (node == null) {
        throw new NoSuchElementException("ID Barang tidak ditemukan.");
        }
        try {
            node.barangList.update(id, field, newValue);
        } catch (NoSuchElementException e) {
            updateBarangRecursive(node.firstChild, id, field, newValue); 
            updateBarangRecursive(node.nextSibling, id, field, newValue);
        }
    }

    public void display() {
        displayRecursive(root);
    }

    private void displayRecursive(Node node) {
        if (node != null) {
            displayRecursive(root.left);
            System.out.println("Kategori: " + node.kategori);
            node.barangList.tampilkan();
            displayRecursive(node.firstChild); 
            displayRecursive(node.nextSibling);
        }
    }

    public void sortBarangInKategori(String kategori, String field) {
        Node node = searchKategori(kategori);
        if (node != null) {
            node.barangList.sort(field);
            System.out.println("Barang dalam kategori " + kategori + " berhasil diurutkan berdasarkan " + field + ".");
        } else {
            System.out.println("Kategori " + kategori + " tidak ditemukan!");
        }
    }

    public Barang cariBarangById(String id) {
        return cariBarangByIdRecursive(root, id);
    }
    
    private Barang cariBarangByIdRecursive(Node node, String id) {
        if (node == null) {
            return null;
        }
    
        Barang found = node.barangList.searchById(id);
        if (found != null) {
            return found;
        }
    
        Barang foundInChild= cariBarangByIdRecursive(node.firstChild, id);
        if (foundInChild != null) {
            return foundInChild;
        }
    
        return cariBarangByIdRecursive(node.nextSibling, id);
    }
}