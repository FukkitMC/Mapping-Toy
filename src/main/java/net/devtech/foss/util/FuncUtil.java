package net.devtech.foss.util;

import net.devtech.foss.util.func.BooleanOperator;
import org.jetbrains.annotations.Nullable;
import java.util.Objects;

public class FuncUtil {
	public static <T> boolean equals(BooleanOperator operator, @Nullable T... objects) {
		boolean val = false;
		assert objects != null : "Array cannot be null";
		for (int i = 0; i < objects.length - 1; i++) {
			boolean value = Objects.equals(objects[i], objects[i + 1]);
			val = i != 0 ? operator.apply(val, value) : value;
		}
		return val;
	}

	public static <T> boolean equalsOne(BooleanOperator operator, T obj, T... objects) {
		boolean val = false;
		assert objects != null : "Array cannot be null";
		for (int i = 0; i < objects.length; i++) {
			boolean value = Objects.equals(objects[i], obj);
			val = i != 0 ? operator.apply(val, value) : value;
		}
		return val;
	}
}
