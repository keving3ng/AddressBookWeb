console.log('test');
$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/addressBookService"
    }).then(function(data) {
        const obj = JSON.stringify(data);
        console.log(obj);
        $('div.content-area').text('test');
    });
});