/**
 * Day 37 - Dependency Injection: Constructor Injection
 */
public class ConstructorInjectionExample {

    interface EmailService {
        void sendEmail(String to, String message);
    }

    static class GmailService implements EmailService {
        public void sendEmail(String to, String message) {
            System.out.println("Sending via Gmail to " + to + ": " + message);
        }
    }

    static class UserService {
        private EmailService emailService;

        // Constructor Injection
        UserService(EmailService emailService) {
            this.emailService = emailService;
        }

        void registerUser(String email) {
            emailService.sendEmail(email, "Welcome!");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Dependency Injection ===\n");

        EmailService emailService = new GmailService();
        UserService userService = new UserService(emailService);

        userService.registerUser("john@example.com");
    }
}


