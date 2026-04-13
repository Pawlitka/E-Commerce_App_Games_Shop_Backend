# Using the Oracle Database Free image (replaces XE)
FROM container-registry.oracle.com/database/free:latest

# Copy your SQL scripts into the entrypoint directory
# Scripts here run ONLY when the database is first created
COPY ./init-scripts/ /opt/oracle/scripts/startup/

ENV ORACLE_PWD=${ORACLE_PWD}