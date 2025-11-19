/**
 * 
 */
package com.lti.filpfit.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.lti.filpfit.beans.GymFlipFitSlot;


/**
 * Service implementation for managing gym slots in the GymFlipFit application.
 *
 * <p>This service provides methods to create slots, retrieve slots for a specific date,
 * and fetch slot details by ID.</p>
 */

@Service
public class GymFlipFitSlotServiceImpl implements GymFlipFitSlotService{
	private final List<GymFlipFitSlot> slots = new ArrayList();
	private final AtomicLong counter = new AtomicLong();


	/**
	 * Creates multiple slots for a given center and date.
	 *
	 * <p>Each slot is assigned an ID if not already present, linked to the specified center,
	 * and initialized with default values such as status "OPEN" and booked count as 0.</p>
	 *
	 * @param centerId the ID of the gym center
	 * @param date     the date for which slots are created
	 * @param list     the list of {@link GymFlipFitSlot} objects to create
	 * @return the list of created {@link GymFlipFitSlot} objects
	 */

	@Override
	public GymFlipFitSlot createSlot(GymFlipFitSlot slot) {
		slot.setId(counter.incrementAndGet());
		slot.setStatus("OPEN");
		slot.setBookedCount(0);
		slots.add(slot);
		return slot;
	}


	/**
	 * Retrieves all slots for a given center and date.
	 *
	 * <p>The slots are sorted by their start time for better readability.</p>
	 *
	 * @param centerId the ID of the gym center
	 * @param date     the date for which slots are retrieved
	 * @return a list of {@link GymFlipFitSlot} objects for the specified center and date
	 */

	@Override
	public List<GymFlipFitSlot> getSlotsForDate(Long centerId, Date date) {
		return slots.stream().filter(s -> centerId.equals(s.getCenterId()) && date.equals(s.getSlotDate()))
				.sorted(Comparator.comparing(GymFlipFitSlot::getStartTime)).collect(Collectors.toList());
	}


	/**
	 * Retrieves a slot by its unique ID.
	 *
	 * @param id the unique identifier of the slot
	 * @return an {@link Optional} containing the {@link GymFlipFitSlot} if found, otherwise empty
	 */

	@Override
	public Optional<GymFlipFitSlot> getSlotById(Long id) {
		return slots.stream().filter(c -> c.getId().equals(id)).findFirst();
	}
}
