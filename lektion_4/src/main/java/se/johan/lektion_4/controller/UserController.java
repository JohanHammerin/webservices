package se.johan.lektion_4.controller;

import org.springframework.web.bind.annotation.*;
import se.johan.lektion_4.model.CustomUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController    // Contains: @ResponseBody & @Controller
// @Controller     // Is a specialized @Component for classpath scannings & Mappings
// @Component         // This annotation enables naming of Stereotype annotations (service, repository, restcontroller), activation of Classpath Scanning
// @ResponseBody      // Sends a result (JSON/HTML)
@RequestMapping("/v1/user")
public class UserController {
    // Debugging User List (Database users)
    List<CustomUser> userList = new ArrayList<>(
            List.of(
                    new CustomUser(1,"Johan", "123", true),
                    new CustomUser(2,"Johan", "123", false),
                    new CustomUser(3,"123", "Johan", true),
                    new CustomUser(4,"Benny", "456", true),
                    new CustomUser(5,"456", "Benny", true),
                    new CustomUser(6,"admin", "0", true)
            )
    );


    @GetMapping("/")
    public List<CustomUser> test() {
        return userList;
    }

    // RequestParam vs PathVariable
    // RequestParam: When then value is optional
    // Example localhost:8080/products/shirts?color=blue/
    // PathVariable: When the value is required to proceed
    // Example localhost:8080/auth/user/usedId/242132/processPayment

    //  @RequestParam does NOT require the sumbol: '{}' (See PathVariable for reference)
    // localhost:8080/v1/user/find?username=
    @GetMapping("/find")
    public List<CustomUser> findUser(@RequestParam(value = "username", defaultValue = "Johan") String username) {
        System.out.println("WORKS");
        List<CustomUser> foundUserList = userList.stream()
                .filter(i -> Objects.equals(i.username(), username))
                .toList();
        return foundUserList;
    }


    @DeleteMapping("/{username}")
    public CustomUser deleteUser(@PathVariable("username") String username) {

        CustomUser customUserToBeDeleted;
        for (int i = 0; i < userList.size(); i++) {
            if (Objects.equals(userList.get(i).username(), username)) {
                customUserToBeDeleted = userList.get(i);
                userList.remove(customUserToBeDeleted);

                return customUserToBeDeleted;
            }
        }

        // userList.stream().filter(customUser -> customUser.username(), username);


        return null;
    }
}
