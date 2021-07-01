

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OrderFormServlet
 */
public class OrderFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out  = response.getWriter();
	  	Enumeration<String> fields;
		Vector<String> fieldNames = new Vector<String>();
		
		fieldNames.add("Description");
		fieldNames.add("Code");
		fieldNames.add("Quantity");
		fieldNames.add("Delivery");
		fieldNames.add("Number");
		fields = fieldNames.elements();
		
		out.println("<h1>Testing do Post....</h1>");
		while(fields.hasMoreElements()) {
		String currentElement =  fields.nextElement();
		out.println(currentElement+" = "+request.getParameter(currentElement)+"<br>")	;
		}
	}
}
