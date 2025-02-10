package lambda;

//함수형 인터페이스라고 명시함
@FunctionalInterface
public interface IntBinaryOperation {
    int apply(int a, int b);
}
