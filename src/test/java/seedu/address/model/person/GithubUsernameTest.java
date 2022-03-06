package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class GithubUsernameTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new GithubUsername(null));
    }

    @Test
    public void constructor_invalidUsername_throwsIllegalArgumentException() {
        String invalidUsername = "";
        assertThrows(IllegalArgumentException.class, () -> new GithubUsername(invalidUsername));
    }

    @Test
    public void isValidGithubUsername() {
        // null username
        assertThrows(NullPointerException.class, () -> GithubUsername.isValidUsername(null));

        // invalid usernames
        assertFalse(GithubUsername.isValidUsername("")); // empty string
        assertFalse(GithubUsername.isValidUsername(" ")); // spaces only
        assertFalse(GithubUsername.isValidUsername("alex_doe")); // contains illegal character

        // valid usernames
        assertTrue(GithubUsername.isValidUsername("johndoe")); // characters only
        assertTrue(GithubUsername.isValidUsername("amy-baller-123")); // alphanumeric with hyphen
        assertTrue(GithubUsername.isValidUsername("12345")); // only numbers
    }
}