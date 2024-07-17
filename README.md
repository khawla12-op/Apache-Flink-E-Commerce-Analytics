# Apache Flink E-Commerce Analytics with Elasticsearch and Postgres

This repository contains an Apache Flink application for real-time sales analytics, utilizing Docker Compose to orchestrate infrastructure components including Apache Flink, Elasticsearch, and Postgres. 
The application processes financial transaction data from Kafka, performs aggregations, and stores results in both Postgres and Elasticsearch for further analysis.
> [!NOTE]
> Requirements: Docker

## Architecture

![System Architecture](https://github.com/khawla12-op/Apache-Flink-E-Commerce-Analytics/blob/main/Generating%20data.png)

## Installation and Setup

1. Clone this repository:
   ```bash
   git clone https://github.com/khawla12-op/Apache-Flink-E-Commerce-Analytics.git
  
2. Start Services with Docker Compose:
   
   This step leverages Docker Compose to launch multiple services needed for the application to run.
    Run docker compose to start the required services (Zookeeper ,Kafka, Elasticsearch, Postgres,kibana):
   ```bash
   docker-compose -f docker-compose-2.yml up -d

4. Start Apache Flink
   ```bash
   docker-compose -f docker-compose-1.yml up -d
5. Create a virtual environment
   ```bash
   python3 -m venv venv
6. Activate the virtual environment:
   ```bash
   .\venv\Scripts\Activate
7. Intsall the requiremnets :
   ```bash
   pip install -r requirements.txt

After these steps, your application should be set up with the necessary services running and the required Python libraries installed in the virtual environment.
  

## Usage
Ensure all Docker containers are up and running. Use the provided Sales Transaction Generator main.py to generate sales transactions into Kafka.
```bach
cd SendeingDataToKafkaTopic
python main.py
```
This will generate transactions data and transform it to the topic 

## Application Details
The ``DataStreamJob`` class in the ``FlinkCommerce`` package is the main entry point. It consumes financial transaction data from Kafka, performs transformations, and stores aggregated results in Postgres and Elasticsearch.

## Code Structure
``DataStreamJob.java``: Contains Flink application logic, including Kafka source setup, stream processing, transformations, and sinks for Postgres and Elasticsearch.

``Deserializer``, ``Dto``, ``utils`` packages: Include classes for deserialization, data transfer objects, and utilities for JSON conversion.

## Configuration
* Kafka settings (bootstrap servers, topic, group ID) are configured within the Kafka source setup.
* Postgres connection details (URL, username, password) are defined in the jdbcUrl, username, and password variables.
* 
## Sink Operations
JDBC operations for Postgres create tables (``transactions``, ``sales_per_category``, ``sales_per_day``, sales_per_month) and handle insert/update operations.
Elasticsearch sink indexes transaction data for analysis.

