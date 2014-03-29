define(['models/students', 'knockoutKendo'], 
    function (model) {
        'use strict';
        var studentsDataSource = model.students;
        return {
            //variables
            studentsData : studentsDataSource.data,
            studentColumns : [
                { 
                    'field' : 'fname', 
                    'title' : 'Name',
                    'template' : '#=fname + " " + lname#'
                },
                { 
                    'field' : 'email', 
                    'title' : 'Email'
                },
                { 
                    'field' : 'phone', 
                    'title' : 'Phone'
                }
            ],
            // functions
            attached : viewAttached
        };
        
        function studentColumns(){
            return ;
        }
        
        function viewAttached(){
            studentsDataSource.read();
        }
    });

