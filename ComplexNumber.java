public class ComplexNumber {
    private double real;
    private double complex;

    public ComplexNumber(double real, double complex) {
        this.real = real;
        this.complex = complex;
    }

    @Override
    public String toString() {
        return real + " + " + complex + "i";
    }

    public ComplexNumber add(ComplexNumber other) {
        double newReal = this.real + other.real;
        double newComplex = this.complex + other.complex;
        System.out.println(new ComplexNumber(newReal, newComplex));
        return new ComplexNumber(newReal, newComplex);
    }

    public ComplexNumber subtract(ComplexNumber other) {
        double newReal = this.real - other.real;
        double newComplex = this.complex - other.complex;
        System.out.println(new ComplexNumber(newReal, newComplex));
        return new ComplexNumber(newReal, newComplex);
    }

    public ComplexNumber multiply(ComplexNumber other) {
        double newReal = (this.real * other.real) - (this.complex * other.complex);
        double newComplex = (this.real * other.complex) + (this.complex * other.real);
        System.out.println(new ComplexNumber(newReal, newComplex));
        return new ComplexNumber(newReal, newComplex);
    }

    public ComplexNumber division(ComplexNumber other) {
        double denominator = (other.real * other.real) + (other.complex * other.complex);
        // System.out.println(denominator);
        double newReal = ((this.real * other.real) + (this.complex * other.complex))/denominator;
        double newComplex = ((this.complex * other.real) - (this.real * other.complex))/denominator;
        System.out.println(new ComplexNumber(newReal, newComplex));
        return new ComplexNumber(newReal, newComplex);
    }
}
