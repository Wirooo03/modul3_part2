import java.util.Scanner;

class NewtonRaphson {

    // Fungsi yang akan dicari akarnya, f(x) = x^2 - 4
    public static double f(double x) {
        return x * x - 4;
    }

    // Turunan dari fungsi f(x), f'(x) = 2x
    public static double df(double x) {
        return 2 * x;
    }

    // Metode Newton-Raphson dengan output tabel
    public static void newtonRaphson(double x0, int maxIter) {
        double tol = 0.00001;
        double x = x0;
        int iter = 0;
        double error = 0;

        // Header tabel
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.printf("%-10s %-15s %-15s %-15s %-15s%n", "Iterasi", "x", "f(x)", "f'(x)", "Error");
        System.out.println("-----------------------------------------------------------------------------------");

        // Proses iterasi Newton-Raphson
        while (iter < maxIter) {
            double fx = f(x);
            double dfx = df(x);
            error = Math.abs(fx);

            // Cetak nilai x, f(x), f'(x), dan error setiap iterasi
            System.out.printf("%-10d %-15.5f %-15.5f %-15.5f %-15.5f%n", iter + 1, x, fx, dfx, error);

            // Jika error sudah lebih kecil dari toleransi, hentikan iterasi
            if (error <= tol) {
                break;
            }

            // Update nilai x dengan rumus Newton-Raphson
            x = x - fx / dfx;

            iter++;
        }

        // Hasil akhir
        if (iter == maxIter) {
            System.out.println("Metode gagal konvergen dalam jumlah iterasi maksimal.");
        } else {
            System.out.println("-----------------------------------------------------------------------------------");
            System.out.printf("Akar persamaan ditemukan pada x = %.5f dengan error = %.5f", x, error);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input tebakan awal, toleransi, dan jumlah iterasi maksimal
        System.out.print("Masukkan tebakan awal: ");
        double x0 = scanner.nextDouble();

        System.out.print("Masukkan jumlah iterasi maksimal: ");
        int maxIter = scanner.nextInt();

        // Hitung akar menggunakan metode Newton-Raphson dan tampilkan tabel
        newtonRaphson(x0, maxIter);

        scanner.close();
    }
}
