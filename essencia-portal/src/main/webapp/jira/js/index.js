var onPageLoadScript = function () {
    //console.log(customUtil.getAllQuery());

//            AP.require('messages', function (messages) {
//                var msgId = messages.error('Lookie here', 'I am only here for a few seconds');
//                setTimeout(function () {
//                    messages.clear(msgId);
//                }, 5000);
//            });

    AP.require('request', function (request) {
        request({
            url: '/rest/api/latest/project',
            success: function (response) {
                // convert the string response to JSON
                response = JSON.parse(response);

                // dump out the response to the console
                console.log(response);
            },
            error: function (err) {
                console.log(arguments);
            }
        });
    });

    AP.getUser(function (user) {
        console.log("user id", user.id);
        console.log("user key", user.key);
        console.log("user name", user.fullName);
    });

    var issueData = {
        "fields": {
            "project": {
                "key": "TEST"
            },
            "summary": "REST ye merry gentlemen.",
            "description": "Creating of an issue using project keys and issue type names using the REST API",
            "issuetype": {
                "name": "Task"
            }
        }
    };
//            AP.require('request', function (request) {
//                request({
//                    url: '/rest/api/latest/issue',
//                    // adjust to a POST instead of a GET
//                    type: 'POST',
//                    data: JSON.stringify(issueData),
//                    success: function (response) {
//                        // convert the string response to JSON
//                        response = JSON.parse(response);
//
//                        // dump out the response to the console
//                        console.log(response);
//                    },
//                    error: function () {
//                        console.log(arguments);
//                    },
//                    // inform the server what type of data is in the body of the HTTP POST
//                    contentType: "application/json"
//                });
//            });
}