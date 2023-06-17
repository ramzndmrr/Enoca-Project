package com.enoca.enocaproject.controller;

import com.enoca.enocaproject.business.TextileService;
import com.enoca.enocaproject.model.textile.TextileRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TextileController {
    private TextileService textileService;
    public TextileController(TextileService textileService){
        this.textileService = textileService;
    }

    @GetMapping("/textiles")
    public ResponseEntity<?> getAll(){
        var response = textileService.getAll();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/textiles")
    public ResponseEntity<?> save(@RequestBody TextileRequest textileRequest){
      var response =  textileService.save(textileRequest);
      return ResponseEntity.ok(response);
    }

    @PostMapping("/update-textile")
    public ResponseEntity<?> update(@RequestBody TextileRequest textileRequest){
        var response = textileService.update(textileRequest);
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/textile/{id}")
    public void delete(@PathVariable Long id){
        textileService.deleteTextile(id);
    }

}
