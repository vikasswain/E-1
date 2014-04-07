define(['models/students', 'knockoutKendo'], 
    function (model) {
        'use strict';
        var studentsDataSource = model.students;
        return {
            //variables
            studentsData : studentsDataSource.data,
            studentColumns : [
                { 
                    'field' : 'first_name', 
                    'title' : 'Name',
                    'template' : '#=first_name + " " + last_name#'
                },
                {
                    'field':'roll_no',
                    'title' :"Roll Number"
                },
                {
                  'field':'address_line_1',
                  'title':'Address',
                  'template':'#=address_line_1 + " " + address_line_2#'
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

