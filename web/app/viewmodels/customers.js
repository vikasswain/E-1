define(['models/customers', 'knockoutKendo'], 
    function (model) {
        'use strict';
        var customersDataSource = model.customers;
        return {
            //variables
            customersData : customersDataSource.data,     // list of all customers
            editableCustomer : customersDataSource.editableCustomer, 
            insertableCustomer : customersDataSource.insertableCustomer,
            deleteableCustomer : customersDataSource.deleteableCustomer,
            customerColumns : [
                { 
                    'field' : 'customer_id', 
                    'title' : 'CustomerID',
                    'type'  : 'number'
                },
                { 
                    'field' : 'title', 
                    'title' : 'Title'
                },
                { 
                    'field' : 'address', 
                    'title' : 'Address'
                }                
            ],
                     editable: "inline" ,

            // functions
            attached : viewAttached,
            saveCustomer : saveCustomer,
            updateCustomer : updateCustomer,
            deleteCustomer :deleteCustomer
        };
        
        
        function viewAttached(){
            customersDataSource.read();
        }
        
        function saveCustomer(){
            if(confirm("This will add this customer to database. Continue?")){
                customersDataSource.create();
            }
        }
        
        function updateCustomer(){
            if(confirm("This will update customer to database. Continue?")){
                customersDataSource.update();
            }
        }   
        
        function deleteCustomer(){
            if(confirm("This will delete customer from database. Continue?")){
                customersDataSource.delete();
            }
        }         
    });

