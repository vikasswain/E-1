define(['config','knockout', 'jquery'], function(config, ko, $){
    "use strict";
    var coursesData = ko.observableArray([]);
    return {
        courses : {
            // variables
            data : coursesData,
            // functions
            read : readCourses
        }
    };
    
    function readCourses(){
        $.ajax({
           type : 'GET',
           url : config.api.course,
           success : function(response){
               coursesData.splice(0, coursesData().length);
               $.each(response, function(){
                   coursesData.push(this);
               })
           }
        });
    }
})
