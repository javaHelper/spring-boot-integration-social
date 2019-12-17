
```
http://localhost:8080/api/customer/1
```

Response

```
{
    "id": 1,
    "firstName": "John",
    "lastName": "Doe",
    "birthdate": "2019-12-17T16:19:14.168"
}
```

```
http://localhost:8080/api/customer/first-name/John
```

Response

```
[
    {
        "id": 1,
        "firstName": "John",
        "lastName": "Doe",
        "birthdate": "2019-12-17T16:19:14.168"
    }
]
```
