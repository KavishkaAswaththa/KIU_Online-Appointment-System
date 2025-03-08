package com.example.demo.controller;

import com.example.demo.dto.LecDTO;
import com.example.demo.service.Email;
import com.example.demo.service.EmailService;
import com.example.demo.dto.AppointmentDTO;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.service.AppointmentService;
import com.example.demo.util.varList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/appointment")
@CrossOrigin

public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private ResponseDTO responseDTO;

    @Autowired
    EmailService emailService;

    @Autowired
    Email email;




   /* @PostMapping(value = "/sendMail")
    public ResponseEntity sendMail(@RequestBody EmailRequest emailRequest) {
        emailService.sendEmail(emailRequest.getTo(), emailRequest.getSubject(), emailRequest.getBody());
        return ResponseEntity.ok("Email sent successfully");
    }

*/


    @PostMapping(value = "/addAppointment")
    public ResponseEntity addAppointment(@RequestBody AppointmentDTO AppointmentDTO) {
        try {
            String res = appointmentService.addAppointment(AppointmentDTO);
            if (res.equals("00")) {
                responseDTO.setCode(varList.ASP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(AppointmentDTO);
                emailService.sendEmail(AppointmentDTO.getStuentEmail(), AppointmentDTO.getSubject(), AppointmentDTO.getBody());
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            } else if (res.equals("06")) {

                responseDTO.setCode(varList.ASP_DUPLICATED);
                responseDTO.setMessage("Appointment Sent");
                responseDTO.setContent(AppointmentDTO);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);

            } else {
                responseDTO.setCode(varList.ASP_FAIL);
                responseDTO.setMessage("Error");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            }

        } catch (Exception ex) {
            responseDTO.setCode(varList.ASP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }


    @PutMapping(value = "/editAppointment")
    public ResponseEntity editAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        try {
            String res = appointmentService.editAppointment(appointmentDTO);
            if (res.equals("00")) {
                responseDTO.setCode(varList.ASP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(appointmentDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            } else if (res.equals("01")) {

                responseDTO.setCode(varList.ASP_DUPLICATED);
                responseDTO.setMessage("");
                responseDTO.setContent(appointmentDTO);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);

            } else {
                responseDTO.setCode(varList.ASP_FAIL);
                responseDTO.setMessage("Error");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            }

        } catch (Exception ex) {
            responseDTO.setCode(varList.ASP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @PutMapping(value = "/updateAppointment")
    public ResponseEntity updateAppointment(@RequestBody LecDTO lecDTO) {
        try {
            String res = appointmentService.updateAppointment(lecDTO);
            if (res.equals("00")) {
                responseDTO.setCode(varList.ASP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(lecDTO);

                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            } else if (res.equals("01")) {

                responseDTO.setCode(varList.ASP_DUPLICATED);
                responseDTO.setMessage("");
                responseDTO.setContent(lecDTO);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);

            } else {
                responseDTO.setCode(varList.ASP_FAIL);
                responseDTO.setMessage("Error");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            }

        } catch (Exception ex) {
            responseDTO.setCode(varList.ASP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }
    @DeleteMapping("/deleteAppointment/{id}")
    public ResponseEntity deleteAppointment(@PathVariable int id) {
        try {
            String res = appointmentService.deleteAppointment(id);
            if (res.equals("00")) {
                responseDTO.setCode(varList.ASP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

            } else {
                responseDTO.setCode(varList.ASP_NO_DATA_FOUND);
                responseDTO.setMessage("No Employee Available For this Id");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            }

        } catch (Exception ex) {
            responseDTO.setCode(varList.ASP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @GetMapping("/searchAppointment/{id}")
    public ResponseEntity searchAppointment(@PathVariable int id){
        try {
            AppointmentDTO employeeDTO = appointmentService.searchAppointment(id);
            if (employeeDTO != null) {
                responseDTO.setCode(varList.ASP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(employeeDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

            } else {
                responseDTO.setCode(varList.ASP_NO_DATA_FOUND);
                responseDTO.setMessage("No Employee Available For this Id");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            }

        } catch (Exception ex) {
            responseDTO.setCode(varList.ASP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @GetMapping("/getAllEmployees")
    public ResponseEntity getAllEmployees(){
        try {
            List<AppointmentDTO> appointmentDTOList = appointmentService.getAllEmployees();
            responseDTO.setCode(varList.ASP_SUCCESS);
            responseDTO.setMessage("Success");
            responseDTO.setContent(appointmentDTOList);
            return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);


        }catch (Exception ex) {
            responseDTO.setCode(varList.ASP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }


}

















