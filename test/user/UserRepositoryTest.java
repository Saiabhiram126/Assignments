package com.example.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    private UserRepository repository;

    @BeforeEach
    void setUp() {
        repository = new UserRepository();
        repository.addUser(new User(1, "Alice"));
        repository.addUser(new User(2, "Bob"));
    }

    // 1️ Valid user ID returns non-empty Optional
    @Test
    void testValidUserIdReturnsNonEmptyOptional() {
        Optional<User> userOpt = repository.findById(1);
        assertTrue(userOpt.isPresent());
        assertEquals("Alice", userOpt.get().getName());
    }

    // 2️ Invalid user ID returns Optional.empty()
    @Test
    void testInvalidUserIdReturnsEmpty() {
        Optional<User> userOpt = repository.findById(999);
        assertFalse(userOpt.isPresent());
    }

    // 3️ Calling get() on empty Optional throws exception
    @Test
    void testGetOnEmptyOptionalThrowsException() {
        Optional<User> userOpt = repository.findById(999);
        assertThrows(NoSuchElementException.class, userOpt::get);
    }

    // 4️ orElse returns default user when ID not found
    @Test
    void testOrElseReturnsDefaultUser() {
        User defaultUser = new User(-1, "Default");
        User user = repository.findById(999)
                .orElse(defaultUser);
        assertEquals("Default", user.getName());
    }

    // 5️ isPresent works correctly for both valid & invalid
    @Test
    void testIsPresentForValidAndInvalid() {
        assertTrue(repository.findById(2).isPresent());
        assertFalse(repository.findById(3).isPresent());
    }
}
