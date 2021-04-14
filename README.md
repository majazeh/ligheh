This is Document and how to use from Ligheh java engine.
here is types of sending and receiving data from server:
| Methods | arguments| return|
| :---: | :---: | :---: |
| **Post**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>```, aclass ```Class``` | Class |
| **GET**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>```, aclass ```Class``` | Class |
| **Put**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>```, aclass ```Class``` | Class |
| **Delete**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>```, aclass ```Class``` | Class |

These are simple ways to sending and receiving data. but we have some sample for each module to use it easier:

- **Auth**

| Methods | arguments| return|
| :---: | :---: | :---: |
| **auth**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` | AuthModel |
| **auth_theory**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` | AuthModel |
| **me**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` | AuthModel |
| **editProfile**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` | AuthModel |
| **editPassword**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` | AuthModel |
| **register**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` | AuthModel |
| **verification**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` | AuthModel |
| **recovery**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` | AuthModel |
| **logout**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` | AuthModel|
| **changeAvatar**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` | AuthModel|

- **Sample**

| Methods | arguments| return|
| :---: | :---: | :---: |
| **list**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` | List |
| **listInstance**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` | List |
| **bulkList**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` | List |
| **show**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` | SampleModel |
| **bulkShow**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` | SampleModel |
| **score**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` | SampleModel |
| **getScore**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` | SampleModel |
| **create**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` | SampleModel |
| **close**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` | null |
| **items**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` | null |
| **theory**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` | null |

- **Center**

| Methods | arguments| return|
| :---: | :---: | :---: |
| **list**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` | List |
| **show**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` | CenterModel|
| **users**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` |  List |
| **createUser**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` | null |
| **user**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` | UserModel |
| **editUser**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` | null|
| **create**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` | CenterModel |
| **edit**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` | CenterModel |
| **theory**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` | null |

- **Room**

| Methods | arguments| return|
| :---: | :---: | :---: |
| **list**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` | List |
| **show**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` | RoomModel |
| **users**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` |  List |
| **createUser**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` | null |
| **user**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` | UserModel |
| **editUser**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` | null|
| **create**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` | RoomModel |
| **edit**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` | RoomModel |

- **Case**

| Methods | arguments| return|
| :---: | :---: | :---: |
| **list**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` | List |
| **show**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` | CaseModel |
| **users**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` | List |
| **addClient**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` | null |

When we want to use Ligheh to Android Project we need to add some codes to out onCreate method of App.class. we need a class called like this ```Exceptioner.External = ExtendOnFailureException.class``` and we have to extend to ```onFailureException``` class. this class need a contractor with an arguments object ```Object``` and call super method with object. we have 3 method for out exceptions:

- onValidation(```object``` HashMap<String, Object>)
  - occur when we have exception in validation of user.
Mostly it occur when client want to login or register to system.
- onClient(```object``` Object)
  - occur when we have exception in app and connected to client.
Mostly occur when we cant connect to internet or have invalid value or ... .
- onServerFail(```object``` Object)
  - occur when we receive error from server after sending request.

If these methods called we dont arrive to ```onOk``` methods of ```Response``` class after sending request.

If we want to do something before and after sending request to server we need to call a class in onCreate method of App.class like this: ```APIRequest.ExternalAPIEvents = ExtendEvent.class``` and then call contractor with arguments of super class and override ```onResponsed``` method for receiving data from server.
