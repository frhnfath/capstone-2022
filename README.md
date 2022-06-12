# API AmbuHelp

## Endpoint
https://c22-ps173.uc.r.appspot.com/api/

## Register
* URL 
  * /users/store
* Method
  * POST
* Request Body
  * name as string
  * email as string
  * password as string
  * telepon as bigInt
* Example
  * https://c22-ps173.uc.r.appspot.com/api/users/store
* Response
  ```
  {
    "code": 200,
    "message": "Success",
    "data": [
        {
            "id": 1,
            "name": "testapi",
            "email": "testapi@gmail.com",
            "password": "testapi",
            "telepon": "089512345678",
            "rule": "user",
            "hospital_id": 0,
            "deleted_at": null,
            "remember_token": null,
            "created_at": "2022-06-10T08:06:51.000000Z",
            "updated_at": "2022-06-10T08:06:51.000000Z"
        }
    ]
  }
  ```

## Login
* URL 
  * /users/show/{email}
* Method
  * GET
* Example
  * https://c22-ps173.uc.r.appspot.com/api/users/show/testapi@gmail.com
* Response
  ```
  {
    "code": 200,
    "message": "Success",
    "data": [
        {
            "id": 1,
            "name": "testapi",
            "email": "testapi@gmail.com",
            "password": "testapi",
            "telepon": "089512345678",
            "rule": "user",
            "hospital_id": 0,
            "deleted_at": null,
            "remember_token": "70cRTOPSmVVLmNUM2bKf4cwd8iC8hLAm",
            "created_at": "2022-06-10T08:06:51.000000Z",
            "updated_at": "2022-06-10T08:06:51.000000Z"
        }
    ]
  }
  ```
  
## Update Profile
* URL 
  * /users/update/{id}
* Method
  * POST
* Request Body
  * name as string
  * email as string
  * password as string
  * telepon as bigInt
* Example
  * https://c22-ps173.uc.r.appspot.com/api/users/update/1
* Response
  ```
  {
    "code": 200,
    "message": "Success",
    "data": [
        {
            "id": 1,
            "name": "testapi",
            "email": "testapi@gmail.com",
            "password": "testapi",
            "telepon": "01234567890",
            "rule": "user",
            "hospital_id": 0,
            "deleted_at": null,
            "remember_token": "70cRTOPSmVVLmNUM2bKf4cwd8iC8hLAm",
            "created_at": "2022-06-10T08:06:51.000000Z",
            "updated_at": "2022-06-10T08:34:38.000000Z"
        }
    ]
  }
  ```

## Delete Profile
* URL 
  * /users/destroy/{id}
* Method
  * POST
* Example
  * https://c22-ps173.uc.r.appspot.com/api/users/destroy/2
* Response
  ```
  {
    "code": 200,
    "message": "Delete Success",
    "data": null
  }
  ```
  
## Get All Profile
* URL 
  * /users
* Method
  * GET
* Example
  * https://c22-ps173.uc.r.appspot.com/api/users
* Response
  ```
  {
    "code": 200,
    "message": "Success",
    "data": [
        {
            "id": 1,
            "name": "testapi",
            "email": "testapi@gmail.com",
            "password": "testapi",
            "telepon": "01234567890",
            "rule": "user",
            "hospital_id": 0,
            "deleted_at": null,
            "remember_token": "70cRTOPSmVVLmNUM2bKf4cwd8iC8hLAm",
            "created_at": "2022-06-10T08:06:51.000000Z",
            "updated_at": "2022-06-10T08:34:38.000000Z"
        },
        {
            "id": 2,
            "name": "testapi2",
            "email": "testapi2@gmail.com",
            "password": "testapi2",
            "telepon": "0895123456789",
            "rule": "user",
            "hospital_id": 0,
            "deleted_at": null,
            "remember_token": null,
            "created_at": "2022-06-10T08:37:33.000000Z",
            "updated_at": "2022-06-10T08:37:33.000000Z"
        }
    ]
  }
  ```
  
## Short Ambulance
* URL 
  * /short/ambulance
* Method
  * POST
* Request Body
  * lintang as double
  * bujur as double
* Example
  * https://c22-ps173.uc.r.appspot.com/api/short/ambulance
* Response
  ```
  {
    "code": 200,
    "message": "Success",
    "data": [
        {
            "id": 9,
            "nama_ambulan": "Ambulance Mardi Rahayu",
            "nama_driver": "Genta",
            "lintang": -6.2023994,
            "bujur": 106.8994353,
            "alamat": "Jl. Jatinegara Kaum, Jakarta Timur",
            "telepon": 81288876543,
            "created_at": null,
            "updated_at": null
        }
    ]
  }
  ```
  
## Short Hospital
* URL 
  * /short/hospital
* Method
  * POST
* Request Body
  * lintang as double
  * bujur as double
* Example
  * https://c22-ps173.uc.r.appspot.com/api/short/hospital
* Response
  ```
  {
    "code": 200,
    "message": "Success",
    "data": [
        {
            "kode": 3172770,
            "nama": "RSIA Alvernia Agusta",
            "jenis": "RSIA",
            "tipe": "C",
            "lintang": -6.19377671215609,
            "bujur": 106.891590453748,
            "alamat": "Jl. Pemuda No.80, Jati, Kec. Pulo Gadung, Kota Jakarta Timur, DKI Jakarta 13220",
            "bed_avail": 1,
            "telepon": 81280210270,
            "created_at": null,
            "updated_at": null
        }
    ]
  }
  ```
