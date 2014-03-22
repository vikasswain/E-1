define(['knockout', 'jquery'], function(ko, $) {
    // StudentsModule
    return {
        list : ko.observableArray([]),
        selectedStudent: ko.observable({}),
        editableStudent: ko.observable({}),
        load : loadList,
        update : update,
        save : save
    };
    
    function loadList(){
        
    }
    
    function update(){
        
    }
    
    function save(){
        
    }
});