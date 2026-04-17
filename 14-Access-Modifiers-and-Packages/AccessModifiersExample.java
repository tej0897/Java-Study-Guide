/**
 * Day 14 - Access Modifiers: public / protected / default / private
 *
 * <p><b>Important note about this repo</b>
 * These examples live in the <i>default package</i> (no {@code package ...;} statement)
 * so we cannot truly demonstrate cross-package compilation in a single-folder example.
 *
 * <p><b>What this file demonstrates</b>
 * <ul>
 *   <li>Visibility within the same class</li>
 *   <li>Visibility from a subclass</li>
 *   <li>Visibility from a non-subclass in the same package</li>
 * </ul>
 */
public class AccessModifiersExample {

    /**
     * Base class containing members with different access levels.
     */
    public static class PublicClass {
        public String publicVar = "Public";
        protected String protectedVar = "Protected";
        String defaultVar = "Default (package-private)";
        private String privateVar = "Private";

        public void publicMethod() {
            System.out.println("Public method");
        }

        protected void protectedMethod() {
            System.out.println("Protected method");
        }

        void defaultMethod() {
            System.out.println("Default (package-private) method");
        }

        private void privateMethod() {
            System.out.println("Private method");
        }

        void showAccessibility() {
            System.out.println("\n--- Access within same class ---");
            System.out.println(publicVar);
            System.out.println(protectedVar);
            System.out.println(defaultVar);
            System.out.println(privateVar);

            publicMethod();
            protectedMethod();
            defaultMethod();
            privateMethod();
        }
    }

    /**
     * Subclass: can access public and protected members.
     * In the same package, it can also access default members.
     */
    static class ChildClass extends PublicClass {
        void accessParentMembers() {
            System.out.println("\n--- Access in child class ---");
            System.out.println(publicVar);      // OK
            System.out.println(protectedVar);   // OK
            System.out.println(defaultVar);     // OK (same package)
            // System.out.println(privateVar);  // ERROR

            publicMethod();
            protectedMethod();
            defaultMethod();
            // privateMethod(); // ERROR
        }
    }

    /**
     * Non-subclass in the same package: can access public/protected/default,
     * but not private.
     */
    static class AnotherClass {
        void accessPublicClass() {
            System.out.println("\n--- Access from another class (same package) ---");
            PublicClass obj = new PublicClass();

            System.out.println(obj.publicVar);
            System.out.println(obj.protectedVar); // OK: same package
            System.out.println(obj.defaultVar);   // OK: same package
            // System.out.println(obj.privateVar); // ERROR

            obj.publicMethod();
            obj.protectedMethod();
            obj.defaultMethod();
            // obj.privateMethod(); // ERROR
        }
    }

    /**
     * Entry point.
     *
     * @param args CLI args (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Access Modifiers Demonstration ===");

        PublicClass obj = new PublicClass();
        obj.showAccessibility();

        new AnotherClass().accessPublicClass();
        new ChildClass().accessParentMembers();

        System.out.println("\n=== Summary ===");
        System.out.println("""
                public:      Accessible everywhere
                protected:   Accessible in same package + subclasses
                default:     Accessible only in same package
                private:     Accessible only in same class
                """);
    }
}
