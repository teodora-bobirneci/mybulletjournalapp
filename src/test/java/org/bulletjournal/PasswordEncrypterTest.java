package org.bulletjournal;

import org.junit.Test;

import static org.bulletjournal.PasswordEncrypter.encrypt;
import static org.bulletjournal.PasswordEncrypter.generateRandomSalt;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * @author Teodora Bobirneci
 */
public class PasswordEncrypterTest {

    private static final String ADMIN_PASS_ENCRYPTED = "1128b03a195a7ea99a720bb80a7ada4bfbe5881dc4ce9998a3ae7ae0cc7d56abf18f06d167122ea6f5c43bfad0bc83ca1b9675cb64134c2e6ce99ebdd3a32537";

    @Test
    public void testEncryption() {
        assertEquals(ADMIN_PASS_ENCRYPTED, encrypt("salt", "admin"));
    }

    @Test
    public void twoConsecutiveSaltsAreDifferent() {
        assertNotEquals(generateRandomSalt(), generateRandomSalt());
    }
}
