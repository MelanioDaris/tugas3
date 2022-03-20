import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame f = new JFrame();

        JLabel lJudul = new JLabel("Masukkan Detail Balok");
        lJudul.setBounds(10, 0, 150, 20);
        f.add(lJudul);

        JLabel lPanjang = new JLabel("Panjang");
        lPanjang.setBounds(10, 25, 150, 20);
        f.add(lPanjang);

        JTextField tfPanjang = new JTextField();
        tfPanjang.setBounds(10, 50, 150, 20);
        f.add(tfPanjang);

        JLabel lLebar = new JLabel("Lebar");
        lLebar.setBounds(10, 75, 150, 20);
        f.add(lLebar);

        JTextField tfLebar = new JTextField();
        tfLebar.setBounds(10, 100, 150, 20);
        f.add(tfLebar);

        JLabel lTinggi = new JLabel("Tinggi");
        lTinggi.setBounds(10, 125, 150, 20);
        f.add(lTinggi);

        JTextField tfTinggi = new JTextField();
        tfTinggi.setBounds(10, 150, 150, 20);
        f.add(tfTinggi);

        JButton bHitung = new JButton("Hitung");
        bHitung.setBounds(10, 175, 150, 20);
        f.add(bHitung);

        JButton bReset = new JButton("Reset");
        bReset.setBounds(10, 200, 150, 20);
        f.add(bReset);

        JLabel lHasil = new JLabel("Hasil");
        lHasil.setBounds(10, 225, 150, 20);
        f.add(lHasil);

        JTextArea taHasil = new JTextArea();
        taHasil.setEditable(false);
        taHasil.setBounds(10, 250, 150, 150);
        taHasil.setLineWrap(true);
        f.add(taHasil);

        bHitung.addActionListener((e) -> {
            try {
                if (tfPanjang.getText().equals("") || tfLebar.getText().equals("") || tfTinggi.getText().equals("")) {
                    throw new Exception("Perhitungan tidak dapat dilakukan, terdapat input kosong.");
                }

                float panjang = Float.parseFloat(tfPanjang.getText());
                float lebar = Float.parseFloat(tfLebar.getText());
                float tinggi = Float.parseFloat(tfTinggi.getText());

                Balok balok = new Balok(panjang, lebar, tinggi);

                String text = "Luas Persegi Panjang Alas: " + balok.luas() + "\nKeliling Persegi Panjang Alas: "
                        + balok.keliling() + "\nLuas Permukaan Balok: " + balok.luasPermukaan() + "\nVolume Balok: "
                        + balok.volume();
                taHasil.setText(text);
            } catch (NumberFormatException exc) {
                taHasil.setText("Perhitungan tidak dapat dilakukan, terdapat input yang bukan bilangan.");
            } catch (Exception exc) {
                taHasil.setText(exc.getMessage());
            }
        });

        bReset.addActionListener((e) -> {
            tfPanjang.setText(null);
            tfLebar.setText(null);
            tfTinggi.setText(null);
            taHasil.setText(null);
        });

        f.setSize(190, 450);
        f.setLayout(null);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
