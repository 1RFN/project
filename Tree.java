import java.util.NoSuchElementException;

public class Tree {
    public class Node {
        String kategori;
        LinkedList barangList;
        Node left, right;

        Node(String kategori) {
            this.kategori = kategori;
            this.barangList = new LinkedList();
            this.left = this.right = null;
        }
    }

    private Node root;

    public void insertKategori(String kategori) {
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
    }
    
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

    private Node searchKategoriRecursive(Node root, String kategori) {
        if (root == null || root.kategori.equals(kategori)) {
            return root;
        }
        if (kategori.compareTo(root.kategori) < 0) {
            return searchKategoriRecursive(root.left, kategori);
        }
        return searchKategoriRecursive(root.right, kategori);
    }

    public void hapusBarang(String id) {
        hapusBarangRecursive(root, id);
    }

    private void hapusBarangRecursive(Node root, String id) {
        if (root == null) {
            return;
        }
        root.barangList.hapus(id);
        hapusBarangRecursive(root.left, id);
        hapusBarangRecursive(root.right, id);
    }

    public void updateBarang(String id, String field, Object newValue) {
        updateBarangRecursive(root, id, field, newValue);
    }

    private void updateBarangRecursive(Node root, String id, String field, Object newValue) {
        if (root == null) {
        throw new NoSuchElementException("ID Barang tidak ditemukan.");
        }
        try {
        root.barangList.update(id, field, newValue);
        } catch (NoSuchElementException e) {
            if (root.left != null) {
            updateBarangRecursive(root.left, id, field, newValue);
            }
            if (root.right != null) {
            updateBarangRecursive(root.right, id, field, newValue);
            }
        }
    }

    public void display() {
        displayRecursive(root);
    }

    private void displayRecursive(Node root) {
        if (root != null) {
            displayRecursive(root.left);
            System.out.println("Kategori: " + root.kategori);
            root.barangList.tampilkan();
            displayRecursive(root.right);
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
    
    private Barang cariBarangByIdRecursive(Node root, String id) {
        if (root == null) {
            return null;
        }
    
        Barang found = root.barangList.searchById(id);
        if (found != null) {
            return found;
        }
    
        found = cariBarangByIdRecursive(root.left, id);
        if (found != null) {
            return found;
        }
    
        return cariBarangByIdRecursive(root.right, id);
    }
}