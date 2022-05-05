This is a model-first ORM. Change the orm.xml schema, persistence.xml persistence-unit name, and EM factory to sync schema. Schema generation is drop-and-create so you need to construct, persist, and commit at least one object to initialize the table in a postgresql IDE (Ex. DataGrip). 

Before running the code, you must open the file src/META-INF/persistence.xml. Find the line with the property "jakarta.persistence.jdbc.password". Change the value to your PostgreSQL password. You should not have to change anything else, unless you did something wacky when installing Postgres.
