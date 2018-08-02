package ait.org;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adat.SzenzorAdat;
import adat.SzO;

@WebServlet("/ESPServlet")
public class ESPServlet extends HttpServlet {

	private static List<SzenzorAdat> senzorAdatok = new ArrayList<SzenzorAdat>();
	private Date date = new Date();
	private static DateFormat df = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
	private ServletContext ctx = null;

	private static final long serialVersionUID = 1L;

	public ESPServlet() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {

		super.init(config);
		ctx = config.getServletContext();
		System.out.println(df.format(date));
	}

	// JOOOOOO!!!!
	protected void doGet (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		try {
		      FileInputStream fis =
		        new FileInputStream(request.getRealPath("/uj.txt"));
		      InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
		      BufferedReader reader = new BufferedReader(isr);
		      String line = null;
		      
		      String eleje = "<!DOCTYPE html>\r\n" + 
		      		"<html>\r\n" + 
		      		"<head>\r\n" + 
		      		"<meta charset=\"UTF-8\">\r\n" + 
		      		"<title>Insert title here</title>\r\n" + 
		      		"</head>\r\n" + 
		      		"<body>";
		      
		      for (int i = 0; i < 4; i++) {
		    	  
		    	// dsf,dhbck
		      }
		      while ((line = reader.readLine()) != null) {
		        out.println(line);
		      }
		    }
		    catch (FileNotFoundException e) {
		      e.printStackTrace();
		    }


	}

	/*
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * 
	 * }
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * !!!! String[] vErtek = request.getParameterValues("v");
		 * 
		 * double[] dVErtek = new double[vErtek.length];
		 * 
		 * for (int i = 0; i < dVErtek.length; i++) {
		 * 
		 * dVErtek[i] = Double.parseDouble(vErtek[i]); dVErtek[i] = dVErtek[i] / 1000.0;
		 * ertek.add(new Szenzor(dVErtek[i], 0.0, 0.0, new Date())); } !!!!
		 */
		/*
		 * for (int i = 0; i < vErtek.length; i++) {
		 * 
		 * double[] dVErtek =
		 * Arrays.stream(vErtek).mapToDouble(Double::parseDouble).toArray(); dVErtek[i]
		 * = dVErtek[i] / 1000.0; }
		 */

		/*
		 * if(senzorAdatok.size() >= 10) {
		 * 
		 * String temp =
		 * getServletConfig().getServletContext().getRealPath("/someFolder");
		 * temp.toString(); FileKezelo.kiirasFileba(senzorAdatok, response, request,
		 * temp); senzorAdatok.clear(); }
		 */

		/*
		 * String[] decibelValues = request.getParameterValues("d"); for(int counter =
		 * 0; counter < decibelValues.length; counter++) { senzorAdatok.add(new
		 * SzenzorAdat(0.0 , 0.0, Double.parseDouble(decibelValues[counter]), new
		 * Date())); }
		 */

		System.out.println(Arrays.toString(request.getParameterValues("d")));// Arrays.toString(dVErtek) + ", " + //
																				// Arrays.toString(request.getParameterValues("d")));

		// a = (request.getParameterValues("d")).length;
		/*
		 * InputStream in =
		 * getServletContext().getResourceAsStream("/WEB-INF/test.txt");
		 * SzO.fileKiiroTeszt(in);
		 */
		// SzO.kiirasFileba(request.getParameterValues("d"));

	}

}
