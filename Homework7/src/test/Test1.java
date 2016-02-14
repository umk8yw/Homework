package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class Test1 {

	private static final int SIZE = 1024;
	private static final String FILE_NAME = "simpleFile.txt";

	public static void main(String[] args) throws IOException {

		FileChannel fc = new FileOutputStream(FILE_NAME).getChannel();
		Charset cs = Charset.forName("UTF-8");
		ByteBuffer buffer = cs.encode(CharBuffer.wrap("Content of a simple file. Persnliche Informationen."));
		fc.write(buffer);
		fc.close();

		fc = new FileInputStream(FILE_NAME).getChannel();
		ByteBuffer buff = ByteBuffer.allocate(SIZE);
		fc.read(buff);
		buff.flip();
		while (buff.hasRemaining())
			System.out.print((char) buff.get());
		fc.close();
	}
}
