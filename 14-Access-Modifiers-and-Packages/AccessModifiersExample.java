/**
 * Day 14 - Access Modifiers and Packages: Demonstrating Package Access
 *
 * Concept:
 * Access modifiers control visibility of classes and members.
 * Packages organize code into logical groups.
 *
 * This example demonstrates:
 * - Public class (accessible everywhere)
 * - Private, protected, default members
 * - Package organization
 * - Access control across boundaries
 *
 * Note: This example is in default package for simplicity
 */
public class AccessModifiersExample {

    /**
     * Public class (accessible from anywhere)
     */
    public static class PublicClass {
        public String publicVar = "Public";
        protected String protectedVar = "Protected";
        String defaultVar = "Default";
        private String privateVar = "Private";

        public void publicMethod() {
            System.out.println("Public method");
        }

        protected void protectedMethod() {
            System.out.println("Protected method");
        }

        void defaultMethod() {
            System.out.println("Default method");
        }

        private void privateMethod() {
            System.out.println("Private method");
        }

        /**
         * Show accessibility within same class
         */
        void showAccessibility() {
            System.out.println("\n--- Access within same class ---");
            System.out.println(publicVar);
            System.out.println(protectedVar);
            System.out.println(defaultVar);
            System.out.println(privateVar);  // Can access private too!

            publicMethod();
            protectedMethod();
            defaultMethod();
            privateMethod();
        }
    }

    /**
     * Child class inheriting PublicClass
     */
    static class ChildClass extends PublicClass {
        void accessParentMembers() {
            System.out.println("\n--- Access in child class ---");
            System.out.println(publicVar);      // OK: public
            System.out.println(protectedVar);   // OK: protected (inherited)
            // System.out.println(defaultVar);  // ERROR: default (not protected)
            // System.out.println(privateVar);  // ERROR: private

            publicMethod();
            protectedMethod();
            // defaultMethod();   // ERROR
            // privateMethod();   // ERROR
        }
    }

    /**
     * Another class in same "package"
     */
    static class AnotherClass {
        void accessPublicClass() {
            System.out.println("\n--- Access from another class (same level) ---");
            PublicClass obj = new PublicClass();

            System.out.println(obj.publicVar);      // OK: public
            // System.out.println(obj.protectedVar);   // ERROR: protected (not subclass)
            // System.out.println(obj.defaultVar);     // ERROR: default
            // System.out.println(obj.privateVar);     // ERROR: private

            obj.publicMethod();
            // obj.protectedMethod();   // ERROR
            // obj.defaultMethod();     // ERROR
            // obj.privateMethod();     // ERROR
        }
    }

    /**
     * Main method - entry point
     */
    public static void main(String[] args) {

        System.out.println("=== Access Modifiers Demonstration ===");

        // Access from same class
        PublicClass obj = new PublicClass();
        obj.showAccessibility();

        // Access from different class (same package)
        AnotherClass another = new AnotherClass();
        another.accessPublicClass();

        // Access from child class
        ChildClass child = new ChildClass();
        child.accessParentMembers();

        System.out.println("\n=== Summary of Access Levels ===");
        System.out.println("""
                public:      Accessible everywhere
                protected:   Accessible in package + subclasses
                default:     Accessible only in package
                private:     Accessible only in same class
                """);

    }

}


