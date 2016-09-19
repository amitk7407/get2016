package DesignPattern;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO class to execute the query on book list
 */
public class CarDAO {

	private Connection con;
	private List<CarVO> listOfCars;
	
	/**
	 * parameterized constructor
	 * @param con : Connection object
	 */
	public CarDAO(Connection con) {
	
		listOfCars = new ArrayList<CarVO>();
		this.con = con;
	}
	
	/**
	 * method to execute the query to add the car details in the database
	 * @param car : CarVO object from which car details to be added in database
	 * @return : boolean to indicate the success of the process
	 */
	public boolean addCarDAO(CarVO car) {
		
		PreparedStatement pstmt = null;
		boolean flag = false;
		
		try {
			
			String query = "INSERT INTO car(CompanyName, ModelName, EngineInCC, FuelCapacity, Mileage, Price, RoadTax, "
					+ "AC, PowerSteering, AccessoryKit, OnRoadPrice) Values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			
			if(con != null){
			
				pstmt = this.con.prepareStatement(query);
			
				if(pstmt != null){

					pstmt.setString(1, car.getCompany());
					pstmt.setString(2, car.getModel());
					pstmt.setInt(3, car.getEngineInCC());
					pstmt.setDouble(4, car.getFuelCapacity());
					pstmt.setDouble(5, car.getMileage());
					pstmt.setDouble(6, car.getPrice());
					pstmt.setDouble(7, car.getRoadTax());
					pstmt.setInt(8, car.getAC());
					pstmt.setInt(9, car.getPowerSteering());
					pstmt.setInt(10, car.getAccessoryKit());
					car.calculateOnRoadPrice();
					pstmt.setDouble(11, car.getOnRoadPrice());
				
					pstmt.executeUpdate();
					flag = true;
				}
			}		
		} catch(SQLException sqle) {
			
			sqle.printStackTrace();
		} finally {
			
			try {

				pstmt.close();	
			} catch(SQLException sqle) {
				
				sqle.printStackTrace();
			}
		}
		return flag;
	}
	
	/**
	 * method to update the car details
	 * @param car : CarVO object whose data is to be updated
	 * @return : boolean
	 */
	public boolean updateCarDAO(CarVO car) {
		
		boolean flag = false;
		PreparedStatement pstmt = null;
		
		try{

			String query = "UPDATE car SET EngineInCC = ?, FuelCapacity = ?, Mileage = ?, Price = ?, RoadTax = ?, AC = ?, "
					+ "PowerSteering = ?, AccessoryKit = ?, OnRoadPrice= ? WHERE CompanyName = ? AND ModelName = ?;";

			if(con != null){
				
				pstmt = this.con.prepareStatement(query);
			
				if(pstmt != null){
				
					pstmt.setInt(1, car.getEngineInCC());
					pstmt.setDouble(2, car.getFuelCapacity());
					pstmt.setDouble(3, car.getMileage());
					pstmt.setDouble(4, car.getPrice());
					pstmt.setDouble(5, car.getRoadTax());
					pstmt.setInt(6, car.getAC());
					pstmt.setInt(7, car.getPowerSteering());
					pstmt.setInt(8, car.getAccessoryKit());
					car.calculateOnRoadPrice();
					pstmt.setDouble(9, car.getOnRoadPrice());
					pstmt.setString(10, car.getCompany());
					pstmt.setString(11, car.getModel());
					
					pstmt.executeUpdate();
					flag = true;
					System.out.println(car.getMileage());
				}
			}

		} catch(SQLException sqle) {
			
			sqle.printStackTrace();
		} finally {
			
			try {

				pstmt.close();	
			} catch(SQLException sqle) {
				
				sqle.printStackTrace();
			}
		}
		return flag;
	}
	
	/**
	 * method to return all the list of the cars present in the database 
	 * @return : list of cars
	 */
	public List<CarVO> selectAllCarsDAO(){

		PreparedStatement pstmt = null;
		ResultSet rst = null;
		try{

			String query = "SELECT CompanyName, ModelName, EngineInCC, FuelCapacity,"
					+ "Mileage, Price, RoadTax, AC, PowerSteering, AccessoryKit, OnRoadPrice FROM car;";

			if(con != null){
				
				pstmt = con.prepareStatement(query);
			
				if(pstmt != null){

					rst = pstmt.executeQuery();
			
					if(rst != null){

						while(rst.next()){

							CarVO car = new CarVO();
							car.setCompany(rst.getString(1));
							car.setModel(rst.getString(2));
							car.setEngineInCC(rst.getInt(3));
							car.setFuelCapacity(rst.getDouble(4));
							car.setMileage(rst.getDouble(5));
							car.setPrice(rst.getDouble(6));
							car.setRoadTax(rst.getDouble(7));
							car.setAC(rst.getInt(8));
							car.setPowerSteering(rst.getInt(9));
							car.setAccessoryKit(rst.getInt(10));
							car.setOnRoadPrice(rst.getDouble(11));
							listOfCars.add(car);
						}
					}
				}
			}
		} catch(SQLException sqle) {
			
			sqle.printStackTrace();
		} finally {
			
			try {

				pstmt.close();	
			} catch(SQLException sqle) {
				
				sqle.printStackTrace();
			}
		}
		return listOfCars;
	}
	
	/**
	 * method to delete the car from the database
	 * @param car : CarVO object which is to be deleted
	 * @return : boolean
	 */
	public boolean checkCarIsPresentDAO(CarVO car) {
		
		boolean flag = false;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		
		try{

			String query = "SELECT CompanyName, ModelName, EngineInCC, FuelCapacity,"
					+ "Mileage, Price, RoadTax, AC, PowerSteering, AccessoryKit, OnRoadPrice FROM car WHERE"
					+ " CompanyName = ? AND ModelName = ?;";

			if(con != null){
				
				pstmt = this.con.prepareStatement(query);
			
				if(pstmt != null){
				
					pstmt.setString(1, car.getCompany());
					pstmt.setString(2, car.getModel());
					
					rst = pstmt.executeQuery();
					
					if(rst != null){

						if(rst.next()){ 
						
							flag = true;
						}
					}
				}
			}

		} catch(SQLException sqle) {
			
			sqle.printStackTrace();
		} finally {
			
			try {

				pstmt.close();	
			} catch(SQLException sqle) {
				
				sqle.printStackTrace();
			}
		}
		return flag;
	}	
}