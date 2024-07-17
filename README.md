# Apache Flink E-Commerce Analytics with Elasticsearch and Postgres

This repository contains an Apache Flink application for real-time sales analytics, utilizing Docker Compose to orchestrate infrastructure components including Apache Flink, Elasticsearch, and Postgres. 
The application processes financial transaction data from Kafka, performs aggregations, and stores results in both Postgres and Elasticsearch for further analysis.
> [!NOTE]
> Requirements: Docker

## Architecture
![Screenshot iling and raising a tentacle.](https://myoctocat.com/assets/images/base-octocat.svg)

![System Architecture](SystemArchitecture.png)

## Installation and Setup

1. Clone this repository:
   ```bash
   git clone https://github.com/your-username/your-repository.git
   cd your-repository
2.Start the required services (Apache Flink, Elasticsearch, Postgres):
docker-compose up

## Usage
Ensure all Docker containers are up and running. Use the provided Sales Transaction Generator main.py to generate sales transactions into Kafka. Run the FlinkCommerce application for real-time analytics on financial transactions.
Application Details
The DataStreamJob class in the FlinkCommerce package is the main entry point. It consumes financial transaction data from Kafka, performs transformations, and stores aggregated results in Postgres and Elasticsearch.

## Components
Apache Flink
Sets up the Flink execution environment.
Connects to Kafka to ingest financial transaction data.
Processes, transforms, and aggregates transaction data streams.
Postgres
Stores transaction data and aggregated results in tables (transactions, sales_per_category, sales_per_day, sales_per_month).
Elasticsearch
Stores transaction data for further analysis.
Code Structure
DataStreamJob.java: Contains Flink application logic, including Kafka source setup, stream processing, transformations, and sinks for Postgres and Elasticsearch.
Packages (Deserializer, Dto, utils): Include classes for deserialization, data transfer objects, and utilities for JSON conversion.
## Configuration
Kafka settings (bootstrap servers, topic, group ID) are configured within the Kafka source setup.
Postgres connection details (URL, username, password) are defined in the jdbcUrl, username, and password variables.
## Sink Operations
JDBC operations for Postgres create tables (transactions, sales_per_category, sales_per_day, sales_per_month) and handle insert/update operations.
Elasticsearch sink indexes transaction data for analysis.

