define(['config','knockout', 'jquery'], function(config, ko, $){
    "use strict";
    var applicantsData = ko.observableArray([]);
    return {
        applicants : {
            // variables
            data : applicantsData,
            // functions
            read : readApplicants
        }
    };
    
    function readApplicants(){
        $.ajax({
           type : 'GET',
           url : config.api.applicant,
           success : function(response){
               applicantsData.splice(0, applicantsData().length);
               $.each(response, function(){
                   applicantsData.push(this);
               })
           }
        });
    }
})
