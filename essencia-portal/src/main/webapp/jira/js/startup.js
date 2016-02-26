var customUtil = {
    getAllQuery: function () {
        var query_string = {};
        var query = window.location.search;
        if (query.length < 1) {
            return query_string;
        }
        query = window.location.search.substring(1);

        var vars = query.split("&");
        for (var i = 0; i < vars.length; i++) {
            var pair = vars[i].split("=");
            if (typeof query_string[pair[0]] === "undefined") {
                query_string[pair[0]] = decodeURIComponent(pair[1]);
            } else if (typeof query_string[pair[0]] === "string") {
                var arr = [query_string[pair[0]], decodeURIComponent(pair[1])];
                query_string[pair[0]] = arr;
            } else {
                query_string[pair[0]].push(decodeURIComponent(pair[1]));
            }
        }
        return query_string;
    },
    getAllQueryFromUrl: function (url) {
        var query_string = {};
        if (url.indexOf('?') === -1) {
            query_string
        }
        var query = url.substring(url.indexOf('?') + 1);
        var vars = query.split("&");
        for (var i = 0; i < vars.length; i++) {
            var pair = vars[i].split("=");
            if (typeof query_string[pair[0]] === "undefined") {
                query_string[pair[0]] = decodeURIComponent(pair[1]);
            } else if (typeof query_string[pair[0]] === "string") {
                var arr = [query_string[pair[0]], decodeURIComponent(pair[1])];
                query_string[pair[0]] = arr;
            } else {
                query_string[pair[0]].push(decodeURIComponent(pair[1]));
            }
        }
        return query_string;
    },
    addJiraParametersToUrl: function (url) {
        var query = window.location.search;
        if (query.length < 1) {
            return url;
        }
        query = window.location.search.substring(1);

        //기존 파라미터가 없으면
        if (url.indexOf('?') === -1) {
            url = url + '?' + query;
        }
        //기존 파라미터가 있으면
        else {
            //기존 파라미터에서 입력받은 파라미터와 중복되는 항목 제거
            function mergeObj(obj1, obj2) {
                var obj3 = {};
                for (var attrname in obj1) {
                    obj3[attrname] = obj1[attrname];
                }
                for (var attrname in obj2) {
                    obj3[attrname] = obj2[attrname];
                }
                return obj3;
            }

            var inputParams = this.getAllQueryFromUrl(url);
            var browserParams = this.getAllQuery();
            var mergedParams = mergeObj(browserParams, inputParams);

            url = url.substring(0, url.indexOf('?'));

            var index = 0;
            for (var key in mergedParams) {
                if (index === 0) {
                    url = url + '?' + key + '=' + mergedParams[key];
                } else {
                    url = url + '&' + key + '=' + mergedParams[key];
                }
                index++;
            }
        }
        return url;
    },
    redirectMenu: function (path) {
        var url = path;
        window.location.href = this.addJiraParametersToUrl(url);
    },
    renderDialog: function (msg) {
        $('#normal-dialog').find('[name=msg]').html(msg);
        AJS.dialog2('#normal-dialog').show();
    },
    renderWarningDialog: function (msg) {
        $('#warning-dialog').find('[name=msg]').html(msg);
        AJS.dialog2('#warning-dialog').show();
    },
    getUserByName: function (name, callback) {
        var data = {
            username: name
        };
        this.callRest('/rest/api/latest/user/search', 'GET', data, function (err, response) {
            callback(err, response);
        });
    },
    callRest: function (url, method, data, callback) {
        AP.require('request', function (request) {
            request({
                url: url,
                type: method,
                dataType: 'json',
                contentType: "application/json; charset=utf-8",
                data: data,
                success: function (response) {
                    response = JSON.parse(response);
                    callback(null, response);
                },
                error: function (response, status, errorThrown) {
                    callback(response, null);
                }
            });
        });
    }
};
$(function () {
    var getUrlParam = function (param) {
        var codedParam = (new RegExp(param + '=([^&]*)')).exec(window.location.search)
        if (codedParam) {
            return decodeURIComponent(codedParam[1]);
        }
        return null;
    };

    if(!getUrlParam('xdm_e') || !getUrlParam('cp')){
        window.location.href = '/jira/page/invalid.jsp';
    }

    var baseUrl = getUrlParam('xdm_e') + getUrlParam('cp');
    $.getScript(baseUrl + '/atlassian-connect/all.js', function () {
        if (page_mode && page_mode == 'aui') {
            onPageLoadScript();
        }
    });

    $('#left-side-menu').find('a').click(function (event) {
        event.preventDefault();
        if ($(this).data('path')) {
            customUtil.redirectMenu($(this).data('path'));
        }
    });

    if (page_mode && page_mode == 'aui') {
        AJS.$('[name=close-button]').click(function (e) {
            e.preventDefault();
            AJS.dialog2('#normal-dialog').hide();
            AJS.dialog2('#warning-dialog').hide();
        });
    }
});