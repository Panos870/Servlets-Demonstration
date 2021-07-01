import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.TimeZone;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WorldClockServlet
 */
public class ClockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DateFormat  timeFormatter = DateFormat.getTimeInstance();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClockServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out  = response.getWriter();
		out.println("<head><script type=\"text/javascript\" src=\"WorldClock.js\"></script><head>");
		out.println("<h1>WORLD CLOCK APPLICATION</h1>");
        String input = request.getParameter("user_input");
        TimeZone tz = getTimeZone(input);
        if(input != "") {
        	if(tz != null) {
        		out.print("<h2>" + tz.getDisplayName() + "</h2>");
        		out.print("<h3>The current time in " + input + " is </h3><h2>"+ getTime(tz)+" <h2>");
        }else
        		out.print("<p>City not found.Try again</p>");
        }
        else {
        	out.print("<h3>The current time here is </h3><h2> "+getTime(TimeZone.getDefault())+" </h2>");
        }
        out.println("<button onclick=\"back()\">BACK</button>");
	}
	   public String getTime(TimeZone tzone)
	   {
	      Date time = new Date();
	      timeFormatter.setTimeZone(tzone);
	      String timeString = timeFormatter.format(time);
	      return timeString;
	   }
	   private static TimeZone getTimeZone(String City)
	   {
	      String[] ids = TimeZone.getAvailableIDs();
	      for (int i = 0; i < ids.length; i++)
	      {
	         if (timeZoneIDmatch(ids[i], City))
	         {
	            return TimeZone.getTimeZone(ids[i]);
	         }
	      }
	      return null;
	   }

	   /**
	     	Checks whether a time zone ID matches a city
      @param id the time zone ID (e.g. "America/Los_Angeles")
      @param aCity the city to match (e.g. "Los Angeles")
      @return true if the ID and city match
	   */
	   private static boolean timeZoneIDmatch(String id, String City)
	   {
	      String idCity = id.substring(id.indexOf('/') + 1);
	      return idCity.replace('_', ' ').equals(City);   //return true if aCity matches the substring of the timezone
	   }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}	
}