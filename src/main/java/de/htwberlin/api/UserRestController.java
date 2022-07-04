//package de.htwberlin.api;
//
//import de.htwberlin.services.UserService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.net.URI;
//import java.net.URISyntaxException;
//
//@RestController
//public class UserRestController {
//    private final UserService userService;
//
//    public UserRestController(UserService userService){
//        this.userService = userService;
//    }
//
//    @PostMapping(path = "/recipe")
//    public ResponseEntity<Void> createUser(@RequestBody UserCreateRequest request) throws URISyntaxException {
//        var user = userService.create(request);
//        URI uri = new URI("/recipe/" + user.getId());
//        return ResponseEntity.created(uri).build();
//    }
//
//
//}
