$(document).ready(function () {

    var API_URL = 'http://localhost:8080/'
    var event = {};

    var pathname = window.location.search;
    var id = pathname.split('=')[1];

    console.log(id);

    $.ajax({
        url: API_URL + "event/" + id
    }).done(function (response) {
        event = response;
        console.log(event);

        var eventContent= $('.event')
        console.log(eventContent)

        eventContent.append("" +
            "<div class='eventName'>" + event.eventName + "</div>" +
            "<div class='trackName'>" + event.trackName + " / " + event.country + "</div>" +
            "<div class='description'>" + event.description + "</div>" +
            "<div class='details'> Szczegóły: </div>" +
            "<div class='date'>" + event.dateStart + " - " + event.dateEnd + "</div>" +
            "<div class='country'>" + event.country + "</div>" +
            "<div class='adress'>" + event.address + "</div>" +
            "<div class='listUsers'> Lista aktualnych uczestników: </div>" +
            "<table class='table'></table>");

        var table = $('.table')

        event.users.forEach(function (e) {
            table.append("" +
                "<tr>" +
                "<td>avatar</td>" +
                "<td>"+ e.username + "</td>" +
                "<td>motorbike</td>" +
                "</tr>")
            console.log(e.username)
        })
    })


})


