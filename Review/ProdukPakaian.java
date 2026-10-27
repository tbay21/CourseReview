
public class ProdukPakaian extends Produk {
    private double diskon;

    public ProdukPakaian(String nama, double harga, double diskon) {
        super(nama, harga);
        this.diskon = diskon;
    }

    @Override
    public double hitungHargaAkhir() {
        double diskonAktual = Math.min(diskon, 30);
        return harga - (harga * diskonAktual / 100);
    }

    @Override
    public String getJenis() {
        return "Pakaian";
    }
}
