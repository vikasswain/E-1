define(['config', 'knockout', 'jquery'], function(config, ko, $) {
    "use strict";
    var customersData = ko.observableArray([]);
    var editableCustomer = {
        customer_id: ko.observable(''),
        title: ko.observable(''),
        address: ko.observable('')
    };
    var insertableCustomer = {
        address: ko.observable(''),
        title: ko.observable('')
    };
    var deleteableCustomer = {
      customer_id : ko.observable('')  
    };
    return {
        customers: {
            // variables
            data: customersData,
            editableCustomer: editableCustomer,
            insertableCustomer: insertableCustomer,
            deleteableCustomer: deleteableCustomer,
            // functions
            read: readCustomers,
            create: createCustomer,
            update : updateCustomer,
            delete : deleteCustomer
        }
    };

    function readCustomers() {
        $.ajax({
            type: 'GET',
            url: config.api.customer,
            success: function(response) {
                customersData.splice(0, customersData().length);
                $.each(response, function() {
                    customersData.push(this);
                });
            }
        });
    }

    function createCustomer() {
        $.ajax({
            url: config.api.customer,
            type: "POST",
            contentType: "application/json",
            data: ko.toJSON(insertableCustomer), /// convert from observable to plain json
            success: function() {
                alert("successfully inserted! ");
                insertableCustomer.address('');
                insertableCustomer.title('');
            }
        });
    }

    function updateCustomer() {
        if (editableCustomer.customer_id() > 0) {
            $.ajax({
                url: config.api.customer,
                type: "PUT",
                contentType: "application/json",
                data: ko.toJSON(editableCustomer), /// convert from observable to plain json
                success: function() {
                    alert("successfully updated");
                    editableCustomer.customer_id('');
                    editableCustomer.address('');
                    editableCustomer.title('');
                }
            });
        }
        else {
            alert("enter valid customer ID!!");
        }
    }


    function deleteCustomer() {
        if (deleteableCustomer.customer_id() > 0) {
            $.ajax({
                url: config.api.customer,
                type: "DELETE",
                contentType: "application/json",
                data: ko.toJSON(deleteableCustomer), /// convert from observable to plain json
                success: function() {
                    alert("successfully deleted");
                    deleteableCustomer.customer_id('');
                }
            });
        }
        else {
            alert("enter valid customer ID!!");
        }
    }


});

