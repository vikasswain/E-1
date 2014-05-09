define(['config', 'knockout', 'jquery'], function(config, ko, $) {
    "use strict";
    var usersData = ko.observableArray([]);
    var editableUser = {
        user_id: ko.observable(''),
        ufname: ko.observable(''),
        ulname: ko.observable(''),
        uname: ko.observable(''),
        pwd: ko.observable(''),
        customer_id: ko.observable('')
    };
    var insertableUser = {
        ufname: ko.observable(''),
        ulname: ko.observable(''),
        uname: ko.observable(''),
        pwd: ko.observable('')   
    };
    var deleteableUser = {
      user_id : ko.observable('')  
    };
    return {
        users: {
            // variables
            data: usersData,
            editableUser: editableUser,
            insertableUser: insertableUser,
            deleteableUser: deleteableUser,
            // functions
            read: readUsers,
            create: createUser,
            update : updateUser,
            delete : deleteUser
        }
    };

    function readUsers() {
        $.ajax({
            type: 'GET',
            url: config.api.user,
            success: function(response) {
                usersData.splice(0, usersData().length);
                $.each(response, function() {
                    usersData.push(this);
                });
            }
        });
    }

    function createUser() {
        $.ajax({
            url: config.api.user,
            type: "POST",
            contentType: "application/json",
            data: ko.toJSON(insertableUser), /// convert from observable to plain json
            success: function() {
                alert("successfully inserted! ");
                insertableUser.ufname('');
                insertableUser.ulname('');
                insertableUser.uname('');
                insertableUser.pwd('');
            }
        });
    }

    function updateUser() {
        if (editableUser.user_id() > 0) {
            $.ajax({
                url: config.api.user,
                type: "PUT",
                contentType: "application/json",
                data: ko.toJSON(editableUser), /// convert from observable to plain json
                success: function() {
                    alert("successfully updated");
                    editableUser.ufname('');
                    editableUser.ulname('');
                    editableUser.uname('');
                    editableUser.pwd('');
                }
            });
        }
        else {
            alert("enter valid user ID!!");
        }
    }


    function deleteUser() {
        if (deleteableUser.user_id() > 0) {
            $.ajax({
                url: config.api.user,
                type: "DELETE",
                contentType: "application/json",
                data: ko.toJSON(deleteableUser), /// convert from observable to plain json
                success: function() {
                    alert("successfully deleted");
                    deleteableUser.user_id('');
                }
            });
        }
        else {
            alert("enter valid user ID!!");
        }
    }


});


