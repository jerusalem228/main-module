package com.sagroup.elementservice.controller;


import com.sagroup.elementservice.Dto.ElementDto;
import com.sagroup.elementservice.service.ElementService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author ABDELBIF
 * @version 1.0
 * @created 6-Feb-2023 08:00:00 PM
 */

@RestController
@RequestMapping("/Element")
public class ElementController {
    @Autowired
    private ElementService elementService;

    @PostMapping
    public ResponseEntity<?> addElement(@RequestBody ElementDto elementDto){
        elementService.addElement(elementDto);
        return new ResponseEntity<>(elementDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> viewElement(@PathVariable Long id){
        ElementDto elementDto = elementService.viewElement(id);
        return new ResponseEntity<>(elementDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateElement( @PathVariable Long id, @RequestBody ElementDto elementDto){
        elementService.updateElement(id, elementDto);
        return new ResponseEntity<>(elementDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeElement(@PathVariable Long id){
        elementService.removeElement(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
