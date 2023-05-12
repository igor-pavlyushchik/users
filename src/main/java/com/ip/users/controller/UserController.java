package com.ip.users.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ip.users.domain.UserItem;
import com.ip.users.repo.UserRepository;

/**
 * UserItem controller.
 * Simplified design without service layer for docker education purposes.
 * Methods to be called with {"userName": "some-username"} , not username).
 */
@RestController
public class UserController {

    final private UserRepository userRepository;

    @Autowired
    public UserController(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/greeting")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello, k8s and %s!", name);
    }

    @PostMapping("/users")
    public UserItem create(@RequestBody final UserItem userItem) {
        return userRepository.save(userItem);
    }

    @GetMapping("/users/{id}")
    public UserItem userData(@PathVariable(value = "id") final Integer id) {
        return userRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("No such user exists."));
    }

    @DeleteMapping("/users/{id}")
    public void deleteById(@PathVariable(value = "id") final Integer id) {
        userRepository.deleteById(id);
    }

    /**
     * Update user name.
     * @param id user id
     * @param userItem entity
     * @return updated user entity.
     */
    @PutMapping("/users/{id}")
    @Transactional
    public UserItem update(@PathVariable(value = "id") Integer id,  @RequestBody final UserItem userItem) {
        UserItem existingUser = userRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("No such user exists."));
        existingUser.setUserName(userItem.getUserName());
        return userRepository.save(existingUser);
    }

    /**
     * Should be used for incrementing/decrementing number of posts, when calling from posts microservice.
     * @param id user id
     * @param increment the positive or negative number of the amount of posts to be added to
     *                 the amount of post currently in the repo.
     * @return updated UserItem.
     */
    @PutMapping("/users/{id}/{increment}")
    @Transactional
    public UserItem updatePostsNumber(@PathVariable(value = "id") Integer id,
                                      @PathVariable (value = "increment") Integer increment) {
        UserItem existingUser = userRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("No such user exists."));
        existingUser.setAmountOfPosts(existingUser.getAmountOfPosts() + increment);
        return userRepository.save(existingUser);
    }
}
