define(function(){
    var baseApi = 'http://localhost:8080/E/rest/';
    return {
        'api' : {
            'student' : baseApi + 'student',
            'studentByBatch' : baseApi + 'student/batches/',
            'course' : baseApi + 'course',
            'applicant' : baseApi + 'applicant',
            'user' : baseApi + 'user',
            'customer' : baseApi + 'customer'
        }
    };
});