public class Driver {
    public static void main(String [] args) throws Exception {
        double [] coeffs_1 = {2.0, 3.0, -4.0};
        int [] exp_1 = {0, 1, 3};
        Polynomial p = new Polynomial(coeffs_1, exp_1);

        double [] coeffs_2 = {3.0, 4.0, 2.0};
        int [] exp_2 = {0, 1, 2};
        Polynomial q = new Polynomial(coeffs_2, exp_2);

        Polynomial r = q.add(p);
        double sum = r.evaluate(3);

        System.out.println("The sum is " + sum);     
    }
}