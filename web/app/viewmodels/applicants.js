define(['models/applicants', 'knockoutKendo'], 
    function (model) {
        'use strict';
        var applicantsDataSource = model.applicants;
        return {
            //variables
            applicantsData : applicantsDataSource.data,
            applicantsColumns : [
                { 
                    'field' : 'app_id', 
                    'title' : 'Application_ID'
                },
                { 
                    'field' : 'first_name', 
                    'title' : 'Name',
                    'template':'#= first_name # #= middle_name # #= last_name #'
                    //'template' : '#=first_name + " "+ middle_name + " "+ last_name#'
                },
                { 
                    'field' : 'date_of_birth', 
                    'title' : 'Birth Date',
                    'type'  : 'date'
                },
                { 
                    'field' : 'gender', 
                    'title' : 'Gender'
                },
                { 
                    'field' : 'email', 
                    'title' : 'Email'
                },
                { 
                    'field' : 'religion', 
                    'title' : 'Religion'
                }, 
                { 
                    'field' : 'caste_id', 
                    'title' : 'Caste ID'
                },
                { 
                    'field' : 'nationality', 
                    'title' : 'Nationality'
                },
                { 
                    'field' : 'parents_income', 
                    'title' : 'Parents Income'
                },
                { 
                    'field' : 'percentage', 
                    'title' : 'percentage',
                    'type'  : 'number'
                            
                },
                { 
                    'field' : 'last_exam_passed', 
                    'title' : 'last_exam_passed'
                },
                { 
                    'field' : 'year_of_passing', 
                    'title' : 'year_of_passing',
                    'type'  : 'date'
                },
                { 
                    'field' : 'course_to_be_admitted', 
                    'title' : 'course_to_be_admitted'
                },
                { 
                    'field' : 'is_eligible', 
                    'title' : 'is_eligible'
                },
                { 
                    'field' : 'address', 
                    'title' : 'address'
                }, 
                { 
                    'field' : 'locality', 
                    'title' : 'locality'
                },
                { 
                    'field' : 'city', 
                    'title' : 'city'
                },
                { 
                    'field' : 'zipcode', 
                    'title' : 'zipcode'
                },
                { 
                    'field' : 'state', 
                    'title' : 'state'
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

