//package de.htwberlin.services;
//
//import de.htwberlin.api.User;
//import de.htwberlin.api.UserCreateRequest;
//import de.htwberlin.persistence.UserEntity;
//import de.htwberlin.persistence.UserRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class UserService {
//
//    private final UserRepository userRepository;
//
//    public UserService(UserRepository userLikesRepository){
//        this.userRepository = userLikesRepository;
//    }
//
//
//public User create(UserCreateRequest request){
//        var userEntity = new UserEntity(request.getRecipeId());
//
//        return  transformEntity(userRepository.save(userEntity));
//}
//
//private User transformEntity(UserEntity userEntity){
//        return new User(
//                userEntity.getId(),
//                userEntity.getRecipeId()
//                );
//}
//public List<User> findAll(){
//        List<UserEntity> users = userRepository.findAll();
//        return users.stream().map(this::transformEntity).collect(Collectors.toList());
//}
//
//}
