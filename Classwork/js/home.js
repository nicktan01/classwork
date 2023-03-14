$(document).ready(function(){

    $.ajax({
        type: 'GET',
        url: 'http://contactlist.us-east-1.elasticbeanstalk.com/contacts',
        success: function() {
            alert('SUCCESS!');
        },
        error: function() {
            alert('FAILURE!');
        }
    })

})