package com.lti.filpfit.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.lti.filpfit.beans.GymFlipFitCustomer;
import com.lti.filpfit.beans.GymFlipFitSlot;

public interface GymFlipFitAdminService {
	
	public List<GymFlipFitCustomer> findAllCustomers();
	public Optional<GymFlipFitCustomer> findCustomerById(Long id);
	public GymFlipFitCustomer updateCustomer(Long id, GymFlipFitCustomer customerDetails);

	public GymFlipFitSlot saveSlot(GymFlipFitSlot slots);
	public GymFlipFitSlot updateSlot(Long id, GymFlipFitSlot slotDetails);
	public void deleteSlot(Long id);


}
