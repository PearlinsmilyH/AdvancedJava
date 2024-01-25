package com.example.library.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/api/getusers")
    Page<User> getUsers(Pageable page)
    {
        return userService.getUsers(page);
    }

    @GetMapping("/api/getusers/ordered-users")
    Page<User> getOrderedUsers(@PageableDefault(sort = "id", direction = Sort.Direction.DESC,size=5) Pageable page)
    {
        return userService.getUsers(page);
    }
}
