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
| **list**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` | list |
| **listInstance**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` | list |
| **bulkList**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` | list |
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
| **list**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` | list |
| **show**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` | CenterModel|
| **users**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` |  list |
| **createUser**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` | null |
| **user**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` | UserModel |
| **editUser**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` | null|
| **create**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` | CenterModel |
| **edit**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` | CenterModel |
| **theory**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` | null |

- **Room**

| Methods | arguments| return|
| :---: | :---: | :---: |
| **list**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` | list |
| **show**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` | RoomModel |
| **users**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` |  list |
| **createUser**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` | null |
| **user**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` | UserModel |
| **editUser**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` | null|
| **create**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` | RoomModel |
| **edit**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` | RoomModel |

- **Case**

| Methods | arguments| return|
| :---: | :---: | :---: |
| **list**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` | list |
| **show**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` | CaseModel |
| **users**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` | UserModel |
| **addClient**| Data ```Hashmap<String, Object>```, Header ```Hashmap<String, Object>``` | null |

