package com.infy.service;

import com.infy.dto.TraineeDTO;
import com.infy.exception.ITrainingException;
import com.infy.repository.ClassroomRepository;
import com.infy.repository.TraineeRepository;

public class ClassroomAllocationServiceImpl implements ClassroomAllocationService {
	
	
	private ClassroomRepository classroomRepository;
	
	private TraineeRepository traineeRepository;
	
	/**
	  this method  calls getTrainee method of ClassroomAllocationDAOImpl class.
	 
	  @param -  Integer traineeId 
	  @return - Trainee object returned from getTrainee method of ClassroomAllocationDAOImpl class
	  @throws "Service.TRAINEE_NOT_FOUND" exception If trainee object returned from getTrainee method of ClassroomAllocationDAOImpl class is null
	 */
	public TraineeDTO getTrainee(Integer traineeId) throws ITrainingException {
		return null;
	}

	/**
	  this method will call the addTrainee method of ClassroomAllocationDAOImpl class. 
	  @param - Trainee object
	  @return - Integer traineeId returned from addTrainee method of ClassroomAllocationDAOImpl class. 
	 */
	public Integer addTrainee(TraineeDTO trainee) throws ITrainingException {
		return null;
	}

	/**
	  this method will call allocateClassroom method of ClassroomAllocationDAOImpl class, which in turn will return value
	  @param -  Integer traineeId, String classRoomId
	  @return - Integer value returned from llocateClassroom method of ClassroomAllocationDAOImpl class
	  @throws -exception as below if the return from llocateClassroom method of ClassroomAllocationDAOImpl class is
	    0 - throw "Service.TRAINEE_NOT_FOUND" exception
	    -1 - throw "Service.CLASSROOM_NOT_FOUND" exception
	    -2 - throw "Service.CLASSROOM_FULL" exception.
	 */
	public Integer allocateClassroom(Integer traineeId, String classRoomId) throws ITrainingException {
		return null;
	}
	/**
	  this method will call deleteTrainee method of ClassroomAllocationDAOImpl class which will return a string value.
	  @param -  Integer traineeId
	  @return - String   value that was received from deleteTrainee method of ClassroomAllocationDAOImpl class
	  @throws -Service.TRAINEE_NOT_FOUND exception if value returned by deleteTrainee method of ClassroomAllocationDAOImpl class is null
	 */
	public String deleteTrainee(Integer traineeId) throws ITrainingException {
		return null;
	}

}
