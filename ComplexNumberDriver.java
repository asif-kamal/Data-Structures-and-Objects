public class ComplexNumberDriver {
    public static void main(String[] args) {

        ComplexNumber c1 = new ComplexNumber(20, -4);
        ComplexNumber c2 = new ComplexNumber(3, 2);

        c1.add(c2);
        c1.subtract(c2);

        c1.multiply(c2);
        c1.division(c2);
    }

}
