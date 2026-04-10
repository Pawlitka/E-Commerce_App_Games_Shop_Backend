# Using the Oracle Database Free image (replaces XE)
FROM container-registry.oracle.com/database/free:latest

# Copy your SQL scripts into the entrypoint directory
# Scripts here run ONLY when the database is first created
COPY ./init-scripts/ /container-entrypoint-initdb.d/

# (Optional) Set environment variables for the DB
ENV ORACLE_PWD=YourStrongPassword123
ENV ORACLE_CHARACTERSET=AL32UTF8