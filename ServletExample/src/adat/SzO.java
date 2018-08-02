package adat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletContext;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class SzO {

	private static List<SzenzorAdat> adatok = new ArrayList<SzenzorAdat>();
	private static List<String> sz = new ArrayList<String>();
	private static String list;
	private static Date date;
	private static DateFormat df = new SimpleDateFormat("yyyy.MM.dd. HH:mm:ss");
	private static Document doc;
	private static String t;

	private static ServletContext ctx = null;

	public static void main(String[] args) {

		// !!!! beolvasFilebol("adat.txt");

		// read("proba.txt");
		// write("proba.txt", "2001.06.03.");
		append("proba.txt", "2001.06.03.");
		read("proba.txt");
		
		try {
			// kiirasTeszt(adatok);
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}

		for (int i = 0; i < 4; i++) {

			adatHtmlbe();
			System.out.println("y");
		}
		// InputStream in = ctx.getResourceAsStream("/WEB-INF/uj.txt");

		// sensorDataToHTMLFormat(ctx.getResourceAsStream("/WEB.INF/pr.html"),
		// "probaaa");

		// kiirasFileba();

		// kiirasTeszt(adatok);

	}
	/*
	 * public static void kiirasFileba(List<SzenzorAdat> adatok, HttpServletResponse
	 * response, HttpServletRequest request) throws IOException {
	 */

	public static void kiirasFileba(String[] tomb) {

		// String fileName = "ServletExample\\WebContent\\WEB-INF\\valami.txt";
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter("valami.txt"));

			for (int i = 0; i < tomb.length; i++) {
				writer.write(tomb[i]); // write(tomb[i]);
			}
			/*
			 * writer.write(szenzorAdatH()); writer.write(szenzorAdatP());
			 * writer.write(szenzorAdatSpl());
			 * 
			 * // writer.write(String.szenzorAdatD());
			 */
			System.out.println("Data is written!");
		} catch (IOException ioe) {
			System.err.println(ioe);
		}
		/*
		 * finally { try { writer.close(); } catch (IOException ioe) {
		 * System.err.println(ioe); } }
		 */
	}
	/*
	 * File file = new File("write.txt");
	 * 
	 * try (Writer writer = new BufferedWriter(new FileWriter(file))) { String
	 * contents = "The quick brown fox" + System.getProperty("line.separator") +
	 * "jumps over the lazy dog.";
	 * 
	 * writer.write(contents); } catch (IOException e) { System.err.println(e); //
	 * e.printStackTrace(); } }
	 */
	/*
	 * 
	 * /* PrintWriter out = response.getWriter(); try { File file = new
	 * File("szenzorAdat.txt"); file.createNewFile(); FileOutputStream fout = new
	 * FileOutputStream(file); fout.write( ("Today is: " + new
	 * java.util.Date()).getBytes()); fout.close(); out.println("<html>");
	 * out.println("<head>"); out.println("<title>Servlet TestFile</title>");
	 * out.println("</head>"); out.println("<body>");
	 * out.println("<h1>Servlet TestFile at " + request.getContextPath () +
	 * "</h1>"); out.println("</body>"); out.println("</html>"); } finally {
	 * out.close(); }
	 */

	// try {
	// PrintStream out = new PrintStream(new FileOutputStream("uj.txt"));
	//
	// for (int i = 0; i < adatok.size(); i++) {
	//
	// out.println(adatok.get(i).toString());
	// }
	// out.close();
	// } catch (IOException ioe) {
	// ioe.printStackTrace(System.out);
	// }

	public static void kiirasTeszt(List<String> adatok) {

		for (String sze : sz) {

			System.out.println(sze);
		}
	}

	public static void FileHtmlbe(String docHtml) { // , PrintWriter printWriter) {

		BufferedWriter out = null;

		try {
			FileWriter fstream = new FileWriter("Adatok.html");
			out = new BufferedWriter(fstream);
			out.write(docHtml);
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void read(String fileName) {

		BufferedReader reader = null;
		String s = " ";

		try {
			reader = new BufferedReader(new FileReader(fileName));
			System.out.println("Data from file:");
			s = reader.readLine();
			while (s != null) {
				System.out.println(s);
				s = reader.readLine();
			}
		} catch (IOException ioe) {
			System.err.println(ioe);
		} finally {
			try {
				reader.close();
			} catch (IOException ioe) {
				System.err.println(ioe);
			}
		}
	}

	public static void write (String fileName, String data) {

		BufferedWriter writer = null;

		try {
			writer = new BufferedWriter(new FileWriter(fileName));
			writer.write(data);
			System.out.println("Data is written!");
		} catch (IOException ioe) {
			System.err.println(ioe);
		} finally {
			try {
				writer.close();
			} catch (IOException ioe) {
				System.err.println(ioe);
			}
		}
	}
	
	public static void append(String fileName, String data) {

		BufferedWriter writer = null;

		try {
			writer = new BufferedWriter(new FileWriter(fileName, true));
			writer.newLine();
			writer.write(data);
			System.out.println("Data is appended!");
			// read("proba.txt");
		} catch (IOException ioe) {
			System.err.println(ioe);
		} finally {
			try {
				writer.close();
			} catch (IOException ioe) {
				System.err.println(ioe);
			}
		}
	}

	public static void adatHtmlbe() {

		// "Adatok.html"
		try {
			doc = Jsoup.parse(new File("Adatok.html"), "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		// doc.ht
		// System.out.println("teszt");

		doc.getElementById("tdH").html(P()); // szenzorAdatH());
		System.out.println("jo");

		doc.getElementById("tdP").html("elso"); // szenzorAdatP());
		doc.getElementById("tdSpl").html("ch"); // szenzorAdatSpl());
		doc.getElementById("tdD").html(df.format(date));

		/*
		 * String id = "trH"; if (id.equals("trH")) { for (int i = 0; i < 4; i++) {
		 * 
		 * } }
		 */

		doc.getElementById("trH").html("ch");

		// System.out.println(doc.html());
		FileHtmlbe(doc.html());

	}

	public static String szenzorAdatH() {

		list = "<tr><td>";

		for (int i = 0; i < sz.size(); i++) {

			if (i == 0) {

				list += sz.get(i);
			}
		}

		list += "</td></tr>";

		return list;
	}

	public static String szenzorAdatP() {

		list = "<tr><td>";

		for (int i = 0; i < sz.size(); i++) {

			if (i == 1) {

				list += sz.get(i);
			}
		}

		list = "</tr></td>";

		return list;
	}

	public static String szenzorAdatSpl() {

		list = "<tr><td>";

		for (int i = 0; i < sz.size(); i++) {

			if (i == 2) {

				list += sz.get(i);
			}
		}

		list = "</tr></td>";

		return list;
	}

	public static void fileKiiroTeszt(InputStream inStream) throws IOException {
		if (inStream == null) {
			System.out.println("inStrea is null poiter ");
			return;
		}
		System.out.println("jslkvhkncbcm ");
		Reader in = new BufferedReader(new InputStreamReader(inStream, "UTF-8"));
		System.out.println(in.read());

	}

	public static String sensorDataToHTMLFormat(InputStream iS, String data) {
		try { // "Adatok.html"
			doc = Jsoup.parse(iS, "UTF-8", "/pr.html");

			// System.out.println("teszt");

			doc.getElementById("serverAdat").html(data);

			// FileHtmlbe(doc.html());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return doc.html();
	}

	public static String P() {

		String s = "dvfvc";

		return s;
	}
}
