define(['config','knockout', 'jquery'], function(config, ko, $){
    "use strict";
    var studentsData = ko.observableArray([]);
    var batch = 1;
    return {
        students : {
            // variables
            data : studentsData,
            batch : batch,
            // functions
            read : readStudents
        }
    };
    
    function readStudents(){
        $.ajax({
           type : 'GET',
           url : config.api.studentByBatch + batch,
           success : function(response){
               studentsData.splice(0, studentsData().length);
               $.each(response, function(){
                   studentsData.push(this);
               })
           }
        });
    }
})
