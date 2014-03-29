define(function(){
    var baseApi = 'http://localhost:8080/E/rest/';
    return {
        'api' : {
            'student' : baseApi + 'student',
            'studentByBatch' : baseApi + 'student/bybatch/'
        }
    }
})