package net.devtech.foss.util;

import org.jetbrains.annotations.NotNull;
import java.io.ByteArrayOutputStream;

public class NoCopyBAOS extends ByteArrayOutputStream {
	public NoCopyBAOS() {
	}

	public NoCopyBAOS(int size) {
		super(size);
	}

	@NotNull
	@Override
	public byte[] toByteArray() {
		return this.buf;
	}
}
