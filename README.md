This is Document and how to use from Ligheh java engine.
here is types of sending and receiving data from server:
| Methods | Inputs | Output |
| :---: | :---: | :---: |
| **Post**| Hashmap<String,Object>,Hashmap<String,Object>,Class | Class |
| **GET**| Hashmap<String,Object>,Hashmap<String,Object>,Class | Class |
| **Put**| Hashmap<String,Object>,Hashmap<String,Object>,Class | Class |
| **Delete**| Hashmap<String,Object>,Hashmap<String,Object>,Class | Class |

These are simple ways to sending and receiving data. but we have some sample for each module to use it easier:
- **Auth**

| Methods | Inputs | Output |
| :---: | :---: | :---: |
| **auth**| Hashmap<String,Object>,Hashmap<String,Object> | AuthModel |
| **auth_theory**| Hashmap<String,Object>,Hashmap<String,Object> | AuthModel |
| **me**| Hashmap<String,Object>,Hashmap<String,Object> | AuthModel |
| **editProfile**| Hashmap<String,Object>,Hashmap<String,Object> | AuthModel |
| **editPassword**| Hashmap<String,Object>,Hashmap<String,Object> | AuthModel |
| **register**| Hashmap<String,Object>,Hashmap<String,Object> | AuthModel |
| **verification**| Hashmap<String,Object>,Hashmap<String,Object> | AuthModel |
| **recovery**| Hashmap<String,Object>,Hashmap<String,Object> | AuthModel |
| **logout**| Hashmap<String,Object>,Hashmap<String,Object> | AuthModel|
| **changeAvatar**| Hashmap<String,Object>,Hashmap<String,Object> | AuthModel|

- **Sample**

| Methods | Inputs | Output |
| :---: | :---: | :---: |
| **list**| Hashmap<String,Object>,Hashmap<String,Object> | list |
| **listInstance**| Hashmap<String,Object>,Hashmap<String,Object> | list |
| **bulkList**| Hashmap<String,Object>,Hashmap<String,Object> | list |
| **show**| Hashmap<String,Object>,Hashmap<String,Object> | SampleModel |
| **bulkShow**| Hashmap<String,Object>,Hashmap<String,Object> | SampleModel |
| **score**| Hashmap<String,Object>,Hashmap<String,Object> | SampleModel |
| **getScore**| Hashmap<String,Object>,Hashmap<String,Object> | SampleModel |
| **create**| Hashmap<String,Object>,Hashmap<String,Object> | SampleModel |
| **close**| Hashmap<String,Object>,Hashmap<String,Object> | null |
| **items**| Hashmap<String,Object>,Hashmap<String,Object> | null |
| **theory**| Hashmap<String,Object>,Hashmap<String,Object> | null |

- **Center**

| Methods | Inputs | Output |
| :---: | :---: | :---: |
| **list**| Hashmap<String,Object>,Hashmap<String,Object> | list |
| **show**| Hashmap<String,Object>,Hashmap<String,Object> | CenterModel|
| **users**| Hashmap<String,Object>,Hashmap<String,Object> |  list |
| **createUser**| Hashmap<String,Object>,Hashmap<String,Object> | null |
| **user**| Hashmap<String,Object>,Hashmap<String,Object> | UserModel |
| **editUser**| Hashmap<String,Object>,Hashmap<String,Object> | null|
| **create**| Hashmap<String,Object>,Hashmap<String,Object> | CenterModel |
| **edit**| Hashmap<String,Object>,Hashmap<String,Object> | CenterModel |
| **theory**| Hashmap<String,Object>,Hashmap<String,Object> | null |

- **Room**

| Methods | Inputs | Output |
| :---: | :---: | :---: |
| **list**| Hashmap<String,Object>,Hashmap<String,Object> | list |
| **show**| Hashmap<String,Object>,Hashmap<String,Object> | RoomModel |
| **users**| Hashmap<String,Object>,Hashmap<String,Object> |  list |
| **createUser**| Hashmap<String,Object>,Hashmap<String,Object> | null |
| **user**| Hashmap<String,Object>,Hashmap<String,Object> | UserModel |
| **editUser**| Hashmap<String,Object>,Hashmap<String,Object> | null|
| **create**| Hashmap<String,Object>,Hashmap<String,Object> | RoomModel |
| **edit**| Hashmap<String,Object>,Hashmap<String,Object> | RoomModel |

- **Case**

| Methods | Inputs | Output |
| :---: | :---: | :---: |
| **list**| Hashmap<String,Object>,Hashmap<String,Object> | list |
| **show**| Hashmap<String,Object>,Hashmap<String,Object> | CaseModel |
| **users**| Hashmap<String,Object>,Hashmap<String,Object> | UserModel |
| **addClient**| Hashmap<String,Object>,Hashmap<String,Object> | null |

