import java.io.*;
import java.util.Date;
import javax.servlet.http.*;
public class HelloServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req,
			HttpServletResponse res) throws IOException{
		Date d = new Date();
		Writer w = res.getWriter();
		w.write("<html><body>");
		w.write("Today is " + d.toString());
		w.write("</body></html>");
	}
}
