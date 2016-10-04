package com.Metacube.daoLayer;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Metacube.model.CarVO;

/**
 * DAO class to execute the query on car
 */
@Repository
public class CarDAOImpl{
	
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Autowired(required=true)
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * method to return all the list of the cars present in the database 
	 * @return : list of cars
	 */
	@SuppressWarnings("unchecked")
	public List<CarVO> selectAllCarsDAO(){

		Session session = this.sessionFactory.getCurrentSession();
		List<CarVO> carsList = session.createQuery("from CarVO").list();
		
		return carsList;
	}

	/**
	 * method to update the car details
	 * @param car : CarVO object whose data is to be updated
	 * @return : Boolean
	 */
	public void updateCarDAO(CarVO carVO) {

		Session session = this.sessionFactory.getCurrentSession();
		carVO.calculateOnRoadPrice();
		session.update(carVO);
	}

	/**
	 * method to execute the query to add the car details in the database
	 * @param car : CarVO object from which car details to be added in database
	 * @return : Boolean to indicate the success of the process
	 */
	public void addCarDAO(CarVO carVO) {

		Session session = this.sessionFactory.getCurrentSession();
		carVO.calculateOnRoadPrice();
		session.persist(carVO);
	}

	/**
	 * method to find the car from the database
	 * @param car : CarVO object which is to be deleted
	 * @return : Boolean
	 */
	@SuppressWarnings("unchecked")
	public CarVO findCarDAO(String companyName, String modelName) {

		Session session = this.sessionFactory.getCurrentSession();
		
		String hql = "FROM CarVO WHERE upper(companyName)='"+companyName+"' AND upper(modelName)='"+modelName+"'";
		Query query = session.createQuery(hql);
		List<CarVO> results = query.list();
		if(results.size() == 0) {
			
			return null;
		} else {

			CarVO carVO = results.get(0);
			return carVO;
		}
	}
}