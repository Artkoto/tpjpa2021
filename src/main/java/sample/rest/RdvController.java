package sample.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sample.domain.Appointment;
import sample.service.AppointmentService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


@Controller
@RequestMapping("/Appointment")
public class RdvController {

	Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AppointmentService rdvService;
	
	/**
	 * POST /create  --> Create a new user in the database.
	 */
	@PostMapping("/create-appointment")
	@ResponseBody
	public Appointment create( Appointment rdv) {
		
		rdvService.saveAppointment(rdv);
		return rdv; 
	}

	/**
	 * DELETE /delete  --> Delete the user having the passed id.
	 */
	@DeleteMapping("/delete/{rdvId}")
	@ResponseBody
	public void delete(@PathVariable Long rdvId) {
			
		rdvService.deleteAppointment(rdvId);
	 
	}

	  /**
	   * GET /get-all  --> Return the list of rdvs
	   *rdvDao
	   */
	  @GetMapping("/appointments")
	  @ResponseBody
	  public Iterable<Appointment> getAllRdv() {
	    
		return rdvService.getAppointments();
	    
	  }
	  
	  /**
	   * GET /get-all  --> Return the list of appointment
	   *
	   */
	  @GetMapping("/get-appointment/{rdvId}")
	  @ResponseBody
	  public Appointment getById(@PathVariable Long rdvId) {
	    
		return rdvService.getAppointment(rdvId).get();
	    
	  }

	/**
     *  GET appointment by title
     * @param title : title of the appointment
     * @return
     */
	@GetMapping("/get-by-title/{title}")
	@ResponseBody
    public Appointment getByTitle(@PathVariable String title)  {
        return rdvService.getAppointmentByTitle(title);
    }
	  
	  /**
	   * PUT /update  --> Update 
	   * database having the passed id.
	   */

	  @PutMapping("/update/Appointment")
	  @ResponseBody
	  public Appointment updateRdv(Appointment rdv) {
	
		rdvService.saveAppointment(rdv);
		return rdv;
	  }
	   

}