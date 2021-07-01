import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RandomFactServlet
 */
public class RandomFactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int counter;
	List<String> list;
    /**
     * @throws IOException 
     * @see HttpServlet#HttpServlet()
     */
    public RandomFactServlet() throws IOException {
        super();
        InputStream inp =  RandomFactServlet.class.getResourceAsStream("Facts.txt");
        BufferedReader bReader = new BufferedReader(new InputStreamReader(inp));
		String line = null;
        list = new ArrayList<String>();
        while ((line = bReader.readLine()) != null) {
            list.add(line);
        }
        System.out.println(list.get(0));
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		counter++;
		Random rand = new Random();
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		String fact = list.get(rand.nextInt(10));
		out.print("<h1>Fact of the Day</h1>");
		out.print("<p>"+fact+"</p>");
		out.print("<p>Site hits = " +  counter+"</p>");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}