package Model;

import java.util.List;
import DAOLayer.CarDAO;
import DAOLayer.DatabaseConnection;

/**
 * Facade Class to serve as Model
 * This class interact with DAO classes
 */
public class CarFacade {
	
	/**
	 * method to find the data of all cars from the database
	 * @return : list of CarVO objects
	 */
	public List<CarVO> getAllCars(){
		
		List<CarVO> listOfCars = null;
		DatabaseConnection db = null;

		try {

			//database connection
			db = DatabaseConnection.getInstance();
			CarDAO carDAO = new CarDAO(db.createConnection());
			
			//calls the DAO method to get the list of cars
			listOfCars = carDAO.selectAllCarsDAO();
			
		} catch(Exception ex){

			ex.printStackTrace();
		} finally{
			
			try {
				
				db.closeConnection();
			} catch(Exception ex){
				
				ex.printStackTrace();
			}
		}
		return listOfCars;
	}
	
	/**
	 * method to update the car's features
	 * @param car : CarVO object sent by UpdateCarServlet class
	 * @return : Boolean
	 */
	public boolean updateCar(CarVO car){

		boolean flag = false;
		DatabaseConnection db = null;

		try {

			//database connection
			db = DatabaseConnection.getInstance();
			CarDAO carDAO = new CarDAO(db.createConnection());

			//calls the DAO method to update the car's features
			if(carDAO.updateCarDAO(car)){

				flag = true;
			}
		} catch(Exception ex){

			ex.printStackTrace();
		} finally{
			
			try {
				
				db.closeConnection();
			} catch(Exception ex){
				
				ex.printStackTrace();
			}
		}
		return flag;
	}
	
	/**
	 * method to add cars in the database
	 * @param car : CarVO object sent by AddCarServlet class
	 * @return : Integer
	 */
	public int addCar(CarVO car){

		int result = 0;
		DatabaseConnection db = null;

		try{

			//database connection
			db = DatabaseConnection.getInstance();
			CarDAO carDAO = new CarDAO(db.createConnection());
			
			//check if the car is already present or not
			if(carDAO.checkCarIsPresentDAO(car)) {
				
				result = 1;
			}else if(carDAO.addCarDAO(car)){					//calls the DAO method to add the car

				result = 2;;
			}
		} catch(Exception ex){

			ex.printStackTrace();
		} finally{
			
			try {
				
				db.closeConnection();
			} catch(Exception ex){
				
				ex.printStackTrace();
			}
		}
		return result;
	}
	
	/**
	 * method to find cars from the database
	 * @param car : CarVO object sent by FindCarServlet class
	 * @return : Boolean
	 */
	public boolean findCar(CarVO car){

		boolean flag = false;
		DatabaseConnection db = null;

		try {

			//database connection
			db = DatabaseConnection.getInstance();
			CarDAO carDAO = new CarDAO(db.createConnection());

			//calls the DAO method to find the car
			if(carDAO.findCarDAO(car)){

				flag = true;
			}
		} catch(Exception ex){

			ex.printStackTrace();
		} finally{
			
			try {
				
				db.closeConnection();
			} catch(Exception ex){
				
				ex.printStackTrace();
			}
		}
		return flag;
	}
}