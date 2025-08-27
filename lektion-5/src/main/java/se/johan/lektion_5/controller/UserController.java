package se.johan.lektion_5.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.johan.lektion_5.model.CustomUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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


    List<CustomUser> userList = new ArrayList<>(
            List.of(
                    new CustomUser(1, "Johan", "123", true),
                    new CustomUser(2, "Johan", "123", false),
                    new CustomUser(3, "123", "Johan", true),
                    new CustomUser(4, "Benny", "456", true),
                    new CustomUser(5, "456", "Benny", true),
                    new CustomUser(6, "admin", "0", true)
            )
    );

    @DeleteMapping("/{username}")
    public ResponseEntity<String> deleteUser(@PathVariable("username") String username) {
        CustomUser userToBeDeleted = null;
        for (int i = 0; i < userList.size(); i++) {
            if (Objects.equals(userList.get(i).username(), username)) {
                userToBeDeleted = userList.get(i);
                userList.remove(i);
                return ResponseEntity.ok().body(username + " was deleted");
            }

        }
        return ResponseEntity.status(404).build();
    }

}
