package com.infy.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dto.DesktopDTO;
import com.infy.dto.DesktopStatus;
import com.infy.dto.TraineeDTO;
import com.infy.entity.Desktop;
import com.infy.entity.Trainee;
import com.infy.exception.InfyTrainingException;
import com.infy.repository.DesktopRepository;
import com.infy.repository.TraineeRespository;

@Service(value = "desktopAllocationService")
@Transactional
public class DesktopAllocationServiceImpl implements DesktopAllocationService {
	
	@Autowired
	private  TraineeRespository traineeRespository;
	
	@Autowired
	private DesktopRepository desktopRepository;

	/**
	 This method calls findById method of traineeRespository sending  traineeId received in parameter
	 @param Integer traineeId
	 @return TraineeDTO object object populated from entity object returned by findById method of traineeRespository
	 @throws Service.TRAINEE_NOT_FOUND exception if object returned by findById method of traineeRespository is null
	 */
	@Override
	public TraineeDTO getTraineeDetails(Integer traineeId) throws InfyTrainingException {
		Optional<Trainee> option = traineeRespository.findById(traineeId);
		if (!option.isPresent()) throw new InfyTrainingException("Service.DESKTOP_NOT_FOUND");
		Trainee trainee= option.orElseThrow(() -> new InfyTrainingException("Service.TRAINEE_NOT_FOUND"));
		
		TraineeDTO traineeDTO = new TraineeDTO();
		
		traineeDTO .setTraineeId(trainee.getTraineeId());
		traineeDTO .setTraineeName(trainee.getTraineeName());
		
		if (trainee.getDesktop()!=null) {
			Desktop desktop = trainee.getDesktop();
			DesktopDTO desktopDTO = new DesktopDTO();
			
			desktopDTO .setDesktopId(desktop.getDesktopId());
			desktopDTO .setDesktopMake(desktop.getDesktopMake());
			desktopDTO .setDesktopModel(desktop.getDesktopModel());
			desktopDTO .setDesktopStatus(desktop.getDesktopStatus());
			
			traineeDTO .setDesktop(desktopDTO);
		}
		
		return traineeDTO;
		
	}
	
	/**
	 This method calls findById method of desktopRepository sending  desktopId received in parameter
	 @param String despktopId
	 @return DesktopDTO object populated from entity object returned by findById method of desktopRepository
	 @throws Service.DESKTOP_NOT_FOUND exception if object returned by findById method of desktopRepository is null
	 */
	@Override
	public DesktopDTO getDesktopDetails(String desktopId) throws InfyTrainingException {
		Optional<Desktop> option = desktopRepository.findById(desktopId);
		if (!option.isPresent()) throw new InfyTrainingException("Service.DESKTOP_NOT_FOUND");
		Desktop desktop= option.orElseThrow(() -> new InfyTrainingException("Service.DESKTOP_NOT_FOUND"));
		
		
		DesktopDTO desktopDTO = new DesktopDTO();
		desktopDTO .setDesktopId(desktop.getDesktopId());
		desktopDTO .setDesktopMake(desktop.getDesktopMake());
		desktopDTO .setDesktopModel(desktop.getDesktopModel());
		desktopDTO .setDesktopStatus(desktop.getDesktopStatus());
		
		
		return desktopDTO;
	}

	/**
	 This method calls save method of traineeRespository sending Trainee entity object populated by trainee object received in parameter
	 @param TraineeDTO object
	 @return Integer traineeId after calling save method of traineeRespository
	 
	 */
	@Override
	public Integer addTrainee(TraineeDTO traineeDTO) throws InfyTrainingException {
		Trainee trainee = new Trainee();
		
		trainee.setTraineeName(traineeDTO.getTraineeName());
		if (traineeDTO.getDesktop()!=null) {
			Desktop desktop = new Desktop();
		
	//		desktop.setDesktopId(traineeDTO.getDesktop().getDesktopId());
			desktop.setDesktopMake(traineeDTO.getDesktop().getDesktopMake());
			desktop.setDesktopModel(traineeDTO.getDesktop().getDesktopModel());
			desktop.setDesktopStatus(traineeDTO.getDesktop().getDesktopStatus());
			
			trainee.setDesktop(desktop);
		}
		
		return traineeRespository.save(trainee).getTraineeId();	

	}

	/**
	 This method calls findById method of traineeRespository sending  traineeId received in parameter, then 
	 checks whether the trainee is allocated to with a desktop, then calls
	 findById method of traineeRespository sending  desktopId received in parameter, then
	 checks whether the desktop is allocated to a trainee and then it allocates the desktop to the trainee.
	 @param Integer traineeId, String desktopId
	 @throws 
	 -Service.TRAINEE_NOT_FOUND exception if object returned by findById method of traineeRespository is null
	 -Service.TRAINEE_DESKTOP_FOUND exception if desktop is already allocated to this trainee
	 -Service.DESKTOP_NOT_FOUND exception if object returned by findById method of desktopRepository is null
	 -Service.DESKTOP_ALREADY_ALLOCATED exception if desktop is already allocated to some other trainee
	 */
	@Override
	public void allocateDesktop(Integer traineeId, String desktopId) throws InfyTrainingException {
		Optional<Trainee> traineeOption = traineeRespository.findById(traineeId);
		Trainee trainee = null;
		if (!traineeOption.isPresent()) throw new InfyTrainingException("Service.TRAINEE_NOT_FOUND");
		else trainee = traineeOption.get();
		
		if (trainee.getDesktop()!=null && trainee.getDesktop().getDesktopStatus()==DesktopStatus.ALLOCATED) throw new InfyTrainingException("Service.TRAINEE_DESKTOP_FOUND");
		
		Optional<Desktop> desktopOption = desktopRepository.findById(desktopId);
		Desktop desktop = null;
		if (!desktopOption.isPresent()) throw new InfyTrainingException("Service.DESKTOP_NOT_FOUND");
		else desktop = desktopOption.get();
		
		if (desktop.getDesktopStatus()!=DesktopStatus.AVAILABLE) throw new InfyTrainingException("Service.DESKTOP_ALREADY_ALLOCATED");
		
		trainee.setDesktop(desktop);
		desktop.setDesktopStatus(DesktopStatus.ALLOCATED);
		
		traineeRespository.save(trainee);
		desktopRepository.save(desktop);
	}
	/**
	 This method calls findById method of traineeRespository sending  traineeId received in parameter, then
	 it deallocates the desktop allocated to the trainee.
	 @param Integer traineeId
	 @throws
	 - Service.TRAINEE_NOT_FOUND exception if object returned by findById method of traineeRespository is null
	 - Service.DESKTOP_NOT_ALLOCATED exception if no desktop is allocated to the trainee
	 */
	@Override
	public void deallocateDesktop(Integer traineeId) throws InfyTrainingException {
		Optional<Trainee> traineeOption = traineeRespository.findById(traineeId);
		Trainee trainee = null;
		if (!traineeOption.isPresent()) throw new InfyTrainingException("Service.TRAINEE_NOT_FOUND");
		else trainee = traineeOption.get();
		
		if (trainee.getDesktop()==null ) throw new InfyTrainingException("Service.DESKTOP_NOT_ALLOCATED");
		
		Desktop desktop = trainee.getDesktop();
		desktop.setDesktopStatus(DesktopStatus.AVAILABLE);
		
		trainee.setDesktop(null);
		
		traineeRespository.save(trainee);
		desktopRepository.save(desktop);
	}
	/**
	 This method first calls findById method of traineeRespository sending  traineeId received in parameter,
	 then calls delete method of traineeRespository sending traineeId received in parameter
	 @param Integer traineeId
	 @throws Service.TRAINEE_NOT_FOUND exception if Trainee object returned by findById method of traineeRespository is null 
	 */
	@Override
	public void deleteTrainee(Integer traineeId) throws InfyTrainingException {
		Optional<Trainee> traineeOption = traineeRespository.findById(traineeId);
		Trainee trainee = null;
		if (!traineeOption.isPresent()) throw new InfyTrainingException("Service.TRAINEE_NOT_FOUND");
		else trainee = traineeOption.get();
		
		if (trainee.getDesktop()!=null ) {
			Desktop desktop = trainee.getDesktop();
			desktop.setDesktopStatus(DesktopStatus.AVAILABLE);
			desktopRepository.save(desktop);
		}
	
		traineeRespository.delete(trainee);
	}
	
}
