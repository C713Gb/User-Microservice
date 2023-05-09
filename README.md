
# User Microservice

This is a user microservice created in Spring boot.


## API Reference

#### Get all users

```http
  POST /users
```

#### Get user by id

```http
  POST /users/${userId}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `Long` | **Required**. Id of user to fetch |

#### getSingleUser(userId)

Fetch user with the help of id

#### Create user

```http
  POST /users
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `Long` | **Required**. Id of user to fetch |
| `firstName`      | `String` | **Required**. First Name of user to fetch |
| `lastName`      | `String` | **Required**. Last Name of user to fetch |
| `email`      | `String` | **Required**. Email of user |

#### createUser(user)

Create user with id, firstName, lastName, and email

#### Delete user

```http
  POST /users/${userId}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `Long` | **Required**. Id of user to fetch |

#### deleteUser(userId)

Delete user with the help of id

