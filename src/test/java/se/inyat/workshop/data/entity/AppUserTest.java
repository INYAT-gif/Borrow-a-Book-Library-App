package se.inyat.workshop.data.entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class AppUserTest {

    @Test
    public void testAppUserConstructor() {
        AppUser appUser = new AppUser("testUser", "password123");

        assertNotNull(appUser);
        assertEquals("testUser", appUser.getUsername());
        assertEquals("password123", appUser.getPassword());
        assertEquals(LocalDate.now(), appUser.getRegDate());
    }

    @Test
    public void testSetUsername() {
        AppUser appUser = new AppUser();
        appUser.setUsername("newUser");
        assertEquals("newUser", appUser.getUsername());
    }

    @Test
    public void testSetPassword() {
        AppUser appUser = new AppUser();
        appUser.setPassword("newPassword");
        assertEquals("newPassword", appUser.getPassword());
    }

    @Test
    public void testSetRegDate() {
        AppUser appUser = new AppUser();
        LocalDate date = LocalDate.of(2020, 1, 1);
        appUser.setRegDate(date);
        assertEquals(date, appUser.getRegDate());
    }

    @Test
    public void testToString() {
        AppUser appUser = new AppUser("testUser", "password123");
        String expected = "AppUser(id=0, username=testUser, password=password123, regDate=" + LocalDate.now() + ", userDetails=null)";
        assertTrue(appUser.toString().contains("username=testUser"));
    }

    // Additional tests for Equals and HashCode can be added as needed
}
