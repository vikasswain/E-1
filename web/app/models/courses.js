define(['config', 'knockout', 'jquery'], function(config, ko, $) {
    "use strict";
    var coursesData = ko.observableArray([]);
    var editableCourse = {
        course_id: ko.observable(''),
        abbr: ko.observable(''),
        title: ko.observable('')
    };
    var insertableCourse = {
        abbr: ko.observable(''),
        title: ko.observable('')
    };
    var deleteableCourse = {
      course_id : ko.observable('')  
    };
    return {
        courses: {
            // variables
            data: coursesData,
            editableCourse: editableCourse,
            insertableCourse: insertableCourse,
            deleteableCourse: deleteableCourse,
            // functions
            read: readCourses,
            create: createCourse,
            update : updateCourse,
            delete : deleteCourse
        }
    };

    function readCourses() {
        $.ajax({
            type: 'GET',
            url: config.api.course,
            success: function(response) {
                coursesData.splice(0, coursesData().length);
                $.each(response, function() {
                    coursesData.push(this);
                });
            }
        });
    }

    function createCourse() {
        $.ajax({
            url: config.api.course,
            type: "POST",
            contentType: "application/json",
            data: ko.toJSON(insertableCourse), /// convert from observable to plain json
            success: function() {
                alert("successfully inserted! ");
                insertableCourse.abbr('');
                insertableCourse.title('');
            }
        });
    }

    function updateCourse() {
        if (editableCourse.course_id() > 0) {
            $.ajax({
                url: config.api.course,
                type: "PUT",
                contentType: "application/json",
                data: ko.toJSON(editableCourse), /// convert from observable to plain json
                success: function() {
                    alert("successfully updated");
                    editableCourse.course_id('');
                    editableCourse.abbr('');
                    editableCourse.title('');
                }
            });
        }
        else {
            alert("enter valid course ID!!");
        }
    }


    function deleteCourse() {
        if (deleteableCourse.course_id() > 0) {
            $.ajax({
                url: config.api.course,
                type: "DELETE",
                contentType: "application/json",
                data: ko.toJSON(deleteableCourse), /// convert from observable to plain json
                success: function() {
                    alert("successfully deleted");
                    deleteableCourse.course_id('');
                }
            });
        }
        else {
            alert("enter valid course ID!!");
        }
    }


});
