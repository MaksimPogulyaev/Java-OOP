public class ConcreteFactory implements ComplexAbstractFactory {

    @Override
    public Complex createComplex() {
        Complex obj1 = new Complex();
        return obj1;
    }

    @Override
    public Complex CreateComplex(int real, int image) {
        Complex obj2 = new Complex(real, image);
        return obj2;
    }
}