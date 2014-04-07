define(['plugins/router', 'durandal/app', 'bootstrap'], function (router, app) {
    return {
        router: router,
        search: function() {
            //It's really easy to show a message box.
            //You can add custom options too. Also, it returns a promise for the user's response.
            app.showMessage('Search not yet implemented...');
        },
        activate: function () {
            router.map([
                { route: '', title:'Dashboard', moduleId: 'viewmodels/students', nav: true },
                { route: 'test', title:'XYZ', moduleId: 'viewmodels/test', nav: true },
                { route: 'courses', title:'XYZ', moduleId: 'viewmodels/courses', nav: true },
                { route: 'applicants', title:'Applications', moduleId: 'viewmodels/applicants', nav: true }
            ]).buildNavigationModel();
            
            return router.activate();
        }
    };
});