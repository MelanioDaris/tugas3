public class Balok extends PersegiPanjang implements Ruang {

    private float tinggi;

    public float getTinggi() {
        return tinggi;
    }

    public void setTinggi(float tinggi) {
        this.tinggi = tinggi;
    }

    public Balok(float panjang, float lebar, float tinggi) {
        super(panjang, lebar);
        this.tinggi = tinggi;
    }

    public Balok(float panjang, float lebar) {
        super(panjang, lebar);
    }

    @Override
    public float volume() {
        return super.luas() * tinggi;
    }

    @Override
    public float luasPermukaan() {
        return 2 * (super.luas() + super.getPanjang() * tinggi + tinggi * super.getLebar());
    }

}
