package employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class GetJobServlet
 */
@WebServlet("/GetJobServlet")
public class GetJobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetJobServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//JobId, JobTitle Map사용.
		EmpDAO dao = new EmpDAO();
		Map<String, String>map = dao.getJobCode();
		//json -> [{"job_id":"job_title"},{},{}]
		JSONObject obj = new JSONObject();
		JSONArray ary = new JSONArray();
		
		Set<String> set = map.keySet();
		for(String str : set) {
			obj.put("job_id", str);
			obj.put("job_title", map.get(str));
			ary.add(obj);
		}
			
		
//		obj.put("job_id", "IT_PROG");
//		obj.put("job_title", "Programmer");
//		ary.add(obj);
		PrintWriter out = response.getWriter();
		out.write(ary.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
