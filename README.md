# SPRING-DATA-JPA

* **PersistenceContext and EntityManager Methods**
    * Understanding the lifecycle of entities and how the `EntityManager` acts as an interface to interact with the persistence context.
* **Entity, Table, and ORM**
    * Mapping Java objects to database tables using Object-Relational Mapping (ORM) principles and annotations like `@Entity` and `@Table`.
* **Using JPA Query Methods**
    * Leveraging Spring Data JPA’s ability to derive queries automatically from method names (e.g., `findByEmail`).
* **Writing Custom JPQL Query and Native Query**
    * Implementing complex logic using Java Persistence Query Language (JPQL) for database-independent queries or Native SQL for database-specific optimization.
* **Projection and Pagination**
    * Optimizing performance and data transfer by fetching only specific fields (Projections) and handling large datasets in chunks (Pagination).
* **Mappings in JPA**
    * Implementing entity relationships such as One-to-One, One-to-Many, and Many-to-Many through a practical project context.
* **Mapping Query with Cascading**
    * Managing how operations (like save or delete) propagate from a parent entity to its related child entities.
* **Fetch Type and N+1 Query Optimization**
    * Balancing `EAGER` vs `LAZY` loading and resolving the N+1 select problem to improve application efficiency.
