package DesignPattern;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddCarServlet
 */
@WebServlet("/AddCarServlet")
public class AddCarServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
		/**
		 * @see HttpServlet#HttpServlet()
		 */
		public AddCarServlet() {
			super();
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
			
				int result =facade.addCar(car); 
				
				if(result == 1) {
					
					out.println("<html><body>");
					out.println("<b>Car is already present in the database</b>");
					out.println("<a href='index.jsp'>View Cars</a>");
					out.println("</body></html>");
				}else if(result == 2){

					out.println("<html><body>");
					out.println("<b>Car Details are successfully added</b>");
					out.println("<a href='index.jsp'>View Cars</a>");
					out.println("</body></html>");
				} else{
					
					out.println("<html><body>");
					out.println("<b>The process is failed</b>");
					out.println("<a href='index.jsp'>View Cars</a>");
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
		}
}