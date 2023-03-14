$(document).ready(function(){

    $.ajax({
        type: 'GET',
        url: 'http://contactlist.us-east-1.elasticbeanstalk.com/contacts',
        success: function() {
            var contactsDiv = $('#allContacts');
        },
        error: function() {
            alert('FAILURE!');
        }
        
    })
    
    $.each(contactArray, function(index, contact) {
        var contactInfo = '<p>';
        contactInfo += 'Name: ' + contact.firstName + ' ' + contact.lastName + '<br>';
        contactInfo += 'Company: ' + contact.company + '<br>';
        contactInfo += 'Email: ' + contact.email + '<br>';
        contactInfo += 'Phone: ' + contact.phone + '<br>';
        contactInfo += '</p><hr>';

        contactsDiv.append(contactInfo);
    })

})