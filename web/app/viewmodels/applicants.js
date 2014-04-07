define(['models/applicants', 'knockoutKendo'], 
    function (model) {
        'use strict';
        var applicantsDataSource = model.applicants;
        return {
            //variables
            applicantsData : applicantsDataSource.data,
            applicantsColumns : [
                { 
                    'field' : 'first_name', 
                    'title' : 'Name',
                    'template' : '#=first_name + " " + last_name#'
                },
                { 
                    'field' : 'last_exam_passed', 
                    'title' : 'Last Exam Passed'
                },
                { 
                    'field' : 'year_of_passing', 
                    'title' : 'Year Of Passing'
                },
                {
                    command: ["edit", "destroy"]
                }
            ],
            // functions
            attached : viewAttached
        };
        
        function applicantsColumns(){
            return ;
        }
        
        function viewAttached(){
            applicantsDataSource.read();
        }
    });

