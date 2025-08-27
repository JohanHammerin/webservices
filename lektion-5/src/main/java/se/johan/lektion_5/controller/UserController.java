package se.johan.lektion_5.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user")
public class UserController {


    /* ResponseEntity
     *   Extension of class HttpEntity that adds HttpStatusCode
     *   HttpHeaders - Allows us to edit the Response Header
     *   If the need arises, the syntax goes as follows:
     *       new ResponseEntity(body, header, statusCode)
     *
     */

    @GetMapping("/ok")
    public ResponseEntity<String> getOk() {
        return ResponseEntity.ok("Hello World!");
    }

    @GetMapping("/br")
    public ResponseEntity<String> getBadRequest() {
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/nf")
    public ResponseEntity<String> getNotFound() {
        return ResponseEntity.notFound().build();
    }

    // TODO - Check någonting som jag inte hann läsa.
    @GetMapping("/ise")
    public ResponseEntity<String> getInternalServerError() {
        return ResponseEntity.internalServerError().build();
    }


}
