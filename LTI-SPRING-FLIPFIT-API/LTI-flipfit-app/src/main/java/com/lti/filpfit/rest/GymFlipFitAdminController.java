/**
 * 
 */
package com.lti.filpfit.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.filpfit.beans.GymFlipFitCustomer;
import com.lti.filpfit.beans.GymFlipFitSlot;
import com.lti.filpfit.services.GymFlipFitAdminService;

import jakarta.ws.rs.core.MediaType;

/**
 * REST controller for managing Admin, slots related operations in the GymFlipFit application.
 *
 * <p>This controller provides endpoints to retrieve customer information and other
 * administrative functionalities. All responses are returned in JSON format.</p>
 *
 * <h2>Responsibilities:</h2>
 * <ul>
 *     <li>Handle HTTP requests for customer data</li>
 *     <li>Delegate business logic to {@code AdminService}</li>
 * </ul>
 *
 * <h2>Endpoints:</h2>
 * <ul>
 *     <li><b>GET /customer/{id}</b> - Fetch customer details by ID</li>
 * </ul>
**/

@RestController
@RequestMapping("/admin")
public class GymFlipFitAdminController {
	
	@Autowired
	private GymFlipFitAdminService adminService;
	
	/*
	 * @Method: getAllCustomer
	 * @Description: listing all the customers
	 * @MethodParameters: No Args
	 * @Exception
	 */
	@RequestMapping(value = "/customers", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
	public List<GymFlipFitCustomer> getAllCustomer() {
		return adminService.findAllCustomers();
	}
	
	/*
	 * @Method: getCustomer
	 * @Description: displaying specific customer data
	 * @MethodParameters: Customer id
	 * @Exception : Id not Found
	 */
	@RequestMapping(value = "/customer/{id}", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
	public ResponseEntity<GymFlipFitCustomer> getCustomerById(@PathVariable Long id) {
		return adminService.findCustomerById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	/*
	 * @Method: updateCustomer
	 * @Description: updating specific customer with help of Id
	 * @MethodParameters: Customer id
	 * @Exception : Id not Found
	 */
	@RequestMapping(value = "/updateCustomer/{id}", produces = MediaType.APPLICATION_JSON, method = RequestMethod.PUT)
	public ResponseEntity<GymFlipFitCustomer> updateCustomer(@PathVariable Long id, @RequestBody GymFlipFitCustomer customerDetails) {
		GymFlipFitCustomer updatedCustomer = adminService.updateCustomer(id, customerDetails);
		if (updatedCustomer != null) {
			return ResponseEntity.ok(updatedCustomer);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// create slot for the class for a centre
	/*
	 * @Method: createSlot
	 * @Description: creating slots
	 * @MethodParameters: Slot json data passing to create
	 * @Exception 
	 */
	@RequestMapping(value = "/createSlot", produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST)
	public ResponseEntity<GymFlipFitSlot> createSlot(@RequestBody GymFlipFitSlot slot) {
		GymFlipFitSlot savedSlot = adminService.saveSlot(slot);
		return new ResponseEntity<>(savedSlot, HttpStatus.CREATED);
	}
	
	
	// update the slot by id
	/*
	 * @Method: updateSlot
	 * @Description: updating specific slot with help of Id
	 * @MethodParameters: Slot id
	 * @Exception : Id not Found
	 */
	@RequestMapping(value = "/updateSlot/{id}", produces = MediaType.APPLICATION_JSON, method = RequestMethod.PUT)
	public ResponseEntity<GymFlipFitSlot> updateSlot(@PathVariable Long id, @RequestBody GymFlipFitSlot slotDetails) {
		GymFlipFitSlot updatedSlot = adminService.updateSlot(id, slotDetails);
		if (updatedSlot != null) {
			return ResponseEntity.ok(updatedSlot);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// deleting the slot by id
	/*@Method: updateSlot
	 * @Description: updating specific slot with help of Id
	 * @MethodParameters: Slot id
	 * @Exception : Id not Found
	 */
	@RequestMapping(value = "/deleteSlot/{id}", produces = MediaType.APPLICATION_JSON, method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteSlot(@PathVariable Long id) {
		adminService.deleteSlot(id);
		return ResponseEntity.noContent().build();
	}

}
