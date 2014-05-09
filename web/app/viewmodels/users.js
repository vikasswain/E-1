define(['models/users', 'knockoutKendo'], 
    function (model) {
        'use strict';
        var usersDataSource = model.users;
        return {
            //variables
            usersData : usersDataSource.data,     // list of all users
            editableUser : usersDataSource.editableUser, 
            insertableUser : usersDataSource.insertableUser,
            deleteableUser : usersDataSource.deleteableUser,
            userColumns : [
                { 
                    'field' : 'user_id', 
                    'title' : 'UserID',
                    'type'  : 'number'
                },
                { 
                    'field' : 'ufname', 
                    'title' : 'First Name'
                },
                { 
                    'field' : 'ulname', 
                    'title' : 'Last Name'
                },
                { 
                    'field' : 'uname', 
                    'title' : 'User Name'
                },
                { 
                    'field' : 'pwd', 
                    'title' : 'Password',
                    'type' : 'password'
                },
                { 
                    'field' : 'customer_id', 
                    'title' : 'CustomerID'
                }                
            ],
                     editable: "inline" ,

            // functions
            attached : viewAttached,
            saveUser : saveUser,
            updateUser : updateUser,
            deleteUser :deleteUser
        };
        
        
        function viewAttached(){
            usersDataSource.read();
        }
        
        function saveUser(){
            if(confirm("This will add this user to database. Continue?")){
                usersDataSource.create();
            }
        }
        
        function updateUser(){
            if(confirm("This will update user to database. Continue?")){
                usersDataSource.update();
            }
        }   
        
        function deleteUser(){
            if(confirm("This will delete user from database. Continue?")){
                usersDataSource.delete();
            }
        }         
    });



