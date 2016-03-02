var onPageLoadScript = function () {
    AJS.$('#contact-form').on('aui-valid-submit', function (event) {
        event.preventDefault();

        var form = $('#contact-form');

        blockSubmitStart();

        var params = {
            email: form.find('[name=email]').val(),
            subject: form.find('[name=subject]').val(),
            contents: form.find('[name=contents]').val()
        };
        $.ajax({
            type: "POST",
            url: "/api/mail/send",
            data: JSON.stringify(params),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (response) {
                if (response.success) {
                    customUtil.renderDialog('Your message have been received.');
                } else {
                    customUtil.renderWarningDialog('Failed to send Email.');
                }
                blockStop();
            },
            error: function (response, status, errorThrown) {
                customUtil.renderWarningDialog('Failed to send Email.');
                blockStop();
            }
        });
    });
};