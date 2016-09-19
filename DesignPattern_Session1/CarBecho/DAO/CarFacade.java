package DesignPattern;

import java.util.List;

public class CarFacade {
	
	public int addCar(CarVO car){

		int result = 0;
		DatabaseConnection db = null;

		try{

			db = DatabaseConnection.getInstance();
			CarDAO carDAO = new CarDAO(db.createConnection());
			
			if(carDAO.checkCarIsPresentDAO(car)) {
				
				result = 1;
			}else if(carDAO.addCarDAO(car)){

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

	public boolean updateCar(CarVO car){

		boolean flag = false;
		DatabaseConnection db = null;

		try {

			db = DatabaseConnection.getInstance();
			CarDAO carDAO = new CarDAO(db.createConnection());

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
	
	public List<CarVO> getAllCars(){
		
		List<CarVO> listOfCars = null;
		DatabaseConnection db = null;

		try {

			db = DatabaseConnection.getInstance();
			CarDAO carDAO = new CarDAO(db.createConnection());
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
	
	/*public boolean deleteCar(CarVO car){

		boolean flag = false;
		DatabaseConnection db = null;

		try {

			db = DatabaseConnection.getInstance();

			CarDAO carDAO = new CarDAO(db.createConnection());

			if(carDAO.deleteCarDAO(car)){

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
	}*/
}