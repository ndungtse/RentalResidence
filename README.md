# RentalResidence

This is a project for a rental residence. It is a web application that allows users to search for rental residences in the area.
It is made for study purposes.

## Deployment

#### Backend API
```bash
  https://rentalresidence-production.up.railway.app/api/v1
```

#### API Documentation (Swagger)
```bash
 https://rentalresidence-production.up.railway.app/swagger-ui/index.html
```


## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.
<!-- getting started with springboot -->
### Prerequisites

What things you need to install the software and how to install them

```bash
Java 17
Maven
```

### Installing

A step by step series of examples that tell you how to get a development env running

Run the following command to install all the dependencies

```bash

```bash
mvn clean install
```

Run the following command to start the application

```bash
mvn spring-boot:run
```

### Endpoints

| HTTP Method | Endpoint     | Description                |
|:------------| :------- | :------------------------- |
| `POST`      | `/api/v1/auth/register` | Endpoint to create new user and account |
| `POST`      | `/api/v1/auth/login` | Endpoint to login user in the application |
| `GET`       | `/api/v1/auth/users` | Endpoint to get all users in the application (only accessible by `ADMIN`) |
| `GET`       | `/api/v1/tranaction` | Endpoint to get all transactions made on user's account like bookings, withdraw and transfer |
| `GET`       | `/api/v1/tranaction/{transaction_id}` | Endpoint to get one transaction made on user's account |
| `GET`       | `/api/v1/property` | Endpoint to get all properties in the application |
| `GET`       | `/api/v1/property/{property_id}` | Endpoint to get one property in the application |
| `POST`      | `/api/v1/property` | Endpoint to create a new property in the application (only accessible by `ADMIN`) |
| `PUT`       | `/api/v1/property/{property_id}` | Endpoint to update a property in the application (only accessible by `ADMIN`) |
| `DELETE`    | `/api/v1/property/{property_id}` | Endpoint to delete a property in the application (only accessible by `ADMIN`) |
| `GET`       | `/api/v1/property/{property_id}/bookings` | Endpoint to get all bookings made on a property |
| `GET`       | `/api/v1/property/{property_id}/bookings/{booking_id}` | Endpoint to get one booking made on a property |
| `POST`      | `/api/v1/property/{property_id}/bookings` | Endpoint to create a new booking on a property |
| `PUT`       | `/api/v1/property/{property_id}/bookings/{booking_id}` | Endpoint to update a booking on a property |
| `DELETE`    | `/api/v1/property/{property_id}/bookings/{booking_id}` | Endpoint to delete a booking on a property |
| `GET`       | `/api/v1/property/{property_id}/bookings/{booking_id}/payments` | Endpoint to get all payments made on a booking |
| `GET`       | `/api/v1/property/{property_id}/bookings/{booking_id}/payments/{payment_id}` | Endpoint to get one payment made on a booking |
| `POST`      | `/api/v1/property/{property_id}/bookings/{booking_id}/payments` | Endpoint to create a new payment on a booking |
| `PUT`       | `/api/v1/property/{property_id}/bookings/{booking_id}/payments/{payment_id}` | Endpoint to update a payment on a booking |
| `GET`       | `/api/v1/review` | Endpoint to get all reviews made on a property |
| `GET`       | `/api/v1/review/{review_id}` | Endpoint to get one review made on a property |
| `POST`      | `/api/v1/review` | Endpoint to create a new review on a property |
| `PUT`       | `/api/v1/review/{review_id}` | Endpoint to update a review on a property |
| `DELETE`    | `/api/v1/review/{review_id}` | Endpoint to delete a review on a property |
| `GET`       | `/api/v1/property/{property_id}/reviews` | Endpoint to get all reviews made on a property |
| `GET`       | `/api/v1/property/{property_id}/reviews/{review_id}` | Endpoint to get one review made on a property |
| `POST`      | `/api/v1/property/{property_id}/reviews` | Endpoint to create a new review on a property |
| `PUT`       | `/api/v1/property/{property_id}/reviews/{review_id}` | Endpoint to update a review on a property |
| `DELETE`    | `/api/v1/property/{property_id}/reviews/{review_id}` | Endpoint to delete a review on a property |
| `GET`       | `/api/v1/property/{property_id}/reviews/{review_id}/replies` | Endpoint to get all replies made on a review |
| `GET`       | `/api/v1/property/{property_id}/reviews/{review_id}/replies/{reply_id}` | Endpoint to get one reply made on a review |


## Built With

* [Spring Boot](https://spring.io/projects/spring-boot) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management

## Authors

* **Ndungutse Charles** - *Initial work* - [ndungutsecharles](https://ndungutsecharles.me)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details