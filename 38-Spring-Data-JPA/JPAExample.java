/**
 * Day 38 - Spring Data JPA: Entity Example
 *
 * Note: Requires JPA/Hibernate dependencies
 */

// @Entity
// @Table(name = "users")
// public class User {
//     @Id
//     @GeneratedValue
//     private Long id;
//
//     @Column(nullable = false)
//     private String name;
//
//     @Column(unique = true)
//     private String email;
// }
//
// @Repository
// public interface UserRepository extends JpaRepository<User, Long> {
//     User findByEmail(String email);
// }

public class JPAConceptExample {
    public static void main(String[] args) {
        System.out.println("=== Spring Data JPA ===\n");
        System.out.println("@Entity: Maps class to database table");
        System.out.println("@Id: Marks primary key");
        System.out.println("@Column: Defines column properties");
        System.out.println("@Repository: Data access layer");
        System.out.println("JpaRepository: Provides CRUD operations");
    }
}


