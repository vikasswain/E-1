define(['models/courses', 'knockoutKendo'], 
    function (model) {
        'use strict';
        var coursesDataSource = model.courses;
        return {
            //variables
            coursesData : coursesDataSource.data,
            courseColumns : [
                { 
                    'field' : 'course_id', 
                    'title' : 'CourseID'
                },
                { 
                    'field' : 'abbr', 
                    'title' : 'Abbrevation'
                },
                { 
                    'field' : 'title', 
                    'title' : 'Title'
                }
            ],
            // functions
            attached : viewAttached
        };
        
        function courseColumns(){
            return ;
        }
        
        function viewAttached(){
            coursesDataSource.read();
        }
    });

