package com.example.demo.service;

import com.example.demo.dto.AppointmentDTO;
import com.example.demo.dto.LecDTO;
import com.example.demo.entity.Appointment;
import com.example.demo.repo.AppointmentRepo;
import com.example.demo.util.varList;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AppointmentService {
    @Autowired
    private AppointmentRepo appointmentRepo;

    @Autowired
    private ModelMapper modelMapper;



    public String addAppointment(AppointmentDTO appointmentDTO) {
        if (appointmentRepo.existsById(appointmentDTO.getId())) {
            return varList.ASP_DUPLICATED;
        } else {
            appointmentRepo.save(modelMapper.map(appointmentDTO, Appointment.class));
            return varList.ASP_SUCCESS;
        }
    }

    public String editAppointment(AppointmentDTO appointmentDTO) {
        if (appointmentRepo.existsById(appointmentDTO.getId())) {
            appointmentRepo.save(modelMapper.map(appointmentDTO, Appointment.class));
            return varList.ASP_SUCCESS;
        } else {
            return varList.ASP_NO_DATA_FOUND;
        }
    }


    public String updateAppointment(LecDTO lecDTO) {
        if (appointmentRepo.existsById(lecDTO.getId())) {
            appointmentRepo.save(modelMapper.map(lecDTO, Appointment.class));
            return varList.ASP_SUCCESS;
        } else {
            return varList.ASP_NO_DATA_FOUND;
        }
    }




    public AppointmentDTO searchAppointment(int Id){
        if (appointmentRepo.existsById(Id)){
            Appointment appointment = appointmentRepo.findById(Id).orElse(null);
            return modelMapper.map(appointment,AppointmentDTO.class);

        }else {
            return null;

        }

    }








    public String deleteAppointment(int id){
        if (appointmentRepo.existsById(id)){
            appointmentRepo.deleteById(id);
            return varList.ASP_SUCCESS;

        }else {
            return varList.ASP_NO_DATA_FOUND;
        }
    }



    public List<AppointmentDTO> getAllEmployees() {
        List<Appointment> appointmentList = appointmentRepo.findAll();
        return modelMapper.map(appointmentList, new TypeToken<ArrayList<AppointmentDTO>>() {}.getType());
    }

    public AppointmentDTO searchEmployee(int empId){
        if (appointmentRepo.existsById(empId)){
            Appointment appointment = appointmentRepo.findById(empId).orElse(null);
            return modelMapper.map(appointment,AppointmentDTO.class);

        }else {
            return null;

        }

    }

}
