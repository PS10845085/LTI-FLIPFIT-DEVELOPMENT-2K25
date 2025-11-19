package com.lti.filpfit.services;

import java.util.List;
import java.util.Optional;

import com.lti.filpfit.beans.GymFlipFitOwner;

public interface GymFlipFitOwnerService {

	public Optional<GymFlipFitOwner> findOwnerById(Long id);

	public List<GymFlipFitOwner> findAllOwners();

	public GymFlipFitOwner saveOwner(GymFlipFitOwner owner);

	public GymFlipFitOwner updateOwner(Long id, GymFlipFitOwner ownerDetails);

	public void deleteOwner(Long id);

	}
