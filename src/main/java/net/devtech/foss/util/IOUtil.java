package net.devtech.foss.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class IOUtil {
	private static final ThreadLocal<byte[]> BUFFER = ThreadLocal.withInitial(() -> new byte[1024]);
	public static byte[] read(InputStream stream) throws IOException {
		byte[] buffer = BUFFER.get();
		NoCopyBAOS stack = new NoCopyBAOS(Math.max(stream.available(), 32));
		int read;
		while ((read = stream.read(buffer)) != -1)
			stack.write(buffer, 0, read);
		return stack.toByteArray();
	}
}
