define(['models/courses', 'knockoutKendo'], 
    function (model) {
        'use strict';
        var coursesDataSource = model.courses;
        return {
            //variables
            coursesData : coursesDataSource.data,     // list of all courses
            editableCourse : coursesDataSource.editableCourse, 
            insertableCourse : coursesDataSource.insertableCourse,
            deleteableCourse : coursesDataSource.deleteableCourse,
            courseColumns : [
                { 
                    'field' : 'course_id', 
                    'title' : 'CourseID',
                    'type'  : 'number'
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
                     editable: "inline" ,

            // functions
            attached : viewAttached,
            saveCourse : saveCourse,
            updateCourse : updateCourse,
            deleteCourse :deleteCourse
        };
        
        
        function viewAttached(){
            coursesDataSource.read();
        }
        
        function saveCourse(){
            if(confirm("This will add this course to database. Continue?")){
                coursesDataSource.create();
            }
        }
        
        function updateCourse(){
            if(confirm("This will update course to database. Continue?")){
                coursesDataSource.update();
            }
        }   
        
        function deleteCourse(){
            if(confirm("This will delete course from database. Continue?")){
                coursesDataSource.delete();
            }
        }         
    });

