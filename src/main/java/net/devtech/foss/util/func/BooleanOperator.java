package net.devtech.foss.util.func;

public interface BooleanOperator {
	BooleanOperator AND = (a, b) -> a && b;
	BooleanOperator OR = (a, b) -> a || b;
	BooleanOperator XOR = (a, b) -> a ^ b;

	boolean apply(boolean a, boolean b);

	default BooleanOperator not() {
		return (a, b) -> !this.apply(a, b);
	}
}
