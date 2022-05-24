package com.codegym.dto;

import com.codegym.model.contract.Contract;
import com.codegym.model.service.RentType;
import com.codegym.model.service.ServiceType;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;


public class ServiceDto {

    private Integer idService;
    @NotBlank(message = "Không được phép để trống")
    @Size(max = 100, message = "Không vượt quá 100 ký tự")
    @Pattern(regexp = "^[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ][\\s\\S]*$", message = "Tên không được nhập kí tự đặt biệt")
    private String nameService;
    @NotBlank(message = "Không được phép để trống")
    @Min(value = 0, message = "Diện tích phải có giá trị dương")
    private String areaService;
    @NotBlank(message = "Không được phép để trống")
    @Min(value = 0, message = "Cost phải có giá trị dương")
    private String costService;
    @NotBlank(message = "Không được phép để trống")
    @Min(value = 1, message = "Số người phải có giá trị dương")
    private String maxPeopleService;

    private RentType rentType;
    private ServiceType serviceType;


    private String standardRoom;
    @NotBlank(message = "Không được phép để trống")
    private String descriptionOtherConvenience;

    @Min(value = 0, message = "Diện tích phải có giá trị dương")
    private String poolArea;

    @Min(value = 1, message = "Số người phải có giá trị Lớn hơn 1")
    private String numberOfFloors;

    List<Contract> contracts;

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public ServiceDto() {
    }

    public Integer getIdService() {
        return idService;
    }

    public void setIdService(Integer idService) {
        this.idService = idService;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public String getAreaService() {
        return areaService;
    }

    public void setAreaService(String areaService) {
        this.areaService = areaService;
    }

    public String getCostService() {
        return costService;
    }

    public void setCostService(String costService) {
        this.costService = costService;
    }

    public String getMaxPeopleService() {
        return maxPeopleService;
    }

    public void setMaxPeopleService(String maxPeopleService) {
        this.maxPeopleService = maxPeopleService;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public String getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(String numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }
}
