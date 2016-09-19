package DesignPattern;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateCarServlet
 */
@WebServlet("/UpdateCarServlet")
public class UpdateCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = null;
		try {
			
			response.setContentType("text/html");
			out = response.getWriter();
			CarVO car = new CarVO();
			CarFacade facade = new CarFacade();

			car.setCompany(request.getParameter("companyName"));
			car.setModel(request.getParameter("modelName"));
			car.setEngineInCC(Integer.parseInt(request.getParameter("engineInCC")));
			car.setFuelCapacity(Double.parseDouble(request.getParameter("fuelCapacity")));
			car.setMileage(Double.parseDouble(request.getParameter("mileage")));
			car.setPrice(Double.parseDouble(request.getParameter("price")));
			car.setRoadTax(Double.parseDouble(request.getParameter("roadTax")));
			
			if(request.getParameter("AC").equals("Yes")){

				car.setAC(1);
			}

			if(request.getParameter("powerSteering").equals("Yes")){

				car.setPowerSteering(1);
			}
			
			if(request.getParameter("accessoryKit").equals("Yes")){

				car.setAccessoryKit(1);
			}
		
			if(facade.updateCar(car)){

				out.println("<html><body>");
				out.println("<b>Car Details are successfully updated</b>");
				out.println("</body></html>");
			}else{
				
				out.println("<html><body>");
				out.println("<b>The process is failed</b>");
				out.println("</body></html>");
			}

		} catch(Exception ex){

			ex.printStackTrace();
		} finally{
			
			out.flush();
			out.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
