package com.lti.filpfit.rest;

import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.filpfit.beans.GymFlipFitScheduler;
import com.lti.filpfit.beans.GymFlipFitSlot;


/**
 * REST controller for managing scheduling operations in the GymFlipFit application.
 *
 * <p>This controller provides endpoints to handle scheduling of gym slots, including
 * creating, updating, retrieving, and deleting schedules. All responses are returned
 * in JSON format.</p>
 *
 * <h2>Responsibilities:</h2>
 * <ul>
 *     <li>Expose REST endpoints for scheduling operations</li>
 *     <li>Handle HTTP requests and delegate business logic to the service layer</li>
 * </ul>
 *
 * <h2>Endpoints:</h2>
 * <ul>
 *     <li><b>GET /scheduler/slot</b> - Retrieve schedules between a start and end time</li>
 *     <li><b>POST /scheduler/schedule</b> - Create a new schedule</li>
 *     <li><b>PUT /scheduler/schedule/{scheduleId}</b> - Update an existing schedule</li>
 *     <li><b>DELETE /scheduler/schedule/{scheduleId}</b> - Remove a schedule</li>
 * </ul>
 *
 * @author Team Bravo
 * @version v1.0.0
 * @see GymFlipFitScheduler
 * @see GymFlipFitSlot
 */

@RestController
@RequestMapping("/scheduler")
public class GymFlipFitSchedulerController {

	
	@GetMapping("/slot")
	public ResponseEntity<List<GymFlipFitScheduler>> getSchedules(@PathVariable Date startTime, @PathVariable Date endTime){
		
		return null;
	}
	@PostMapping("/schedule")
	public ResponseEntity<GymFlipFitScheduler> scheduleSlot(@RequestBody GymFlipFitScheduler scheduler){
		
		return null;
	}
	@PutMapping("/schedule/{scheduleId}")
	public ResponseEntity<GymFlipFitScheduler> updateSchedule(@RequestBody GymFlipFitScheduler scheduler, @PathVariable int scheduleId){
		
		return null;
	}
	@DeleteMapping("/schedule/{scheduleId}")
	public ResponseEntity<GymFlipFitScheduler> removeSchedule(@PathVariable int scheduleId){
		
		return null;
	}
}
