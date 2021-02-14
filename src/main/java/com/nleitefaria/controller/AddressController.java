package com.nleitefaria.controller;

import com.nleitefaria.domain.AddressDTO;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api(value = "AddressController", description = "REST endpoint related to Addresses")
@RestController
public class AddressController {

    //TODO : Finish this
    @Operation(summary = "Get all Addresses")
    @GetMapping("/api/v1/addresses")
    public ResponseEntity<List<AddressDTO>> findAll()
    {
        List addressDTOList = new ArrayList();
        //TODO : Finish this
        return new ResponseEntity<List<AddressDTO>>(addressDTOList, HttpStatus.OK);
    }
}
